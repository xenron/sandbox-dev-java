package dg.concurrency.hw.ch081;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class NioClient
{
    public static void main(String[] args)throws Exception
    {
        SocketChannel client = SocketChannel.open();
        client.configureBlocking(false);
        client.connect(new InetSocketAddress("localhost", 12345));
        Selector selector = Selector.open();
        client.register(selector, SelectionKey.OP_CONNECT);
        System.out.println("===== client start ====");

        while(true)
        {
            if(selector.select()>0)
            {
                Iterator<SelectionKey> iter = selector.selectedKeys().iterator();

                while(iter.hasNext())
                {
                    SelectionKey key = iter.next();
                    iter.remove();
                    SocketChannel channel = (SocketChannel) key.channel();
                    if(key.isConnectable())
                    {
                        channel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
                        channel.finishConnect();
                        System.out.println("client connection server");
                        channel.write(ByteBuffer.wrap("client prepare \r\n".getBytes()));
                    }
                    //read
                    if(key.isReadable())
                    {
                        ByteBuffer buffer = ByteBuffer.allocate(20);
                        int len = -1;
                        while(0 != (len = channel.read(buffer)))
                        {
                            System.out.println(new String(buffer.array(), 0, len));
                            buffer.clear();
                        }
                    }
                    //write
                    if(key.isWritable())
                    {
                        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
                        String line = read.readLine();
                        channel.write(ByteBuffer.wrap((line + "\r\n").getBytes()));
                    }
                    // delay time
                    Thread.sleep(2000);
                }

            }

        }

    }
}
