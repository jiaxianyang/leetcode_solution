//基因序列可以表示为一条由 8 个字符组成的字符串，其中每个字符都是 'A'、'C'、'G' 和 'T' 之一。 
//
// 假设我们需要调查从基因序列 start 变为 end 所发生的基因变化。一次基因变化就意味着这个基因序列中的一个字符发生了变化。 
//
// 
// 例如，"AACCGGTT" --> "AACCGGTA" 就是一次基因变化。 
// 
//
// 另有一个基因库 bank 记录了所有有效的基因变化，只有基因库中的基因才是有效的基因序列。（变化后的基因必须位于基因库 bank 中） 
//
// 给你两个基因序列 start 和 end ，以及一个基因库 bank ，请你找出并返回能够使 start 变化为 end 所需的最少变化次数。如果无法完成
//此基因变化，返回 -1 。 
//
// 注意：起始基因序列 start 默认是有效的，但是它并不一定会出现在基因库中。 
//
// 
//
// 示例 1： 
//
// 
//输入：start = "AACCGGTT", end = "AACCGGTA", bank = ["AACCGGTA"]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：start = "AACCGGTT", end = "AAACGGTA", bank = ["AACCGGTA","AACCGCTA",
//"AAACGGTA"]
//输出：2
// 
//
// 示例 3： 
//
// 
//输入：start = "AAAAACCC", end = "AACCCCCC", bank = ["AAAACCCC","AAACCCCC",
//"AACCCCCC"]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// start.length == 8 
// end.length == 8 
// 0 <= bank.length <= 10 
// bank[i].length == 8 
// start、end 和 bank[i] 仅由字符 ['A', 'C', 'G', 'T'] 组成 
// 
//
// Related Topics 广度优先搜索 哈希表 字符串 👍 234 👎 0

package com.rj.leetcode_solution.leetcode.editor.cn;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

//java:最小基因变化
class P433MinimumGeneticMutation {
    public static void main(String[] args) {
        Solution solution = new P433MinimumGeneticMutation().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minMutation(String startGene, String endGene, String[] bank) {
            //1、如果开始和结束的基因一样返回0
            if (startGene.equals(endGene)) {
                return 0;
            }
            //hash表存储基因库
            Set<String> genePool = new HashSet<>();
            for (String gene : bank) {
                genePool.add(gene);
            }
            //2、如果变化后的基因不存在基因库返回 -1
            if (!genePool.contains(endGene)) {
                return -1;
            }
            Set<String> visited = new HashSet<>();
            Queue<String> queue = new LinkedList<>();
            queue.offer(startGene);
            visited.add(startGene);
            char[] keys = {'A', 'C', 'G', 'T'};
            int step = 1;
            while (!queue.isEmpty()) {
                int currentGeneSzie = queue.size();
                for (int i = 0; i < currentGeneSzie; i++) {
                    String currentGene = queue.poll();
                    for (int j = 0; j < 8; j++) {
                        for (int k = 0; k < 4; k++) {
                            //基因序列8个字符，变化的字符非自己
                            if (keys[k] != currentGene.charAt(j)) {
                                StringBuilder sb = new StringBuilder(currentGene);
                                //突变后的基因序列
                                sb.setCharAt(j, keys[k]);
                                String nextGene = sb.toString();
                                //没有访问过 & 并且在基因序列中
                                if (!visited.contains(nextGene) && genePool.contains(nextGene)) {
                                    if (nextGene.equals(endGene)) {
                                        return step;
                                    }
                                    //访问过的放入到queue中，走了几步等于循环了几次
                                    queue.offer(nextGene);
                                    visited.add(nextGene);
                                }
                            }
                        }
                    }
                }
                //访问过的放入到queue中，走了几步等于循环了几次
                step++;
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
