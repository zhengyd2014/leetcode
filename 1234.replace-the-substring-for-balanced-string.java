/*
 * @lc app=leetcode id=1234 lang=java
 *
 * [1234] Replace the Substring for Balanced String
 *
 * https://leetcode.com/problems/replace-the-substring-for-balanced-string/description/
 *
 * algorithms
 * Medium (31.61%)
 * Likes:    201
 * Dislikes: 41
 * Total Accepted:    8.3K
 * Total Submissions: 26.2K
 * Testcase Example:  '"QWER"'
 *
 * You are given a string containing only 4 kinds of characters 'Q', 'W', 'E'
 * and 'R'.
 * 
 * A string is said to be balanced if each of its characters appears n/4 times
 * where n is the length of the string.
 * 
 * Return the minimum length of the substring that can be replaced with any
 * other string of the same length to make the original string s balanced.
 * 
 * Return 0 if the string is already balanced.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "QWER"
 * Output: 0
 * Explanation: s is already balanced.
 * 
 * Example 2:
 * 
 * 
 * Input: s = "QQWE"
 * Output: 1
 * Explanation: We need to replace a 'Q' to 'R', so that "RQWE" (or "QRWE") is
 * balanced.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "QQQW"
 * Output: 2
 * Explanation: We can replace the first "QQ" to "ER". 
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: s = "QQQQ"
 * Output: 3
 * Explanation: We can replace the last 3 'Q' to make s = "QWER".
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 10^5
 * s.length is a multiple of 4
 * s contains only 'Q', 'W', 'E' and 'R'.
 * 
 * 
 */

// @lc code=start

// 1234. Replace the Substring for Balanced String

// condition check is for the strings out of the window.

class Solution {
    public int balancedString(String s) {
        int[] map = new int[26];
        for (char c : s.toCharArray()) {
            map[c-'A']++;
        }
        
        int target = s.length() / 4;
        
        int min = s.length();
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c  = s.charAt(right);
            map[c-'A']--;
            
            while (left < s.length() 
                   && map['Q'-'A'] <= target 
                   && map['W'-'A'] <= target 
                   && map['E'-'A'] <= target 
                   && map['R'-'A'] <= target) {
                min = Math.min(min, right - left + 1);
                map[s.charAt(left)-'A']++;
                left++;
            }
        }
        
        return min;
    }
}

// @lc code=end

