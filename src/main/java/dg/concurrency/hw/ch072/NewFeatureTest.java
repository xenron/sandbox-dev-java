package dg.concurrency.hw.ch072;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;


public class NewFeatureTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // 创建一个具有10个线程的线程池
        ExecutorService se = Executors.newFixedThreadPool(30);
        // 产生一张桌子，桌子的最大容量为10
        DiningTable table = new DiningTable(10);
        // 产生生产者对象
        Chef chef = new Chef(table);
        // 产生消费者对象
        Eater eater = new Eater(table);


        //本例只是模拟10个生产者与10个消费者，并没有完全按照题目的意思来进行解答
        for (int i = 1; i < 11; i++) {
            final FutureTask cheafTask = new FutureTask(chef);
            final FutureTask eaterTask = new FutureTask(eater);
            // 启动一个生产者线程
            se.execute(cheafTask);
            // 启动一个消费者线程
            se.execute(eaterTask);
            // 启动一个线程监听当前生产者线程的结果
            se.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        String st = (String) cheafTask.get();
                        System.out.println(st);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }

                }
            });
            // 启动一个线程监听当前消费者线程的结果
            se.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        String st = (String) eaterTask.get();
                        System.out.println(st);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                }
            });
            //有序地关闭前面已经启动的一些线程
        }
        se.shutdown();
    }
}


class Chef implements Callable {
    private DiningTable t;
    private Random random = new Random();

    public Chef(DiningTable table) {
        this.t = table;
    }

    public DiningTable getT() {
        return t;
    }

    public void setT(DiningTable t) {
        this.t = t;
    }

    public Dish produce() {
        try {
            // 模拟做菜用的时间,200-400毫秒一道菜
            // 跟下面一句的效果一致
            TimeUnit.MILLISECONDS.sleep(200 + random.nextInt(201));
            // Thread.sleep(200 + random.nextInt(201));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Dish food = new Dish();
        return food;
    }

    @Override
    public String call() throws Exception {
        for (int i = 0; i < 10; i++) {
            Dish food = produce();
            t.putFood(food);
        }
        return Thread.currentThread().getName() + "结束";
    }

}


class Eater implements Callable {
    private DiningTable t;
    private Random random = new Random();

    public Eater(DiningTable table) {
        this.t = table;
    }

    public DiningTable getT() {
        return t;
    }

    public void setT(DiningTable t) {
        this.t = t;
    }


    public void consume(Dish food) {
        try {
            // 模拟吃菜用的时间
            // 跟下面一句的效果一致
            TimeUnit.MILLISECONDS.sleep(400 + random.nextInt(201));
            // Thread.sleep(400 + random.nextInt(201));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String call() throws Exception {
        for (int i = 0; i < 10; i++) {
            Dish food = t.getFood();
            consume(food);
        }

        return Thread.currentThread().getName() + "结束";
    }

}


class Dish {
    Random random = new Random();

    private String foodName;

    public Dish() {
        super();
        int posi = random.nextInt(name.length);
        this.foodName = name[posi];
    }

    String name[] = {"巫山烤鱼", "清炒小白菜 ", "糖醋里脊", "手撕包菜", "拔丝香蕉", "水煮肉片", "酸菜鱼",
            "土豆肉片"};

    public String getName() {
        return foodName;
    }

}


class DiningTable {
    // 装食物用的容器
    private LinkedList list = new LinkedList();
    // 定义最大放菜量
    private int maxSize;
    // 创建一把锁
    private Lock lock = new ReentrantLock();
    // 获得当前lock对象的 Condition 实例
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

    public DiningTable(int maxSize) {
        super();
        this.maxSize = maxSize;
        this.condition = lock.newCondition();
    }


    public void putFood(Dish food) {
        // 先进行锁定, 与synchronize起的作用类似
        lock.lock();
        try {
            // 防止假唤醒
            while (list.size() >= maxSize) {

                System.out.println("菜已经上满了" + Thread.currentThread().getName() + ",让他们先吃,等消灭几盘再做菜");
                // 如果桌子的菜已经放满了，则让当前线程等待
                this.condition.await();
            }
            list.addLast(food);
            System.out.println(Thread.currentThread().getName() + "烹饪了"
                    + food.getName());
            // 通知所有休眠的食客线程继续吃菜
            this.condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 解除锁定
            lock.unlock();
        }
    }


    public Dish getFood() {
        // 先进行锁定, 与synchronize起的作用类似
        lock.lock();
        Dish dish = null;
        try {
            // 防止假唤醒
            while (list.size() <= 0) {
                System.out.println("菜已经被吃光了" + Thread.currentThread().getName() + "歇会再吃");

                // 如果桌子上已经没有菜了，则让当前线程等待
                this.condition.await();
            }
            dish = (Dish) list.removeFirst();
            System.out.println(Thread.currentThread().getName() + "吃掉了"
                    + dish.getName());
            // 通知所有休眠的做菜线程继续做菜
            this.condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 解除锁定
            lock.unlock();
        }

        return dish;
    }

}
