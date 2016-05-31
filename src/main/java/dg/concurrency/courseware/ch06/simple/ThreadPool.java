package dg.concurrency.courseware.ch06.simple;

import java.util.List;
import java.util.Vector;

public class ThreadPool 
{
    private static ThreadPool instance = null;

    //���е��̶߳���
    private List<Worker> idleThreads;
    //���е��߳�����
    private int threadCounter;
    private boolean isShutDown = false;
    
    private ThreadPool() 
    {       
        this.idleThreads = new Vector(5);
        threadCounter = 0;
    }
    
    public int getCreatedThreadsCount() {
        return threadCounter;
    }
    
    //ȡ���̳߳ص�ʵ��
    public synchronized static ThreadPool getInstance() {
        if (instance == null)
            instance = new ThreadPool();
        return instance;
    }
   
    //���̷߳������
    protected synchronized void repool(Worker repoolingThread)
    {
        if (!isShutDown) 
        {
            idleThreads.add(repoolingThread);
        }
        else 
        {
            repoolingThread.shutDown();//�ر��߳�
        }
    }
        
    //ֹͣ���������߳�
    public synchronized void shutdown()
    {
       isShutDown = true;
       for (int threadIndex = 0; threadIndex < idleThreads.size(); threadIndex++)
       {
             Worker idleThread = (Worker) idleThreads.get(threadIndex);
             idleThread.shutDown();
       }
    }
    
    //ִ������
    public synchronized void start(Runnable target)
    {
        Worker thread = null; 
        //����п����̣߳���ֱ��ʹ��
        if (idleThreads.size() > 0) 
        {
            int lastIndex = idleThreads.size() - 1;
            thread = (Worker) idleThreads.get(lastIndex);
            idleThreads.remove(lastIndex);
            //����ִ���������
            thread.setTarget(target);
        }
        //û�п����̣߳��򴴽����߳�
        else 
        { 
            threadCounter++;
            // �������̣߳�
            thread = new Worker(target, "PThread #" + threadCounter, this);
            //��������߳�
            thread.start();
        }
    }
}