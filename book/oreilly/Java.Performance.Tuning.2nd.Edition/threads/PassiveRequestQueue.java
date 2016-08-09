package tuning.threads;

public class PassiveRequestQueue
{
  //The queue of requests
  FIFO_Queue queue = new FIFO_Queue();

  public synchronized void acceptRequest(Request r)
  {
    //Add to the queue, then notify all processors waiting
    //on the releaseRequest() method
    queue.add(r);
    notify();
  }

  static boolean shutdown = false;
  public synchronized Request releaseRequest()
  {
    for(;;)
    {
      //if the queue is empty, just go back into the wait call
      if (queue.isEmpty())
        try {wait();} catch (InterruptedException e){}

      //We might have been interrupted. If shutdown is true
      //then return a null request to indicate the thread
      //should finish
      if (shutdown)
        return null;

      //Otherwise we need to check again if the queue
      //is empty, just in case.
      if (!queue.isEmpty())
        return (Request) queue.pop();
    }
  }

  public synchronized void niceShutdown()
  {
    shutdown = true;
    notifyAll();
  }
}
