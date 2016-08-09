package tuning.server;

public class PassiveRequestQueue
{
  FIFO_Queue queue = new FIFO_Queue();

  public synchronized void acceptRequest(Request r)
  {
    queue.add(r);
    notify();
  }

  public synchronized Request releaseRequest()
  {
    for(;;)
    {
      if (queue.isEmpty())
        try {wait();} catch (InterruptedException e){}
      //Need to check again, in case the we were interrupted
      if (!queue.isEmpty())
        return (Request) queue.pop();
    }
  }
}
