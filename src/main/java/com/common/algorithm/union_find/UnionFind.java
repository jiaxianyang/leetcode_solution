package com.common.algorithm.union_find;

/**
 * 并查集
 *
 * @author jiaxianyang
 * @date 2024/8/6 20:19
 */
public class UnionFind {
    private int count = 0;
    private int[] parent;

    public UnionFind(int n) {
        this.count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]]; //路径压缩
            p = parent[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }
        parent[rootP] = rootQ;
        count--;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public static void main(String[] args) {
        UnionFind uf = new UnionFind(10);

        uf.union(1, 2);
        uf.union(2, 3);
        uf.union(4, 5);
        uf.union(6, 7);
        uf.union(5, 6);

        // 测试 find 方法
        System.out.println("Find 1: " + uf.find(1)); // 输出 1
        System.out.println("Find 2: " + uf.find(2)); // 输出 1
        System.out.println("Find 3: " + uf.find(3)); // 输出 1
        System.out.println("Find 4: " + uf.find(4)); // 输出 4
        System.out.println("Find 5: " + uf.find(5)); // 输出 4
        System.out.println("Find 6: " + uf.find(6)); // 输出 4
        System.out.println("Find 7: " + uf.find(7)); // 输出 4

        // 测试 connected 方法
        System.out.println(uf.connected(1, 3)); // true
        System.out.println(uf.connected(4, 7)); // true
        System.out.println(uf.connected(1, 5)); // false

//        解释
//        测试 find 方法：
//
//        System.out.println("Find 1: " + uf.find(1)); 等语句用于测试 find 方法，输出每个节点的根节点。
//        例如，uf.find(1) 应该输出 1，因为 1 是 1、2、3 的根节点。
//        uf.find(4) 应该输出 4，因为 4 是 4、5、6、7 的根节点。
//        测试 connected 方法：
//
//        System.out.println(uf.connected(1, 3)); 应该输出 true，因为 1 和 3 是连通的。
//        System.out.println(uf.connected(4, 7)); 应该输出 true，因为 4 和 7 是连通的。
//        System.out.println(uf.connected(1, 5)); 应该输出 false，因为 1 和 5 不是连通的。
//        通过这些测试，可以验证 find 和 connected 方法的正确性。
    }
}
