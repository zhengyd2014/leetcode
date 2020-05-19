/*
 * @lc app=leetcode id=767 lang=java
 *
 * [767] Reorganize String
 *
 * https://leetcode.com/problems/reorganize-string/description/
 *
 * algorithms
 * Medium (47.02%)
 * Likes:    1233
 * Dislikes: 61
 * Total Accepted:    66.9K
 * Total Submissions: 141.3K
 * Testcase Example:  '"aab"'
 *
 * Given a string S, check if the letters can be rearranged so that two
 * characters that are adjacent to each other are not the same.
 * 
 * If possible, output any possible result.  If not possible, return the empty
 * string.
 * 
 * Example 1:
 * 
 * 
 * Input: S = "aab"
 * Output: "aba"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: S = "aaab"
 * Output: ""
 * 
 * 
 * Note:
 * 
 * 
 * S will consist of lowercase letters and have length in range [1, 500].
 * 
 * 
 * 
 * 
 */

// @lc code=start

// 767. Reorganize String

// same as "1054. Distant Barcodes"
// sort by count, fill even position the odd position

class Solution {
    public String reorganizeString(String S) {
        int[] count = new int[26];
        int max = 0;
        for (char c : S.toCharArray()) {
            count[c-'a']++;
            max = Math.max(max, count[c-'a']);
        }
        if (max > (S.length() + 1) / 2) return "";
        
        //a[0] : count,  a[1]: character, desc order
        PriorityQueue<int[]> pq = new PriorityQueue<int[]> ((a,b) -> b[0] - a[0]);
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) pq.offer(new int[] {count[i], i});
        }
        
        char[] ans = new char[S.length()];
        int[] curr = new int[2];
        for (int i = 0; i < S.length(); i += 2) {
            if (curr[0] == 0 && !pq.isEmpty()) curr = pq.poll();
            ans[i] = (char)('a' + curr[1]);
            curr[0]--;
        }
        
        for (int i = 1; i < S.length(); i += 2) {
            if (curr[0] == 0 && !pq.isEmpty()) curr = pq.poll();
            ans[i] = (char)('a' + curr[1]);
            curr[0]--;
        }
        
        return new String(ans);
    }
}

// @lc code=end

