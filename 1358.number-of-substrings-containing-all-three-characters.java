/*
 * @lc app=leetcode id=1358 lang=java
 *
 * [1358] Number of Substrings Containing All Three Characters
 *
 * https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/description/
 *
 * algorithms
 * Medium (53.95%)
 * Likes:    206
 * Dislikes: 2
 * Total Accepted:    6.4K
 * Total Submissions: 11.6K
 * Testcase Example:  '"abcabc"'
 *
 * Given a string s consisting only of characters a, b and c.
 * 
 * Return the number of substrings containing at least one occurrence of all
 * these characters a, b and c.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "abcabc"
 * Output: 10
 * Explanation: The substrings containing at least one occurrence of the
 * characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab",
 * "bcabc", "cab", "cabc" and "abc" (again). 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "aaacb"
 * Output: 3
 * Explanation: The substrings containing at least one occurrence of the
 * characters a, b and c are "aaacb", "aacb" and "acb". 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "abc"
 * Output: 1
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 3 <= s.length <= 5 x 10^4
 * s only consists of a, b or c characters.
 * 
 */

// @lc code=start


// 1358. Number of Substrings Containing All Three Characters

// dp[i] records the number of matching substrings ending at i-th character.

class Solution {
    public int numberOfSubstrings(String s) {
        if (s.length() < 3) return 0;
        
        int[] dp = new int[s.length()]; 
        int left = 0;
        int[] count = new int[3];
        int cnt = 3;
        Arrays.fill(count, 1);
        for (int right = 0; right < s.length(); right++) {
            int index = s.charAt(right) - 'a';
            if (count[index] > 0) cnt--;
            count[index]--;
            while (cnt == 0) {
                int leftIndex = s.charAt(left) - 'a';
                count[leftIndex]++;
                if (count[leftIndex] > 0) cnt++;
                left++;
            }
            dp[right] = left;     // left means the first one not match, substrings start before left all matching
        }
        
        int total = 0;
        for (int num : dp) total += num;
        return total;
    }
}

// @lc code=end

