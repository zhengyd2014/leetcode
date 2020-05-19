/*
 * @lc app=leetcode id=1262 lang=java
 *
 * [1262] Greatest Sum Divisible by Three
 *
 * https://leetcode.com/problems/greatest-sum-divisible-by-three/description/
 *
 * algorithms
 * Medium (44.75%)
 * Likes:    344
 * Dislikes: 10
 * Total Accepted:    12.4K
 * Total Submissions: 27K
 * Testcase Example:  '[3,6,5,1,8]'
 *
 * Given an array nums of integers, we need to find the maximum possible sum of
 * elements of the array such that it is divisible by three.
 * 
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [3,6,5,1,8]
 * Output: 18
 * Explanation: Pick numbers 3, 6, 1 and 8 their sum is 18 (maximum sum
 * divisible by 3).
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [4]
 * Output: 0
 * Explanation: Since 4 is not divisible by 3, do not pick any number.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [1,2,3,4,4]
 * Output: 12
 * Explanation: Pick numbers 1, 3, 4 and 4 their sum is 12 (maximum sum
 * divisible by 3).
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 4 * 10^4
 * 1 <= nums[i] <= 10^4
 * 
 * 
 */

// @lc code=start

// 
//  dp[i][j]:  the i-th element, the sum is with the remainder as j.
// 

class Solution {
    public int maxSumDivThree(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][3];
        
        for (int i = 1; i <= n; i++) { 
            for (int j = 0; j <=2; j++) dp[i][j] = dp[i-1][j];
            for (int j = 0; j <=2; j++) {
                int sum = nums[i-1] + dp[i-1][j];
                dp[i][sum%3] = Math.max(dp[i][sum%3], sum);
            }
        }
        
        return dp[n][0];
    }
}

// @lc code=end

