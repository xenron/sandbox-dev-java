package ch8.pattern.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureMain2 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
       
        ExecutorService executor = Executors.newFixedThreadPool(1);
          Future<String> future=executor.submit(new RealData("a"));

        System.out.println("�������");
        try {
             Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
         System.out.println("��� = " + future.get());
    }
}
