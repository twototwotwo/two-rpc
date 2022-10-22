package cn.twototwotwo.core.protocol;

public abstract class Protocol {
    public final static Byte VERSION = 0;
    public final static Byte TYPE_REQUEST = 0;

    public final static Byte TYPE_RESPONSE = 1;

    /**
    * must equal Protocol.VERSION
     */
    public byte version = VERSION;

    /**
     * type=0 : @see Request
     * type=1 : @see Response
     */
    public byte type;

    /**
     * how to serizable/deserizable
    * @see cn.twototwotwo.serizable.SerializeType
     */
    public byte serializeType;

    public int uniqueId;
}