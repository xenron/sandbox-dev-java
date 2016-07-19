package com.bedpotato.Algorithms.C2.Sort;

@SuppressWarnings("rawtypes")
public class InsertionWithSentinel extends SortBase {

	@Override
	public void sort(Comparable[] a) {
		// TODO 需要把数组第一个位置留空，否则第一个数就被覆盖了
		int length = a.length;
		for (int i = 2; i < length; i++) {
			System.out.println("arr[0]==" + a[0]);
			if (less(a[i], a[i - 1])) {
				a[0] = a[i];
				int j;
				for (j = i - 1; less(a[0], a[j]); j--) {
					a[j + 1] = a[j];
				}
				a[j + 1] = a[0];
			}
		}
	}

	@Override
	public void practise(Comparable[] a) {
		// TODO Auto-generated method stub
		
	}
}
