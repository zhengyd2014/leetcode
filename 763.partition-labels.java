/*
 * @lc app=leetcode id=763 lang=java
 *
 * [763] Partition Labels
 *
 * https://leetcode.com/problems/partition-labels/description/
 *
 * algorithms
 * Medium (73.87%)
 * Likes:    1835
 * Dislikes: 89
 * Total Accepted:    100.7K
 * Total Submissions: 135.7K
 * Testcase Example:  '"ababcbacadefegdehijhklij"'
 *
 * 
 * A string S of lowercase letters is given.  We want to partition this string
 * into as many parts as possible so that each letter appears in at most one
 * part, and return a list of integers representing the size of these parts.
 * 
 * 
 * Example 1:
 * 
 * Input: S = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it
 * splits S into less parts.
 * 
 * 
 * 
 * Note:
 * S will have length in range [1, 500].
 * S will consist of lowercase letters ('a' to 'z') only.
 * 
 */

// @lc code=start

// 763. Partition Labels

// count[] records the last postion of each character in S

class Solution {
    public List<Integer> partitionLabels(String S) {
        
        List<Integer> result = new ArrayList<>();
        int[] count = new int[26];
        for (int i = 0; i < S.length(); i++) {
            count[S.charAt(i)-'a'] = i;
        }
            
        int l = 0, r = 0;
        for (int i = 0; i < S.length(); i++) {
            r = Math.max(r, count[S.charAt(i)-'a']);
            if (i == r) {
                result.add(r - l + 1);
                l = i + 1;
            }
        }
        
        return result;
    }
}

// @lc code=end

