package cn.twototwotwo.core.protocol;

public class Request extends Protocol{
    public Request() {
        type = TYPE_REQUEST;
    }

    public String serviceName;

    public String methodName;

    public byte argsCount;

    public byte[][] args;
}