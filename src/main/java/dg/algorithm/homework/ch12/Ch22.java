package dg.algorithm.hw.ch12;

import java.util.HashSet;
import java.util.Stack;

public class Ch22 {
    //adjacent list representation
    static class GraphNode
    {
        int val = -1;
        GraphNode next = null;

        GraphNode(int v) { val = v; }
        GraphNode(int v, GraphNode nxt) { val = v; next = nxt; }
        public int getVal() { return val;}
    }

    static GraphNode[] initGraph(int num)
    {
        if (num <= 0)
            return null;

        GraphNode[] nodes = new GraphNode[num];
        for (int i = 0; i < num; i++)
            nodes[i] = new GraphNode(i);

        return nodes;
    }

    static void addEdge(GraphNode[] graph, int s, int e)
    {
        GraphNode tmp = new GraphNode(e);
        tmp.next = graph[s].next;
        graph[s].next = tmp;
    }

    //adjacent matrix representation
    static void addEdge(int[][] graph, int s, int e)
    {
        graph[s][e] = 1;
    }

    //22.1-3
    static GraphNode[] TransPose(GraphNode[] graph)
    {
        if (null == graph)
            return null;

        GraphNode[] ret = initGraph(graph.length);

        for (int i = 0; i < graph.length; i++)
        {
            GraphNode iter = graph[i].next;
            while (iter != null)
            {
                addEdge(ret, iter.val, i);
                iter = iter.next;
            }
        }

        return ret;
    }

    //22.1-5
    static GraphNode[] makeSquareMatrix(GraphNode[] graph)
    {
        if (null == graph)
            return null;

        int len = graph.length;
        GraphNode[] ret = initGraph(len);

        for (int i = 0; i < len; i++)
        {
            boolean[] rec = new boolean[len];
            GraphNode iter1 = graph[i].next;
            while (iter1 != null)
            {
                if (!rec[iter1.val])
                {
                    rec[iter1.val] = true;
                    addEdge(ret, i, iter1.val);
                }

                GraphNode iter2 = graph[iter1.val].next;
                while (iter2 != null)
                {
                    if (!rec[iter2.val])
                    {
                        rec[iter2.val] = true;
                        addEdge(ret, i, iter2.val);
                    }

                    iter2 = iter2.next;
                }

                iter1 = iter1.next;
            }
        }

        return ret;
    }

    static void makeSquareMatrix(int[][] m)
    {
        if (m == null)
            return;

        int len = m.length;
        for (int i = 0; i < len; i++)
        {
            for (int j = 0; j < len; j++)
            {
                for (int k = 0; k < len; k++)
                {
                    if (m[i][j] > 0 && m[j][k] > 0)
                        m[i][k] = 1;
                }
            }
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////
    //write it again, very tricky
    static void innerStackDFS(GraphNode[] graph, int s, HashSet<Integer> set)
    {
        Stack<GraphNode> stk = new Stack<GraphNode>();

        System.out.println(s);
        set.add(s);
        stk.push(graph[s].next);

        while (!stk.empty())
        {
            GraphNode tmp = stk.pop();
            if (tmp == null || set.contains(tmp.val))
                continue;

            System.out.println(tmp.val);
            set.add(tmp.val);

            GraphNode it = tmp;
            while (it != null && set.contains(it.val))
                it = it.next;

            stk.push(it);
            stk.push(graph[tmp.val].next);
        }
    }

    static void stackDFS(GraphNode[] graph)
    {
        if (null == graph)
            return;

        HashSet<Integer> visited = new HashSet<Integer>();
        for (int i = 0; i < graph.length; i++)
        {
            if (!visited.contains(i))
                innerStackDFS(graph, i, visited);
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////

    static boolean innerJudge(int[][] graph, int s, HashSet<Integer> set)
    {
        if (set.contains(s))
            return false;

        set.add(s);
        for (int i = 0; i < graph.length; i++)
        {
            if (graph[s][i] > 0)
            {
                if (!innerJudge(graph, i, set))
                    return false;
            }
        }

        return true;
    }

    // Suppose is a DAG
    static boolean isSinglyConnected(int[][] graph)
    {
        for (int i = 0; i < graph.length; i++)
        {
            HashSet<Integer> set = new HashSet<Integer>();
            if (!innerJudge(graph, i, set))
                return false;
        }

        return true;
    }

    static public void main(String[] strs)
    {
        GraphNode[] g = initGraph(10);
        addEdge(g, 0, 3);
        addEdge(g, 0, 4);
        addEdge(g, 3, 6);
        addEdge(g, 4, 7);
        addEdge(g, 4, 2);
        addEdge(g, 2, 8);

        for (GraphNode node : g) {
            System.out.println(node.getVal());
        }
        for (GraphNode node : TransPose(g)) {
            System.out.println(node.getVal());
        }

//        stackDFS(g);
//
//        int[][] graph = new int[4][4];
//        graph[0][1] = 1;
//        graph[1][2] = 1;
//        graph[1][3] = 1;
//        //graph[2][3] = 1;
//
//        boolean b = isSinglyConnected(graph);
    }
}
