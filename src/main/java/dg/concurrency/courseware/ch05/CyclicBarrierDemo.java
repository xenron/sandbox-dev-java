package dg.concurrency.courseware.ch05;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static class Soldier implements Runnable {
        private String soldier;
        private final CyclicBarrier cyclic;

        Soldier(CyclicBarrier cyclic, String soldierName) {
            this.cyclic = cyclic;
            this.soldier = soldierName;
        }

        public void run() {
            try {
                //�ȴ�����ʿ������
                cyclic.await();
                doWork();
                //�ȴ�����ʿ����ɹ���
                cyclic.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }

        void doWork() {
            try {
                Thread.sleep(Math.abs(new Random().nextInt()%10000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(soldier + ":�������");
        }
    }

    public static class BarrierRun implements Runnable {
        boolean flag;
        int N;
        public BarrierRun(boolean flag, int N) {
            this.flag = flag;
            this.N = N;
        }

        public void run() {
            if (flag) {
                System.out.println("˾��:[ʿ��" + N + "����������ɣ�]");
            } else {
                System.out.println("˾��:[ʿ��" + N + "����������ϣ�]");
                flag = true;
            }
        }
    }

    public static void main(String args[]) throws InterruptedException {
        final int N = 10;
        Thread[] allSoldier=new Thread[N];
        boolean flag = false;
        CyclicBarrier cyclic = new CyclicBarrier(N, new BarrierRun(flag, N));
        //�������ϵ㣬��Ҫ��Ϊ��ִ���������
        System.out.println("���϶��飡");
        for (int i = 0; i < N; ++i) {
            System.out.println("ʿ�� "+i+" ������");
            allSoldier[i]=new Thread(new Soldier(cyclic, "ʿ�� " + i));
            allSoldier[i].start();
            if(i==5){
             	allSoldier[0].interrupt();
             }
        }
    }
}

