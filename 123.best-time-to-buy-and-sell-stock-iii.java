/*
 * [123] Best Time to Buy and Sell Stock III
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/
 *
 * algorithms
 * Hard (30.03%)
 * Total Accepted:    99.9K
 * Total Submissions: 332.6K
 * Testcase Example:  '[]'
 *
 * Say you have an array for which the ith element is the price of a given
 * stock on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete at most two
 * transactions.
 * 
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must
 * sell the stock before you buy again).
 */
class Solution {
    public int maxProfit(int[] prices) {
		if (prices == null || prices.length <= 1) {
			return 0;
		}

		int profit = 0;
		int n = prices.length;
		int[] left = new int[n];
		int[] right = new int[n];
		int min = prices[0];
		for (int i = 1; i < n; i++) {
			min = Math.min(min, prices[i]);
			profit = Math.max(profit, prices[i] - min);
			left[i] = profit;
		}		

		profit = 0;
		int max = prices[n - 1];
		for (int i = n - 2; i >= 0; i--) {
		    max = Math.max(max, prices[i]);
		    profit = Math.max(profit, max - prices[i]);
		   	right[i] = profit;
		}

		profit = 0;
		for (int i = 0; i < n; i++) {
			int r = (i == n - 1) ? 0 : right[i + 1];
			profit = Math.max(profit, left[i] + r);
		}	

		return profit;
    }
}
