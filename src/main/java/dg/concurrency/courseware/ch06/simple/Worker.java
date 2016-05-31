package dg.concurrency.courseware.ch06.simple;

public class Worker extends Thread 
{
	//�̳߳�
    private ThreadPool pool;
    //����
    private Runnable target;   
    private boolean isShutDown = false;
    private boolean isIdle = false;
    
    public Worker(Runnable target, String name, ThreadPool pool)
    {
        super(name);
        this.pool = pool;
        this.target = target;
    }
    
    public Runnable getTarget() 
    {
        return target;
    }
    
    public boolean isIdle() 
    {
        return isIdle;
    }
    public void run() 
    {
        while (!isShutDown) 
        {  
            isIdle = false;
            if (target != null) 
            {
            	// ��������
                target.run();  
            }
            //���������
            isIdle = true;
            try 
            {
            	//����������󣬲��ر��̣߳����Ƿ����̳߳ؿ��ж���
                pool.repool(this);
                synchronized (this) 
                {
                	//�߳̿��У��ȴ��µ�������
                    wait();
                }
            }
            catch (InterruptedException ie)
            {
            }
            isIdle = false;
        }
    }
    
    
    public synchronized void setTarget(Runnable newTarget)
    {
        target = newTarget; 
        //����������֮��֪ͨrun��������ʼִ���������
        notifyAll();       
    }
    
    public synchronized void shutDown()
    {
        isShutDown = true;
        notifyAll();
    }
}
