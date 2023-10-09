//一个机器人位于一个
// m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。 
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。 
//
// 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？ 
//
// 网格中的障碍物和空位置分别用 1 和 0 来表示。 
//
// 
//
// 示例 1： 
// 
// 
//输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
//输出：2
//解释：3x3 网格的正中间有一个障碍物。
//从左上角到右下角一共有 2 条不同的路径：
//1. 向右 -> 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右 -> 向右
// 
//
// 示例 2： 
// 
// 
//输入：obstacleGrid = [[0,1],[0,0]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// m == obstacleGrid.length 
// n == obstacleGrid[i].length 
// 1 <= m, n <= 100 
// obstacleGrid[i][j] 为 0 或 1 
// 
//
// Related Topics 数组 动态规划 矩阵 👍 1074 👎 0

package com.rj.leetcode_solution.leetcode.editor.cn;
//java:不同路径 II
class P63UniquePathsIi{
    public static void main(String[] args){
        Solution solution = new P63UniquePathsIi().new Solution();
        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(solution.uniquePathsWithObstacles(obstacleGrid));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //1、方案1
        //个人理解认为更好理解：
/*        滚动数组的理解
        首先从第一行开始遍历,f[0]已经进行初始化,想到到达obstacleGrid[0][j]只能够从左往右走,上面没有路可以走,java整型数组初始化的时候默认值是零,
                也就是说f[j]的默认值都是零,经过f[j] += f[j - 1] (此时i=0也就是在第一行)的第一次循环完成后第一行的所有值就已经确定了,没有障碍物就是全为1,有障碍物就是为1或0。
        现在f[i]数组中保存的值就是从起点出发到第一行第i个网格有多少条不同的路径。之后继续循环，当i=1也就是遍历到第二行，（每一行第一个网格的值如果有障碍就将其置0，
        如果无障碍的话值与上一行的f[j]保持一致，不用变化），第二个网格的值计算方式为上方的网格值加上左边网格的值，左边网格值已经确定，为f[j-1]，
        而上方网格的值就是上一轮循环中的f[j]，两个值相加得到第二行第二个网格的值并将f[j]中的数据覆盖，依次循环将f[j]中的数据全部替换，此时f[j]中就保存了从起点出发到第二行第j个网格有多少条不同的路径。
        继续循环直到完成，最后的结果就是从起点到终点有多少条不同的路径。*/
//        int n = obstacleGrid.length, m = obstacleGrid[0].length;
//        int[] f = new int[m];
//        f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                if (obstacleGrid[i][j] == 1) {
//                    f[j] = 0;
//                    continue;
//                }
//                if (j - 1 >= 0 && obstacleGrid[i][j] == 0) {
//                    f[j] += f[j - 1];
//                }
//            }
//        }
//        return f[m - 1];




        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }
        //定义 dp 数组并初始化第 1 行和第 1 列
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < m && obstacleGrid[0][j] == 0; j++) {
            dp[0][j] = 1;
        }
        //根据状态转移方程 dp[i][j] = dp[i - 1][j] + dp[i][j - 1]进行递推
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[n - 1][m - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
