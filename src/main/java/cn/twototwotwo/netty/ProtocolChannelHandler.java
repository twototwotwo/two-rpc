package cn.twototwotwo.netty;

import cn.twototwotwo.core.protocol.Protocol;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.ByteToMessageCodec;

import java.util.List;

import static java.nio.charset.StandardCharsets.*;

/**
 * channel handler by in and out
 * decode/encode byte to @see Reqeust
 * decode/encode byte to @see Response
 */
public class ProtocolChannelHandler extends ByteToMessageCodec<Protocol> {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof ByteBuf) {
            System.out.println(((ByteBuf) msg).toString(UTF_8));
        }
        //
        
        ctx.fireChannelRead(msg);
    }

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {

        ctx.write(msg, promise);
    }

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Protocol protocol, ByteBuf byteBuf) throws Exception {
        // request or response
        if (Protocol.TYPE_REQUEST.equals(protocol.type)) {
            byteBuf.writeByte(Protocol.TYPE_REQUEST);
        }else {
            byteBuf.writeByte(Protocol.TYPE_RESPONSE);
        }
    }

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        
    }
}
