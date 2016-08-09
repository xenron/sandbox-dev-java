package tuning.struct;

import tuning.dict.Dict;
import java.util.Hashtable;
import java.util.Vector;
import tuning.unpublishable.UnsynchronizedHashtable;
//global replace HashMap with UnsynchronizedHashtable if before JDK 1.2
import java.util.HashMap;
import java.util.TreeMap;

public class TernarySearchTreeTest
{
  public static void main(String[] args)
  {
    try
    {
      Dict.initialize(true);
find1();
      TernarySearchTree6 h = new TernarySearchTree6();
      for (int i = Dict.RAND_DICT.length-1; i>=0; i--)
        h.put(Dict.RAND_DICT[i], Boolean.TRUE);
      for (int i = Dict.RAND_DICT.length-1; i>=0; i--)
	if ( h.get(Dict.RAND_DICT[i]) != Boolean.TRUE ) throw new Exception(""+i);
      System.out.println(h.nodeCount());
      h.release(); h=null; System.gc();
      TernarySearchTree3.dummy();

      randternarySearchTree2();

      randhashtable();
      hashtable();
      sizedrandhashtable();
      sizedhashtable();

      randUnsynchronizedhashtable();
      Unsynchronizedhashtable();
      sizedrandUnsynchronizedhashtable();
      sizedUnsynchronizedhashtable();

      randUnsynchronizedTreeMap();
      UnsynchronizedTreeMap();

      randternarySearchTree0();
      ternarySearchTree0();

      randternarySearchTree1();
      ternarySearchTree1();

      randternarySearchTree2();
      ternarySearchTree2();

      randternarySearchTree3();
      ternarySearchTree3();

      ternarySearchTree4();
      randternarySearchTree4();

      randternarySearchTree5();
      ternarySearchTree5();

      ternarySearchTree5();
      randternarySearchTree5();

      randternarySearchTree4();
      ternarySearchTree4();

      ternarySearchTree3();
      randternarySearchTree3();

      ternarySearchTree2();
      randternarySearchTree2();

      ternarySearchTree1();
      randternarySearchTree1();

      ternarySearchTree0();
      randternarySearchTree0();

      randUnsynchronizedTreeMap();
      UnsynchronizedTreeMap();

      sizedUnsynchronizedhashtable();
      sizedrandUnsynchronizedhashtable();
      Unsynchronizedhashtable();
      randUnsynchronizedhashtable();

      sizedhashtable();
      sizedrandhashtable();
      hashtable();
      randhashtable();
    }
    catch(Exception e){e.printStackTrace();}
  }

private static void quicksort_comparator(String arr[], int lo, int hi)
{
	if( lo >= hi ) 
		return;

	int mid = ( lo + hi ) / 2;
	String tmp;
	String middle = arr[ mid ];

	if( arr[ lo ].compareTo(middle) > 0 )
	{
		arr[ mid ] = arr[ lo ];
		arr[ lo ] = middle;
		middle = arr[ mid ];
	}

	if( middle.compareTo(arr[ hi ]) > 0)
	{
		arr[ mid ] = arr[ hi ];
		arr[ hi ] = middle;
		middle = arr[ mid ];

		if( arr[ lo ].compareTo(middle) > 0)
		{
			arr[ mid ] = arr[ lo ];
			arr[ lo ] = middle;
			middle = arr[ mid ];
		}
	}

	int left = lo + 1;
	int right = hi - 1;

	if( left >= right ) 
		return;

	for( ;; ) 
	{
		while( arr[ right ].compareTo(middle ) > 0)
		{
			right--;
		}

		while( left < right && arr[ left ].compareTo(middle ) <= 0)
		{
			left++;
		}

		if( left < right )
		{
			tmp = arr[ left ];
			arr[ left ] = arr[ right ];
			arr[ right ] = tmp;
			right--;
		}
		else
		{
			break;
		}
	}

	quicksort_comparator(arr, lo, left);
	quicksort_comparator(arr, left + 1, hi);
}

public static void find() {find("s");}
public static void find(String s)
{

    long t1 = System.currentTimeMillis();
  String[] arr = new String[Dict.DICT.length];
  System.arraycopy(Dict.DICT, 0, arr, 0, Dict.DICT.length);
  quicksort_comparator(arr, 0, arr.length-1);
    t1 = System.currentTimeMillis() - t1;

    long t2 = System.currentTimeMillis();
  int startIdx = -(comparisonSearch(arr, s+((char) 0), 0, arr.length-1)+1);
  int endIdx = -(comparisonSearch(arr, s+ ((char) 255), 0, arr.length-1)+1);
if (startIdx < 0 || endIdx < 0)throw new RuntimeException ("no");
  Object[] objs = new Object[endIdx-startIdx];
  for (int i = startIdx ; i < endIdx; i++)
    objs[i-startIdx] = arr[i];
    t2 = System.currentTimeMillis() - t2;
  System.out.println("Create & search & num items found for sorted\t" + t1 + "\t" + t2 + " " + objs.length);
//System.exit(0);
}

public static void find1() {find1("s");}
public static void find1(String s)
{

    long t1 = System.currentTimeMillis();
    t1 = System.currentTimeMillis() - t1;

    Hashtable h = new Hashtable(2*Dict.DICT.length-1);
    for (int i = Dict.DICT.length-1; i>=0; i--)
      h.put(Dict.DICT[i], Boolean.TRUE);

    long t2 = System.currentTimeMillis();
    Vector v = new Vector();
    java.util.Enumeration e = h.keys();
    String s1;
    for(;e.hasMoreElements();) {
      s1=(String)e.nextElement();
      if(s1.startsWith(s)){v.addElement(s);}
    }
    Object[] objs = new Object[v.size()];
    for(int i=v.size()-1;i>=0;i--)
	objs[i]=h.get(v.elementAt(i));
    t2 = System.currentTimeMillis() - t2;
  System.out.println("1.Create & search & num items found for sorted\t" + t1 + "\t" + t2 + " " + objs.length);
//System.exit(0);
}

/**
 * Searches for an occurence of the given argument, between <code>fromIndex</code>
 * and <code>toIndex</code> inclusive in an array pre-sorted according to the ordering
 * given by the Comparator using an iterative binary search algorithm.
 * <p>
 * Tests for equality using the <code>Comparator</code> object passed, finding
 * objects equal if the <code>Comparator.compare(Object,Object)</code> method
 * returns 0.
 * <p>
 * If the object is not in the array, the return code gives the position into
 * which the element should be inserted to retain the ordering within the array
 * according to the formula <code>insertionIndex = -(return code) - 1</code>
 * <p>
 * If the array is not pre-sorted accrding to the given <code>Comparator</code>,
 * the results are undefined (including the possibility of infinitely looping).
 * <p>
 * If <code>elem</code> or any of the elements of the array
 * are <code>null</code>, then use the <code>Comparator</code> needs to support
 * the comparison against <code>null</code> objects.
 *
 * @param 	arr 		the array being searched.
 * @param   elem    the object being searched for.
 * @param   fromIndex   the index to start searching from.
 * @param 	toIndex		the index to finish searching on.
 * @param 	comparator		the <code>Comparator</code> object which provides ordered comparisons
 *											on the elements.
 * @return  the index of an occurrence of the object argument in
 *          the array between position <code>fromIndex</code> and
 *					<code>toIndex</code> inclusive; returns <code>-(insertionIndex + 1)</code>
 *					if the object is not found. If more than one index is
 *					valid (because of a series of objects equal to the <code>elem</code>),
 *					then the index returned can be that of any of the equal objects.
 * @exception ArrayIndexOutOfBoundsException  if either index is outside the array
 * @see java.util.Comparator	
 */
public static int comparisonSearch(String[] arr, String elem, int fromIndex, int toIndex)
{
	int mid,cmp;
	while (fromIndex <= toIndex)
	{
		mid =(fromIndex + toIndex)/2;
		if ( (cmp = arr[mid].compareTo(elem)) < 0)
			fromIndex = mid + 1;
		else if (cmp > 0)
			toIndex = mid - 1;
		else
			return mid;
	}
	return -(fromIndex + 1);
}

