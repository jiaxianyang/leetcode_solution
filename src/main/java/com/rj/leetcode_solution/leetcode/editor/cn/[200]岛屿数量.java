//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 2087 👎 0

package com.rj.leetcode_solution.leetcode.editor.cn;

//java:岛屿数量
class P200NumberOfIslands {
    public static void main(String[] args) {
        Solution solution = new P200NumberOfIslands().new Solution();
        char[][] grid = {{'1','1','1','1','0'}, {'1','1','0','1','0'}, {'1','1','0','0','0'}, {'0','0','0','0','0'}};
        solution.numIslands(grid);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 入口
         */
        public int numIslands(char[][] grid) {
            // 并查集
//            return numsIsLandsByUnion(grid);
            // dfs
            return numsIsLandsByDfs(grid);
        }

        public int numsIsLandsByDfs(char[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }
            int nr = grid.length;
            int nc = grid[0].length;
            int numIslands = 0;
            for (int r = 0; r < nr; r++) {
                for (int c = 0; c < nc; c++) {
                    if (grid[r][c] == '1') {
                        numIslands++;
                        dfs(grid, r, c);
                    }
                }
            }
            return numIslands;
        }

        private void dfs(char[][] grid, int r, int c) {
            int nr = grid.length;
            int nc = grid[0].length;
            if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
                return;
            }
            grid[r][c] = '0';
            dfs(grid, r - 1, c);
            dfs(grid, r + 1, c);
            dfs(grid, r, c - 1);
            dfs(grid, r, c + 1);
        }


        class UnionFind {
            int count;
            int[] parent;

            public UnionFind(char[][] grid) {
                count = 0;
                int m = grid.length;
                int n = grid[0].length;
                parent = new int[m * n];
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        if (grid[i][j] == '1') {
                            parent[i * n + j] = i * n + j;
                            count++;
                        }
                    }
                }
            }

            public int find(int i) {
                while (i != parent[i]) {
                    parent[i] = parent[parent[i]];
                    i = parent[i];
                }
                return i;
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

            public int getCount() {
                return count;
            }
        }

        private int numsIsLandsByUnion(char[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }
            int nr = grid.length;
            int nc = grid[0].length;
            UnionFind uf = new UnionFind(grid);
            for (int r = 0; r < nr; r++) {
                for (int c = 0; c < nc; c++) {
                    if (grid[r][c] == '1') {
                        grid[r][c] = '0';
                        if (r - 1 >= 0 && grid[r - 1][c] == '1') {
                            uf.union(r * nc + c, (r - 1) * nc + c);
                        }
                        if (r + 1 < nr && grid[r + 1][c] == '1') {
                            uf.union(r * nc + c, (r + 1) * nc + c);
                        }
                        if (c - 1 >= 0 && grid[r][c - 1] == '1') {
                            uf.union(r * nc + c, r * nc + c - 1);
                        }
                        if (c + 1 < nc && grid[r][c + 1] == '1') {
                            uf.union(r * nc + c, r * nc + c + 1);
                        }
                    }
                }
            }
            return uf.getCount();
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
