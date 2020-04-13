import java.util.Map;

/*
 * @lc app=leetcode id=974 lang=java
 *
 * [974] Subarray Sums Divisible by K
 *
 * https://leetcode.com/problems/subarray-sums-divisible-by-k/description/
 *
 * algorithms
 * Medium (46.84%)
 * Likes:    649
 * Dislikes: 55
 * Total Accepted:    26.8K
 * Total Submissions: 56.2K
 * Testcase Example:  '[4,5,0,-2,-3,1]\n5'
 *
 * Given an array A of integers, return the number of (contiguous, non-empty)
 * subarrays that have a sum divisible by K.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: A = [4,5,0,-2,-3,1], K = 5
 * Output: 7
 * Explanation: There are 7 subarrays with a sum divisible by K = 5:
 * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2,
 * -3]
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= A.length <= 30000
 * -10000 <= A[i] <= 10000
 * 2 <= K <= 10000
 * 
 * 
 */

// @lc code=start
class Solution {
    public int subarraysDivByK(int[] A, int K) {

        int n = A.length;
        int[] sum = new int [n + 1];
        for (int i = 0; i < n; i++) {
            sum[i+1] = sum[i] + A[i];
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <= n; i++) {
            int reminder = (sum[i] % K + K) % K;   // 处理 负数
            map.put(reminder, map.getOrDefault(reminder, 0) + 1);
        }

        int count = 0;
        for (int v : map.values()) {
            count += (v * (v - 1)) / 2;
        }

        return count;
    }
}
// @lc code=end

