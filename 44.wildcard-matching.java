/*
 * [44] Wildcard Matching
 *
 * https://leetcode.com/problems/wildcard-matching/description/
 *
 * algorithms
 * Hard (20.85%)
 * Total Accepted:    116.2K
 * Total Submissions: 557.3K
 * Testcase Example:  '"aa"\n"a"'
 *
 * Implement wildcard pattern matching with support for '?' and '*'.
 * 
 * 
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * 
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "*") → true
 * isMatch("aa", "a*") → true
 * isMatch("ab", "?*") → true
 * isMatch("aab", "c*a*b") → false
 * 
 */

// match is mean delete the matched character(s) from S or/and P
// pay attention how to init FIRST line
// for p =   * a * b
//         0 1 2 3 4
//         T T F F F
//           ^

class Solution {
    public boolean isMatch(String s, String p) {
		int m = s.length();
		int n = p.length();
		boolean[][] match = new boolean[m + 1][n + 1];
		match[0][0] = true;
		for (int j = 1; j <= n; j++) {
			if (p.charAt(j - 1) == '*') {
				match[0][j] = match[0][j - 1];
			}
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
					match[i][j] = match[i - 1][j - 1];
				} else if (p.charAt(j - 1) == '*') {
					match[i][j] = match[i - 1][j] || match[i][j - 1];
				} 
			}
		}

		return match[m][n];
    }
}
