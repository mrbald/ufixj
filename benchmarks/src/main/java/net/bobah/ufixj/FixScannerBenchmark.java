/*
 * Copyright (c) 2014, Oracle America, Inc.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  * Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 *  * Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 *  * Neither the name of Oracle nor the names of its contributors may be used
 *    to endorse or promote products derived from this software without
 *    specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
 * THE POSSIBILITY OF SUCH DAMAGE.
 */

package net.bobah.ufixj;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import org.openjdk.jmh.annotations.*;

import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

@Fork(1)
@BenchmarkMode(Mode.AverageTime)
@Measurement(iterations = 5)
@Warmup(iterations = 5)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Thread)
public class FixScannerBenchmark {
    private static final byte[] newOrderMultileg =
            asFIX("8=FIX.4.2|9=232|35=AB|49=user|56=CQG_Gateway|34=2|52=20121123-11:50:54.268|11=Order2466|54=2|55=F.US.EDAS3Z12|60=20121123-11:50:34|38=3|40=1|1=9|50555=2|50600=F.US.EDAZ12 |50654=123_123|50624=2|50623=1|50600=F.US.EDAH13|50654=456|50624=1|50623=1|10=201|");
    private static final byte[] orderFill =
            asFIX("8=FIX.4.2|9=438|35=8|49=CQG_Gateway|56=fix_client|34=40|57=private_label|129=fix_client|52=20160112-12:01:08.014|50584=Request266|20026=FIX.4.2|1=10168929|37=375260011|198=9D-40E4B1AFEB9D6481|20111=20160112-11:56:25.327|20029=375260011|39=2|40=1|55=F.US.EDAS3H16|54=1|14=2.0000|151=0.0000|38=2.0000|59=0|1028=Y|6=12.00000000|17=7e6f0a75-1e8d-4f2c-977b-518f3cce7aca|20=3|150=I|60=20160112-11:56:25.400|50526=000EGBEO|11=Order10325|20014=PSfix_client|20010=SIMfix_client|10=041|");

    private byte[][] samples = {newOrderMultileg, orderFill};

    private static byte[] asFIX(String str) {
        return str.replace('|', (char)0x01).getBytes(Charset.forName("ISO-8859-1"));
    }

    private FixTagBuf fixTagBuf = new FixTagBuf();

    static class FixTagBuf {
        int size = 0;
        int[] data = new int[1024];
        enum Field {
            TAG,
            BEG,
            END
        }
    };

    private int parseWithBareLoops(byte[] buf, FixTagBuf fixTagBuf) {
        fixTagBuf.size = 0;
        for (int i = 0; i < buf.length; ++i) {
            int tag = 0;

            for (; i < buf.length && buf[i] != '='; ++i) {
                assert (buf[i] - '0' <= 9): "malformed fix message";
                tag *= 10;
                tag += (buf[i] - '0');
            }
            assert (buf[i] == '='): "malformed fix message";

            fixTagBuf.data[fixTagBuf.size + FixTagBuf.Field.TAG.ordinal()] = tag;

            fixTagBuf.data[fixTagBuf.size + FixTagBuf.Field.BEG.ordinal()] = ++i;

            for (; i < buf.length && buf[i] != 0x01; ++i);
            assert (buf[i] == 0x01): "malformed fix message";

            fixTagBuf.data[fixTagBuf.size + FixTagBuf.Field.END.ordinal()] = i++;
            ++fixTagBuf.size;
        }
        return fixTagBuf.size;
    }

    @FunctionalInterface
    public interface FixMsgVisitor {
        boolean visit(int tag, int beg, int end);
    }

    private int parseWithVisitor(byte[] buf, int pos, int len, FixMsgVisitor visitor) {
        for (int i = pos; i < len; ++i) {
            int tag = 0;

            for (; i < len && buf[i] != '='; ++i) {
                assert (buf[i] - '0' <= 9): "malformed fix message";
                tag *= 10;
                tag += (buf[i] - '0');
            }
            assert (buf[i] == '='): "malformed fix message";

            final int beg = ++i;

            for (; i < len && buf[i] != 0x01; ++i);
            assert (buf[i] == 0x01): "malformed fix message";

            final int end = i++;

            if (!visitor.visit(tag, beg, end))
                return i;
        }
        return len;
    }

    ByteBuf byteBuf = PooledByteBufAllocator.DEFAULT.directBuffer(1024);
    byte[] arrayByteBuf = new byte[1024];
    {
        byteBuf.writeBytes(newOrderMultileg);
    }

    @Benchmark
    public int benchmarkNewOrderMultileg() {
        byteBuf.markReaderIndex();
        try {
            int len = byteBuf.readableBytes();
            byteBuf.readBytes(arrayByteBuf, 0, len);
            return parseWithVisitor(arrayByteBuf,0, len, (tag, beg, end) -> true);
        } finally {
            byteBuf.resetReaderIndex();
        }
    }

    @Benchmark
    public int benchmarkOrderFillVisitor() {
        return parseWithVisitor(orderFill, 0, orderFill.length, (tag, beg, end) -> true);
    }

    @Benchmark
    public int benchmarkOrderFillBareLoop() {
        fixTagBuf.size = 0;
        return parseWithBareLoops(orderFill, fixTagBuf);
    }

}
