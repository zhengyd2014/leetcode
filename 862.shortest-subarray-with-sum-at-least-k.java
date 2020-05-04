/*
 * @lc app=leetcode id=862 lang=java
 *
 * [862] Shortest Subarray with Sum at Least K
 *
 * https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/description/
 *
 * algorithms
 * Hard (23.58%)
 * Likes:    914
 * Dislikes: 27
 * Total Accepted:    26.5K
 * Total Submissions: 111.3K
 * Testcase Example:  '[1]\n1'
 *
 * Return the length of the shortest, non-empty, contiguous subarray of A with
 * sum at least K.
 * 
 * If there is no non-empty subarray with sum at least K, return -1.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: A = [1], K = 1
 * Output: 1
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: A = [1,2], K = 4
 * Output: -1
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: A = [2,-1,2], K = 3
 * Output: 3
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= A.length <= 50000
 * -10 ^ 5 <= A[i] <= 10 ^ 5
 * 1 <= K <= 10 ^ 9
 * 
 * 
 * 
 * 
 * 
 */

// @lc code=start


//  862. Shortest Subarray with Sum at Least K

//  1. prefix-sum is the first step for subarray problem
//  2. this is a monotonic arry problem. maitain visited sum in array in a increasing way.
//     to make sure of that, before offerLast(), need to pop all items larger or equal to it.

class Solution {
    public int shortestSubarray(int[] A, int K) {
        if (A.length <= 0) return -1;
        
        int min = Integer.MAX_VALUE;
        int[] sum = new int[A.length+1];
        for (int i = 1; i <= A.length; i++) sum[i] = sum[i-1] + A[i-1];
        
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i <= A.length; i++) {
            while (!dq.isEmpty() && sum[i] - sum[dq.peekFirst()] >= K) {
                int left = dq.pollFirst();
                min = Math.min(min, i - left);
            }
            
            while(!dq.isEmpty() && sum[i] <= sum[dq.peekLast()])  dq.pollLast();
            dq.offerLast(i);
        }
        
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}


// @lc code=end

