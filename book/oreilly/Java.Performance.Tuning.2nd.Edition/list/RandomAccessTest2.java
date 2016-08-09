import java.util.*;

public class RandomAccessTest2
{
  int i;
  public RandomAccessTest2(int i) {this.i = i;}

  static boolean RandomAccessExists = false;
  public static void main(String[] args)
  {
    try
    {
      Class c =  Class.forName("java.util.RandomAccess");
      RandomAccessExists = true;
    }
    catch (ClassNotFoundException e)
    {
      RandomAccessExists = false;
    }
    int SIZE = args.length>0 ? Integer.parseInt(args[0]) : 100000;
    ArrayList arrayList = new ArrayList(SIZE);
    LinkedList linkedList = new LinkedList();
    RandomAccessTest r;
    for (int i = 0; i < SIZE; i++)
    {
      arrayList.add(r = new RandomAccessTest(i));
      linkedList.add(r);
    }

    testAll(arrayList, linkedList);
  }

  public static void testAll(List list1, List list2)
  {
    testLoopCounter(list1);
    System.out.println("testLoopCounter(" + list2.getClass().getName() + ") not run as it takes too long");
    //testLoopCounter(list2);
    testIterator(list1);
    testIterator(list2);
    testIteratorWithLoopCounter(list1);
    testIteratorWithLoopCounter(list2);
    testRandomAccess(list1);
    testRandomAccess(list2);
  }

  
  public static long testLoopCounter(List list)
  {
    long time = System.currentTimeMillis();
    int count = 0;
    for (int i=0, n=list.size(); i < n; i++)
      count += ( (RandomAccessTest) list.get(i)).i;
    time = System.currentTimeMillis() - time;
    System.out.println(list.getClass().getName() + " in testLoopCounter took "  + time + " millis to get result " + count);
    return time;
  }

  public static long testIterator(List list)
  {
    long time = System.currentTimeMillis();
    int count = 0;
    for (Iterator i=list.iterator(); i.hasNext(); )
      count += ( (RandomAccessTest) i.next()).i;
    time = System.currentTimeMillis() - time;
    System.out.println(list.getClass().getName() + " in testIterator took "  + time + " millis to get result " + count);
    return time;
  }

  public static long testIteratorWithLoopCounter(List list)
  {
    long time = System.currentTimeMillis();
    int count = 0;
    Iterator i=list.iterator();
    for (int j=0, n=list.size() ; j < n ; j++)
      count += ( (RandomAccessTest) i.next()).i;
    time = System.currentTimeMillis() - time;
    System.out.println(list.getClass().getName() + " in testIteratorWithLoopCounter took "  + time + " millis to get result " + count);
    return time;
  }

  public static long testRandomAccess(List list)
  {
    if (RandomAccessExists && (list instanceof RandomAccess) )
      return testLoopCounter(list);
    else
      return testIteratorWithLoopCounter(list);
  }
}
