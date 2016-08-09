package tuning.struct;

import java.util.*;

public class TypeTesting
{
  public static final int CAPACITY = 100000;
  public static void main(String args[])
  {
    //In order to isolate the effects of synchronization, we make sure
    //that the garbage collector doesn't interfere with the test. So
    //we use a bunch of pre-allocated, pre-sized collections, and
    //populate those collections with pre-existing objects. No objects
    //will be created or released during the timing phase of the tests.
    int REPEAT = (args.length > 0) ? Integer.parseInt(args[0]) : 100;

    //Vary the order.
    testGeneralArray(REPEAT);
    testIntArray(REPEAT);
    testStringArray(REPEAT);
    testIntArray(REPEAT);
    testStringArray(REPEAT);
    testGeneralArray(REPEAT);
    testIntArray(REPEAT);
    testGeneralArray(REPEAT);
    testStringArray(REPEAT);
  }

  public static void testGeneralArray(int REPEAT)
  {
    //initialize
    Integer integer = new Integer(5);
    ObjArrayList l = new ObjArrayList(CAPACITY);
    for (int j = 0; j < CAPACITY; j++)
      l.add(integer);

    //Set an existing object
    long time = System.currentTimeMillis();
    for (int i = REPEAT; i > 0; i--)
      for (int j = 0; j < CAPACITY; j++)
        l.set(j, integer);
    System.out.println("Setting an existing Integer(5) in object array took: " + 
     (System.currentTimeMillis()-time));

    //Set an new object
    time = System.currentTimeMillis();
    for (int i = REPEAT/10; i > 0; i--)
      for (int j = 0; j < CAPACITY; j++)
        l.set(j, new Integer(j));
    System.out.println("Setting a new Integer in object array took: " + 
     (System.currentTimeMillis()-time) + " x 10");

    //Get an existing object without casting
    Object o;
    time = System.currentTimeMillis();
    for (int i = REPEAT; i > 0; i--)
      for (int j = 0; j < CAPACITY; j++)
        o = l.get(j);
    System.out.println("Getting an existing Object from object array took: " + 
     (System.currentTimeMillis()-time));

    //Get an existing object
    time = System.currentTimeMillis();
    for (int i = REPEAT; i > 0; i--)
      for (int j = 0; j < CAPACITY; j++)
        integer = (Integer) l.get(j);
    System.out.println("Getting an existing Integer(" + integer + ") from object array took: " + 
     (System.currentTimeMillis()-time));

    //Get underlying int value
    int num = 33;
    time = System.currentTimeMillis();
    for (int i = REPEAT; i > 0; i--)
      for (int j = 0; j < CAPACITY; j++)
        num = ((Integer) l.get(j)).intValue();
    System.out.println("Getting an existing int (" + num + ") from object array took: " + 
     (System.currentTimeMillis()-time));
    System.out.println();
  }

  public static void testIntArray(int REPEAT)
  {
    //initialize
    int integer = 5;
    IntArrayList l = new IntArrayList(CAPACITY);
    for (int j = 0; j < CAPACITY; j++)
      l.add(integer);

    //Set an existing int
    long time = System.currentTimeMillis();
    for (int i = REPEAT; i > 0; i--)
      for (int j = 0; j < CAPACITY; j++)
        l.set(j, integer);
    System.out.println("Setting an existing int in int array took: " + 
     (System.currentTimeMillis()-time));

    //Set an new int
    time = System.currentTimeMillis();
    for (int i = REPEAT; i > 0; i--)
      for (int j = 0; j < CAPACITY; j++)
        l.set(j, j);
    System.out.println("Setting a new int in int array took: " + 
     (System.currentTimeMillis()-time));

    //Get an existing int without casting
    time = System.currentTimeMillis();
    for (int i = REPEAT; i > 0; i--)
      for (int j = 0; j < CAPACITY; j++)
        integer = l.get(j);
    System.out.println("Getting an existing int " + integer + " from int array took: " + 
     (System.currentTimeMillis()-time));
    System.out.println();
  }