  static void report(String type, boolean rand, boolean sized, long create, long update, long access)
  {
    System.out.print("cr, up, ac ");
    System.out.print(rand ? "rnd " : "    ");
    System.out.print(sized ? "szd " : "    ");
    for (int i = 25-type.length(); i>=0;i--)
      System.out.print(" ");
    System.out.print(type);
    System.out.print(" is ");
    System.out.print(create);
    System.out.print("\t");
    System.out.print(update);
    System.out.print("\t");
    System.out.println(access);
  }

  static void randternarySearchTree5()
  {
    long t1 = System.currentTimeMillis();
    TernarySearchTree5 h = new TernarySearchTree5();
    t1 = System.currentTimeMillis() -  t1;

    long t2 = System.currentTimeMillis();
    for (int i = Dict.RAND_DICT.length-1; i>=0; i--)
      h.put(Dict.RAND_DICT[i], Boolean.TRUE);
    t2 = System.currentTimeMillis() -  t2;

    Object o;
    long t3 = System.currentTimeMillis();
    for (int i = Dict.RAND_DICT.length-1; i>=0; i--)
      o = h.get(Dict.RAND_DICT[i]);
    t3 = System.currentTimeMillis() -  t3;

    report("TernarySearchTree5", true, false, t1, t2, t3);
    h.release();o=null;h=null;System.gc();
  }

