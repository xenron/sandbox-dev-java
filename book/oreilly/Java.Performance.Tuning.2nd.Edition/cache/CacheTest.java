package tuning.cache;

import java.util.HashMap;
import java.util.Hashtable;
import java.lang.Math;

public class CacheTest
{
  static Object[] cache_keys = new Object[128];
  static Object[] cache_values = new Object[128];
  static Hashtable hash = new Hashtable();

  public static void main(String[] args)
  {
    try
    {
      System.out.println("started populating");
      populate();
      System.out.println("started accessing");
      access_test();
      access_test();
    }
    catch(Exception e){e.printStackTrace();}
  }

  public static void populate()
  {
    for (int i = 0; i < 100000; i++)
      hash.put(new Integer(i), new Integer(i+5));
  }

  public static Object plain_access(Integer i)
  {
    return hash.get(i);
  }

  public static Object cached_access(Integer i)
  {
    int access = Math.abs(i.hashCode()) & 127;
    Object o;
    if ( (o = cache_keys[access]) == null || !o.equals(i))
    {
      if (o != null)
        System.out.println("Collsion between " + o + " and " + i);
      o = hash.get(i);
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
    Integer a0 = new Integer(6767676);
    Integer a1 = new Integer(33);
    Integer a2 = new Integer(998);
    Integer a3 = new Integer(3333);
    Integer a4 = new Integer(12348765);
    Integer a5 = new Integer(9999);
    Integer a6 = new Integer(66665);
    Integer a7 = new Integer(1234);
    Integer a8 = new Integer(987654);
    Integer a9 = new Integer(3121219);
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
