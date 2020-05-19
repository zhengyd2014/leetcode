/*
 * @lc app=leetcode id=1283 lang=java
 *
 * [1283] Find the Smallest Divisor Given a Threshold
 *
 * https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/description/
 *
 * algorithms
 * Medium (42.57%)
 * Likes:    138
 * Dislikes: 35
 * Total Accepted:    10.6K
 * Total Submissions: 24.4K
 * Testcase Example:  '[1,2,5,9]\n6'
 *
 * Given an array of integers nums and an integer threshold, we will choose a
 * positive integer divisor and divide all the array by it and sum the result
 * of the division. Find the smallest divisor such that the result mentioned
 * above is less than or equal to threshold.
 * 
 * Each result of division is rounded to the nearest integer greater than or
 * equal to that element. (For example: 7/3 = 3 and 10/2 = 5).
 * 
 * It is guaranteed that there will be an answer.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,2,5,9], threshold = 6
 * Output: 5
 * Explanation: We can get a sum to 17 (1+2+5+9) if the divisor is 1. 
 * If the divisor is 4 we can get a sum to 7 (1+1+2+3) and if the divisor is 5
 * the sum will be 5 (1+1+1+2). 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [2,3,5,7,11], threshold = 11
 * Output: 3
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [19], threshold = 5
 * Output: 4
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 5 * 10^4
 * 1 <= nums[i] <= 10^6
 * nums.length <= threshold <= 10^6
 * 
 */

// @lc code=start

// 1283. Find the Smallest Divisor Given a Threshold

// binary search value range
// pay attent to range selection, 

class Solution {
    public int smallestDivisor(int[] nums, int threshold) {      
        int l = 1;
        int h = (int)1e9;
        
        while (l + 1 < h) {
            int mid = l + (h - l) / 2;
            int sum = sumOfDivisor(nums, mid);
            if (sum <= threshold) {
                h = mid;
            } else {
                l = mid;
            }
        }
        
        if (sumOfDivisor(nums, l) <= threshold) return l;
        return h;
    }
    
    private int sumOfDivisor(int[] nums, int m) {
        int sum = 0;
        for (int i : nums)
             sum += (i + m - 1) / m;
        return sum;
    }
}

// @lc code=end

