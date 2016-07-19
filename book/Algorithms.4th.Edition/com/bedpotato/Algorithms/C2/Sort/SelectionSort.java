package com.bedpotato.Algorithms.C2.Sort;

@SuppressWarnings("rawtypes")
public class SelectionSort extends SortBase {

	@Override
	public void sort(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			int minIndex = i;
			for (int j = i + 1; j < a.length; j++) {
				if (less(a[j], a[minIndex])) {
					minIndex = j;
				}
			}
			exch(a, i, minIndex);
		}
	}

	@Override
	public void practise(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			int minIndex = i;
			for (int j = i + 1; j < a.length; j++) {
				if (less(a[j], a[minIndex])) {
					minIndex = j;
				}
			}
			exch(a, i, minIndex);
		}
	}
}
