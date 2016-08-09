package tuning.sorting;
import java.util.Random;
import java.util.Arrays;
import java.io.*;

class SortBuildNode
{
  int value;
  SortBuildNode next;
  SortBuildNode last;
  public SortBuildNode(int val, SortBuildNode last, SortBuildNode next)
  {
    this.value = val;
    this.last = last;
    this.next = next;
  }
}

public class SortBuild
{
  static int SEED = 1234567890;

  SortBuildNode root;
  int size;
  public SortBuild(int val)
  {
    root = new SortBuildNode(val, null, null);
    size++;
  }
  public int[] toArray()
  {
    int[] arr = new int[size];
    SortBuildNode node = root;
    for (int i = size-1; i >= 0; i--)
    {
      arr[i] = node.value;
      node = node.next;
    }
    return arr;
  }
  public void addSorted(int val)
  {
    size++;
    SortBuildNode node = root;
    while(node.value > val)
    {
      if(node.next == null)
      {
        node.next = new SortBuildNode(val, node, null);
        return;
      }
      else
        node = node.next;
    }
    if (node == root)
    {
      root = new SortBuildNode(val, null, node);
      node.last = root;
    }
    else
    {
      node.last.next = new SortBuildNode(val, node.last, node);
      node.last = node.last.next;
    }
  }

  public static void buildRandList(int arrsize)
    throws IOException
  {
    int[] arr = new int[arrsize];
    java.util.Random r = new java.util.Random(SEED);
    DataOutputStream wrtr = new DataOutputStream(
      new BufferedOutputStream(new FileOutputStream("t.tmp")));
    for (int i = arrsize - 1; i >= 0 ; i--)
      wrtr.writeInt(r.nextInt()/10);
    wrtr.flush();
    wrtr.close();
  }

  public static int[] readAndSortRandList(int arrsize)
    throws IOException
  {
    int[] arr = new int[arrsize];
    long time = System.currentTimeMillis();
    DataInputStream rdr = new DataInputStream(
      new BufferedInputStream(new FileInputStream("t.tmp")));
    for (int i = arrsize - 1; i >= 0 ; i--)
      arr[i] = rdr.readInt();
    rdr.close();
    System.out.println("Read time: " + (System.currentTimeMillis()-time));
    time = System.currentTimeMillis();
    quicksort(arr, 0, arrsize-1);

    System.out.println("Sort time: " + (System.currentTimeMillis()-time));
    return arr;
  }

  public static int[] sortWhileReadingRandList(int arrsize)
    throws IOException
  {
    long time = System.currentTimeMillis();
    DataInputStream rdr = new DataInputStream(
      new BufferedInputStream(new FileInputStream("t.tmp")));
    int read;
    SortBuild sorter = new SortBuild(rdr.readInt());
    for (int i = arrsize-1; i > 0; i--)
    {
      sorter.addSorted(rdr.readInt());
    }
    rdr.close();
    int[] arr = sorter.toArray();
    System.out.println("Sort while reading time: " + (System.currentTimeMillis()-time));
    return arr;
  }

  public static int binarySearch(int[] arr, int elem, int fromIndex, int toIndex)
  {
    int mid,cmp;
    while (fromIndex <= toIndex)
    {
      mid =(fromIndex + toIndex)/2;
      if ( (cmp = arr[mid] - elem) < 0)
        fromIndex = mid + 1;
      else if (cmp > 0)
        toIndex = mid - 1;
      else
       return mid;
    }
    return fromIndex;
  }

  public static void main(String[] args)
  {
    try
    {
      int SIZE = Integer.parseInt(args[0]);
      buildRandList(SIZE);
      int[] arr1 = readAndSortRandList(SIZE);
      int[] arr2 = sortWhileReadingRandList(SIZE);
      for (int i = Math.max(arr1.length,arr2.length)-1; i >= 0; i--)
        if(arr1[i] != arr2[i])
          System.out.println(arr1[i] + "!=" + arr2[i]);
    }
    catch(Exception e){e.printStackTrace();}
  }

  public static void quicksort(int[] arr, int lo, int hi)
  {
    if( lo >= hi ) 
      return;

    int mid = ( lo + hi ) / 2;
    int tmp;
    int middle = arr[ mid ];

    if( arr[ lo ] > middle )
    {
      arr[ mid ] = arr[ lo ];
      arr[ lo ] = middle;
      middle = arr[ mid ];
    }
    
    if( middle > arr[ hi ])
    {
      arr[ mid ] = arr[ hi ];
      arr[ hi ] = middle;
      middle = arr[ mid ];

      if( arr[ lo ] > middle)
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
      while( arr[ right ] > middle)
      {
        right--;
      }

      while( left < right && arr[ left ] <= middle )
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

    quicksort(arr, lo, left);
    quicksort(arr, left + 1, hi);
  }


}

