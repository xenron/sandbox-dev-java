package tuning.sorting;

import java.util.Arrays;

public class Flashsort1
{

  public static void flashsort1(int[] arr)
  {
    //Number of groups into which the elements are classified
    //Neubert suggests 0.2 to 0.5 times the number of elements in the array.
    int num_groups = (int) (0.4 * arr.length);

    //Count the number of elements in each group
    int[] groups = new int[num_groups];
    
    flashsort1(arr, num_groups, groups);
  }

public static void flashsort1(int[] arr, int num_groups, int[] groups)
{
  //First get the minimum and maximum values
  int min = arr[0];
  int max_idx = 0;
  int i;
  for (i = arr.length-1; i > 0; i--)
  {
    if (arr[i] < min)
      min = arr[i];
    if (arr[i] > arr[max_idx])
      max_idx = i;
  }
  //If they are the same, all elements are identical
  //so the array is already sorted.
  if (min == arr[max_idx])
    return;
  
  //Count the number of elements in each group
  //Take care to handle possible integer overflow by
  //casting to larger datatypes where this might occur.
  double scaling_constant = (num_groups - 1) / ( ((double) arr[max_idx]) - min);
  int group;
  for (i = arr.length-1; i >= 0; i--)
  {
    group = (int) (scaling_constant * (((long) arr[i]) - min));
    groups[group]++;
  }
  
  //Set the groups to point to the indexes in the array
  //which are the last index for each group.
  groups[0]--;
  for (i = 1; i < groups.length; i++)
  {
    groups[i] += groups[i-1];
  }
  
  //Put the biggest element at index 0 so that the swapping
  //algorithm below starts on the largest element & max group.
  int old_value = arr[max_idx];
  arr[max_idx] = arr[0];
  arr[0] = old_value;
  
  //start with element at index 0
  int idx = 0;
  //and the maximum group
  group = num_groups - 1;

  //Start moving elements into their groups.
  //We need to make 'arr.length' moves at most,
  //but if we have one move left in the outer loop
  //then the remaining element is already in the right place,
  //so we need test for only 'arr.length-1' moves.
  int number_of_moves_left = arr.length - 1;
  
  int new_value;
  while(number_of_moves_left > 0)
  {
    //When the first group fills up, we start scanning
    //for elements left in the wrong groups, and move them.
    //Note that we scan through the array only once.
    while(idx > groups[group])
    {
      idx++;
      group = (int) (scaling_constant * (((long) arr[idx]) - min));
    }
    
    new_value = arr[idx];
    //We run this loop until the first group fills up.
    //Then we run the previous scan loop to get back into this loop.
    while( idx != (groups[group]+1) )
    {
      group = (int) (scaling_constant * (((long) new_value) - min));
      old_value = arr[groups[group]];
      arr[groups[group]] = new_value;
      new_value = old_value;
      groups[group]--; //decrement the pointer to the next index
      number_of_moves_left--;
    }
  }
  
  //Now we have our partially ordered array,
  //we do an insertion sort to order the remainder.
  for (i = arr.length - 3; i >= 0; i--)
  {
    if (arr[i+1] < arr[i])
    {
      old_value = arr[i];
      idx = i;
      while(arr[idx+1] < old_value)
      {
        arr[idx] = arr[idx+1];
        idx++;
      }
      arr[idx] = old_value;
    }
  }
}
  public static void flashsort2(int[] arr, int num_groups, int[] groups)
  {
    //First get the minimum and maximum values
    int min = arr[0];  //minimum value
    int max = arr[0];  //maximum value
    int max_idx = 0;   //index of element with maximum value
    int i;
    int el;
    for (i = arr.length-1; i > 0; i--)
    {
      if ((el=arr[i]) < min)
        min = el;
      if (el > max)
      {
        max_idx = i;
        max = arr[max_idx];
      }
    }
    //If they are the same, all elements are identical
    //so the array is already sorted.
    if (min == max)
      return;

    //Count the number of elements that will fall into each group
    //The scaling constant scales all values into the range 0 to (num_groups - 1)

//OLD    double scaling_constant = (num_groups - 1) / ( ((double) arr[max_idx]) - min);
    //***Optimized
    //Test to ensure at least three groups, so that scaling constant can be an int
    if (num_groups < 3)
	throw new IllegalArgumentException("must have at least three groups");
    int scaling_cnstnt = (int) ((((long) max) - min) / (num_groups - 1));
    //and increment to handle extreme case of max evenly dividing
    scaling_cnstnt++;
    int scaled_min = min/scaling_cnstnt;
    int group;

    for (i = arr.length-1; i >= 0; i--)
    {
//OLD      groups[(int) (scaling_constant * (((long) arr[i]) - min))]++;
//OLD2        groups[(arr[i] - min)/scaling_cnstnt]++;
        groups[(arr[i]/scaling_cnstnt)-scaled_min]++;
    }

    //And set the group to point to the index in the array
    //which is the last index for that group.
    groups[0]--;
    for (i = 1; i < groups.length; i++)
    {
      groups[i] += groups[i-1];
    }

    //Put the biggest element at index 0 so that the swapping
    //algorithm below starts on the largest element & max group.
    int old_value = arr[max_idx];
    arr[max_idx] = arr[0];
    arr[0] = old_value;

    //start with element at index 0
    int idx = 0;
    //and the maximum group
    group = num_groups - 1;

    //Start moving elements into their groups.
    //We need to make 'arr.length' moves at most,
    //but if we have one move left in the outer loop
    //then the remaining element is already in the right place,
    //so we need test for only 'arr.length-1' moves.
    int number_of_moves_left = arr.length - 1;

    int new_value;
    while(number_of_moves_left > 0)
    {
      //When the first group fills up, we start scanning
      //for elements left in the wrong groups, and move them.
      //Note that we scan through the array only once.
      while(idx > groups[group])
      {
        idx++;
//OLD        group = (int) (scaling_constant * (((long) arr[idx]) - min));
//OLD2        group = (int) ( (((long) arr[idx]) - min)/scaling_cnstnt);
        group = (arr[idx]/scaling_cnstnt) - scaled_min;
      }

      new_value = arr[idx];
      while( idx != (groups[group]+1) )
      {
//OLD        group = (int) (scaling_constant * (((long) new_value) - min));
//OLD2        group = (int) ( (((long) new_value) - min)/scaling_cnstnt);
        group = (new_value/scaling_cnstnt) - scaled_min;
        old_value = arr[groups[group]];
        arr[groups[group]] = new_value;
        new_value = old_value;
        groups[group]--; //decrement the pointer to the next index
        number_of_moves_left--;
      }
    }

    //Now we have our partially ordered array,
    //we do an insertion sort to order the remainder.
    for (i = arr.length - 3; i >= 0; i--)
    {
      if (arr[i+1] < arr[i])
      {
        old_value = arr[i];
        idx = i;
        while(arr[idx+1] < old_value)
        {
          arr[idx] = arr[idx+1];
          idx++;
        }
        arr[idx] = old_value;
      }
    }
  }
  public static void main(String args[])
  {
    test();
  }
  public static void quicksort(int[] arr)
  {
    quicksort(arr, 0, arr.length-1);
  }
  public static void quicksort(int[] arr, int lo, int hi)
  {
    if( lo >= hi ) 
      return;

    int mid = ( lo + hi ) / 2;
    int tmp;
    int middle = arr[ mid ];

    if( arr[ lo ] > middle)
    {
      arr[ mid ] = arr[ lo ];
      arr[ lo ] = middle;
      middle = arr[ mid ];
    }

    if( middle > arr[hi])
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

      while( left < right && arr[ left ] <= middle)
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
  public static void refsort(int[] arr)
  {
    Arrays.sort(arr);
  }
  public static void test()
  {
    for (int j = 10; ; j*= 10)
      for (int i = j*2;  i < j*10; i+=j*2)
        test(i);
  }
  public static void test(int arrsize)
  {
    int[] arr = new int[arrsize];
    java.util.Random r = new java.util.Random();
    for (int i = arrsize - 1; i >= 0 ; i--)
      arr[i] = r.nextInt()/10;
    int[] tosort;
    long time;
    
    tosort = (int[]) arr.clone();
//    int num_groups = (int) (0.2 * arr.length);
//    int[] groups = new int[num_groups];
    System.gc();
    time = System.currentTimeMillis();
//    flashsort1(tosort, num_groups, groups);
    flashsort1(tosort);
    time = System.currentTimeMillis() - time;
    System.out.println("The flashsort1 of " + arrsize + " elements took " + time + " milliseconds");
    System.gc();
    
    tosort = (int[]) arr.clone();
    System.gc();
    time = System.currentTimeMillis();
    refsort(tosort);
    time = System.currentTimeMillis() - time;
    System.out.println("The refsort of " + arrsize + " elements took " + time + " milliseconds");
    System.gc();

    tosort = (int[]) arr.clone();
    System.gc();
    time = System.currentTimeMillis();
    quicksort(tosort);
    time = System.currentTimeMillis() - time;
    System.out.println("The quicksort of " + arrsize + " elements took " + time + " milliseconds");
    System.gc();
  }
}