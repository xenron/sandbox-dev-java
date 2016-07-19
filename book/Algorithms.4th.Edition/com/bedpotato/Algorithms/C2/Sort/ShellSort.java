package com.bedpotato.Algorithms.C2.Sort;

@SuppressWarnings("rawtypes")
public class ShellSort extends SortBase {
	@Override
	public void sort(Comparable[] a) {
		int h = 1;
		while (h < a.length / 3) {
			h = 3 * h + 1;
		}
		while (h >= 1) {
			for (int i = h; i < a.length; i++) {
				for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
					exch(a, j, j - h);
				}
			}
			h = h / 3;
		}
	}

	@Override
	public void practise(Comparable[] a) {
		int h = 1;
		while (h < a.length / 3) {
			h = h * 3 + 1;
		}
		while (h >= 1) {
			for (int i = h; i < a.length; i++) {
				for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
					exch(a, j, j - h);
				}
			}
			h = h / 3;
		}
	}
}
