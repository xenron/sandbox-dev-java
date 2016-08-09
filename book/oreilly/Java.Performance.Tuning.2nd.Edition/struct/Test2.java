package tuning.struct;

import java.util.*;

public class Test2
{
  public static void initializeList(List collection)
  {
    System.out.println("Initializing...");
    //All four character strings. Extend to more characters
    //depending on your processor speed and memory availability
    char c = 'a';
    char d = 'a';
    char e = 'a';
    char f = 'a';
    StringBuffer sb = new StringBuffer(4);
    for (int ic = 0; ic < 26; ic++)
    {
      sb.setLength(0);
      sb.append(c++);
      d = e = f = 'a';
      for (int id = 0; id < 26; id++)
      {
        sb.setLength(1);
        sb.append(d++);
        e = f = 'a';
        for (int ie = 0; ie < 26; ie++)
        {
          sb.setLength(2);
          sb.append(e++);
          f = 'a';
          for (int i = 0; i < 26; i++)
          {
            sb.setLength(3);
            sb.append(f++);
            collection.add(sb.toString());
          }
        }
      }
    }
    System.out.println("Finished initializing.");
  }

  public static void main(String[] args)
  {
    TestList collection = new TestList();
    initializeList(collection);
    TestStringList l = new TestStringList(collection);

    test0(collection); //ignore
    test0(l); //ignore
    System.out.println("Test0 is simply to fully initialize the runtime");
    System.out.println();

    fulltest(collection, l);
    fulltest(collection, l);
    fulltest(collection, l);
    fulltest(collection, l);
  }

  public static void fulltest(TestList collection, TestStringList l)
  {
    test1(collection);
    test2(collection);
    test3(collection);
    test4(collection);
    test5(collection);
    test6(collection);
    test7(collection);
    test8(collection);
    test9(collection);
    test10(collection);
    test11(collection);
    test12(l);
    test13(l);
    test14(l);
    System.out.println();
  }

  public static void test0(TestStringList collection)
  {
    int count = 0;
    for(int i = 0; i < collection.size(); i++)
    {
      if(     ( ((String) collection.get(i)).indexOf("ie") != -1 )
           | ( ((String) collection.get(i)).indexOf("xy") != -1 )
           | ( ((String) collection.get(i)).indexOf("pq") != -1 ) )
        count++;
    }
  }
  public static void test0(TestList collection)
  {
    int count = 0;
    for(int i = 0; i < collection.size()/2; i++)
    {
      if(     ( ((String) collection.get(i)).indexOf("ie") != -1 )
           | ( ((String) collection.get(i)).indexOf("xy") != -1 )
           | ( ((String) collection.get(i)).indexOf("pq") != -1 ) )
        count++;
    }
    for(int i = collection.size()/2; i < collection.size(); i++)
    {
      if(     ( ((String) collection.getAsArrayList(i)).indexOf("ie") != -1 )
           | ( ((String) collection.getAsArrayList(i)).indexOf("xy") != -1 )
           | ( ((String) collection.getAsArrayList(i)).indexOf("pq") != -1 ) )
        count++;
    }
    System.out.println("Test0 completed");
  }

  public static void test1(TestList collection)
  {
    //Initial test
    long time = System.currentTimeMillis();
    int count = 0;
    for(int i = 0; i < collection.size(); i++)
    {
      if(     ( ((String) collection.get(i)).indexOf("ie") != -1 )
           | ( ((String) collection.get(i)).indexOf("xy") != -1 )
           | ( ((String) collection.get(i)).indexOf("pq") != -1 ) )
        count++;
    }
    System.out.println("Test1: initial test.                          Time is " + 
      (System.currentTimeMillis()-time) + " (result " + count + " elmnts)");
  }

  public static void test2(TestList collection)
  {
    long time = System.currentTimeMillis();
    int count = 0;
    for(int i = 0; i < collection.size(); i++)
    {
      if(     ( ((String) collection.get(i)).indexOf("ie") != -1 )
           || ( ((String) collection.get(i)).indexOf("xy") != -1 )
           || ( ((String) collection.get(i)).indexOf("pq") != -1 ) )
        count++;
    }
    System.out.println("Test2: changing to shortcut booleans.         Time is " + 
      (System.currentTimeMillis()-time) + " (result " + count + " elmnts)");
  }

