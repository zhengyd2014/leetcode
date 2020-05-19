/*
 * @lc app=leetcode id=856 lang=java
 *
 * [856] Score of Parentheses
 *
 * https://leetcode.com/problems/score-of-parentheses/description/
 *
 * algorithms
 * Medium (59.13%)
 * Likes:    955
 * Dislikes: 34
 * Total Accepted:    33.3K
 * Total Submissions: 56.1K
 * Testcase Example:  '"()"'
 *
 * Given a balanced parentheses string S, compute the score of the string based
 * on the following rule:
 * 
 * 
 * () has score 1
 * AB has score A + B, where A and B are balanced parentheses strings.
 * (A) has score 2 * A, where A is a balanced parentheses string.
 * 
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: "()"
 * Output: 1
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "(())"
 * Output: 2
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: "()()"
 * Output: 2
 * 
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: "(()(()))"
 * Output: 6
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * S is a balanced parentheses string, containing only ( and ).
 * 2 <= S.length <= 50
 * 
 * 
 * 
 * 
 * 
 * 
 */

// @lc code=start

// 856. Score of Parentheses

// 这个居然对了，没想到

// recursive parse character one by one
// note the inner most pair, which equals 1, need special handling.

class Solution {
    int i = 0;
    public int scoreOfParentheses(String S) {
        int score = 0;
        while (i < S.length()) {
            char c = S.charAt(i++);
            
            if (c == '(') {
                int sub = scoreOfParentheses(S);
                if (sub == 0) score += 1;      // sub == 0 means it is ')'
                else score += 2 * sub;
            } else {
                break;
            }
        }
        
        return score;
    }  
}

// @lc code=end

