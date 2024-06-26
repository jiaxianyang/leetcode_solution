//在二维网格 grid 上，有 4 种类型的方格： 
//
// 
// 1 表示起始方格。且只有一个起始方格。 
// 2 表示结束方格，且只有一个结束方格。 
// 0 表示我们可以走过的空方格。 
// -1 表示我们无法跨越的障碍。 
// 
//
// 返回在四个方向（上、下、左、右）上行走时，从起始方格到结束方格的不同路径的数目。 
//
// 每一个无障碍方格都要通过一次，但是一条路径中不能重复通过同一个方格。 
//
// 
//
// 示例 1： 
//
// 输入：[[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
//输出：2
//解释：我们有以下两条路径：
//1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
//2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2) 
//
// 示例 2： 
//
// 输入：[[1,0,0,0],[0,0,0,0],[0,0,0,2]]
//输出：4
//解释：我们有以下四条路径： 
//1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
//2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
//3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
//4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3) 
//
// 示例 3： 
//
// 输入：[[0,1],[2,0]]
//输出：0
//解释：
//没有一条路能完全穿过每一个空的方格一次。
//请注意，起始和结束方格可以位于网格中的任意位置。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length * grid[0].length <= 20 
// 
//
// Related Topics 位运算 数组 回溯 矩阵 👍 354 👎 0

package com.rj.leetcode_solution.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//java:不同路径 III
class P980UniquePathsIii{
    public static void main(String[] args){
        Solution solution = new P980UniquePathsIii().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Map<Integer, Integer> memo = new HashMap<Integer, Integer>();

        public int uniquePathsIII(int[][] grid) {
            int r = grid.length, c = grid[0].length;
            int si = 0, sj = 0, st = 0;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (grid[i][j] == 0 || grid[i][j] == 2) {
                        st |= 1 << (i * c + j);
                    } else if (grid[i][j] == 1) {
                        si = i;
                        sj = j;
                    }
                }
            }
            return dp(grid, si, sj, st);
        }

        public int dp(int[][] grid, int i, int j, int st) {
            if (grid[i][j] == 2) {
                return st == 0 ? 1 : 0;
            }
            int r = grid.length, c = grid[0].length;
            int key = ((i * c + j) << (r * c)) + st;
            if (!memo.containsKey(key)) {
                int res = 0;
                for (int[] dir : dirs) {
                    int ni = i + dir[0], nj = j + dir[1];
                    if (ni >= 0 && ni < r && nj >= 0 && nj < c && (st & (1 << (ni * c + nj))) > 0) {
                        res += dp(grid, ni, nj, st ^ (1 << (ni * c + nj)));
                    }
                }
                memo.put(key, res);
            }
            return memo.get(key);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}