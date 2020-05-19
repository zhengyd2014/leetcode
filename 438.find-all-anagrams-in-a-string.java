/*
 * @lc app=leetcode id=438 lang=java
 *
 * [438] Find All Anagrams in a String
 *
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
 *
 * algorithms
 * Medium (41.04%)
 * Likes:    2503
 * Dislikes: 164
 * Total Accepted:    203.7K
 * Total Submissions: 490.9K
 * Testcase Example:  '"cbaebabacd"\n"abc"'
 *
 * Given a string s and a non-empty string p, find all the start indices of p's
 * anagrams in s.
 * 
 * Strings consists of lowercase English letters only and the length of both
 * strings s and p will not be larger than 20,100.
 * 
 * The order of output does not matter.
 * 
 * Example 1:
 * 
 * Input:
 * s: "cbaebabacd" p: "abc"
 * 
 * Output:
 * [0, 6]
 * 
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of
 * "abc".
 * 
 * 
 * 
 * Example 2:
 * 
 * Input:
 * s: "abab" p: "ab"
 * 
 * Output:
 * [0, 1, 2]
 * 
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int cnt = p.length();
        int count[] = new int[256];
        for (char c : p.toCharArray()) count[c]++;

        int left = 0;
        List<Integer> ans = new ArrayList<>();
        for(int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (count[c] > 0) cnt--;
            count[c]--;

            while(count[c] < 0) {
                char l = s.charAt(left);
                count[l]++;
                if (count[l] > 0) cnt++;
                left++;
            }

            if (cnt == 0) ans.add(left);
        }

        return ans;
    }
}
// @lc code=end

