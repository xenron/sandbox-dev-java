package dg.concurrency.hw.ch071;


import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.DoubleAdder;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class IntegralTest {

    public static double sumOfArea = 0;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // 创建一个线程池
        ExecutorService se = Executors.newFixedThreadPool(30);
        CalculationResource table = new CalculationResource(10);
        // 生产者对象
        Producer producer = new Producer(table);
        // 消费者对象
        Consumer consumer = new Consumer(table);
        DoubleAdder adder = new DoubleAdder();


        final FutureTask producerTask = new FutureTask(producer);
        // 启动一个生产者线程
        se.execute(producerTask);
        // 启动一个线程监听当前生产者线程的结果
        se.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String st = (String) producerTask.get();
                    System.out.println(st);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }

            }
        });

        // 模拟10个消费者
        for (int i = 0; i < 10; i++) {
            final FutureTask<Double> consumerTask = new FutureTask<Double>(consumer);
            // 启动一个消费者线程
            se.execute(consumerTask);
            // 启动一个线程监听当前消费者线程的结果
            se.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Double area = consumerTask.get();
                        sumOfArea += area.doubleValue();
                        System.out.println("Thread Result : area is " + area);
                        System.out.println("函数 y=1/x 在定义域 [1,100] 上与X轴围成的面积, 累计计算结果为：" + sumOfArea);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        se.shutdown();
    }
}


class Producer implements Callable {
    private CalculationResource t;
    private Random random = new Random();

    public Producer(CalculationResource table) {
        this.t = table;
    }

    public CalculationResource getT() {
        return t;
    }

    public void setT(CalculationResource t) {
        this.t = t;
    }

    public CalculationItem produce(double x, double y) {
        try {
            TimeUnit.MILLISECONDS.sleep(random.nextInt(20));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        CalculationItem item = new CalculationItem(x, y);
        return item;
    }

    @Override
    public String call() throws Exception {
        for (double i = 0; i < 100; ) {
            i = i + 0.01;
            CalculationItem item = produce(0.01, 1 / i);
            t.putItem(item);

        }
        return "线程：" + Thread.currentThread().getName() + " , 生产者线程结束";
    }

}


class Consumer implements Callable<Double> {
    private CalculationResource t;
    private Random random = new Random();

    public Consumer(CalculationResource table) {
        this.t = table;
    }

    public CalculationResource getT() {
        return t;
    }

    public void setT(CalculationResource t) {
        this.t = t;
    }


    public void consume(CalculationItem item) {
        try {
            item.setArea(item.getX() * item.getY());
            System.out.println("x is " + item.getX() + " , y is " + item.getY() + " , area is " + item.getArea());
            // 模拟计算所消耗的时间
            TimeUnit.MILLISECONDS.sleep(100 + random.nextInt(201));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Double call() throws Exception {
        double sumOfArea = 0;
        for (int i = 0; i < 1000; i++) {
            CalculationItem item = t.getItem();
            consume(item);
            sumOfArea = sumOfArea + item.getArea();
        }

        return sumOfArea;
    }
}


class CalculationItem {
    private double x;
    private double y;
    private double area;

    public CalculationItem(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getArea() {
        return this.area;
    }

    public void setArea(double area) {
        this.area = area;
    }
}

class CalculationResource {
    private LinkedList list = new LinkedList();
    private int maxSize;
    private Lock lock = new ReentrantLock();
    private Condition condition;

    public Lock getLock() {
        return lock;
    }

    public void setLock(Lock lock) {
        this.lock = lock;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public LinkedList getList() {
        return list;
    }

    public void setList(LinkedList list) {
        this.list = list;
    }

    public int getMaxSize() {
        return maxSize;
    }


    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public CalculationResource(int maxSize) {
        super();
        this.maxSize = maxSize;
        this.condition = lock.newCondition();
    }


    public void putItem(CalculationItem item) {
        // 进行锁定
        lock.lock();
        try {
            // 防止假唤醒
            while (list.size() >= maxSize) {

                System.out.println("线程：" + Thread.currentThread().getName() + " , 处理队列已满，稍后重试");
                this.condition.await();
            }
            list.addLast(item);
            System.out.println("线程：" + Thread.currentThread().getName() + " , 添加了计算对象：x = " + item.getX() + " , 添加了计算对象：y = " + item.getY());
            this.condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 解除锁定
            lock.unlock();
        }
    }


    public CalculationItem getItem() {
        // 进行锁定
        lock.lock();
        CalculationItem item = null;
        try {
            // 防止假唤醒
            while (list.size() <= 0) {
                System.out.println("线程：" + Thread.currentThread().getName() + " , 处理队列为空，稍后重试");
                this.condition.await();
            }
            item = (CalculationItem) list.removeFirst();
            System.out.println("线程：" + Thread.currentThread().getName() + " , 处理了计算对象：x=" + item.getX());
            this.condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 解除锁定
            lock.unlock();
        }

        return item;
    }

}
