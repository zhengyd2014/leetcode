/*
 * [3] Longest Substring Without Repeating Characters
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 *
 * algorithms
 * Medium (24.55%)
 * Total Accepted:    410.1K
 * Total Submissions: 1.7M
 * Testcase Example:  '"abcabcbb"'
 *
 * Given a string, find the length of the longest substring without repeating
 * characters.
 * 
 * Examples:
 * 
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * 
 * Given "bbbbb", the answer is "b", with the length of 1.
 * 
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the
 * answer must be a substring, "pwke" is a subsequence and not a substring.
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
		Set<Character> distinct = new HashSet<>();

		int right = 0;
		int maxLen = 0;
		for (int left = 0; left < s.length(); left++) {
			while (right < s.length() && !distinct.contains(s.charAt(right))) {
				distinct.add(s.charAt(right));
				maxLen = Math.max(maxLen, right - left + 1);
				right++;
			}

			distinct.remove(s.charAt(left));
		}		

		return maxLen;
    }
}
