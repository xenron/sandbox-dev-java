package tuning.string;
import tuning.dict.Dict;
import java.text.Collator;
import java.text.CollationKey;
import java.util.Locale;

public class Sorting
{
  String source;
  char[] carr;
static Locale LOCALE = Locale.US;
  public Sorting(String s)
  {
    source = s;
    carr = new char[s.length()];
    s.getChars(0, carr.length, carr, 0);
  }

  public static void main(String[] args)
  {
    int REPEAT = 20;
    if (args.length == 1)
      REPEAT = Integer.parseInt(args[0]);

    try{Dict.initialize(true);}catch(Exception e){e.printStackTrace();}
    String[] D1 = new String[Dict.DICT.length];
    String[] D2 = new String[Dict.DICT.length];
    String[] D3 = new String[Dict.DICT.length];
    String[] D4 = new String[Dict.DICT.length];
    String[] D5 = new String[Dict.DICT.length];
    String[] D6 = new String[Dict.DICT.length];
    String[] D7 = new String[Dict.DICT.length];
    for (int i = D1.length-1 ; i >= 0 ; i--)
    {
      D1[i] = Dict.RAND_DICT[i];
      D2[i] = Dict.RAND_DICT[i];
      D3[i] = Dict.RAND_DICT[i];
      D4[i] = Dict.RAND_DICT[i];
      D5[i] = Dict.RAND_DICT[i];
      D6[i] = Dict.RAND_DICT[i];
      D7[i] = Dict.RAND_DICT[i];
    }

    long time ;


    time = System.currentTimeMillis();
    for (int i = REPEAT ; i > 0; i--)
      quicksort_compareTo(D1, 0, D1.length-1);
    System.out.println("Time to quicksort using String.compareTo (in millis): " + 
      (System.currentTimeMillis()-time));

    time = System.currentTimeMillis();
    for (int i = REPEAT ; i > 0; i--)
      quicksort_Sorting(D2);
    System.out.println("Time to quicksort using Sorting.compare (in millis): " + 
      (System.currentTimeMillis()-time));

    time = System.currentTimeMillis();
    for (int i = REPEAT ; i > 0; i--)
      quicksort_collationKey(D3);
    System.out.println("Time to quicksort using CollationKey.compareTo (in millis): " + 
      (System.currentTimeMillis()-time));

    time = System.currentTimeMillis();
    for (int i = REPEAT ; i > 0; i--)
      quicksort_collator(Collator.getInstance(LOCALE), D4, 0, D1.length-1);
    System.out.println("Time to quicksort using Collator.compare (in millis): " + 
      (System.currentTimeMillis()-time));

    time = System.currentTimeMillis();
    for (int i = REPEAT ; i > 0; i--)
      quicksort_compareTo(D6, 0, D1.length-1);
      quicksort_collationKey(D6);
    System.out.println("Time to double quicksort using CollationKey.compareTo (in millis): " + 
      (System.currentTimeMillis()-time));

    time = System.currentTimeMillis();
    for (int i = REPEAT ; i > 0; i--)
      quicksort_compareTo(D7, 0, D1.length-1);
      quicksort_collator(Collator.getInstance(LOCALE), D7, 0, D1.length-1);
    System.out.println("Time to double quicksort using Collator.compare (in millis): " + 
      (System.currentTimeMillis()-time));

  }

  public static void quicksort_collator(Collator c, String[] arr, int lo, int hi)
  {
    if( lo >= hi ) 
      return;

    int mid = ( lo + hi ) / 2;
    String tmp;
    String middle = arr[ mid ];

    if( c.compare(arr[ lo ], middle) > 0 )
    {
      arr[ mid ] = arr[ lo ];
      arr[ lo ] = middle;
      middle = arr[ mid ];
    }
    
    if( c.compare(middle, arr[ hi ]) > 0)
    {
      arr[ mid ] = arr[ hi ];
      arr[ hi ] = middle;
      middle = arr[ mid ];

      if( c.compare(arr[ lo ], middle) > 0)
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
      while( c.compare(arr[ right ], middle ) > 0)
      {
        right--;
      }

      while( left < right && c.compare(arr[ left ], middle ) <= 0)
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

    quicksort_collator(c, arr, lo, left);
    quicksort_collator(c, arr, left + 1, hi);
  }


  public static void quicksort_Sorting(String[] arr)
  {
    Sorting[] keys = new Sorting[arr.length];
    for (int i = arr.length-1; i >= 0; i--)
      keys[i] = new Sorting(arr[i]);
    quicksort_Sorting(keys, 0, arr.length-1);
    for (int i = arr.length-1; i >= 0; i--)
      arr[i] = keys[i].source;
  }

  public static int compare(char[] arr1, char[] arr2)
  {
    int n = Math.min(arr1.length, arr2.length);
    for (int i = 0; i < n; i++)
    {
      if (arr1[i] != arr2[i])
        return arr1[i] - arr2[i];
    }
    return arr1.length - arr2.length;
  }

  public static void quicksort_Sorting(Sorting[] arr, int lo, int hi)
  {
    if( lo >= hi ) 
      return;

    int mid = ( lo + hi ) / 2;
    Sorting tmp;
    Sorting middle = arr[ mid ];

    if( compare(arr[ lo ].carr, middle.carr) > 0 )
    {
      arr[ mid ] = arr[ lo ];
      arr[ lo ] = middle;
      middle = arr[ mid ];
    }
    
    if( compare(middle.carr, arr[ hi ].carr) > 0)
    {
      arr[ mid ] = arr[ hi ];
      arr[ hi ] = middle;
      middle = arr[ mid ];

      if( compare(arr[ lo ].carr, middle.carr) > 0)
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
      while( compare(arr[ right ].carr, middle.carr ) > 0)
      {
        right--;
      }

      while( left < right && compare(arr[ left ].carr, middle.carr ) <= 0)
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

    quicksort_Sorting(arr, lo, left);
    quicksort_Sorting(arr, left + 1, hi);
  }

  public static void quicksort_collationKey(String[] arr)
  {
    CollationKey[] keys = new CollationKey[arr.length];
    Collator c = Collator.getInstance(LOCALE);
    for (int i = arr.length-1; i >= 0; i--)
      keys[i] = c.getCollationKey(arr[i]);
    quicksort_collationKey(keys, 0, arr.length-1);
    for (int i = arr.length-1; i >= 0; i--)
      arr[i] = keys[i].getSourceString();
  }

  public static void quicksort_collationKey(CollationKey[] arr, int lo, int hi)
  {
    if( lo >= hi ) 
      return;

    int mid = ( lo + hi ) / 2;
    CollationKey tmp;
    CollationKey middle = arr[ mid ];

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

    quicksort_collationKey(arr, lo, left);
    quicksort_collationKey(arr, left + 1, hi);
  }

  public static void quicksort_compareTo(String[] arr, int lo, int hi)
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

    quicksort_compareTo(arr, lo, left);
    quicksort_compareTo(arr, left + 1, hi);
  }
}
