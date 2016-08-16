package dg.concurrency.hw.ch081;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.Future;

public class AioClient {
    public static void main(String[] args) throws Exception {
        System.out.println(" === client start === ");
        AsynchronousSocketChannel client = AsynchronousSocketChannel.open();

        Future<Void> future = client.connect(new InetSocketAddress("127.0.0.1", 12345));
        future.get();

        ByteBuffer writeBuffer = ByteBuffer.allocate(20);
        String eval = "4+5";
        System.out.println("client send message : " + eval);
        writeBuffer.put(eval.getBytes());
        writeBuffer.flip();
        client.write(writeBuffer);

        ByteBuffer buffer = ByteBuffer.allocate(20);
        client.read(buffer, null, new CompletionHandler<Integer, Void>() {
            @Override
            public void completed(Integer len, Void attachment) {
                System.out.println("received server message : " + new String(buffer.array(), 0, len));
            }

            @Override
            public void failed(Throwable exc, Void attachment) {
                exc.printStackTrace();
                try {
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });


        Thread.sleep(10000);
    }
}
