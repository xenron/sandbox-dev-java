package tuning.cache;

import java.util.Hashtable;
import java.lang.Math;

public class Test2
{
  static Test2[] cache_keys = new Test2[128];
  static Object[] cache_values = new Object[128];
  static Hashtable hash = new Hashtable();

  int cacheRef = -1;
  int value;
  static int freeIndex = 0;

  public static void main(String[] args)
  {
    try
    {
      System.out.println("started populating");
      populate();
      System.out.println("started accessing");
      access_test();
    }
    catch(Exception e){e.printStackTrace();}
  }

  public Test2(int i)
  {
    value = i;
  }

  public int hashCode()
  {
    return value;
  }
  public boolean equals(Object obj)
  {
    if ((obj != null) && (obj instanceof Test2))
	  return value == ((Test2) obj).value;
	else
	  return false;
  }

  public static void populate()
  {
    for (int i = 0; i < 100000; i++)
      hash.put(new Test2(i), new Integer(i+5));
  }

  public static Object plain_access(Test2 i)
  {
    return hash.get(i);
  }

  public static Object cached_access(Test2 i)
  {
    int access = i.cacheRef;
    Object o;
    if (access == -1)
    {
      o = hash.get(i);
      //Wind round to the start of the cache if full up
      if (freeIndex >= cache_keys.length)
        freeIndex = 0;
      //Get the next index;
      access = i.cacheRef = freeIndex++;
      //If there was already something there, set it uncached
      if (cache_keys[access] != null)
      {
        System.out.println("Collsion between " + cache_keys[access] + " and " + i);
        cache_keys[access].cacheRef = -1;
      }
      //And cache our new value.
      cache_keys[access] = i;
      cache_values[access] = o;
      return o;
    }
    else
    {
      return cache_values[access];
    }
  }

  public static void access_test()
  {
    Test2 a0 = new Test2(6767676);
    Test2 a1 = new Test2(33);
    Test2 a2 = new Test2(998);
    Test2 a3 = new Test2(3333);
    Test2 a4 = new Test2(12348765);
    Test2 a5 = new Test2(9999);
    Test2 a6 = new Test2(66665);
    Test2 a7 = new Test2(1234);
    Test2 a8 = new Test2(987654);
    Test2 a9 = new Test2(3121219);
    Object o1,o2,o3,o4,o5,o6,o7,o8,o9,o0;
    long time = System.currentTimeMillis();
    for (int i = 0; i < 1000000; i++)
    {
       o1 = plain_access(a0);
       o2 = plain_access(a1);
       o3 = plain_access(a2);
       o4 = plain_access(a3);
       o5 = plain_access(a4);
       o6 = plain_access(a5);
       o7 = plain_access(a6);
       o8 = plain_access(a7);
       o9 = plain_access(a8);
       o0 = plain_access(a9);
    }
    System.out.println("plain access took " + (System.currentTimeMillis()-time));

    time = System.currentTimeMillis();
    for (int i = 0; i < 1000000; i++)
    {
       o1 = cached_access(a0);
       o2 = cached_access(a1);
       o3 = cached_access(a2);
       o4 = cached_access(a3);
       o5 = cached_access(a4);
       o6 = cached_access(a5);
       o7 = cached_access(a6);
       o8 = cached_access(a7);
       o9 = cached_access(a8);
       o0 = cached_access(a9);
    }
    System.out.println("cached access took " + (System.currentTimeMillis()-time));

  }

}