  static void ternarySearchTree5()
  {
    long t1 = System.currentTimeMillis();
    TernarySearchTree5 h = new TernarySearchTree5();
    t1 = System.currentTimeMillis() -  t1;

    long t2 = System.currentTimeMillis();
    for (int i = Dict.DICT.length-1; i>=0; i--)
      h.put(Dict.DICT[i], Boolean.TRUE);
    t2 = System.currentTimeMillis() -  t2;

    Object o;
    long t3 = System.currentTimeMillis();
    for (int i = Dict.DICT.length-1; i>=0; i--)
      o = h.get(Dict.DICT[i]);
    t3 = System.currentTimeMillis() -  t3;

    report("TernarySearchTree5", false, false, t1, t2, t3);

    h.release();o=null;h=null;System.gc();
  }

  static void randternarySearchTree4()
  {
    long t1 = System.currentTimeMillis();
    TernarySearchTree4 h = new TernarySearchTree4();
    t1 = System.currentTimeMillis() -  t1;

    long t2 = System.currentTimeMillis();
    for (int i = Dict.RAND_DICT.length-1; i>=0; i--)
      h.put(Dict.RAND_DICT[i], Boolean.TRUE);
    t2 = System.currentTimeMillis() -  t2;

    Object o;
    long t3 = System.currentTimeMillis();
    for (int i = Dict.RAND_DICT.length-1; i>=0; i--)
      o = h.get(Dict.RAND_DICT[i]);
    t3 = System.currentTimeMillis() -  t3;

    report("TernarySearchTree4", true, false, t1, t2, t3);
    h.release();o=null;h=null;System.gc();
  }

  static void ternarySearchTree4()
  {
    long t1 = System.currentTimeMillis();
    TernarySearchTree4 h = new TernarySearchTree4();
    t1 = System.currentTimeMillis() -  t1;

    long t2 = System.currentTimeMillis();
    for (int i = Dict.DICT.length-1; i>=0; i--)
      h.put(Dict.DICT[i], Boolean.TRUE);
    t2 = System.currentTimeMillis() -  t2;

    Object o;
    long t3 = System.currentTimeMillis();
    for (int i = Dict.DICT.length-1; i>=0; i--)
      o = h.get(Dict.DICT[i]);
    t3 = System.currentTimeMillis() -  t3;

    report("TernarySearchTree4", false, false, t1, t2, t3);

    h.release();o=null;h=null;System.gc();
  }


  static void randternarySearchTree3()
  {
    long t1 = System.currentTimeMillis();
    TernarySearchTree3 h = new TernarySearchTree3();
    t1 = System.currentTimeMillis() -  t1;

    long t2 = System.currentTimeMillis();
    for (int i = Dict.RAND_DICT.length-1; i>=0; i--)
      h.put(Dict.RAND_DICT[i], Boolean.TRUE);
    t2 = System.currentTimeMillis() -  t2;

    Object o;
    long t3 = System.currentTimeMillis();
    for (int i = Dict.RAND_DICT.length-1; i>=0; i--)
      o = h.get(Dict.RAND_DICT[i]);
    t3 = System.currentTimeMillis() -  t3;

    report("TernarySearchTree3", true, false, t1, t2, t3);
    h.release();o=null;h=null;System.gc();
  }

