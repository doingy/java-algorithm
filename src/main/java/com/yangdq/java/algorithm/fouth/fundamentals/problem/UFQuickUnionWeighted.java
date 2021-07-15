package com.yangdq.java.algorithm.fouth.fundamentals.problem;

/**
 * union-find
 * - 加权 quick union
 * @see UFQuickUnion
 */
public class UFQuickUnionWeighted {
    private int[] id;
    // 各个根节点所对应分量的大小
    private int[] sz;
    private int count;

    /**
     * 以整型标识初始化N个触点
     */
    public UFQuickUnionWeighted(int n) {
        count = n;
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
        sz = new int[n];
        for (int i = 0; i < n; i++) {
            sz[i] = 1;
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

        if (sz[pRoot] < sz[qRoot]) {
            id[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        } else {
            id[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }

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