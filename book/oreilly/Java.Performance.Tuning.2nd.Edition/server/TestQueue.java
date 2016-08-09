package tuning.server;

import java.util.Vector;

public class TestQueue
{
  public static void main(String[] args)
  {
        ActiveRequestQueue q = new ActiveRequestQueue(2);
	q.acceptRequest(new Request());
	q.acceptRequest(new Request());
	q.acceptRequest(new Request());
	q.acceptRequest(new Request());
        //stagger the requests juts slightly
        try{Thread.sleep(1000);}catch(InterruptedException e){}
	q.acceptRequest(new Request());
	q.acceptRequest(new Request());
	q.acceptRequest(new Request());
	q.acceptRequest(new Request());
	q.acceptRequest(new Request());
	q.acceptRequest(new Request());
	q.acceptRequest(new Request());
  }
}

class FIFO_Queue {
  java.util.Stack v = new java.util.Stack();
  public void add(Object o){v.push(o);}
  public Object pop(){return v.pop();}
  public boolean isEmpty(){return v.isEmpty();}
}

class RequestProcessor {
  public RequestResult processRequest(Request r)
  {
    System.out.println("Processing request: " + r);
    try{Thread.sleep(2000);}catch(InterruptedException e){}
    return new RequestResult();
  }
}
class RequestResult {
}
class Request {
}
