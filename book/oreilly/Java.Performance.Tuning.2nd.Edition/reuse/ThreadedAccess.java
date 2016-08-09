package tuning.reuse;

import java.util.*;

public class ThreadedAccess
  implements Runnable
{
  static int ThreadCount = 0;

  public void run()
  {
    //simple test just accesses the thread local vector, adds the
    //thread specific string to it, and sleeps for two seconds before
    //again accessing the thread local and printing out the value.
    String s = "This is thread " + ThreadCount++;
    Vector v = getVector();
    v.addElement(s);
    v = getVector();
    v.addElement(s);
    try{Thread.sleep(2000);}catch(Exception e){}
    v = getVector();
    v.addElement(s);
    System.out.println(v);
  }

  public static void main(String[] args)
  {
    try
    {
      for (int i = 0; i < 5; i++)
      {
        (new Thread(new ThreadedAccess())).start();
        try{Thread.sleep(200);}catch(Exception e){}
      }
    }
    catch(Exception e){e.printStackTrace();}
  }

  private static ThreadLocal vectors = new ThreadLocal();
  public static Vector getVector()
  {
     //Lazily initialized version. Get the thread local object
     Vector v = (Vector) vectors.get();
     if (v == null)
     {
       //First time. So create a vector and set the thread local
       v = new Vector();
       vectors.set(v);
     }
     return v;
  }

  private static Hashtable hvectors = new Hashtable();
  /* This method is equivalent to the getVector() method, 
   * but works prior to JDK 1.2 (as well as after).
   */
  public static Vector getVectorPriorToJDK12()
  {
     //Lazily initialized version. Get the thread local object
     Vector v = (Vector) hvectors.get(Thread.currentThread());
     if (v == null)
     {
       //First time. So create a vector and set the thread local
       v = new Vector();
       hvectors.put(Thread.currentThread(), v);
     }
     return v;
  }
}
