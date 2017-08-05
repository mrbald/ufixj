package net.bobah.ufixj;

import com.google.openrtb.OpenRtb;
import com.google.openrtb.json.OpenRtbJsonFactory;
import com.google.openrtb.json.OpenRtbJsonReader;
import com.google.openrtb.json.OpenRtbJsonWriter;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;
import io.netty.buffer.ByteBufOutputStream;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

public class HttpHandler extends SimpleChannelInboundHandler<FullHttpRequest> {
    private static final Logger LOG = LoggerFactory.getLogger(HttpHandler.class);
    private final OpenRtbJsonReader jsonReader;
    private final OpenRtbJsonWriter jsonWriter;

    public HttpHandler() {
        final OpenRtbJsonFactory jsonFactory = OpenRtbJsonFactory.create();
        jsonReader = jsonFactory.newReader();
        jsonWriter = jsonFactory.newWriter();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest msg) throws Exception {
        final OpenRtb.BidRequest bidRequest = jsonReader.readBidRequest(new ByteBufInputStream(msg.content()));
        final OpenRtb.BidResponse bidResponse = OpenRtb.BidResponse.newBuilder()
                .setId(UUID.randomUUID().toString())
                .setBidid(bidRequest.getId())
                .build();

        final ByteBuf responseBuf = Unpooled.buffer();
        jsonWriter.writeBidResponse(bidResponse, new ByteBufOutputStream(responseBuf));

        FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, responseBuf);
        response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain; charset=UTF-8");
        response.headers().set(HttpHeaderNames.CONTENT_LENGTH, response.content().readableBytes());
        response.headers().set(HttpHeaderNames.CONNECTION, HttpHeaderValues.KEEP_ALIVE);
        ctx.writeAndFlush(response);
    }
}
