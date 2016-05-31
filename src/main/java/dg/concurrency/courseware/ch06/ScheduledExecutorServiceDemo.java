
package dg.concurrency.courseware.ch06;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceDemo {
    public static void main(String[] args) {
        ScheduledExecutorService ses=Executors.newScheduledThreadPool(10);
        //���ǰ�������û����ɣ������Ҳ��������
        ses.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    System.out.println(System.currentTimeMillis()/1000);
//                    if(System.currentTimeMillis()%2==0){
//                    	System.out.println("exception");
//                    	throw new RuntimeException();
//                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }                
            }
        }, 0, 2, TimeUnit.SECONDS);
        
    }
}
