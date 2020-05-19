/*
 * @lc app=leetcode id=739 lang=java
 *
 * [739] Daily Temperatures
 *
 * https://leetcode.com/problems/daily-temperatures/description/
 *
 * algorithms
 * Medium (62.27%)
 * Likes:    2462
 * Dislikes: 74
 * Total Accepted:    142.1K
 * Total Submissions: 227.4K
 * Testcase Example:  '[73,74,75,71,69,72,76,73]'
 *
 * 
 * Given a list of daily temperatures T, return a list such that, for each day
 * in the input, tells you how many days you would have to wait until a warmer
 * temperature.  If there is no future day for which this is possible, put 0
 * instead.
 * 
 * For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76,
 * 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
 * 
 * 
 * Note:
 * The length of temperatures will be in the range [1, 30000].
 * Each temperature will be an integer in the range [30, 100].
 * 
 */

// @lc code=start

// 739. Daily Temperatures

// Stack: store index not the value

class Solution {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> s = new Stack<>();
        
        int[] ans = new int[T.length];
        for (int i = T.length - 1; i >= 0; i--) {
            while(!s.isEmpty() && T[i] >= T[s.peek()]) s.pop();
            ans[i] = s.isEmpty() ? 0 : s.peek() - i;
            s.push(i);
        }
        
        return ans;
    }
}

// @lc code=end

