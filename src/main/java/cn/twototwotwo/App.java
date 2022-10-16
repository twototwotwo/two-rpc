package cn.twototwotwo;

import cn.twototwotwo.core.Server;
import cn.twototwotwo.core.impl.ServerImpl;


/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) throws InterruptedException {
        Server server = new ServerImpl();
        server.init();
    }

}
