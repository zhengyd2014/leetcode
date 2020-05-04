/*
 * @lc app=leetcode id=1048 lang=java
 *
 * [1048] Longest String Chain
 *
 * https://leetcode.com/problems/longest-string-chain/description/
 *
 * algorithms
 * Medium (53.67%)
 * Likes:    675
 * Dislikes: 47
 * Total Accepted:    47.6K
 * Total Submissions: 88.4K
 * Testcase Example:  '["a","b","ba","bca","bda","bdca"]'
 *
 * Given a list of words, each word consists of English lowercase letters.
 * 
 * Let's say word1 is a predecessor of word2 if and only if we can add exactly
 * one letter anywhere in word1 to make it equal to word2.  For example, "abc"
 * is a predecessor of "abac".
 * 
 * A word chain is a sequence of words [word_1, word_2, ..., word_k] with k >=
 * 1, where word_1 is a predecessor of word_2, word_2 is a predecessor of
 * word_3, and so on.
 * 
 * Return the longest possible length of a word chain with words chosen from
 * the given list of words.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: ["a","b","ba","bca","bda","bdca"]
 * Output: 4
 * Explanation: one of the longest word chain is "a","ba","bda","bdca".
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= words.length <= 1000
 * 1 <= words[i].length <= 16
 * words[i] only consists of English lowercase letters.
 * 
 * 
 * 
 * 
 * 
 */

// @lc code=start

// 1048. Longest String Chain

// 1. sort by length
// 2. Map to store longest string chains for previous strings

class Solution {
    public int longestStrChain(String[] words) {
        if (words.length == 0) return 0;
        
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        Map<String, Integer> chains = new HashMap<>();
        for (String word : words) {
            int best = 0;
            for (int j = 0; j < word.length(); j++) {
                String child = word.substring(0, j) + word.substring(j+1, word.length());
                best = Math.max(best, chains.getOrDefault(child, 0) + 1);
            }
            chains.put(word, best);
        }
        
        return Collections.max(chains.values());
    }
}
// @lc code=end

