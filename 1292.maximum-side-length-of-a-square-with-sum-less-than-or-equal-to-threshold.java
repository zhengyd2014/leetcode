/*
 * @lc app=leetcode id=1292 lang=java
 *
 * [1292] Maximum Side Length of a Square with Sum Less than or Equal to Threshold
 *
 * https://leetcode.com/problems/maximum-side-length-of-a-square-with-sum-less-than-or-equal-to-threshold/description/
 *
 * algorithms
 * Medium (46.64%)
 * Likes:    231
 * Dislikes: 13
 * Total Accepted:    9.4K
 * Total Submissions: 19.9K
 * Testcase Example:  '[[1,1,3,2,4,3,2],[1,1,3,2,4,3,2],[1,1,3,2,4,3,2]]\r\n4\r'
 *
 * Given a m x n matrix mat and an integer threshold. Return the maximum
 * side-length of a square with a sum less than or equal to threshold or return
 * 0 if there is no such square.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: mat = [[1,1,3,2,4,3,2],[1,1,3,2,4,3,2],[1,1,3,2,4,3,2]], threshold =
 * 4
 * Output: 2
 * Explanation: The maximum side length of square with sum less than 4 is 2 as
 * shown.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: mat = [[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2]],
 * threshold = 1
 * Output: 0
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: mat = [[1,1,1,1],[1,0,0,0],[1,0,0,0],[1,0,0,0]], threshold = 6
 * Output: 3
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: mat = [[18,70],[61,1],[25,85],[14,40],[11,96],[97,96],[63,45]],
 * threshold = 40184
 * Output: 2
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= m, n <= 300
 * m == mat.length
 * n == mat[i].length
 * 0 <= mat[i][j] <= 10000
 * 0 <= threshold <= 10^5
 * 
 * 
 */

// @lc code=start

// 1292. Maximum Side Length of a Square with Sum Less than or Equal to Threshold

// presum + bounded search

class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = mat[i-1][j-1] + dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1];
            }
        }
        
        int ans = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = ans; i + k <= m && j + k <= n; k++) {
                    if (rangeSum(dp, i, j, i+k, j+k) > threshold) break;
                    ans = k + 1;
                }
            }
        }
        
        return ans;
    }
    
    private int rangeSum(int[][] dp, int x1, int y1, int x2, int y2) {
        return dp[x2][y2] - dp[x1-1][y2] - dp[x2][y1-1] + dp[x1-1][y1-1];
    }
}
// @lc code=end

