package com.bedpotato.Algorithms.C1;

public class UnionFind_WeightedQuickUnion extends UnionFind {
	private int[] sz;

	public UnionFind_WeightedQuickUnion(int number) {
		super(number);
		sz = new int[count];
		for (int i = 0; i < count; i++) {
			sz[i] = 1;
		}
	}

	@Override
	public int find(int p) {
		while (p != id[p]) {
			p = id[p];
		}
		return p;
	}

	@Override
	public void union(int p, int q) {
		int pRoot = find(p);
		int qRoot = find(q);
		if (pRoot == qRoot) {
			return;
		}
		// 将小树的根节点连接到大树的根节点
		if (sz[pRoot] < sz[qRoot]) {
			id[pRoot] = qRoot;
			sz[qRoot] += sz[pRoot];
		} else {
			id[qRoot] = pRoot;
			sz[pRoot] += sz[qRoot];
		}
		count--;
	}
}
