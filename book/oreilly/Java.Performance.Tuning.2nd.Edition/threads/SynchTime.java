package tuning.threads;
//import java.util.Random;
import tuning.unpublishable.Random;
public class SynchTime
{
  long SEED = 12345L;
  static Random Rand;
  static SynchTime Other = new SynchTime();
  static boolean Switch;
  int num = 0;

  public boolean equals(Object o)
  {
    return ((SynchTime) o).num == num;
  }

  public boolean unsyncTest()
  {
    if(Switch)
      num = Rand.nextInt();
    else
      num = 0;
    Switch = !Switch;
    return Other.equals(this);
  }
  public synchronized boolean syncTest()
  {
    if(Switch)
      num = Rand.nextInt();
    else
      num = 0;
    Switch = !Switch;
    return Other.equals(this);
  }
  public static void main(String args[])
  {
    int repeat = 10000000;
    SynchTime inst = new SynchTime();
    inst.main1(repeat);
    inst.main2(repeat);
    inst.main3(repeat);
    inst.main4(repeat);
    inst.main1(repeat);
    inst.main4(repeat);
    inst.main3(repeat);
    inst.main2(repeat);
  }    
  public void main1(int repeat)
  {
    Rand = new Random(SEED);
    Switch = false;
    num = 0;
    int count = 0;
    long time = System.currentTimeMillis();
    for (int i = repeat; i > 0; i--)
    {
      if(Switch)
        num = Rand.nextInt();
      else
        num = 0;
      Switch = !Switch;
      if (Other.equals(this))
        count++;
    }
    System.out.println("inlined took " + (System.currentTimeMillis() - time) + " count = " + count);
  }    
  public void main2(int repeat)
  {
    Rand = new Random(SEED);
    Switch = false;
    num = 0;
    int count = 0;
    long time = System.currentTimeMillis();
    for (int i = repeat; i > 0; i--)
      if (unsyncTest())
        count++;
    System.out.println("unsyncTest took " + (System.currentTimeMillis() - time) + " count = " + count);
  }    
  public void main3(int repeat)
  {
    Rand = new Random(SEED);
    Switch = false;
    num = 0;
    int count = 0;
    long time = System.currentTimeMillis();
    for (int i = repeat; i > 0; i--)
      if (syncTest())
        count++;
    System.out.println("syncTest took " + (System.currentTimeMillis() - time) + " count = " + count);
  }
  public void main4(int repeat)
  {
    Rand = new Random(SEED);
    Switch = false;
    num = 0;
    int count = 0;
    long time = System.currentTimeMillis();
    synchronized(this)
    {
      for (int i = repeat; i > 0; i--)
        if (unsyncTest())
          count++;
    }
    System.out.println("sync unsyncTest took " + (System.currentTimeMillis() - time) + " count = " + count);
  }
}