  static void ternarySearchTree3()
  {
    long t1 = System.currentTimeMillis();
    TernarySearchTree3 h = new TernarySearchTree3();
    t1 = System.currentTimeMillis() -  t1;

    long t2 = System.currentTimeMillis();
    for (int i = Dict.DICT.length-1; i>=0; i--)
      h.put(Dict.DICT[i], Boolean.TRUE);
    t2 = System.currentTimeMillis() -  t2;

    Object o;
    long t3 = System.currentTimeMillis();
    for (int i = Dict.DICT.length-1; i>=0; i--)
      o = h.get(Dict.DICT[i]);
    t3 = System.currentTimeMillis() -  t3;

    report("TernarySearchTree3", false, false, t1, t2, t3);

    h.release();o=null;h=null;System.gc();
  }

  static void randternarySearchTree2()
  {
    long t1 = System.currentTimeMillis();
    TernarySearchTree2 h = new TernarySearchTree2();
    t1 = System.currentTimeMillis() -  t1;

    long t2 = System.currentTimeMillis();
    for (int i = Dict.RAND_DICT.length-1; i>=0; i--)
      h.put(Dict.RAND_DICT[i], Boolean.TRUE);
    t2 = System.currentTimeMillis() -  t2;

    Object o;
    long t3 = System.currentTimeMillis();
    for (int i = Dict.RAND_DICT.length-1; i>=0; i--)
      o = h.get(Dict.RAND_DICT[i]);
    t3 = System.currentTimeMillis() -  t3;

    report("TernarySearchTree2", true, false, t1, t2, t3);
    h.release();o=null;h=null;System.gc();
  }

  static void ternarySearchTree2()
  {
    long t1 = System.currentTimeMillis();
    TernarySearchTree2 h = new TernarySearchTree2();
    t1 = System.currentTimeMillis() -  t1;

    long t2 = System.currentTimeMillis();
    for (int i = Dict.DICT.length-1; i>=0; i--)
      h.put(Dict.DICT[i], Boolean.TRUE);
    t2 = System.currentTimeMillis() -  t2;

    Object o;
    long t3 = System.currentTimeMillis();
    for (int i = Dict.DICT.length-1; i>=0; i--)
      o = h.get(Dict.DICT[i]);
    t3 = System.currentTimeMillis() -  t3;

    report("TernarySearchTree2", false, false, t1, t2, t3);

    h.release();o=null;h=null;System.gc();
  }

  static void randternarySearchTree1()
  {
    long t1 = System.currentTimeMillis();
    TernarySearchTree1 h = new TernarySearchTree1();
    t1 = System.currentTimeMillis() -  t1;

    long t2 = System.currentTimeMillis();
    for (int i = Dict.RAND_DICT.length-1; i>=0; i--)
      h.put(Dict.RAND_DICT[i], Boolean.TRUE);
    t2 = System.currentTimeMillis() -  t2;

    Object o;
    long t3 = System.currentTimeMillis();
    for (int i = Dict.RAND_DICT.length-1; i>=0; i--)
      o = h.get(Dict.RAND_DICT[i]);
    t3 = System.currentTimeMillis() -  t3;

    report("TernarySearchTree1", true, false, t1, t2, t3);

    h.release();o=null;h=null;System.gc();
  }

  static void ternarySearchTree1()
  {
    long t1 = System.currentTimeMillis();
    TernarySearchTree1 h = new TernarySearchTree1();
    t1 = System.currentTimeMillis() -  t1;

    long t2 = System.currentTimeMillis();
    for (int i = Dict.DICT.length-1; i>=0; i--)
      h.put(Dict.DICT[i], Boolean.TRUE);
    t2 = System.currentTimeMillis() -  t2;

    Object o;
    long t3 = System.currentTimeMillis();
    for (int i = Dict.DICT.length-1; i>=0; i--)
      o = h.get(Dict.DICT[i]);
    t3 = System.currentTimeMillis() -  t3;

    report("TernarySearchTree1", false, false, t1, t2, t3);

    h.release();o=null;h=null;System.gc();
  }


  static void randternarySearchTree0()
  {
    long t1 = System.currentTimeMillis();
    TernarySearchTree0 h = new TernarySearchTree0();
    t1 = System.currentTimeMillis() -  t1;

    long t2 = System.currentTimeMillis();
    for (int i = Dict.RAND_DICT.length-1; i>=0; i--)
      h.put(Dict.RAND_DICT[i], Boolean.TRUE);
    t2 = System.currentTimeMillis() -  t2;

    Object o;
    long t3 = System.currentTimeMillis();
    for (int i = Dict.RAND_DICT.length-1; i>=0; i--)
      o = h.get(Dict.RAND_DICT[i]);
    t3 = System.currentTimeMillis() -  t3;

    report("TernarySearchTree0", true, false, t1, t2, t3);

    h.release();o=null;h=null;System.gc();
  }

