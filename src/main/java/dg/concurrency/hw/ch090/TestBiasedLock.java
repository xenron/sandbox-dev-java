package dg.concurrency.hw.ch090;

import java.util.List;
import java.util.Vector;

public class TestBiasedLock {
    private static List<Integer> list = new Vector<Integer>();

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            list.add(i);
        }
        System.out.println("cost time : " + (System.currentTimeMillis() - start) + " ms");
    }
}