  public static void test3(TestList collection)
  {
    long time = System.currentTimeMillis();
    int count = 0;
    int max = collection.size();
    for(int i = 0; i < max; i++)
    {
      if(     ( ((String) collection.get(i)).indexOf("ie") != -1 )
           | ( ((String) collection.get(i)).indexOf("xy") != -1 )
           | ( ((String) collection.get(i)).indexOf("pq") != -1 ) )
        count++;
    }
    System.out.println("Test3: replacing size() call with a variable. Time is " + 
      (System.currentTimeMillis()-time) + " (result " + count + " elmnts)");
  }

  public static void test4(TestList collection)
  {
    long time = System.currentTimeMillis();
    int count = 0;
    int max = collection.size();
    for(int i = 0; i < max; i++)
    {
      if(     ( ((String) collection.get(i)).indexOf("ie") != -1 )
           || ( ((String) collection.get(i)).indexOf("xy") != -1 )
           || ( ((String) collection.get(i)).indexOf("pq") != -1 ) )
        count++;
    }
    System.out.println("Test4: both test2 and test3 optimizations.    Time is " + 
      (System.currentTimeMillis()-time) + " (result " + count + " elmnts)");
  }

  public static void test5(TestList collection)
  {
    long time = System.currentTimeMillis();
    int count = 0;
    int max = collection.size();
    String s;
    for(int i = 0; i < max; i++)
    {
      if(     ( (s = (String) collection.get(i)).indexOf("ie") != -1 )
           || (                       s.indexOf("xy") != -1 )
           || (                       s.indexOf("pq") != -1 ) )
        count++;
    }
    System.out.println("Test5: as test4, plus eliminating two casts.  Time is " + 
      (System.currentTimeMillis()-time) + " (result " + count + " elmnts)");
  }

  public static void test6(TestList collection)
  {
    long time = System.currentTimeMillis();
    int count = 0;
    String s;
    for(int i = 0; i < collection.size(); i++)
    {
      if(     ( (s = (String) collection.get(i)).indexOf("ie") != -1 )
           || (                       s.indexOf("xy") != -1 )
           || (                       s.indexOf("pq") != -1 ) )
        count++;
    }
    System.out.println("Test6: as test3, plus eliminating two casts.  Time is " + 
      (System.currentTimeMillis()-time) + " (result " + count + " elmnts)");
  }

  public static void test7(TestList collection)
  {
    long time = System.currentTimeMillis();
    int count = 0;
    int max = collection.size();
    String s;
    for(int i = 0; i < max; i++)
    {
      if(     ( (s = (String) collection.getAsArrayList(i)).indexOf("ie") != -1 )
           || (                       s.indexOf("xy") != -1 )
           || (                       s.indexOf("pq") != -1 ) )
        count++;
    }
    System.out.println("Test7: as test5, but using ArrayList.get().   Time is " + 
      (System.currentTimeMillis()-time) + " (result " + count + " elmnts)");
  }

  public static void test8(TestList collection)
  {
    long time = System.currentTimeMillis();
    int count = 0;
    String s;
    for(int i = 0; i < collection.size(); i++)
    {
      if(     ( (s = (String) collection.getAsArrayList(i)).indexOf("ie") != -1 )
           || (                       s.indexOf("xy") != -1 )
           || (                       s.indexOf("pq") != -1 ) )
        count++;
    }
    System.out.println("Test8: as test6, but using ArrayList.get().   Time is " + 
      (System.currentTimeMillis()-time) + " (result " + count + " elmnts)");
  }

  public static void test9(TestList collection)
  {
    long time = System.currentTimeMillis();
    int count = collection.customQuery1();
    System.out.println("Test9: using optimized customQuery1.          Time is " + 
      (System.currentTimeMillis()-time) + " (result " + count + " elmnts)");
  }

  public static void test10(TestList collection)
  {
    long time = System.currentTimeMillis();
    int count = collection.customQuery2();
    System.out.println("Test10: using optimized customQuery2.         Time is " + 
      (System.currentTimeMillis()-time) + " (result " + count + " elmnts)");
  }

