/*
 * @lc app=leetcode id=992 lang=java
 *
 * [992] Subarrays with K Different Integers
 *
 * https://leetcode.com/problems/subarrays-with-k-different-integers/description/
 *
 * algorithms
 * Hard (46.57%)
 * Likes:    775
 * Dislikes: 15
 * Total Accepted:    21.8K
 * Total Submissions: 46.7K
 * Testcase Example:  '[1,2,1,2,3]\n2'
 *
 * Given an array A of positive integers, call a (contiguous, not necessarily
 * distinct) subarray of A good if the number of different integers in that
 * subarray is exactly K.
 * 
 * (For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.)
 * 
 * Return the number of good subarrays of A.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: A = [1,2,1,2,3], K = 2
 * Output: 7
 * Explanation: Subarrays formed with exactly 2 different integers: [1,2],
 * [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: A = [1,2,1,3,4], K = 3
 * Output: 3
 * Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3],
 * [2,1,3], [1,3,4].
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= A.length <= 20000
 * 1 <= A[i] <= A.length
 * 1 <= K <= A.length
 * 
 */

// @lc code=start

// 992. Subarrays with K Different Integers

// "exact == K" is equals to "atmost K" - "atmost K-1"

class Solution {
    public int subarraysWithKDistinct(int[] A, int K) {
        return subArraysAtMost(A, K) - subArraysAtMost(A, K - 1);
    }
    
    public int subArraysAtMost(int[] A, int K) {
        if (A == null || A.length == 0 || K <= 0) return 0;
        
        int left = 0;
        int total = 0;
        Map<Integer, Integer> count = new HashMap<>();
        for (int right = 0; right < A.length; right++) {
            int curr = A[right];
            count.put(curr, count.getOrDefault(curr, 0) + 1);
            if (count.get(curr) == 1) K--;
            
            while (K < 0) {
                count.put(A[left], count.get(A[left]) - 1);
                if (count.get(A[left]) == 0) K++;
                left++;
            }
            
            total += right - left + 1;
        }
        
        return total;
    }
}

// @lc code=end

