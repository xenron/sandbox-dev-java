package dg.concurrency.hw.ch05;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by ran on 2016/3/27.
 */
public class ConcurrentLinkedQueueTest2 {
    public static void main(String[] args) {
        test2();

    }

    private static void test2() {
        long lbegin = System.currentTimeMillis();
        ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<>();
        Thread[] writers = new Thread[10];
        for (int i = 0 ; i < 10 ; i++) //10个写入线程
        {
            writers[i] = new Thread("write" + i)
            {
                @Override
                public void run()
                {
                    for (int j = 0; j < 10000; j++)
                    {
                        queue.add(j);
                    }
                }
            };
            writers[i].start();
        }

        Thread[] readers = new Thread[10];
        for (int i = 0 ; i < 10 ; i++) //10个写入线程
        {
            readers[i] = new Thread("reader" + i)
            {
                @Override
                public void run()
                {
                    Object o;
                    while( (o = queue.poll()) != null )
                    {
                        //System.out.println(Thread.currentThread().getName() + ":" + o.toString());
                    }
                }
            };

            readers[i].start();
        }

        try
        {
            for ( int i = 0; i < 10 ; i ++)
            {
                writers[i].join();
                readers[i].join();
            }
        }
        catch(InterruptedException ex)
        {
            System.out.println(ex.getMessage());
        }

        long lend = System.currentTimeMillis();
        System.out.print("ConcurrentLinkedQueue总耗时");
        System.out.println(lend - lbegin);
    }
}
