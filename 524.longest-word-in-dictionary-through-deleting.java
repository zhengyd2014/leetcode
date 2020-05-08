/*
 * @lc app=leetcode id=524 lang=java
 *
 * [524] Longest Word in Dictionary through Deleting
 *
 * https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/description/
 *
 * algorithms
 * Medium (47.82%)
 * Likes:    490
 * Dislikes: 219
 * Total Accepted:    62.3K
 * Total Submissions: 130K
 * Testcase Example:  '"abpcplea"\n["ale","apple","monkey","plea"]'
 *
 * 
 * Given a string and a string dictionary, find the longest string in the
 * dictionary that can be formed by deleting some characters of the given
 * string. If there are more than one possible results, return the longest word
 * with the smallest lexicographical order. If there is no possible result,
 * return the empty string.
 * 
 * Example 1:
 * 
 * Input:
 * s = "abpcplea", d = ["ale","apple","monkey","plea"]
 * 
 * Output: 
 * "apple"
 * 
 * 
 * 
 * 
 * Example 2:
 * 
 * Input:
 * s = "abpcplea", d = ["a","b","c"]
 * 
 * Output: 
 * "a"
 * 
 * 
 * 
 * Note:
 * 
 * All the strings in the input will only contain lower-case letters.
 * The size of the dictionary won't exceed 1,000.
 * The length of all the strings in the input won't exceed 1,000.
 * 
 * 
 */

// @lc code=start

// 524. Longest Word in Dictionary through Deleting

// sort: O(nlgn * x)  n: dictionary length, x: average length of string

class Solution {
    public String findLongestWord(String s, List<String> d) {
        Collections.sort(d, new Comparator<String>() {
            public int compare(String a, String b) {
                if (a.length() != b.length()) return b.length() - a.length();
                else {
                    return a.compareTo(b);
                }
            }
        });
        
        for (String w : d) {
            if (isSubsequence(s, w)) return w;
        }
        
        return "";
    }
    
    private boolean isSubsequence(String s, String t) {
        if (t.length() == 0) return true;
        if (s.length() < t.length()) return false;
        
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (j < t.length() && s.charAt(i) == t.charAt(j)) {
                j++;
            }
        }
        
        return j == t.length();
    }
}
// @lc code=end

