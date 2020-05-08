/*
 * @lc app=leetcode id=275 lang=java
 *
 * [275] H-Index II
 *
 * https://leetcode.com/problems/h-index-ii/description/
 *
 * algorithms
 * Medium (36.12%)
 * Likes:    292
 * Dislikes: 471
 * Total Accepted:    95.1K
 * Total Submissions: 263K
 * Testcase Example:  '[0,1,3,5,6]'
 *
 * Given an array of citations sorted in ascending order (each citation is a
 * non-negative integer) of a researcher, write a function to compute the
 * researcher's h-index.
 * 
 * According to the definition of h-index on Wikipedia: "A scientist has index
 * h if h of his/her N papers have at least h citations each, and the other N −
 * h papers have no more than h citations each."
 * 
 * Example:
 * 
 * 
 * Input: citations = [0,1,3,5,6]
 * Output: 3 
 * Explanation: [0,1,3,5,6] means the researcher has 5 papers in total and each
 * of them had 
 * ⁠            received 0, 1, 3, 5, 6 citations respectively. 
 * Since the researcher has 3 papers with at least 3 citations each and the
 * remaining 
 * two with no more than 3 citations each, her h-index is 3.
 * 
 * Note:
 * 
 * If there are several possible values for h, the maximum one is taken as the
 * h-index.
 * 
 * Follow up:
 * 
 * 
 * This is a follow up problem to H-Index, where citations is now guaranteed to
 * be sorted in ascending order.
 * Could you solve it in logarithmic time complexity?
 * 
 * 
 */

// @lc code=start

// 275. H-Index II

// there are conditions check after search:
//   1. check left
//   2. check right
//   3. both fail, not found.

class Solution {
    public int hIndex(int[] citations) {
        if (citations.length == 0) return 0;
        
        int l = 0;
        int h = citations.length - 1;
        while (l + 1 < h) {
            int mid = l + (h - l) / 2;
            if (citations[mid] > citations.length - mid) h = mid;
            else l = mid;
        }
        
        if (citations[l] >= citations.length - l) return citations.length - l;
        if (citations[h] >= citations.length - h) return citations.length - h;
        return 0;
    }
}

// @lc code=end

