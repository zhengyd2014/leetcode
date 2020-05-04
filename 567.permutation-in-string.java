/*
 * @lc app=leetcode id=567 lang=java
 *
 * [567] Permutation in String
 *
 * https://leetcode.com/problems/permutation-in-string/description/
 *
 * algorithms
 * Medium (40.41%)
 * Likes:    1143
 * Dislikes: 52
 * Total Accepted:    85.8K
 * Total Submissions: 211.3K
 * Testcase Example:  '"ab"\n"eidbaooo"'
 *
 * Given two strings s1 and s2, write a function to return true if s2 contains
 * the permutation of s1. In other words, one of the first string's
 * permutations is the substring of the second string.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s1 = "ab" s2 = "eidbaooo"
 * Output: True
 * Explanation: s2 contains one permutation of s1 ("ba").
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:s1= "ab" s2 = "eidboaoo"
 * Output: False
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * The input strings only contain lower case letters.
 * The length of both given strings is in range [1, 10,000].
 * 
 * 
 */

// @lc code=start


// 567. Permutation in String

// sliding window: when cnt == 0, indicate all string matches in the window

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() == 0) return true;
        if (s2.length() == 0) return false;
        
        int cnt = s1.length();
        int[] count = new int[26];
        for (char c : s1.toCharArray()) {
            count[c-'a']++;
        }
        
        int left = 0;
        for (int right = 0; right < s2.length(); right++) {
            int index = s2.charAt(right) - 'a';
            if (count[index] > 0) cnt--;
            count[index]--;
            
            while(count[index] < 0) {
                int l_index = s2.charAt(left) - 'a';
                count[l_index]++;
                if (count[l_index] > 0) cnt++;
                left++;
            }
            
            if (cnt == 0) return true;
        }
        
        return false;
    }
}

// @lc code=end

