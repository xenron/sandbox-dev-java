package com.bedpotato.Algorithms.C1;

import java.util.Arrays;

import com.bedpotato.alg4.Stopwatch;
import com.bedpotato.alg4.constants.Alg4Constants;
import com.bedpotato.alg4.utils.In;

public class ThreeSum {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		int[] a = In.readInts(Alg4Constants.DATA_PATH + "4Kints.txt");
		Stopwatch sw = new Stopwatch();
		System.out.println(threeSum(a));
		System.out.println(sw.elapsedTime());
		sw = new Stopwatch();
		System.out.println(threeSumFast(a));
		System.out.println(sw.elapsedTime());
	}

	public static int threeSum(int[] a) {
		int number = a.length;
		int cnt = 0;
		for (int i = 0; i < number; i++) {
			for (int j = i + 1; j < number; j++) {
				for (int k = j + 1; k < number; k++) {
					if (a[i] + a[j] + a[k] == 0) {
						cnt++;
					}
				}
			}
		}
		return cnt;
	}

	public static int threeSumFast(int[] a) {
		int number = a.length;
		int cnt = 0;
		Arrays.sort(a);
		for (int i = 0; i < number; i++) {
			for (int j = i + 1; j < number; j++) {
				if (Arrays.binarySearch(a, -(a[i] + a[j])) > j) {
					cnt++;
				}
			}
		}
		return cnt;
	}
}
