package tuning.threads;

public class ThreadRace
  implements Runnable
{
  //global counter
  static int num=0;

  public static void increment()
  {
    int n = num;
    //This next line gives the context switcher an ideal
    //place to switch context.
    System.out.print(num+" ");
    //And when it switches back, n will still be the old
    //value from the old thread.
    num = n + 1;
  }

  public static void main(String args[])
  {
    ThreadRace d1 = new ThreadRace();
    ThreadRace d2 = new ThreadRace();

    Thread d1Thread = new Thread(d1);
    Thread d2Thread = new Thread(d2);

    d1Thread.start();
    d2Thread.start();
  }

  public void run()
  {
    for (int i = 200; i >= 0 ; i--)
    {
      increment();
    }
  }
}