  public static void testStringArray(int REPEAT)
  {
    //initialize
    String string = "hello";
    StringArrayList l = new StringArrayList(CAPACITY);
    for (int j = 0; j < CAPACITY; j++)
      l.add(string);

    //Set an existing String
    long time = System.currentTimeMillis();
    for (int i = REPEAT; i > 0; i--)
      for (int j = 0; j < CAPACITY; j++)
        l.set(j, string);
    System.out.println("Setting an existing String in String array took: " + 
     (System.currentTimeMillis()-time));

    //Get an existing String without casting
    time = System.currentTimeMillis();
    for (int i = REPEAT; i > 0; i--)
      for (int j = 0; j < CAPACITY; j++)
        string = l.get(j);
    System.out.println("Getting an existing String " + string + " from String array took: " + 
     (System.currentTimeMillis()-time));
    System.out.println();
  }
}

class ObjArrayList
{
    private transient Object elementData[];
    private int size;
    private int modCount;
    public ObjArrayList(int initialCapacity) {
	super();
	this.elementData = new Object[initialCapacity];
    }
    public Object get(int index) {
	RangeCheck(index);

	return elementData[index];
    }
    public Object set(int index, Object element) {
	RangeCheck(index);

	Object oldValue = elementData[index];
	elementData[index] = element;
	return oldValue;
    }
    public boolean add(Object o) {
	ensureCapacity(size + 1);  // Increments modCount!!
	elementData[size++] = o;
	return true;
    }
    private void RangeCheck(int index) {
	if (index >= size || index < 0)
	    throw new IndexOutOfBoundsException(
		"Index: "+index+", Size: "+size);
    }
    public void ensureCapacity(int minCapacity) {
	modCount++;
	int oldCapacity = elementData.length;
	if (minCapacity > oldCapacity) {
	    Object oldData[] = elementData;
	    int newCapacity = (oldCapacity * 3)/2 + 1;
    	    if (newCapacity < minCapacity)
		newCapacity = minCapacity;
	    elementData = new Object[newCapacity];
	    System.arraycopy(oldData, 0, elementData, 0, size);
	}
    }
}

class IntArrayList
{
    private transient int elementData[];
    private int size;
    private int modCount;
    public IntArrayList(int initialCapacity) {
	super();
	this.elementData = new int[initialCapacity];
    }
    public int get(int index) {
	RangeCheck(index);

	return elementData[index];
    }
    public int set(int index, int element) {
	RangeCheck(index);

	int oldValue = elementData[index];
	elementData[index] = element;
	return oldValue;
    }
    public boolean add(int o) {
	ensureCapacity(size + 1);  // Increments modCount!!
	elementData[size++] = o;
	return true;
    }
    private void RangeCheck(int index) {
	if (index >= size || index < 0)
	    throw new IndexOutOfBoundsException(
		"Index: "+index+", Size: "+size);
    }
    public void ensureCapacity(int minCapacity) {
	modCount++;
	int oldCapacity = elementData.length;
	if (minCapacity > oldCapacity) {
	    int oldData[] = elementData;
	    int newCapacity = (oldCapacity * 3)/2 + 1;
    	    if (newCapacity < minCapacity)
		newCapacity = minCapacity;
	    elementData = new int[newCapacity];
	    System.arraycopy(oldData, 0, elementData, 0, size);
	}
    }
}

class StringArrayList
{
    private transient String elementData[];
    private int size;
    private int modCount;
    public StringArrayList(int initialCapacity) {
	super();
	this.elementData = new String[initialCapacity];
    }
    public String get(int index) {
	RangeCheck(index);

	return elementData[index];
    }
    public String set(int index, String element) {
	RangeCheck(index);

	String oldValue = elementData[index];
	elementData[index] = element;
	return oldValue;
    }
    public boolean add(String o) {
	ensureCapacity(size + 1);  // Increments modCount!!
	elementData[size++] = o;
	return true;
    }
    private void RangeCheck(int index) {
	if (index >= size || index < 0)
	    throw new IndexOutOfBoundsException(
		"Index: "+index+", Size: "+size);
    }
    public void ensureCapacity(int minCapacity) {
	modCount++;
	int oldCapacity = elementData.length;
	if (minCapacity > oldCapacity) {
	    String oldData[] = elementData;
	    int newCapacity = (oldCapacity * 3)/2 + 1;
    	    if (newCapacity < minCapacity)
		newCapacity = minCapacity;
	    elementData = new String[newCapacity];
	    System.arraycopy(oldData, 0, elementData, 0, size);
	}
    }
}
