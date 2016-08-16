package dg.algorithm.hw.ch12;

import java.util.Iterator;

//22.1-3 有向图G = (V, E)转置是图GT = (V, ET)，其中ET = {(v, u)属于VXV: (u, v)属于E}，因此GT就是将G中所有的边反向后形成的图。写出根据G计算GT的有效算法（针对邻接表和邻接矩阵两种形式分别写出），并分析所给出算法的运行时间。
//
//        针对邻接矩阵的算法：
//        void Transpose(int Adj[V][V], int V)
//        {
//        int r, c;
//        for(r = 0; r < V; r++)
//        for(c = r; c < V; c++)
//        {
//			/* 不使用临时变量交换 */
//        Adj[c][r] = Adj[r][c] ^ Adj[r][c];
//        Adj[r][c] = Adj[r][c] ^ Adj[r][c];
//        Adj[c][r] = Adj[r][c] ^ Adj[r][c];
//        }
//        }
//
//        该算法的时间复杂度为：O(V*V)
//
//
//        针对邻接表的算法：
//        typedef struct node
//        {
//        int data;
//        struct node *next;
//        }VNode;
//
//        void Transpose(VNode Adj[], VNode newAdj[], int V)
//        {
//        int i;
//        for(i = 0; i < V; i++)
//        {
//        VNode *p = Adj[i].next;
//        while(p != NULL)
//        {
//        newAdj[p->data]->next = (VNode *)malloc(sizeof(VNode));
//        newAdj[p->data]->next->data = Adj[i].data;
//        newAdj[p->data]->next->next = NULL;
//        p = p->next;
//        }
//        }
//        }
//
//        该算法的时间复杂度是: O(V+E)。
public class C1_3 {
    public static void main(String[] args) throws Exception {
    }
}
