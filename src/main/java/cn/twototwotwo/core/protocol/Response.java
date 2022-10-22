package cn.twototwotwo.core.protocol;

import java.util.Map;

public class Response extends Protocol{
    public Response() {
        type = TYPE_RESPONSE;
    }
    
    private byte[] data;
}