/*
 * @lc app=leetcode id=826 lang=java
 *
 * [826] Most Profit Assigning Work
 *
 * https://leetcode.com/problems/most-profit-assigning-work/description/
 *
 * algorithms
 * Medium (37.74%)
 * Likes:    319
 * Dislikes: 57
 * Total Accepted:    17.9K
 * Total Submissions: 47.2K
 * Testcase Example:  '[2,4,6,8,10]\n[10,20,30,40,50]\n[4,5,6,7]'
 *
 * We have jobs: difficulty[i] is the difficulty of the ith job, and profit[i]
 * is the profit of the ith job. 
 * 
 * Now we have some workers. worker[i] is the ability of the ith worker, which
 * means that this worker can only complete a job with difficulty at most
 * worker[i]. 
 * 
 * Every worker can be assigned at most one job, but one job can be completed
 * multiple times.
 * 
 * For example, if 3 people attempt the same job that pays $1, then the total
 * profit will be $3.  If a worker cannot complete any job, his profit is $0.
 * 
 * What is the most profit we can make?
 * 
 * Example 1:
 * 
 * 
 * Input: difficulty = [2,4,6,8,10], profit = [10,20,30,40,50], worker =
 * [4,5,6,7]
 * Output: 100 
 * Explanation: Workers are assigned jobs of difficulty [4,4,6,6] and they get
 * profit of [20,20,30,30] seperately.
 * 
 * Notes:
 * 
 * 
 * 1 <= difficulty.length = profit.length <= 10000
 * 1 <= worker.length <= 10000
 * difficulty[i], profit[i], worker[i]  are in range [1, 10^5]
 * 
 * 
 */

// @lc code=start


// 826. Most Profit Assigning Work
// dp[i] : the most profit of difficulty==i

class Solution {
    
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int[] dp = new int[100001];
        
        // use max here to find the best profit for jobs has same difficulty
        for (int i = 0; i < difficulty.length; i++) {
            dp[difficulty[i]] = Math.max(dp[difficulty[i]], profit[i]);
        }
        
        // calculate dp[i] based on the conclustion that dp[i-1] is the best profit for i-1
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(dp[i], dp[i-1]);
        }
        
        int ans = 0;
        for (int w : worker) {
            ans += dp[w];
        }
        
        return ans;
    }
}

// @lc code=end

