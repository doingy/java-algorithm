package com.yangdq.java.algorithm.fouth.fundamentals.problem;

/**
 * union-find
 *  - quick-find
 * @see UFQuickUnion
 */
public class UF {
    // 分量id
    private int[] id;
    // 分量数量
    private int count;

    /**
     * 以整型标识初始化N个触点
     */
    public UF(int n) {
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
        int pId = find(p);
        int qId = find(q);

        if (pId == qId) {
            return;
        }

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pId) {
                id[i] = qId;
            }
        }
        count--;
    }

    /**
     * p 所在分量的标识符
     */
    int find(int p) {
        return id[p];
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
