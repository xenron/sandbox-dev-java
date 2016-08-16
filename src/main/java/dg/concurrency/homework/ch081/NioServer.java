package dg.concurrency.hw.ch081;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class NioServer {
    public static void main(String[] args) throws Exception {

        ServerSocketChannel server = ServerSocketChannel.open();
        server.bind(new InetSocketAddress(12345));
        server.configureBlocking(false);
        Selector selector = Selector.open();
        server.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("======= server start =======");
        while (true) {
            while (selector.select() > 0) {
                Iterator<SelectionKey> iter = selector.selectedKeys().iterator();
                while (iter.hasNext()) {
                    SelectionKey key = iter.next();
                    iter.remove();
                    if (key.isAcceptable()) {
                        SocketChannel channel = ((ServerSocketChannel) (key.channel())).accept();
                        channel.configureBlocking(false);
                        channel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
                        System.out.println("server accept client");
                        channel.write(ByteBuffer.wrap("server already \r\n".getBytes()));
                    }
                    //read
                    if (key.isReadable()) {

                        SocketChannel channel = (SocketChannel) key.channel();
                        ByteBuffer buffer = ByteBuffer.allocate(20);
                        int len = 0;
                        String result = "";
                        while (0 != (len = channel.read(buffer))) {
                            result = result + new String(buffer.array(), 0, len);
                            buffer.clear();
                        }
                        if (!result.startsWith("client prepare ")) {
                            result = result.replaceAll("\r\n","");
                            System.out.println("recive eval : " + result);
                            result = String.valueOf(Eval.eval(result));
                            System.out.println("send result : " + result);
                            channel.write(ByteBuffer.wrap((result + "\r\n").getBytes()));
                        }

                    }
                    // delay time
                    Thread.sleep(2000);
                }
            }
        }

    }
}
