package com.yangdq.java.algorithm.fouth.fundamentals.problem;

/**
 * union-find
 * - quick union
 * @see UF
 */
public class UFQuickUnion {
    private int[] id;
    private int count;

    /**
     * 以整型标识初始化N个触点
     */
    public UFQuickUnion(int n) {
        count = n;
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    /**
     * 在 p 和 q 之间添加一条连接
     */
    void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }

        id[pRoot] = qRoot;

        count--;
    }

    /**
     * p 所在分量的标识符
     */
    int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    /**
     * 如果 p 和 q 存在于同一个分量中则返回true
     */
    boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 连通分量的数量
     */
    int count() {
        return count;
    }
}
