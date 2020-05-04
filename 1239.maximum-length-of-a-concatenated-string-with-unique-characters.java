/*
 * @lc app=leetcode id=1239 lang=java
 *
 * [1239] Maximum Length of a Concatenated String with Unique Characters
 *
 * https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/description/
 *
 * algorithms
 * Medium (46.09%)
 * Likes:    267
 * Dislikes: 43
 * Total Accepted:    18.5K
 * Total Submissions: 39.8K
 * Testcase Example:  '["un","iq","ue"]'
 *
 * Given an array of strings arr. String s is a concatenation of a sub-sequence
 * of arr which have unique characters.
 * 
 * Return the maximum possible length of s.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: arr = ["un","iq","ue"]
 * Output: 4
 * Explanation: All possible concatenations are "","un","iq","ue","uniq" and
 * "ique".
 * Maximum length is 4.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: arr = ["cha","r","act","ers"]
 * Output: 6
 * Explanation: Possible solutions are "chaers" and "acters".
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
 * Output: 26
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= arr.length <= 16
 * 1 <= arr[i].length <= 26
 * arr[i] contains only lower case English letters.
 * 
 * 
 */

// @lc code=start

// 位操作来验证字符是否重复，相当于Set，但比set效率要高

class Solution {

    int max = 0;
    public int maxLength(List<String> arr) {
        List<Integer> masks = getMasks(arr);
        dfs(masks, 0, 0);
        return max;
    }

    private void dfs(List<Integer> masks, int start, int path) {
        for (int i = start; i < masks.size(); i++) {
            int mask = masks.get(i);
            if ( (mask & path) != 0) continue; 
            int len = Integer.bitCount(path) + Integer.bitCount(mask);
            max = Math.max(max, len);
            dfs(masks, i+1, path | mask);
        }
    }

    private List<Integer> getMasks(List<String> arr) {
        List<Integer> masks = new ArrayList<>();
        for (String word : arr) {
            int mask = 0;
            for (char c : word.toCharArray()) {
                mask |= 1 << (c - 'a');
            }
            // check if there are duplicate chars in the string
            if (Integer.bitCount(mask) != word.length()) continue;  

            masks.add(mask);
        }
        return masks;
    }
}
// @lc code=end

