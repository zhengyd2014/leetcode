/*
 * @lc app=leetcode id=678 lang=java
 *
 * [678] Valid Parenthesis String
 *
 * https://leetcode.com/problems/valid-parenthesis-string/description/
 *
 * algorithms
 * Medium (34.10%)
 * Likes:    1577
 * Dislikes: 48
 * Total Accepted:    97.3K
 * Total Submissions: 313.8K
 * Testcase Example:  '"()"'
 *
 * 
 * Given a string containing only three types of characters: '(', ')' and '*',
 * write a function to check whether this string is valid. We define the
 * validity of a string by these rules:
 * 
 * Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 * Any right parenthesis ')' must have a corresponding left parenthesis '('.
 * Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 * '*' could be treated as a single right parenthesis ')' or a single left
 * parenthesis '(' or an empty string.
 * An empty string is also valid.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: "()"
 * Output: True
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: "(*)"
 * Output: True
 * 
 * 
 * 
 * Example 3:
 * 
 * Input: "(*))"
 * Output: True
 * 
 * 
 * 
 * Note:
 * 
 * The string size will be in the range [1, 100].
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean checkValidString(String s) {
        if (s == null || s.length() == 0) return true;

        int lo = 0;
        int hi = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                lo++;
                hi++;
            } else if (c == ')') {
                if (lo > 0) lo--;
                hi--;
                if (hi < 0) return false;
            } else {   // c == '*'
                if (lo > 0) lo--;
                hi++;
            }
        }

        return lo == 0;
    }
}
// @lc code=end

