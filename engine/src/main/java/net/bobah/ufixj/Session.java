package net.bobah.ufixj;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Session implements Runnable {
    private static final Logger log = LoggerFactory.getLogger(Session.class);

    interface IMachine {
        boolean processEvent(@Nonnull IEvent event);

        default void start() {
            start(null);
        }

        default void terminate() {
            terminate(null);
        }

        void start(@Nullable IEvent event);

        void terminate(@Nullable IEvent event);

        <ENUM extends Enum<ENUM>> void startSubMachine(@Nonnull IState owner, @Nonnull Class<ENUM> type, @Nonnull IState entry, @Nonnull IState exit);

        IMachine getSubMachine(@Nonnull IState state);

        void terminateSubMachine(@Nonnull IState state);

        Session getSession();
    }

    interface IEvent {
        /**
         * decode and dispatch specific event type
         */
        IState dispatch(IState state);
    }

    enum Event implements IEvent {
        ENABLE {
            @Override
            public IState dispatch(IState state) {
                return state.onEnable();
            }
        },
        DISABLE {
            @Override
            public IState dispatch(IState state) {
                return state.onDisable();
            }
        },
        ACTIVATE {
            @Override
            public IState dispatch(IState state) {
                return state.onActivate();
            }
        },
        DEACTIVATE {
            @Override
            public IState dispatch(IState state) {
                return state.onDeactivate();
            }
        }
    }

    interface IEventHandler {
        default IState onEnable() {
            return null;
        }

        default IState onDisable() {
            return null;
        }

        default IState onActivate() {
            return null;
        }

        default IState onDeactivate() {
            return null;
        }

        default IState onConnect() {
            return null;
        }

        default IState onDisconnect() {
            return null;
        }

        default IState onLogon() {
            return null;
        }

        default IState onLogoff() {
            return null;
        }

        default IState onResend() {
            return null;
        }

        default IState onBehind() {
            return null;
        }

        default IState onCaughtUp() {
            return null;
        }

        default IState onError() {
            return null;
        }

        default IState onStale() {
            return null;
        }

        default IState onAppMessage() {
            return null;
        }

        default IState onHeartbeat() {
            return null;
        }
    }

    interface IState extends IEventHandler {
        default void enter(@Nonnull IMachine machine) {
            enter();
        }

        default void leave(@Nonnull IMachine machine) {
            leave();
        }

        default IState handle(@Nonnull IMachine machine, @Nonnull IEvent event) {
            return handle(event);
        }

        default void enter() {
        }

        default void leave() {
        }

        default IState handle(@Nonnull IEvent event) {
            return event.dispatch(this);
        }
    }

    static class Machine<ENUM extends Enum<ENUM>> implements IMachine {
        private final Session session;
        private final IState entry;
        private final IState exit;
        private final Map<ENUM, IMachine> subMachines;
        private IState state;

        Machine(Session session, Class<ENUM> type, IState entry, IState exit) {
            this.session = session;
            this.entry = entry;
            this.exit = exit;
            subMachines = new EnumMap<>(type);
        }

        @Override
        public <CHILD_ENUM extends Enum<CHILD_ENUM>> void startSubMachine(IState state, Class<CHILD_ENUM> type, IState entry, IState exit) {
            final Machine<CHILD_ENUM> subMachine = new Machine<>(session, type, entry, exit);
            subMachines.put((ENUM) state, subMachine);
            subMachine.start();
        }

        @Override
        public IMachine getSubMachine(IState state) {
            return subMachines.get((ENUM) state);
        }

        @Override
        public void terminateSubMachine(IState state) {
            subMachines.get((ENUM) state).terminate();
        }

        @Override
        public boolean processEvent(IEvent event) {
            IMachine subMachine = getSubMachine(state);
            if (subMachine != null) {
                return subMachine.processEvent(event);
            } else {
                IState next = state.handle(this, event);
                if (next != state) {
                    if (next == null) {
                        return false;
                    } else {
                        transition(next, event);
                    }
                }
                return true;
            }
        }

        boolean isTerminated() {
            return state == exit;
        }

        private void transition(@Nonnull IState next, @Nullable IEvent event) {
            if (state != null)
                state.leave(this);
            final IState prev = state;
            state = next;

            next.enter(this);
        }

        public void start(IEvent event) {
            transition(entry, event);
        }

        public void terminate(IEvent event) {
            transition(exit, event);
        }

        @Override
        public Session getSession() {
            return session;
        }
    }

    enum OnlineState implements IState {
        ONLINE {
            @Override
            public IState onStale() {
                return STALE;
            }
        },
        STALE {
            @Override
            public void enter(IMachine machine) {
            }
            @Override
            public IState onHeartbeat() {
                return ONLINE;
            }
        },
        LOGGED_OFF;
    }

    enum LogonState implements IState {
        LOGGING_ON {
            @Override
            public void enter(IMachine machine) {
                machine.getSession().logon();
            }
            @Override
            public IState onLogon() {
                return BEHIND_AT_LOGON;
            }
        },
        BEHIND_AT_LOGON {
            @Override
            public void enter(IMachine machine) {
                machine.getSession().catchup();
            }

            @Override
            public IState onCaughtUp() {
                return ONLINE;
            }
        },
        ONLINE {
            @Override
            public void enter(IMachine machine) {
                machine.startSubMachine(this, OnlineState.class, OnlineState.ONLINE, OnlineState.LOGGED_OFF);
            }

            @Override
            public IState handle(IMachine machine, IEvent event) {
                return machine.getSubMachine(this).processEvent(event) ? this : event.dispatch(this);
            }

            @Override
            public IState onLogoff() {
                return BEHIND_AT_LOGOFF;
            }

            @Override
            public void leave(IMachine machine) {
                machine.terminateSubMachine(this);
            }
        },
        BEHIND_AT_LOGOFF {
            @Override
            public void enter(IMachine machine) {
                machine.getSession().catchup();
            }

            @Override
            public IState onCaughtUp() {
                return parent;
            }
        },
        LOGGED_OFF;
    }

    private void catchup() {
    }

    private void logon() {
    }

    enum ConnectState implements IState {
        DISCONNECTED {
            @Override
            public void enter(IMachine machine) {
                machine.getSession().connect();
            }

            @Override
            public IState onConnect() {
                return CONNECTED;
            }
        },
        CONNECTED {
            @Override
            public void enter(IMachine machine) {
                machine.startSubMachine(this, LogonState.class, LogonState.LOGGING_ON, LogonState.LOGGED_OFF);
            }

            @Override
            public IState handle(IEvent event) {
                return machine.getSubMachine(this).processEvent(event) ? this : event.dispatch(this);
            }

            @Override
            public IState onDisconnect() {
                return DISCONNECTED;
            }

            @Override
            public void leave(IMachine machine) {
                machine.terminateSubMachine(this);
            }
        },
        INACTIVE;
    }

    private void connect() {
    }

    enum ActiveState implements IState {
        INACTIVE {
            @Override
            public IState onActivate() {
                return ACTIVE;
            }
        },
        ACTIVE {
            @Override
            public void enter(IMachine machine) {
                machine.startSubMachine(this, ConnectState.class, ConnectState.DISCONNECTED, ConnectState.INACTIVE);
            }

            @Override
            public IState handle(IEvent event) {
                return machine.getSubMachine(this).processEvent(event) ? this : event.dispatch(this);

            }

            @Override
            public IState onDeactivate() {
                return INACTIVE;
            }

            @Override
            public void leave(IMachine machine) {
                machine.terminateSubMachine(this);
            }
        },
        DISABLED;
    }

    enum SessionState implements IState {
        DISABLED {
            @Override
            public IState onEnable() {
                return ENABLED;
            }
        },
        ENABLED {
            @Override
            public void enter(IMachine machine) {
                machine.startSubMachine(this, ActiveState.class, ActiveState.INACTIVE, ActiveState.DISABLED);
            }

            @Override
            public IState handle(IMachine machine, IEvent event) {
                return machine.getSubMachine(this).processEvent(event) ? this : event.dispatch(this);
            }

            @Override
            public IState onDisable() {
                return DISABLED;
            }

            @Override
            public void leave(IMachine machine) {
                machine.terminateSubMachine(this);
            }
        },
        TERMINATED;
    }

    static IMachine machine = new Machine<>(SessionState.class, SessionState.DISABLED, SessionState.TERMINATED);

    @Override
    public void run() {
        final List<Event> events = Arrays.asList(Event.ENABLE, Event.ACTIVATE, Event.DEACTIVATE, Event.DISABLE);
        machine.start(null);
        events.stream().forEach(machine::processEvent);
        machine.terminate(null);
    }

    public static void main(String... args) {
        new Session().run();
    }

}
