//字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列
// beginWord -> s1 -> s2 -> ... -> sk： 
//
// 
// 每一对相邻的单词只差一个字母。 
// 
// 对于 1 <= i <= k 时，每个
// si 都在
// wordList 中。注意， beginWord 不需要在
// wordList 中。
// 
// sk == endWord 
// 
//
// 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，返回 从 beginWord 到 endWord 的 最短转换序列 
//中的 单词数目 。如果不存在这样的转换序列，返回 0 。 
//
// 示例 1： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot",
//"log","cog"]
//输出：5
//解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
// 
//
// 示例 2： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot",
//"log"]
//输出：0
//解释：endWord "cog" 不在字典中，所以无法进行转换。 
//
// 
//
// 提示： 
//
// 
// 1 <= beginWord.length <= 10 
// endWord.length == beginWord.length 
// 1 <= wordList.length <= 5000 
// wordList[i].length == beginWord.length 
// beginWord、endWord 和 wordList[i] 由小写英文字母组成 
// beginWord != endWord 
// wordList 中的所有字符串 互不相同 
// 
//
// Related Topics 广度优先搜索 哈希表 字符串 👍 1206 👎 0

package com.rj.leetcode_solution.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

//java:单词接龙
class P127WordLadder {
    public static void main(String[] args) {
        Solution solution = new P127WordLadder().new Solution();
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        solution.ladderLength("hit", "cog", wordList);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //双向广度优先搜索
        Map<String, Integer> wordId = new HashMap<String, Integer>();
        List<List<Integer>> edge = new ArrayList<List<Integer>>();
        int nodeNum = 0;

        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            for (String word : wordList) {
                addEdge(word);
            }
            addEdge(beginWord);
            if (!wordId.containsKey(endWord)) {
                return 0;
            }

            int[] disBegin = new int[nodeNum];
            Arrays.fill(disBegin, Integer.MAX_VALUE);
            int beginId = wordId.get(beginWord);
            disBegin[beginId] = 0;
            Queue<Integer> queBegin = new LinkedList<Integer>();
            queBegin.offer(beginId);

            int[] disEnd = new int[nodeNum];
            Arrays.fill(disEnd, Integer.MAX_VALUE);
            int endId = wordId.get(endWord);
            disEnd[endId] = 0;
            Queue<Integer> queEnd = new LinkedList<Integer>();
            queEnd.offer(endId);

            while (!queBegin.isEmpty() && !queEnd.isEmpty()) {
                int queBeginSize = queBegin.size();
                for (int i = 0; i < queBeginSize; ++i) {
                    int nodeBegin = queBegin.poll();
                    if (disEnd[nodeBegin] != Integer.MAX_VALUE) {
                        return (disBegin[nodeBegin] + disEnd[nodeBegin]) / 2 + 1;
                    }
                    for (int it : edge.get(nodeBegin)) {
                        if (disBegin[it] == Integer.MAX_VALUE) {
                            disBegin[it] = disBegin[nodeBegin] + 1;
                            queBegin.offer(it);
                        }
                    }
                }

                int queEndSize = queEnd.size();
                for (int i = 0; i < queEndSize; ++i) {
                    int nodeEnd = queEnd.poll();
                    if (disBegin[nodeEnd] != Integer.MAX_VALUE) {
                        return (disBegin[nodeEnd] + disEnd[nodeEnd]) / 2 + 1;
                    }
                    for (int it : edge.get(nodeEnd)) {
                        if (disEnd[it] == Integer.MAX_VALUE) {
                            disEnd[it] = disEnd[nodeEnd] + 1;
                            queEnd.offer(it);
                        }
                    }
                }
            }
            return 0;
        }

        public void addEdge(String word) {
            addWord(word);
            int id1 = wordId.get(word);
            char[] array = word.toCharArray();
            int length = array.length;
            for (int i = 0; i < length; ++i) {
                char tmp = array[i];
                array[i] = '*';
                String newWord = new String(array);
                addWord(newWord);
                int id2 = wordId.get(newWord);
                edge.get(id1).add(id2);
                edge.get(id2).add(id1);
                array[i] = tmp;
            }
        }

        public void addWord(String word) {
            if (!wordId.containsKey(word)) {
                wordId.put(word, nodeNum++);
                edge.add(new ArrayList<Integer>());
            }
        }


    //1、广度优先搜索 + 优化建图
//      Map<String, Integer> wordId = new HashMap<>();
//        List<List<Integer>> edge = new ArrayList<>();
//        int nodeNum = 0;
//        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//            for (String word : wordList) {
//                addEdge(word);
//            }
//            addEdge(beginWord);
//            if (!wordId.containsKey(endWord)) {
//                return 0;
//            }
//            int[] dis = new int[nodeNum];
//            Arrays.fill(dis, Integer.MAX_VALUE);
//            int beginId = wordId.get(beginWord), endId = wordId.get(endWord);
//            dis[beginId] = 0;
//            Queue<Integer> que = new LinkedList<>();
//            que.offer(beginId);
//            while (!que.isEmpty()) {
//                int x = que.poll();
//                if (x == endId) {
//                    return dis[endId] / 2 + 1;
//                }
//                for (Integer it : edge.get(x)) {
//                    if (dis[it] == Integer.MAX_VALUE) {
//                        dis[it] = dis[x] + 1;
//                        que.offer(it);
//                    }
//                }
//            }
//            return 0;
//        }
//
//        private void addEdge(String word) {
//            addWord(word);
//            Integer id1 = wordId.get(word);
//            char[] array = word.toCharArray();
//            int length = array.length;
//            for (int i = 0; i < length; i++) {
//                char tmp = array[i];
//                array[i] = '*';
//                String newWord = new String(array);
//                addWord(newWord);
//                int id2 = wordId.get(newWord);
//                edge.get(id1).add(id2);
//                edge.get(id2).add(id1);
//                array[i] = tmp;
//            }
//        }
//
//        private void addWord(String word) {
//            if (!wordId.containsKey(word)) {
//                wordId.put(word, nodeNum++);
//                edge.add(new ArrayList<>());
//            }
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