  static void ternarySearchTree0()
  {
    long t1 = System.currentTimeMillis();
    TernarySearchTree0 h = new TernarySearchTree0();
    t1 = System.currentTimeMillis() -  t1;

    long t2 = System.currentTimeMillis();
    for (int i = Dict.DICT.length-1; i>=0; i--)
      h.put(Dict.DICT[i], Boolean.TRUE);
    t2 = System.currentTimeMillis() -  t2;

    Object o;
    long t3 = System.currentTimeMillis();
    for (int i = Dict.DICT.length-1; i>=0; i--)
      o = h.get(Dict.DICT[i]);
    t3 = System.currentTimeMillis() -  t3;

    report("TernarySearchTree0", false, false, t1, t2, t3);

    h.release();o=null;h=null;System.gc();
  }


  static void sizedrandUnsynchronizedhashtable()
  {
    long t1 = System.currentTimeMillis();
    HashMap h = new HashMap(2*Dict.DICT.length-1);
    t1 = System.currentTimeMillis() -  t1;

    long t2 = System.currentTimeMillis();
    for (int i = Dict.RAND_DICT.length-1; i>=0; i--)
      h.put(Dict.RAND_DICT[i], Boolean.TRUE);
    t2 = System.currentTimeMillis() -  t2;

    Object o;
    long t3 = System.currentTimeMillis();
    for (int i = Dict.RAND_DICT.length-1; i>=0; i--)
      o = h.get(Dict.RAND_DICT[i]);
    t3 = System.currentTimeMillis() -  t3;

    report("HashMap", true, true, t1, t2, t3);

    o=null;h=null;System.gc();
  }

  static void sizedUnsynchronizedhashtable()
  {
    long t1 = System.currentTimeMillis();
    HashMap h = new HashMap(2*Dict.DICT.length-1);
    t1 = System.currentTimeMillis() -  t1;

    long t2 = System.currentTimeMillis();
    for (int i = Dict.DICT.length-1; i>=0; i--)
      h.put(Dict.DICT[i], Boolean.TRUE);
    t2 = System.currentTimeMillis() -  t2;

    Object o;
    long t3 = System.currentTimeMillis();
    for (int i = Dict.DICT.length-1; i>=0; i--)
      o = h.get(Dict.DICT[i]);
    t3 = System.currentTimeMillis() -  t3;

    report("HashMap", false, true, t1, t2, t3);

    o=null;h=null;System.gc();
  }
  static void randUnsynchronizedhashtable()
  {
    long t1 = System.currentTimeMillis();
    HashMap h = new HashMap();
    t1 = System.currentTimeMillis() -  t1;

    long t2 = System.currentTimeMillis();
    for (int i = Dict.RAND_DICT.length-1; i>=0; i--)
      h.put(Dict.RAND_DICT[i], Boolean.TRUE);
    t2 = System.currentTimeMillis() -  t2;

    Object o;
    long t3 = System.currentTimeMillis();
    for (int i = Dict.RAND_DICT.length-1; i>=0; i--)
      o = h.get(Dict.RAND_DICT[i]);
    t3 = System.currentTimeMillis() -  t3;

    report("HashMap", true, false, t1, t2, t3);

    o=null;h=null;System.gc();
  }

  static void Unsynchronizedhashtable()
  {
    long t1 = System.currentTimeMillis();
    HashMap h = new HashMap();
    t1 = System.currentTimeMillis() -  t1;

    long t2 = System.currentTimeMillis();
    for (int i = Dict.DICT.length-1; i>=0; i--)
      h.put(Dict.DICT[i], Boolean.TRUE);
    t2 = System.currentTimeMillis() -  t2;

    Object o;
    long t3 = System.currentTimeMillis();
    for (int i = Dict.DICT.length-1; i>=0; i--)
      o = h.get(Dict.DICT[i]);
    t3 = System.currentTimeMillis() -  t3;

    report("HashMap", false, false, t1, t2, t3);

    o=null;h=null;System.gc();
  }
  static void sizedrandhashtable()
  {
    long t1 = System.currentTimeMillis();
    Hashtable h = new Hashtable(2*Dict.DICT.length-1);
    t1 = System.currentTimeMillis() -  t1;

    long t2 = System.currentTimeMillis();
    for (int i = Dict.RAND_DICT.length-1; i>=0; i--)
      h.put(Dict.RAND_DICT[i], Boolean.TRUE);
    t2 = System.currentTimeMillis() -  t2;

    Object o;
    long t3 = System.currentTimeMillis();
    for (int i = Dict.RAND_DICT.length-1; i>=0; i--)
      o = h.get(Dict.RAND_DICT[i]);
    t3 = System.currentTimeMillis() -  t3;

    report("Hashtable", true, true, t1, t2, t3);

    o=null;h=null;System.gc();
  }

