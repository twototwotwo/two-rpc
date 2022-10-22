package cn.twototwotwo.netty;

import cn.twototwotwo.core.protocol.Protocol;
import cn.twototwotwo.core.protocol.Request;
import cn.twototwotwo.core.protocol.Response;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageCodec;

import java.util.List;

public class ProtocolCodec extends ByteToMessageCodec<Protocol> {

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Protocol protocol, ByteBuf byteBuf) throws Exception {

    }

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        // mark readerIndex in order to reset when decode fail
        byteBuf.markReaderIndex();

        if (byteBuf.readableBytes() < 2) {
            return;
        }

        // check version
        if (Protocol.VERSION != byteBuf.readByte()) {
            // TODO log err
            return;
        }
        // rqeuest or response
        byte type = byteBuf.readByte();
        Protocol protocol;
        if (Protocol.TYPE_REQUEST.equals(type)) {
            protocol = decodeRequest(byteBuf);
        }else {
            protocol = decodeRepsonse(byteBuf);
        }
        if (protocol == null) {
            byteBuf.resetReaderIndex();
        }else {
            list.add(protocol);
        }
    }


    private Request decodeRequest(ByteBuf byteBuf) {
        Request request = new Request();
        // read service name
        
        // read method name

        // read args count

        // loop to read all args

        return request;
    }

    private Response decodeRepsonse(ByteBuf byteBuf) {
        Response reponse = new Response();

        return reponse;
    }
}