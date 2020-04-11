/*
 * @lc app=leetcode id=714 lang=java
 *
 * [714] Best Time to Buy and Sell Stock with Transaction Fee
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/
 *
 * algorithms
 * Medium (51.91%)
 * Likes:    1321
 * Dislikes: 39
 * Total Accepted:    60.1K
 * Total Submissions: 112.4K
 * Testcase Example:  '[1,3,2,8,4,9]\n2'
 *
 * Your are given an array of integers prices, for which the i-th element is
 * the price of a given stock on day i; and a non-negative integer fee
 * representing a transaction fee.
 * You may complete as many transactions as you like, but you need to pay the
 * transaction fee for each transaction.  You may not buy more than 1 share of
 * a stock at a time (ie. you must sell the stock share before you buy again.)
 * Return the maximum profit you can make.
 * 
 * Example 1:
 * 
 * Input: prices = [1, 3, 2, 8, 4, 9], fee = 2
 * Output: 8
 * Explanation: The maximum profit can be achieved by:
 * Buying at prices[0] = 1Selling at prices[3] = 8Buying at prices[4] =
 * 4Selling at prices[5] = 9The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) =
 * 8.
 * 
 * 
 * 
 * Note:
 * 0 < prices.length .
 * 0 < prices[i] < 50000.
 * 0 .
 * 
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices, int fee) {
        if (prices == null ||  prices.length == 0) return 0;

        int[][] dp = new int[2][prices.length];
        dp[0][0] = -prices[0];
        dp[1][0] = 0;

        for (int i = 1; i < prices.length; i++) {
            dp[0][i] = Math.max(dp[0][i-1], dp[1][i-1] - prices[i]);
            dp[1][i] = Math.max(dp[1][i-1], dp[0][i-1] + prices[i] - fee);
        }

        return dp[1][prices.length - 1];
    }
}
// @lc code=end

