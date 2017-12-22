/*
 * [643] Maximum Average Subarray I
 *
 * https://leetcode.com/problems/maximum-average-subarray-i/description/
 *
 * algorithms
 * Easy (37.85%)
 * Total Accepted:    20.7K
 * Total Submissions: 54.7K
 * Testcase Example:  '[1,12,-5,-6,50,3]\n4'
 *
 * 
 * Given an array consisting of n integers, find the contiguous subarray of
 * given length k that has the maximum average value. And you need to output
 * the maximum average value.
 * 
 * 
 * Example 1:
 * 
 * Input: [1,12,-5,-6,50,3], k = 4
 * Output: 12.75
 * Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
 * 
 * 
 * 
 * Note:
 * 
 * 1 k n 
 * Elements of the given array will be in the range [-10,000, 10,000].
 * 
 * 
 */
class Solution {
    public double findMaxAverage(int[] nums, int k) {
		int sum = 0;
		for (int i = 0; i < k; i++) {
			sum += nums[i];
		}

		int maxSum = sum;
		for (int i = k; i < nums.length; i++) {
			sum += nums[i] - nums[i - k];
			maxSum = Math.max(maxSum, sum);
		}

		return (double)maxSum / k;		
    }
}
