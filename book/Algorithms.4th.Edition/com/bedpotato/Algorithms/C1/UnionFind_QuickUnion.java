package com.bedpotato.Algorithms.C1;


public class UnionFind_QuickUnion extends UnionFind {

	public UnionFind_QuickUnion(int number) {
		super(number);
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
		id[pRoot] = qRoot;
		count--;
	}

}
