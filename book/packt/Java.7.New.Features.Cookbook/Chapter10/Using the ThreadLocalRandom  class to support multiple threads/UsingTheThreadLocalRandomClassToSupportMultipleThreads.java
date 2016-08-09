package packt;

import java.util.concurrent.ThreadLocalRandom;

public class UsingTheThreadLocalRandomClassToSupportMultipleThreads {

    public static void main(String[] args) {
        System.out.println("Five random integers");
        for(int i = 0; i<5; i++) {
            System.out.println(ThreadLocalRandom.current().nextInt());
        }
        
        System.out.println();
        System.out.println("Random double number between 0.0 and 35.0");
        System.out.println(ThreadLocalRandom.current().nextDouble(35.0));
        
        System.out.println();
        System.out.println("Five random Long numbers between 1234567 and 7654321");
        for(int i = 0; i<5; i++) {
            System.out.println(
                    ThreadLocalRandom.current().nextLong(1234567L, 7654321L));
        }


    }
}
