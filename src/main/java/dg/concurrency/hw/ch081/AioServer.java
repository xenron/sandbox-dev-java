package dg.concurrency.hw.ch081;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Date;
import java.util.concurrent.*;


public class AioServer {
    private static Charset charset = Charset.forName("UTF-8");
    private static CharsetEncoder encoder = charset.newEncoder();
    private static String result = "";

    public static void main(String[] args) throws Exception {
        System.out.println(" === server start === ");
        AsynchronousChannelGroup group = AsynchronousChannelGroup.withThreadPool(Executors.newFixedThreadPool(4));
        AsynchronousServerSocketChannel server = AsynchronousServerSocketChannel.open(group).bind(new InetSocketAddress("0.0.0.0", 12345));
        server.accept(null, new CompletionHandler<AsynchronousSocketChannel, Void>() {
            @Override
            public void completed(AsynchronousSocketChannel ch, Void attachment) {
                server.accept(null, this);
                try {
                    handle(ch);
                    String now = new Date().toString();
                    ByteBuffer buffer = encoder.encode(CharBuffer.wrap(result));
//                    ByteBuffer buffer = encoder.encode(CharBuffer.wrap("9" + "\r\n"));
                    //result.write(buffer, null, new CompletionHandler<Integer,Void>(){...}); //callback or
                    Future<Integer> f = ch.write(buffer);
                    f.get();
                    System.out.println("server sent message : " + result);

                    ch.close();
                } catch (IOException | InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void failed(Throwable exc, Void attachment) {
                exc.printStackTrace();
            }
        });

        group.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
    }

    public static void handle(AsynchronousSocketChannel channel) {
        ByteBuffer buffer = ByteBuffer.allocate(20);
        int len = 0;

        try {
//            while (0 != (len = channel.read(buffer).get())) {
//                result = result + new String(buffer.array(), 0, len);
//                buffer.clear();
//            }
            len = channel.read(buffer).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        buffer.flip();
        String eval = new String(buffer.array(), 0, len);
        System.out.println("receive client message : " + eval );
        result = String.valueOf(Eval.eval(eval));
//        System.out.println("server receive : " + result);
    }
}