package com.common.algorithm.union_find;

/**
 * 解释
 * 1、初始化：
 *  parent 数组存储每个节点的父节点，初始时每个节点的父节点都是自己。
 *  rank 数组存储树的深度，初始时每个节点的深度都是 1。
 * 2、查找操作（find）：
 *  查找节点 p 的根节点，同时进行路径压缩，使得树的高度降低，提高后续操作的效率。
 * 3、合并操作（union）：
 *  合并两个节点 p 和 q 所在的集合，使用按秩合并的策略，即将深度较小的树合并到深度较大的树上。
 * 4、连通性检查（connected）：
 *  判断两个节点 p 和 q 是否在同一个集合中。
 *
 * 复杂度
 *  时间复杂度：
 *      find 和 union 操作的均摊时间复杂度为 O(α(n))，其中 α 是反阿克曼函数，增长极其缓慢，几乎可以认为是常数时间。
 * 这个实现是并查集的经典实现，适用于解决许多图论中的连通性问题，如网络连接、岛屿数量等。
 *
 * @author jiaxianyang
 * @date 2024/8/7 10:19
 */
public class UnionFindFromAi {
    private int[] parent;
    private int[] rank;

    //初始化并查集，每个节点指向自己，rank (树的深度)初始化为1
    public UnionFindFromAi(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    //查找操作，带路径压缩
    public int find(int p) {
        if (parent[p] != p) {
            parent[p] = find(parent[p]);//路径压缩
        }
        return parent[p];
    }

    //合并操作，按秩合并
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP != rootQ) {
            if (rank[rootP] > rank[rootQ]) {
                parent[rootQ] = rootP;
            } else if (rank[rootP] < rank[rootQ]) {
                parent[rootP] = rootQ;
            } else {
                parent[rootQ] = rootP;
                rank[rootP] += 1;
            }
        }
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public static void main(String[] args) {
        UnionFindFromAi uf = new UnionFindFromAi(10);

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
