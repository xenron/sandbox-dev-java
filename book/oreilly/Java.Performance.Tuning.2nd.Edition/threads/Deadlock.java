package tuning.threads;

public class Deadlock implements Runnable
{
  String me;
  Deadlock other;

  public synchronized void hello()
  {
    //print out hello from this thread then sleep one second.
    System.out.println(me + " says hello");
    try {Thread.sleep(1000);}
    catch (InterruptedException e) {}
  }

  public void init(String name, Deadlock friend)
  {
    //We have a name, and a reference to the other Deadlock object
    //so that we can call each other
    me = name;
    other = friend;
  }

  public static void main(String args[])
  {
    //wait as long as the argument suggests (or use 20 ms as default)
    int wait = args.length == 0 ? 20 : Integer.parseInt(args[0]);

    Deadlock d1 = new Deadlock();
    Deadlock d2 = new Deadlock();

    //make sure the Deadlock objects know each other
    d1.init("d1", d2);
    d2.init("d2", d1);

    Thread d1Thread = new Thread(d1);
    Thread d2Thread = new Thread(d2);

    //Start the first thread, then wait as long as
    //instructed before starting the other
    d1Thread.start();
    try {Thread.sleep(wait);}
    catch (InterruptedException e) {}
    d2Thread.start();
  }

  public synchronized void run()
  {
    //We say we’re starting, then sleep half a second.
    System.out.println("Starting thread " + me);
    try {Thread.sleep(500);}
    catch (InterruptedException e) {}

    //Then we say we’re calling the other guy’s hello(), and do so
    System.out.println("Calling hello from " + me + " to " + other.me);
    other.hello();
    System.out.println("Ending thread " + me);
  }
}
