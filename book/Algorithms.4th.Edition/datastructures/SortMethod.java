package datastructures;

/**
 * 
 * 
 * @author 阿伦
 * 
 */
public class SortMethod {
	public static int[] a = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34,
			15, 35, 25, 53, 51 };

	public static void main(String[] args) {
//		quickSort(a, 0, a.length - 1);
//		insertionSort(a);
		MergeSort.Mergesort(a);
		print(a);
	}

	public static void print(int[] a) {
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}

	/**
	 * 快速排序基本思想：在要排序的一组数中，假设前面(n-1) [n>=2] 个数已经是排 好顺序的，现在要把第n个数插到前面的有序数中，使得这n个数
	 * 也是排好顺序的。如此反复循环，直到全部排好顺序。
	 * 
	 * @param a
	 */
	private static void insertionSort(int[] a) {
		/* 当前准备被排序的数据 */
		int temp;
		/* 从第二个数据开始，循环向前比较，被比较项如果比自身大，则被比较项前移，如果本身比较大或者相同，则插入到被比较项的前面 */
		for (int i = 1; i < a.length; i++) {
			int j = i - 1;
			temp = a[i];
			for (; j >= 0 && temp < a[j]; j--) {
				a[j + 1] = a[j];
			}
			a[j + 1] = temp;
		}
	}

	/**
	 * 快速排序使用分治法（Divide and conquer）策略来把一个串行（list）分为两个子串行（sub-lists）。 步骤为：
	 * 从数列中挑出一个元素，称为 "基准"（pivot），
	 * 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边
	 * ）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作。
	 * 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
	 * 递归的最底部情形，是数列的大小是零或一，也就是永远都已经被排序好了
	 * 。虽然一直递归下去，但是这个算法总会退出，因为在每次的迭代（iteration）中，它至少会把一个元素摆到它最后的位置去。
	 * 
	 * @param a
	 */
	private static void quickSort(int a[], int left, int right) {
		int i, j, temp;
		i = left;
		j = right;
		if (left > right) {
			return;
		}
		temp = a[left];
		while (i != j)/* 找到最终位置 */
		{
			while (a[j] >= temp && j > i) {
				j--;
			}
			if (j > i) {
				a[i++] = a[j];
			}
			print(a);
			while (a[i] <= temp && j > i) {
				i++;
			}
			if (j > i) {
				a[j--] = a[i];
			}
			print(a);
		}
		a[i] = temp;
		quickSort(a, left, i - 1);/* 递归左边 */
		quickSort(a, i + 1, right);/* 递归右边 */
	}
}
