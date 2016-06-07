package dg.algorithm.hw.ch12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;

public class MinSpanTreeAlgo {
    static class Edge
    {
        public int s = 0;
        public int e = 0;
        public int w = 0;

        Edge(int ps, int pe, int pw)
        {
            s = ps;
            e = pe;
            w = pw;
        }
    }

    static public class Comp implements Comparator<Edge>
    {
        public int compare(Edge e1, Edge e2)
        {
            return e1.w - e2.w;
        }
    }

    static void kruskal(int[][] graph)
    {
//        if (null == graph)
//            return;
//
//        int len = graph.length;
//        int[] set = new int[len];
//        for (int i = 0; i < len; i++)
//            DisjointSet.make_set(i, set);
//
//        ArrayList<Edge> edges = new ArrayList<Edge>();
//        for (int i = 0; i < len; i++)
//        {
//            for (int j = i; j < len; j++)
//            {
//                if (graph[i][j] > 0)
//                    edges.add(new Edge(i, j, graph[i][j]));
//            }
//        }
//
//        Collections.sort(edges, new Comp());
//        Iterator<Edge> iter = edges.iterator();
//        while (iter.hasNext())
//        {
//            Edge e = iter.next();
//            if (DisjointSet.find_set(e.s, set) != DisjointSet.find_set(e.e, set))
//            {
//                DisjointSet.union(e.s, e.e, set);
//                System.out.println(e.s + " ==> " + e.e);
//            }
//        }
    }

    static void prim(int[][] graph)
    {
        if (graph == null)
            return;

        PriorityQueue<Edge> que = new PriorityQueue<Edge>(10, new Comp());
        HashSet<Integer> set = new HashSet<Integer>();
        int len = graph.length;

        set.add(0);
        for (int i = 0; i < len; i++)
        {
            if (graph[0][i] > 0)
                que.add(new Edge(0, i, graph[0][i]));
        }

        while (!que.isEmpty())
        {
            Edge e = que.remove();
            if (set.contains(e.e))
                continue;

            System.out.println(e.s + " ==> " + e.e);
            set.add(e.e);

            for (int i = 0; i < len; i++)
            {
                if (graph[e.e][i] > 0 && !set.contains(i))
                    que.add(new Edge(e.e, i, graph[e.e][i]));
            }
        }
    }

    public static void main(String[] strs)
    {
        int[][] g = new int[9][9];
        g[0][1] = 4;
        g[1][0] = 4;

        g[0][7] = 8;
        g[7][0] = 8;

        g[1][7] = 11;
        g[7][1] = 11;

        g[8][7] = 7;
        g[7][8] = 7;

        g[6][7] = 1;
        g[7][6] = 1;

        g[6][8] = 6;
        g[8][6] = 6;

        g[1][2] = 8;
        g[2][1] = 8;

        g[2][8] = 2;
        g[8][2] = 2;

        g[6][5] = 2;
        g[5][6] = 2;

        g[2][5] = 4;
        g[5][2] = 4;

        g[2][3] = 7;
        g[3][2] = 7;

        g[3][5] = 14;
        g[5][3] = 14;

        g[4][5] = 10;
        g[5][4] = 10;

        g[3][4] = 9;
        g[4][3] = 9;

        prim(g);
    }
}
