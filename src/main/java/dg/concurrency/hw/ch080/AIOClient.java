package dg.concurrency.hw.ch080;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;

public class AIOClient {
    public static void main(String... args) throws Exception {
        AsynchronousSocketChannel client = AsynchronousSocketChannel.open();
        client.connect(new InetSocketAddress("localhost", 9888)).get();
        // System.out.println(client.isConnected());
        client.write(ByteBuffer.wrap("test".getBytes())).get();
        // while(true) {
        //     client.write(ByteBuffer.wrap("test".getBytes())).get();
        // }
    }
}
