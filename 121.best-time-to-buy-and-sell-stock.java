/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 *
 * algorithms
 * Easy (49.72%)
 * Likes:    4602
 * Dislikes: 205
 * Total Accepted:    811.2K
 * Total Submissions: 1.6M
 * Testcase Example:  '[7,1,5,3,6,4]'
 *
 * Say you have an array for which the i^th element is the price of a given
 * stock on day i.
 * 
 * If you were only permitted to complete at most one transaction (i.e., buy
 * one and sell one share of the stock), design an algorithm to find the
 * maximum profit.
 * 
 * Note that you cannot sell a stock before you buy one.
 * 
 * Example 1:
 * 
 * 
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit
 * = 6-1 = 5.
 * Not 7-1 = 6, as selling price needs to be larger than buying price.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 * 
 * 
 */

// @lc code=start



//   dp[i][0]  i-th day, with stock
//   dp[i][1]  i-th day, without stock

class Solution {
    public int maxProfit2(int[] prices) {
        if (prices.length <= 1) return 0; 
        int n = prices.length;
        int[][] dp = new int[n][2];
        
        //base case
        dp[0][0] = 0;           // 1st day, without stock
        dp[0][1] = -prices[0];  // 1st day, with stock
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
        }
        
        return dp[n-1][0];
    }
    
    // with space compression
    
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0; 
        
        int dp_i_0 = 0;
        int dp_i_1 = -prices[0];
        for (int i = 0; i < prices.length; i++) {
            int dp0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            int dp1 = Math.max(dp_i_1, -prices[i]);
            dp_i_0 = dp0;
            dp_i_1 = dp1;
        }
        
        return dp_i_0;
    }
}

// @lc code=end