  public static void test11(TestList collection)
  {
    long time = System.currentTimeMillis();
    int count = collection.customQuery3();
    System.out.println("Test11: using optimized customQuery3.         Time is " + 
      (System.currentTimeMillis()-time) + " (result " + count + " elmnts)");
  }

  public static void test12(TestStringList l)
  {
    long time = System.currentTimeMillis();
    int count = l.customQuery1();
    System.out.println("Test12: using String optimized customQuery1.  Time is " + 
      (System.currentTimeMillis()-time) + " (result " + count + " elmnts)");
  }

  public static void test13(TestStringList l)
  {
    long time = System.currentTimeMillis();
    int count = l.customQuery2();
    System.out.println("Test13: using String optimized customQuery2.  Time is " + 
      (System.currentTimeMillis()-time) + " (result " + count + " elmnts)");
  }

  public static void test14(TestStringList l)
  {
    long time = System.currentTimeMillis();
    int count = l.customQuery3();
    System.out.println("Test14: using String optimized customQuery3.  Time is " + 
      (System.currentTimeMillis()-time) + " (result " + count + " elmnts)");
  }

}

class TestList
  extends Vector
{
  public Object getAsArrayList(int index)
  {
    if (index >= elementCount || index < 0)
      throw new IndexOutOfBoundsException("Index: "+index+", Size: "+elementCount);
    return elementData[index];
  }

  public int customQuery1()
  {
    int count = 0;
    String s;
    for(int i = 0; i < elementCount; i++)
    {
      if(     ( (s = (String) elementData[i]).indexOf("ie") != -1 )
           || (                       s.indexOf("xy") != -1 )
           || (                       s.indexOf("pq") != -1 ) )
        count++;
    }
    return count;
  }

  public int customQuery2()
  {
    int count = 0;
    String s;
    int max = elementCount;
    for(int i = 0; i < max; i++)
    {
      if(     ( (s = (String) elementData[i]).indexOf("ie") != -1 )
           || (                       s.indexOf("xy") != -1 )
           || (                       s.indexOf("pq") != -1 ) )
        count++;
    }
    return count;
  }

  public int customQuery3()
  {
    int count = 0;
    String s;
    int max = elementCount;
    Object[] arr = elementData;
    for(int i = 0; i < max; i++)
    {
      if(     ( (s = (String) arr[i]).indexOf("ie") != -1 )
           || (                       s.indexOf("xy") != -1 )
           || (                       s.indexOf("pq") != -1 ) )
        count++;
    }
    return count;
  }

}

class TestStringList
{
  String[] elementData;
  int elementCount;
  public TestStringList(TestList l)
  {
    elementCount = l.size();
    elementData = new String[elementCount];
    for(int i = 0; i < elementCount; i++)
      elementData[i] = (String) l.get(i);
  }

  public String get(int index)
  {
    if (index >= elementCount || index < 0)
      throw new IndexOutOfBoundsException("Index: "+index+", Size: "+elementCount);
    return elementData[index];
  }

  public int size() {return elementCount;}

  public int customQuery1()
  {
    int count = 0;
    String s;
    for(int i = 0; i < elementCount; i++)
    {
      if(     ( (s = elementData[i]).indexOf("ie") != -1 )
           || (                       s.indexOf("xy") != -1 )
           || (                       s.indexOf("pq") != -1 ) )
        count++;
    }
    return count;
  }

  public int customQuery2()
  {
    int count = 0;
    String s;
    int max = elementCount;
    for(int i = 0; i < max; i++)
    {
      if(     ( (s = elementData[i]).indexOf("ie") != -1 )
           || (                       s.indexOf("xy") != -1 )
           || (                       s.indexOf("pq") != -1 ) )
        count++;
    }
    return count;
  }

  public int customQuery3()
  {
    int count = 0;
    String s;
    int max = elementCount;
    String[] arr = elementData;
    for(int i = 0; i < max; i++)
    {
      if(     ( (s = arr[i]).indexOf("ie") != -1 )
           || (                       s.indexOf("xy") != -1 )
           || (                       s.indexOf("pq") != -1 ) )
        count++;
    }
    return count;
  }
}
