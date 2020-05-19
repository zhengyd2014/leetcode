/*
 * @lc app=leetcode id=907 lang=java
 *
 * [907] Sum of Subarray Minimums
 *
 * https://leetcode.com/problems/sum-of-subarray-minimums/description/
 *
 * algorithms
 * Medium (30.91%)
 * Likes:    988
 * Dislikes: 63
 * Total Accepted:    22.2K
 * Total Submissions: 71K
 * Testcase Example:  '[3,1,2,4]'
 *
 * Given an array of integers A, find the sum of min(B), where B ranges over
 * every (contiguous) subarray of A.
 * 
 * Since the answer may be large, return the answer modulo 10^9 + 7.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: [3,1,2,4]
 * Output: 17
 * Explanation: Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2],
 * [1,2,4], [3,1,2,4]. 
 * Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.  Sum is 17.
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= A.length <= 30000
 * 1 <= A[i] <= 30000
 * 
 * 
 * 
 * 
 * 
 * 
 */

// @lc code=start

// 907. Sum of Subarray Minimums

// dp[i]: the sum of min(subarray) end at i-th element
// 
// when A[i] > A[j], the min of all the subarray ends with i-j-th element still applys.
// just need to plus the subarrays that the min is A[i].

class Solution {
    public int sumSubarrayMins(int[] A) {
        int mod = (int)1e9 + 7;
        int ans = 0;
        
        int[] dp = new int[A.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < A.length; i++) {
            while (!stack.isEmpty() && A[i] <= A[stack.peek()]) stack.pop();
            if (stack.isEmpty()) dp[i] = (i + 1) * A[i];
            else dp[i] = dp[stack.peek()] + (i - stack.peek()) * A[i];
            stack.push(i);
        }
        
        for (int i = 0; i < dp.length; i++) {
            ans = (ans + dp[i]) % mod;
        }
        return ans;
    }
    
    
    //  o(n^2)
    
    public int sumSubarrayMins2(int[] A) {
        int mod = (int)1e9 + 7;
        int ans = 0;
        
        int[] dp = new int[A.length];
        dp[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            int j = i - 1;
            while (j >= 0 && A[i] <= A[j]) j--;
            if (j >= 0) dp[i] = dp[j] + (i - j) * A[i];
            else dp[i] = (i + 1) * A[i];
        }
        
        for (int i = 0; i < dp.length; i++) {
            ans = (ans + dp[i]) % mod;
        }
        return ans;
    }
}

// @lc code=end