  static void sizedhashtable()
  {
    long t1 = System.currentTimeMillis();
    Hashtable h = new Hashtable(2*Dict.DICT.length-1);
    t1 = System.currentTimeMillis() -  t1;

    long t2 = System.currentTimeMillis();
    for (int i = Dict.DICT.length-1; i>=0; i--)
      h.put(Dict.DICT[i], Boolean.TRUE);
    t2 = System.currentTimeMillis() -  t2;

    Object o;
    long t3 = System.currentTimeMillis();
    for (int i = Dict.DICT.length-1; i>=0; i--)
      o = h.get(Dict.DICT[i]);
    t3 = System.currentTimeMillis() -  t3;

    report("Hashtable", false, true, t1, t2, t3);

    o=null;h=null;System.gc();
  }
  static void randhashtable()
  {
    long t1 = System.currentTimeMillis();
    Hashtable h = new Hashtable();
    t1 = System.currentTimeMillis() -  t1;

    long t2 = System.currentTimeMillis();
    for (int i = Dict.RAND_DICT.length-1; i>=0; i--)
      h.put(Dict.RAND_DICT[i], Boolean.TRUE);
    t2 = System.currentTimeMillis() -  t2;

    Object o;
    long t3 = System.currentTimeMillis();
    for (int i = Dict.RAND_DICT.length-1; i>=0; i--)
      o = h.get(Dict.RAND_DICT[i]);
    t3 = System.currentTimeMillis() -  t3;

    report("Hashtable", true, false, t1, t2, t3);

    o=null;h=null;System.gc();
  }

  static void hashtable()
  {
    long t1 = System.currentTimeMillis();
    Hashtable h = new Hashtable();
    t1 = System.currentTimeMillis() -  t1;

    long t2 = System.currentTimeMillis();
    for (int i = Dict.DICT.length-1; i>=0; i--)
      h.put(Dict.DICT[i], Boolean.TRUE);
    t2 = System.currentTimeMillis() -  t2;

    Object o;
    long t3 = System.currentTimeMillis();
    for (int i = Dict.DICT.length-1; i>=0; i--)
      o = h.get(Dict.DICT[i]);
    t3 = System.currentTimeMillis() -  t3;

    report("Hashtable", false, false, t1, t2, t3);

    o=null;h=null;System.gc();
  }
  static void randUnsynchronizedTreeMap()
  {
    long t1 = System.currentTimeMillis();
    TreeMap h = new TreeMap();
    t1 = System.currentTimeMillis() -  t1;

    long t2 = System.currentTimeMillis();
    for (int i = Dict.RAND_DICT.length-1; i>=0; i--)
      h.put(Dict.RAND_DICT[i], Boolean.TRUE);
    t2 = System.currentTimeMillis() -  t2;

    Object o;
    long t3 = System.currentTimeMillis();
    for (int i = Dict.RAND_DICT.length-1; i>=0; i--)
      o = h.get(Dict.RAND_DICT[i]);
    t3 = System.currentTimeMillis() -  t3;

    report("TreeMap", true, false, t1, t2, t3);

    o=null;h=null;System.gc();
  }

  static void UnsynchronizedTreeMap()
  {
    long t1 = System.currentTimeMillis();
    TreeMap h = new TreeMap();
    t1 = System.currentTimeMillis() -  t1;

    long t2 = System.currentTimeMillis();
    for (int i = Dict.DICT.length-1; i>=0; i--)
      h.put(Dict.DICT[i], Boolean.TRUE);
    t2 = System.currentTimeMillis() -  t2;

    Object o;
    long t3 = System.currentTimeMillis();
    for (int i = Dict.DICT.length-1; i>=0; i--)
      o = h.get(Dict.DICT[i]);
    t3 = System.currentTimeMillis() -  t3;

    report("TreeMap", false, false, t1, t2, t3);

    o=null;h=null;System.gc();
  }
}
