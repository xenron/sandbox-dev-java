package dg.concurrency.hw.ch080;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class NioTcpServer1 {
    public static void main(String[] args) throws Exception {
        //open ServerSocketChannel
        ServerSocketChannel server = ServerSocketChannel.open();
        // bind port
        server.bind(new InetSocketAddress(17000));
        //set noblocking
        server.configureBlocking(false);
        //open selector
        Selector selector = Selector.open();
        //register accept event
        server.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("=======server start=======");
        while (true) {
            while (selector.select() > 0) {
                Iterator<SelectionKey> iter = selector.selectedKeys().iterator();
                while (iter.hasNext()) {
                    SelectionKey key = iter.next();
                    //avoid duplication
                    iter.remove();
                    //accept
                    if (key.isAcceptable()) {
                        SocketChannel channel = ((ServerSocketChannel) (key.channel())).accept();
                        channel.configureBlocking(false);
                        //register read and write
                        channel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
                        System.out.println("server accept client");
                        channel.write(ByteBuffer.wrap("server already \r\n".getBytes()));
                    }
                    //read
                    if (key.isReadable()) {

                        SocketChannel channel = (SocketChannel) key.channel();
                        ByteBuffer buffer = ByteBuffer.allocate(20);
                        int len = 0;
                        while (0 != (len = channel.read(buffer))) {
                            System.out.println(new String(buffer.array(), 0, len));
                            buffer.clear();
                        }
                    }
                    //write
                    if (key.isWritable()) {
                        System.out.print("server#: ");
                        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

                        String line = read.readLine();

                        SocketChannel channel = (SocketChannel) key.channel();
                        //send some data
                        channel.write(ByteBuffer.wrap((line + "\r\n").getBytes()));
                    }
                    //set network delay
                    Thread.sleep(2000);
                }
            }
        }

    }
}
