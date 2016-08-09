package tuning.threads;

import java.util.*;

public class ListTesting
{
  public static final int CAPACITY = 100000;
  public static void main(String args[])
  {
    maintest(args);
    maintest(args);
  }

  public static void maintest(String args[])
  {
    //In order to isolate the effects of synchronization, we make sure
    //that the garbage collector doesn't interfere with the test. So
    //we use a bunch of pre-allocated, pre-sized collections, and
    //populate those collections with pre-existing objects. No objects
    //will be created or released during the timing phase of the tests.
    List[] l = {new Vector(CAPACITY), new Vector(CAPACITY),
      new Vector(CAPACITY), new ArrayList(CAPACITY),
      new ArrayList(CAPACITY), new ArrayList(CAPACITY),
      Collections.synchronizedList(new ArrayList(CAPACITY)),
      Collections.synchronizedList(new ArrayList(CAPACITY)),
      Collections.synchronizedList(new ArrayList(CAPACITY))};
    int REPEAT = (args.length > 0) ? Integer.parseInt(args[0]) : 100;

    //Vary the order.
    test(l[0], REPEAT, "Vector");
    test(l[6], REPEAT, "sync ArrayList" );
    test(l[3], REPEAT, "ArrayList");
    test(l[1], REPEAT, "Vector");
    test(l[4], REPEAT, "ArrayList");
    test(l[7], REPEAT, "sync ArrayList" );
    test(l[2], REPEAT, "Vector");
    test(l[5], REPEAT, "ArrayList");
    test(l[8], REPEAT, "sync ArrayList" );
  }

  public static void test(List l, int REPEAT, String ltype)
  {
    //need to initialize for set() to work. Don't measure this time
    for (int j = 0; j < CAPACITY; j++)
      l.add(Boolean.FALSE);

    long time = System.currentTimeMillis();
    //The test sets elements repeatedly. The set methods are
    //very similar. Apart from synchronization, the Vector.set()
    //is slightly more efficient than the ArrayList.set(), which
    //is in turn more efficient than the wrapped ArrayList because
    //there is one extra layer of method calls for the wrapped object.
    for (int i = REPEAT; i > 0; i--)
      for (int j = 0; j < CAPACITY; j++)
        l.set(j, Boolean.TRUE);
    System.out.println(ltype + " took " +
        (System.currentTimeMillis()-time));
  }
}
