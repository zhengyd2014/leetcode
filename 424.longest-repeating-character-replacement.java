/*
 * @lc app=leetcode id=424 lang=java
 *
 * [424] Longest Repeating Character Replacement
 *
 * https://leetcode.com/problems/longest-repeating-character-replacement/description/
 *
 * algorithms
 * Medium (45.68%)
 * Likes:    1069
 * Dislikes: 67
 * Total Accepted:    58.4K
 * Total Submissions: 127.4K
 * Testcase Example:  '"ABAB"\n2'
 *
 * Given a string s that consists of only uppercase English letters, you can
 * perform at most k operations on that string.
 * 
 * In one operation, you can choose any character of the string and change it
 * to any other uppercase English character.
 * 
 * Find the length of the longest sub-string containing all repeating letters
 * you can get after performing the above operations.
 * 
 * Note:
 * Both the string's length and k will not exceed 10^4.
 * 
 * Example 1:
 * 
 * 
 * Input:
 * s = "ABAB", k = 2
 * 
 * Output:
 * 4
 * 
 * Explanation:
 * Replace the two 'A's with two 'B's or vice versa.
 * 
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * s = "AABABBA", k = 1
 * 
 * Output:
 * 4
 * 
 * Explanation:
 * Replace the one 'A' in the middle with 'B' and form "AABBBBA".
 * The substring "BBBB" has the longest repeating letters, which is 4.
 * 
 * 
 * 
 * 
 */

// @lc code=start

/*
     我们其实就是求满足 (子字符串的长度减去出现次数最多的字符个数)<=k 的最大子字符串长度即可

     为啥这里不用更新 maxCnt 呢？这是个好问题，原因是此题让求的是最长的重复子串，
     maxCnt 相当于卡了一个窗口大小，我们并不希望窗口变小，
     虽然窗口在滑动，但是之前是出现过跟窗口大小相同的符合题意的子串，缩小窗口没有意义，
     并不会使结果 res 变大，所以我们才不更新 maxCnt 的
 */


class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int ans = 0;
        int left = 0;
        int max_cnt = 0;
        for (int right = 0; right < s.length(); right++) {
            count[s.charAt(right) - 'A']++;
            max_cnt = Math.max(max_cnt, count[s.charAt(right) - 'A']);
            
            while (right - left + 1 > max_cnt + k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }
            
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
// @lc code=end

