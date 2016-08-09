package tuning.list;

import java.util.*;

public class Test2
{
  public static void main(String[] args)
  {
    int multiple = args.length == 0 ? 1 : Integer.parseInt(args[0]);
    test1(multiple);
//    System.out.println();
    test1(multiple);
  }

  public static void forceGC() {/*testmemory(64);*/ }

  public static void test1(int multiple)
  {
    //Compare arraylist vs linkedlist insertion at 0, end, middle.
    Object element = new Object();
    int repeat_short = 100 * multiple;
    int repeat_medium = 10000 * multiple;
    int repeat_long = 1000000 * multiple;

    forceGC();
    traversal2(repeat_long, element, repeat_short/10);
    forceGC();
    traversal2(repeat_long, element, repeat_short/10);
    forceGC();
    traversal(repeat_long, element, repeat_short);

    forceGC(); System.out.println("First Short ArrayList " + insert0(new ArrayList(100), repeat_short, element, 10000));
    forceGC(); System.out.println("Last Short ArrayList " + insert_last(new ArrayList(100), repeat_short, element, 10000));
    forceGC(); System.out.println("Middle Short ArrayList " + insert_mid(new ArrayList(100), repeat_short, element, 10000));
  }

  public static void traversal2(int size, Object o, int repeat)
  {
    ArrayList al = new ArrayList();
    for (int i = 0; i < size; i++)
      al.add(o);
    System.out.println("Starting");

    ListIterator iterator;
    long time = System.currentTimeMillis();
    int count = 0;
    for (int j = 0; j < repeat; j++)
    {
      iterator =  al.listIterator(0);
      for (int i = 0; i < size; i++)
        if(iterator.next() == null)
          count++;
    }
    time = System.currentTimeMillis() - time;
    System.out.println("ArrayList iteration " + time);
    al = null;
    iterator = null;

    forceGC();
    
    LinkedList ll = new LinkedList();
    for (int i = 0; i < size; i++)
      ll.add(o);

    System.out.println("Starting");
    time = System.currentTimeMillis();
    count = 0;
    for (int j = 0; j < repeat; j++)
    {
      iterator =  ll.listIterator(0);
      for (int i = 0; i < size; i++)
        if(iterator.next() == null)
          count++;
    }
    time = System.currentTimeMillis() - time;
    System.out.println("LinkedList iteration " + time);
    ll = null;
    iterator = null;

    forceGC();

}
  public static void traversal(int size, Object o, int repeat)
  {
    //init elementData
    Object[] elementData = new Object[size];
    for (int i = 0; i < size; i++)
      elementData[i] = o;

    long time = System.currentTimeMillis();
    int count = 0;
    for (int j = 0; j < repeat; j++)
      for (int i = 0; i < size; i++)
        if(elementData[i] == null)
          count++;
    time = System.currentTimeMillis() - time;
    System.out.println("ArrayList internal traversal " + time);
    elementData = null;

    forceGC();

    //init nodes
    Node root = new Node(null, null, null);
    Node node = new Node(o, root, root);
    root.next = node;
    root.previous = node;
    for (int i = 1; i < size; i++)
    {
      node = new Node(o, root.next, root);
      root.next = node;
      node.next.previous = node;
    }


    node = root.next;
    count = 0;
    time = System.currentTimeMillis();
    for (int j = 0; j < repeat; j++)
    {
      node = root.next;
      for (int i = 0; i < size; i++, node = node.next)
        if (node.element == null)
          count++;
    }
    time = System.currentTimeMillis() - time;
    System.out.println("LinkedList internal traversal " + time);
    root = node = null;
  }

  public static long insert0(List l, int repeat, Object o, int nestedRepeat)
  {
    long time = 0;
    for (int i = nestedRepeat; i > 0; i--)
    {
      l = new ArrayList(100);
      time += insert0(l, repeat, o);
    }
    return time;
  }

  public static long insert0(List l, int repeat, Object o)
  {
    long time = System.currentTimeMillis();
    for (int i = 0; i < repeat; i++)
      l.add(0, o);
    return System.currentTimeMillis() - time;
  }

  public static long insert_last(List l, int repeat, Object o, int nestedRepeat)
  {
    long time = 0;
    for (int i = nestedRepeat; i > 0; i--)
    {
      l = new ArrayList(100);
      time += insert_last(l, repeat, o);
    }
    return time;
  }

  public static long insert_last(List l, int repeat, Object o)
  {
    long time = System.currentTimeMillis();
    for (int i = 0; i < repeat; i++)
      l.add(o);
    return System.currentTimeMillis() - time;
  }

  public static long insert_mid(List l, int repeat, Object o, int nestedRepeat)
  {
    long time = 0;
    for (int i = nestedRepeat; i > 0; i--)
    {
      l = new ArrayList(100);
      time += insert_mid(l, repeat, o);
    }
    return time;
  }

  public static long insert_mid(List l, int repeat, Object o)
  {
    long time = System.currentTimeMillis();
    for (int i = 0; i < repeat; i++)
      l.add(i/2, o);
    return System.currentTimeMillis() - time;
  }

                      public static int testmemory(int megabytes)
                      {
                        if (megabytes > 1000)
                        {
                          System.out.println("forget it");
                          return -1;
                        }
                        Object[] memoryHolder = new Object[megabytes];
                        int count = 0;
                        try
                        {
                          for (; count < memoryHolder.length; count++)
                          {
                            memoryHolder[count] = new byte[1048576];
                          }
                        }
                        catch(OutOfMemoryError bounded){}
                        long highWater = Runtime.getRuntime().totalMemory();
                    //  System.out.println("High water in bytes: " + highWater);
                    //  System.out.println("Megabytes allocatable in megabytes: " + count);
                        memoryHolder = null; //release for GC
                        //might be a good idea to call System.gc() and Thread.sleep(2000)
                        //to give the GC time to happen. 
                        //We know we could allocate "count" megabytes and have a
                        //high water mark of "highWater". Return whichever you prefer.
                        return count;
                      }


}
