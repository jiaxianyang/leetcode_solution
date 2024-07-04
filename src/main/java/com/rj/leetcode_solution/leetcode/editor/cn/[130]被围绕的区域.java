//给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' 组成，捕获 所有 被围绕的区域： 
//
// 
// 连接：一个单元格与水平或垂直方向上相邻的单元格连接。 
// 区域：连接所有 '0' 的单元格来形成一个区域。 
// 围绕：如果您可以用 'X' 单元格 连接这个区域，并且区域中没有任何单元格位于 board 边缘，则该区域被 'X' 单元格围绕。 
// 
//
// 通过将输入矩阵 board 中的所有 'O' 替换为 'X' 来 捕获被围绕的区域。 
//
// 
// 
// 
// 
// 
//
// 示例 1： 
//
// 
// 输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O",
//"X","X"]] 
// 
//
// 输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]] 
//
//
// 解释： 
// 
// 在上图中，底部的区域没有被捕获，因为它在 board 的边缘并且不能被围绕。 
//
// 示例 2： 
//
// 
// 输入：board = [["X"]] 
// 
//
// 输出：[["X"]] 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 200 
// board[i][j] 为 'X' 或 'O' 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 1129 👎 0

package com.rj.leetcode_solution.leetcode.editor.cn;
//java:被围绕的区域
class P130SurroundedRegions{
    public static void main(String[] args){
        Solution solution = new P130SurroundedRegions().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        int n, m;

        public void solve(char[][] board) {
            n = board.length;
            if (n == 0) {
                return;
            }
            m = board[0].length;
            for (int i = 0; i < n; i++) {
                dfs(board, i, 0);
                dfs(board, i, m - 1);
            }
            for (int i = 1; i < m - 1; i++) {
                dfs(board, 0, i);
                dfs(board, n - 1, i);
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[i][j] == 'A') {
                        board[i][j] = 'O';
                    } else if (board[i][j] == 'O') {
                        board[i][j] = 'X';
                    }
                }
            }
        }

        public void dfs(char[][] board, int x, int y) {
            if (x < 0 || x >= n || y < 0 || y >= m || board[x][y] != 'O') {
                return;
            }
            board[x][y] = 'A';
            dfs(board, x + 1, y);
            dfs(board, x - 1, y);
            dfs(board, x, y + 1);
            dfs(board, x, y - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}