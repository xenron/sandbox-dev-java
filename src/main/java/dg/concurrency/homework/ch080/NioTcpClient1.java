package dg.concurrency.hw.ch080;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class NioTcpClient1
{
    public static void main(String[] args)throws Exception
    {
        //get socketchannel
        SocketChannel client = SocketChannel.open();
        //set no blocking
        client.configureBlocking(false);
        //connect to remote address
        client.connect(new InetSocketAddress("localhost", 17000));
        //open selector
        Selector selector = Selector.open();
        //register connection event
        client.register(selector, SelectionKey.OP_CONNECT);

        System.out.println("=====client start====");

        while(true)
        {
            if(selector.select()>0)
            {
                Iterator<SelectionKey> iter = selector.selectedKeys().iterator();

                while(iter.hasNext())
                {
                    SelectionKey key = iter.next();
                    //avoid duplication
                    iter.remove();
                    //obtain current channel
                    SocketChannel channel = (SocketChannel) key.channel();
                    //connect
                    if(key.isConnectable())
                    {
                        //register read and write
                        channel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
                        //finish connect
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
                        System.out.print("client#: ");
                        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

                        String line = read.readLine();
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
