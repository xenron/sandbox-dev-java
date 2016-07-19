package com.bedpotato.Algorithms.C1;

import com.bedpotato.alg4.constants.Alg4Constants;
import com.bedpotato.alg4.utils.In;

public abstract class UnionFind {
	int id[];// 分量ID
	int count;// 分量数量

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		int[] numbers = In.readInts(Alg4Constants.DATA_PATH + "tinyUF.txt");
		int count = numbers[0];
		// QuickUnion
		// UnionFind_QuickUnion QU = new UnionFind_QuickUnion(count);
		// for (int i = 1; i < numbers.length; i += 2) {
		// QU.union(numbers[i], numbers[i + 1]);
		// }
		// System.out.println(QU.count());

		// QuickFind
		UnionFind_QuickFind QF = new UnionFind_QuickFind(count);
		for (int i = 1; i < numbers.length; i += 2) {
			QF.union(numbers[i], numbers[i + 1]);
		}
		System.out.println(QF.count());

		// WeightedQuickUnion
		UnionFind_WeightedQuickUnion WQN = new UnionFind_WeightedQuickUnion(
				count);
		for (int i = 1; i < numbers.length; i += 2) {
			WQN.union(numbers[i], numbers[i + 1]);
		}
		System.out.println(WQN.count());
	}

	public UnionFind(int number) {
		count = number;
		id = new int[number];
		for (int i = 0; i < number; i++) {
			id[i] = i;
		}
	}

	public int count() {
		return count;
	}

	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}

	public abstract int find(int p);

	public abstract void union(int p, int q);
}
