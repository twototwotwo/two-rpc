package cn.twototwotwo.core.protocol;

public class Protocol {

    public static Byte TYPE_REQUEST = 0;

    public static Byte TYPE_RESPONSE = 1;

    /**
     * type=0 : @see Request
     * type=1 : @see Response
     */
    public Byte type;

    /**
     * how to serizable/deserizable
    * @see cn.twototwotwo.serizable.SerializeType
     */
    public Byte serializeType;

    public String methodName;

    public Byte argsCount;

    public Byte[][] args;

    
}