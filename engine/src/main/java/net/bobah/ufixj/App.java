package net.bobah.ufixj;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.kqueue.KQueueEventLoopGroup;
import io.netty.channel.kqueue.KQueueServerSocketChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.HttpServerKeepAliveHandler;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.SelfSignedCertificate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;


/**
 * Hello world!
 *
 */
public class App 
{
    private static final boolean SSL = System.getProperty("ssl") != null;
    private static final int PORT = Integer.parseInt(System.getProperty("port", SSL? "8443" : "8080"));

    private static final Logger log = LoggerFactory.getLogger(App.class);
    public static void main( String[] args ) throws Exception {
        final SslContext sslCtx;
        if (SSL) {
            SelfSignedCertificate ssc = new SelfSignedCertificate();
            sslCtx = SslContextBuilder.forServer(ssc.certificate(), ssc.privateKey()).build();
        } else {
            sslCtx = null;
        }

        final EventLoopGroup eventLoopGroup = new KQueueEventLoopGroup();
        try {
            new ServerBootstrap()
                    .group(eventLoopGroup)
                    .channel(KQueueServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            if (sslCtx != null) {
                                ch.pipeline().addLast(sslCtx.newHandler(ch.alloc()));
                            }

                            ch.pipeline()
                                    .addLast(new HttpServerCodec())
                                    .addLast(new HttpServerKeepAliveHandler())
                                    .addLast(new HttpObjectAggregator(1 << 20))
                                    //.addLast(new HttpServerExpectContinueHandler()) <-- encapsulated in HttpObjectAggregator
                                    .addLast(new HttpHandler());
                        }
                    })
                    .option(ChannelOption.SO_BACKLOG, 1000)
                    .option(ChannelOption.SO_REUSEADDR, true)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    .childOption(ChannelOption.SO_SNDBUF, 100000)
                    .childOption(ChannelOption.SO_RCVBUF, 100000)
                    .childOption(ChannelOption.TCP_NODELAY, true)
                    .localAddress(new InetSocketAddress(PORT))
                    //.childOption(ChannelOption.SO_LINGER, 0)
                    .validate()
                    .bind()
                    .channel()
                    .closeFuture()
                    .sync();
        } finally {
            eventLoopGroup.shutdownGracefully();
        }
    }
}
