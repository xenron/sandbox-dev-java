package dg.concurrency.courseware.ch07;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureMain2 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
       
        ExecutorService executor = Executors.newFixedThreadPool(1);
        //ִ��FutureTask���൱�������е� client.request("a") ��������
        //�����￪���߳̽���RealData��call()ִ��
        Future<String> future=executor.submit(new RealData("a"));

        System.out.println("�������");
        try {
        //������Ȼ��������������ݲ���������ʹ��sleep��������ҵ���߼��Ĵ���
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        //�൱��data.getResult ()��ȡ��call()�����ķ���ֵ
        //�����ʱcall()����û��ִ����ɣ�����Ȼ��ȴ�
        System.out.println("���� = " + future.get());
    }
}
