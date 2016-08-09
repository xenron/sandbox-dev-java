package tuning.sorting;
import java.util.Random;
import java.util.Arrays;
import java.util.Comparator;

public class Sortable
  implements Comparable
{
  static int SEED = 1234567890;
  int order;
  public Sortable(int i){order = i;}
  public int compareTo(Object o){return order - ((Sortable) o).order;}
  public int compareToSortable(Sortable o){return order - o.order;}
  public static void main(String[] args)
  {
    maintest(args);
    if (args.length > 1)
      maintest(args);
  }

  public static void maintest(String[] args)
  {
    int SIZE = Integer.parseInt(args[0]);
    Sortable[] list = new Sortable[SIZE];
    for (int i = SIZE-1; i >= 0; i--)
      list[i] = new Sortable(i);

    long time ;
    Sortable[] listToSort;
    list = randomized(list);
    listToSort = (Sortable[]) list.clone();
    ArrayQuickSorter.SINGLETON.sort(new SortableComparer(), listToSort, 0, listToSort.length);
    quicksort_Sortable2(listToSort, 0, listToSort.length-1);
    for (int i = SIZE-1; i >= 0; i--)
      if(listToSort[i].order != i)
	System.out.println("here");

    listToSort = (Sortable[]) list.clone();
    time = System.currentTimeMillis();
    ArrayQuickSorter.SINGLETON.sort(new SortableComparer(), listToSort, 0, listToSort.length);
    System.out.println("ArrayQuickSorter time using Sortable.method: " + 
      (System.currentTimeMillis()-time));
    for (int i = SIZE-1; i >= 0; i--)
      if(listToSort[i].order != i)
	System.out.println(listToSort[i].order + " here " + i);

    listToSort = (Sortable[]) list.clone();
    time = System.currentTimeMillis();
    ArrayQuickSorter.SINGLETON.sort(new SortableComparer2(), listToSort, 0, listToSort.length);
    System.out.println("ArrayQuickSorter time using Sortable.field: " + 
      (System.currentTimeMillis()-time));
    for (int i = SIZE-1; i >= 0; i--)
      if(listToSort[i].order != i)
	System.out.println(listToSort[i].order + " here " + i);

    listToSort = (Sortable[]) list.clone();
    time = System.currentTimeMillis();
    quicksort_Sortable2(listToSort, 0, listToSort.length-1);
    System.out.println("quicksort time using Sortable.field: " + 
      (System.currentTimeMillis()-time));
    for (int i = SIZE-1; i >= 0; i--)
      if(listToSort[i].order != i)
	System.out.println("here");

    listToSort = (Sortable[]) list.clone();
    time = System.currentTimeMillis();
    quicksort_Sortable1(listToSort, 0, listToSort.length-1);
    System.out.println("quicksort time using Sortable.method: " + 
      (System.currentTimeMillis()-time));
    for (int i = SIZE-1; i >= 0; i--)
      if(listToSort[i].order != i)
	System.out.println("here");
    listToSort = (Sortable[]) list.clone();
    time = System.currentTimeMillis();
    quicksort_Comparable(listToSort, 0, listToSort.length-1);
    System.out.println("quicksort time using Comparable: " + 
      (System.currentTimeMillis()-time));
    for (int i = SIZE-1; i >= 0; i--)
      if(listToSort[i].order != i)
	System.out.println("here");

    listToSort = (Sortable[]) list.clone();
    time = System.currentTimeMillis();
    quicksort_Object(listToSort, 0, listToSort.length-1);
    System.out.println("quicksort time using Object: " + 
      (System.currentTimeMillis()-time));
    for (int i = SIZE-1; i >= 0; i--)
      if(listToSort[i].order != i)
	System.out.println("here");
    listToSort = (Sortable[]) list.clone();
    time = System.currentTimeMillis();
    Arrays.sort(listToSort, 0, listToSort.length);
    System.out.println("quicksort time using Arrays.sort: " + 
      (System.currentTimeMillis()-time));
    for (int i = SIZE-1; i >= 0; i--)
      if(listToSort[i].order != i)
	System.out.println("here");
  }

  public static Sortable[] randomized(Sortable[] arr)
  {
    Sortable[] list = new Sortable[arr.length];
    Sortable[] list2 = (Sortable[]) arr.clone();
    Random rand = new Random(SEED);
    int idx;
    for (int i = list.length-1; i >= 0 ; i--)
    {
	idx = (int) ((Math.abs(rand.nextInt()) * (long) i)/Integer.MAX_VALUE);
	list[i] = list2[idx];
	list2[idx] = list2[i];
	list2[i] = null;
    }
    list2 = null;
    rand = null;
    System.gc();
    return list;
  }

  public static void quicksort_Sortable1(Sortable[] arr, int lo, int hi)
  {
    if( lo >= hi ) 
      return;

    int mid = ( lo + hi ) / 2;
    Sortable tmp;
    Sortable middle = arr[ mid ];

    if( arr[ lo ].compareToSortable(middle) > 0 )
    {
      arr[ mid ] = arr[ lo ];
      arr[ lo ] = middle;
      middle = arr[ mid ];
    }
    
    if( middle.compareToSortable(arr[ hi ]) > 0)
    {
      arr[ mid ] = arr[ hi ];
      arr[ hi ] = middle;
      middle = arr[ mid ];

      if( arr[ lo ].compareToSortable(middle) > 0)
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
      while( arr[ right ].compareToSortable(middle ) > 0)
      {
        right--;
      }

      while( left < right && arr[ left ].compareToSortable(middle ) <= 0)
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

    quicksort_Sortable1(arr, lo, left);
    quicksort_Sortable1(arr, left + 1, hi);
  }

  public static void quicksort_Sortable2(Sortable[] arr, int lo, int hi)
  {
    if( lo >= hi ) 
      return;

    int mid = ( lo + hi ) / 2;
    Sortable tmp;
    Sortable middle = arr[ mid ];

    if( arr[ lo ].order > middle.order )
    {
      arr[ mid ] = arr[ lo ];
      arr[ lo ] = middle;
      middle = arr[ mid ];
    }
    
    if( middle.order > arr[ hi ].order)
    {
      arr[ mid ] = arr[ hi ];
      arr[ hi ] = middle;
      middle = arr[ mid ];

      if( arr[ lo ].order > middle.order)
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
      while( arr[ right ].order > middle.order)
      {
        right--;
      }

      while( left < right && arr[ left ].order <= middle.order )
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

    quicksort_Sortable2(arr, lo, left);
    quicksort_Sortable2(arr, left + 1, hi);
  }

  public static void quicksort_Comparable(Comparable[] arr, int lo, int hi)
  {
    if( lo >= hi ) 
      return;

    int mid = ( lo + hi ) / 2;
    Comparable tmp;
    Comparable middle = arr[ mid ];

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

    quicksort_Comparable(arr, lo, left);
    quicksort_Comparable(arr, left + 1, hi);
  }

  public static void quicksort_Object(Object[] arr, int lo, int hi)
  {
    if( lo >= hi ) 
      return;

    int mid = ( lo + hi ) / 2;
    Object tmp;
    Object middle = arr[ mid ];

    if( ((Comparable) arr[ lo ]).compareTo(middle) > 0 )
    {
      arr[ mid ] = arr[ lo ];
      arr[ lo ] = middle;
      middle = arr[ mid ];
    }
    
    if( ((Comparable) middle).compareTo(arr[ hi ]) > 0)
    {
      arr[ mid ] = arr[ hi ];
      arr[ hi ] = middle;
      middle = arr[ mid ];

      if( ((Comparable) arr[ lo ]).compareTo(middle) > 0)
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
      while( ((Comparable) arr[ right ]).compareTo(middle ) > 0)
      {
        right--;
      }

      while( left < right && ((Comparable) arr[ left ]).compareTo(middle ) <= 0)
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

    quicksort_Object(arr, lo, left);
    quicksort_Object(arr, left + 1, hi);
  }

}

interface Comparer
  extends Comparator
{
  public boolean hasComparisonKeys();
  public ComparisonKey getComparisonKey(Object o);
}

interface RawIntComparer
  extends Comparer
{
  public void getComparisonKey(Object o, int[] orders, int idx);
}

class SortableComparer
 implements Comparer
{
  public boolean hasComparisonKeys(){return true;}
  public ComparisonKey getComparisonKey(Object o){
    return new IntegerComparisonKey(o, ((Sortable) o).order);}
  public int compare(Object o1, Object o2) {
    System.out.println("wrong");return 1;}
}

class SortableComparer2
 extends SortableComparer
 implements RawIntComparer
{
  public ComparisonKey getComparisonKey(Object o){
    return null;}
  public void getComparisonKey(Object s, int[] orders, int index){
    orders[index] = ((Sortable) s).order;}
}

interface ComparisonKey
{
  public int compareTo(ComparisonKey target);
  public Object getSource();
}

class IntegerComparisonKey
  implements ComparisonKey
{
  public Object source;
  public int order;
  public IntegerComparisonKey(Object source, int order) {
     this.source = source;
     this.order = order;
  }
  public int compareTo(ComparisonKey target){
    System.out.println("wrong");
    return order - ((IntegerComparisonKey) target).order;
  }
  public Object getSource() {return source;}
}

class ArrayQuickSorter
{
  public static ArrayQuickSorter SINGLETON = new ArrayQuickSorter();

  public void sort(Comparator comparator, Object[] arr, int startIndex, int length)
  {
    //If the comparator is part of the extended framework, handle
    //the special case where it recommends using comparison keys
    if (comparator instanceof Comparer && ((Comparer) comparator).hasComparisonKeys())
    {
      //wrap the objects in the ComparisonKeys
      //but if the ComparisonKey is the special case of IntegerComparisonKey,
      //handle that specially
    if (comparator instanceof RawIntComparer)
    {
      RawIntComparer comparer = (RawIntComparer) comparator;
      Object[] oarr = new Object[length];
      int[] orders = new int[length];

      for(int j = length-1, i = startIndex+length-1; j >= 0; i--, j--)
      {
          comparer.getComparisonKey(arr[i], orders, j);
          oarr[j] = arr[i];
      }

      //sort using the optimized sort for IntegerComparisonKeys
      sort_intkeys(oarr, orders, 0, length);

      //and unwrap
      for(int j = length-1, i = startIndex+length-1; j >= 0; i--, j--)
        arr[i] = oarr[j];
    }
    else
    {
      Comparer comparer = (Comparer) comparator;
      ComparisonKey first = comparer.getComparisonKey(arr[startIndex]);
      if (first instanceof IntegerComparisonKey)
      {
        //wrap in IntegerComparisonKeys
        IntegerComparisonKey[] iarr = new IntegerComparisonKey[length];
        iarr[startIndex] = (IntegerComparisonKey) first;
        for(int j = length-1, i = startIndex+length-1; j > 0; i--, j--)
          iarr[j] = (IntegerComparisonKey) comparer.getComparisonKey(arr[i]);

        //sort using the optimized sort for IntegerComparisonKeys
        sort_intkeys(iarr, 0, length);

        //and unwrap
        for(int j = length-1, i = startIndex+length-1; j >= 0; i--, j--)
          arr[i] = iarr[j].source;
      }
      else
      {
        //wrap in IntegerComparisonKeys
        ComparisonKey[] karr = new ComparisonKey[length];
        karr[startIndex] = first; 
        for(int j = length-1, i = startIndex+length-1; j > 0; i--, j--)
          karr[i] = comparer.getComparisonKey(arr[i]);

        //sort using the optimized sort for ComparisonKeys
        sort_keys(karr, 0, length);

        //and unwrap
        for(int j = length-1, i = startIndex+length-1; j >= 0; i--, j--)
          arr[i] = karr[i].getSource();
      }
    }
    }
    else
      //just use the original algorithm
      sort_comparator(comparator, arr, startIndex, length);
  }
  public void sort_comparator(Comparator comparator, Object[] arr, int startIndex, int length)
  {
    //quicksort algorithm implementation using Comparator.compare(Object, Object)
    System.out.println("wrong");
  }
  public void sort_keys(ComparisonKey[] arr, int startIndex, int length)
  {
    //quicksort algorithm implementation using ComparisonKey.compare(ComparisonKey)
    System.out.println("wrong");
  }
  public void sort_intkeys(IntegerComparisonKey[] arr, int startIndex, int length)
  {
    //quicksort algorithm implementation comparing key order directly
    //using access to the IntegerComparisonKey.order field
    //i.e if (arr[i].order > arr[j].order)
    int lo = startIndex;
    int hi = startIndex+length-1;
    quicksort_Sortable2(arr, lo, hi);
  }
  public static void quicksort_Sortable2(IntegerComparisonKey[] arr, int lo, int hi)
  {
    if( lo >= hi ) 
      return;

    int mid = ( lo + hi ) / 2;
    IntegerComparisonKey tmp;
    IntegerComparisonKey middle = arr[ mid ];

    if( arr[ lo ].order > middle.order )
    {
      arr[ mid ] = arr[ lo ];
      arr[ lo ] = middle;
      middle = arr[ mid ];
    }
    
    if( middle.order > arr[ hi ].order)
    {
      arr[ mid ] = arr[ hi ];
      arr[ hi ] = middle;
      middle = arr[ mid ];

      if( arr[ lo ].order > middle.order)
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
      while( arr[ right ].order > middle.order)
      {
        right--;
      }

      while( left < right && arr[ left ].order <= middle.order )
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

    quicksort_Sortable2(arr, lo, left);
    quicksort_Sortable2(arr, left + 1, hi);
  }

  public void sort_intkeys(Object[] sources, int[] orders, int startIndex, int length)
  {
    //quicksort algorithm implementation comparing key order directly
    //using access to the IntegerComparisonKey.order field
    //i.e if (arr[i].order > arr[j].order)
    int lo = startIndex;
    int hi = startIndex+length-1;
    quicksort(sources, orders, lo, hi);
  }
  public static void quicksort(Object[] sources, int[] orders, int lo, int hi)
  {
    if( lo >= hi ) 
      return;

    int mid = ( lo + hi ) / 2;
    Object tmp_o;
    int tmp_i;
    int middle = orders[ mid ];

    if( orders[ lo ] > middle )
    {
      orders[ mid ] = orders[ lo ];
      orders[ lo ] = middle;
      middle = orders[ mid ];
      tmp_o = sources[mid];
      sources[ mid ] = sources[ lo ];
      sources[ lo ] = tmp_o;
    }
    
    if( middle > orders[ hi ])
    {
      orders[ mid ] = orders[ hi ];
      orders[ hi ] = middle;
      middle = orders[ mid ];
      tmp_o = sources[mid];
      sources[ mid ] = sources[ hi ];
      sources[ hi ] = tmp_o;

      if( orders[ lo ] > middle)
      {
        orders[ mid ] = orders[ lo ];
        orders[ lo ] = middle;
        middle = orders[ mid ];
        tmp_o = sources[mid];
        sources[ mid ] = sources[ lo ];
        sources[ lo ] = tmp_o;
      }
    }

    int left = lo + 1;
    int right = hi - 1;

    if( left >= right ) 
      return;

    for( ;; ) 
    {
      while( orders[ right ] > middle)
      {
        right--;
      }

      while( left < right && orders[ left ] <= middle )
      {
        left++;
      }

      if( left < right )
      {
        tmp_i = orders[ left ];
        orders[ left ] = orders[ right ];
        orders[ right ] = tmp_i;
        tmp_o = sources[ left ];
        sources[ left ] = sources[ right ];
        sources[ right ] = tmp_o;
        right--;
      }
      else
      {
        break;
      }
    }

    quicksort(sources, orders, lo, left);
    quicksort(sources, orders, left + 1, hi);
  }


}
