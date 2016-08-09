package tuning.struct;

import java.util.Hashtable;
import java.util.Enumeration;

public class PartialSearcher
{
	Hashtable hash;
	String[] sortedArray;

	public static void main(String args[])
	{
		Hashtable h = new Hashtable();
		h.put("hello", new Integer(1));
		h.put("hell", new Integer(2));
		h.put("alpha", new Integer(3));
		h.put("bye", new Integer(4));
		h.put("hello2", new Integer(5));
		h.put("solly", new Integer(6));
		h.put("sally", new Integer(7));
		h.put("silly", new Integer(8));
		h.put("zorro", new Integer(9));
		h.put("hi", new Integer(10));

		PartialSearcher p = new PartialSearcher(h);
		Object[] objs = p.match(args[0]);
		for(int i = 0; i<objs.length; i++)
			System.out.println(objs[i]);

	}

	public PartialSearcher(Hashtable h)
	{
		hash = h;
		createSortedArray();
	}

	public Object[] match(String s)
	{
		int startIdx = binarySearch(sortedArray, s, 0, sortedArray.length-1);
		int endIdx = binarySearch(sortedArray, s+ '\uFFFF', 0, sortedArray.length-1);
		
		Object[] objs = new Object[endIdx-startIdx];
		for (int i = startIdx ; i < endIdx; i++)
			objs[i-startIdx] = sortedArray[i];
		return objs;
	}

	public void createSortedArray()
	{
		sortedArray = new String[hash.size()];
		Enumeration e = hash.keys();
		for (int i = 0; e.hasMoreElements(); i++)
			sortedArray[i] = (String) e.nextElement();
		quicksort(sortedArray, 0, sortedArray.length-1);
	}

	public static int binarySearch(String[] arr, String elem, int fromIndex, int toIndex)
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
		return fromIndex;
	}
	public void quicksort(String[] arr, int lo, int hi)
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

		quicksort(arr, lo, left);
		quicksort(arr, left + 1, hi);
	}
}
