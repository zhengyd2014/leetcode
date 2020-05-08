/*
 * @lc app=leetcode id=451 lang=java
 *
 * [451] Sort Characters By Frequency
 *
 * https://leetcode.com/problems/sort-characters-by-frequency/description/
 *
 * algorithms
 * Medium (59.45%)
 * Likes:    1215
 * Dislikes: 98
 * Total Accepted:    140.9K
 * Total Submissions: 235.6K
 * Testcase Example:  '"tree"'
 *
 * Given a string, sort it in decreasing order based on the frequency of
 * characters.
 * 
 * Example 1:
 * 
 * Input:
 * "tree"
 * 
 * Output:
 * "eert"
 * 
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid
 * answer.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input:
 * "cccaaa"
 * 
 * Output:
 * "cccaaa"
 * 
 * Explanation:
 * Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 * 
 * 
 * 
 * Example 3:
 * 
 * Input:
 * "Aabb"
 * 
 * Output:
 * "bbAa"
 * 
 * Explanation:
 * "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 * 
 * 
 */

// @lc code=start

// 451. Sort Characters By Frequency

// bucket sort (count sort)

class Solution {
    public String frequencySort(String s) {
        int[] count = new int[256];
        for (char c : s.toCharArray()) count[c]++;
        
        List<Character>[] buckets = new List[s.length() + 1];
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) continue;
            int index = count[i];
            if (buckets[index] == null) buckets[index] = new ArrayList<Character>();
            buckets[index].add((char)i);
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = buckets.length - 1; i >= 0; i--) {
            if (buckets[i] == null) continue;
            
            for (char c : buckets[i]) {
                for (int j = 0; j < i; j++) sb.append(c);
            }
        }
        
        return sb.toString();
    }
}

// @lc code=end

