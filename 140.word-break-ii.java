/*
 * @lc app=leetcode id=140 lang=java
 *
 * [140] Word Break II
 *
 * https://leetcode.com/problems/word-break-ii/description/
 *
 * algorithms
 * Hard (28.44%)
 * Likes:    1588
 * Dislikes: 340
 * Total Accepted:    209.2K
 * Total Submissions: 694.2K
 * Testcase Example:  '"catsanddog"\n["cat","cats","and","sand","dog"]'
 *
 * Given a non-empty string s and a dictionary wordDict containing a list of
 * non-empty words, add spaces in s to construct a sentence where each word is
 * a valid dictionary word. Return all such possible sentences.
 * 
 * Note:
 * 
 * 
 * The same word in the dictionary may be reused multiple times in the
 * segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * Output:
 * [
 * "cats and dog",
 * "cat sand dog"
 * ]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * Output:
 * [
 * "pine apple pen apple",
 * "pineapple pen apple",
 * "pine applepen apple"
 * ]
 * Explanation: Note that you are allowed to reuse a dictionary word.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output:
 * []
 * 
 */

// @lc code=start
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashMap<String, List<String>> memo = new HashMap<>();
        List<String> result = new ArrayList<>();

        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) return result;
        Set<String> words = new HashSet<>();
        for (String word : wordDict) {
            words.add(word);
        }

        return dfs(s, words, memo);
    }

    private List<String> dfs(String s, Set<String> words, HashMap<String, List<String>> memo) {
        if (memo.containsKey(s)) return memo.get(s);

        List<String> result = new ArrayList<String>();
        if (s.length() == 0) {
            result.add("");
            return result;
        }
        
        for (int i = 1; i <= s.length(); i++) {
            String word = s.substring(0, i);
            if (words.contains(word)) {
                String rest = s.substring(i);
                List<String> subs = dfs(rest, words, memo);
                for (String sub : subs) {
                    if (sub.length() == 0) {
                        result.add(word);
                    } else {
                        result.add(word + " " + sub);
                    }
                    
                }
            }
        }

        memo.put(s, result);
        return result;
    }
}
// @lc code=end

