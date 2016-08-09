package packt;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.EnumSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ReadingFromAFileUsingTheAsynchronousFileChannelCllass {
 
    public static void main(String args[]) {
        ExecutorService pool = new ScheduledThreadPoolExecutor(3);        
        try (AsynchronousFileChannel fileChannel =
                        AsynchronousFileChannel.open(Paths.get("/home/docs/items.txt"),
                        EnumSet.of(StandardOpenOption.READ), pool)) {
            System.out.println("Main Thread ID: " + Thread.currentThread().getId());

            CompletionHandler<Integer, ByteBuffer> handler =
                    new CompletionHandler<Integer, ByteBuffer>() {

                        @Override
                        public synchronized void completed(Integer result, ByteBuffer attachment) {
                            for (int i = 0; i < attachment.limit(); i++) {
                                System.out.print((char) attachment.get(i));
                            }
                            System.out.println("");
                            System.out.println("CompletionHandler Thread ID: "
                                    + Thread.currentThread().getId());
                            System.out.println("");
                        }

                        @Override
                        public void failed(Throwable e, ByteBuffer attachment) {
                            System.out.println("Failed");
                        }
                    };
            final int bufferCount = 5;
            ByteBuffer buffers[] = new ByteBuffer[bufferCount];
            for (int i = 0; i < bufferCount; i++) {
                buffers[i] = ByteBuffer.allocate(10);
                fileChannel.read(buffers[i], i * 10, buffers[i], handler);
            }
            pool.awaitTermination(1, TimeUnit.SECONDS);

            System.out.println("Byte Buffers");
            for (ByteBuffer byteBuffer : buffers) {
                for (int i = 0; i < byteBuffer.limit(); i++) {
                    System.out.print((char) byteBuffer.get(i));
                }
                System.out.println();
            }
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
