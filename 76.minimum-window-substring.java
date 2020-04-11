/*
 * @lc app=leetcode id=76 lang=java
 *
 * [76] Minimum Window Substring
 *
 * https://leetcode.com/problems/minimum-window-substring/description/
 *
 * algorithms
 * Hard (32.15%)
 * Likes:    3779
 * Dislikes: 264
 * Total Accepted:    352.1K
 * Total Submissions: 1M
 * Testcase Example:  '"ADOBECODEBANC"\n"ABC"'
 *
 * Given a string S and a string T, find the minimum window in S which will
 * contain all the characters in T in complexity O(n).
 * 
 * Example:
 * 
 * 
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 * 
 * 
 * Note:
 * 
 * 
 * If there is no such window in S that covers all characters in T, return the
 * empty string "".
 * If there is such window, you are guaranteed that there will always be only
 * one unique minimum window in S.
 * 
 * 
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null) return "";

        int counter = t.length();
        int[] count = new int[256];
        for (char c : t.toCharArray()) {
            count[c]++;
        }

        int left = 0;
        int minLen = Integer.MAX_VALUE;
        String min = s;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (count[c] > 0) {
                counter--;
            }
            count[c]--;

            while (counter == 0) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1; 
                    min = s.substring(left, right + 1);
                }

                count[s.charAt(left)]++;
                if (count[s.charAt(left)] > 0) counter++;
                left++;
            }
        }

        if (minLen == Integer.MAX_VALUE) return "";
        return min;
    }
}
// @lc code=end

