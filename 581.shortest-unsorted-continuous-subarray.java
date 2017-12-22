/*
 * [581] Shortest Unsorted Continuous Subarray
 *
 * https://leetcode.com/problems/shortest-unsorted-continuous-subarray/description/
 *
 * algorithms
 * Easy (29.35%)
 * Total Accepted:    24.4K
 * Total Submissions: 83.1K
 * Testcase Example:  '[2,6,4,8,10,9,15]'
 *
 * Given an integer array, you need to find one continuous subarray that if you
 * only sort this subarray in ascending order, then the whole array will be
 * sorted in ascending order, too.  
 * 
 * You need to find the shortest such subarray and output its length.
 * 
 * Example 1:
 * 
 * Input: [2, 6, 4, 8, 10, 9, 15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make
 * the whole array sorted in ascending order.
 * 
 * 
 * 
 * Note:
 * 
 * Then length of the input array is in range [1, 10,000].
 * The input array may contain duplicates, so ascending order here means . 
 * 
 * 
 */
class Solution {
    public int findUnsortedSubarray(int[] nums) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		boolean flag = false;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] < nums[i - 1]) {
				flag = true;
			}

			if (flag) {
				min = Math.min(nums[i], min);
			}
		}

		flag = false;
		for (int i = nums.length - 2; i >= 0; i--) {
			if (nums[i] > nums[i + 1]) {
				flag = true;
			}

			if (flag) {
				max = Math.max(max, nums[i]);
			}
		}

		int left, right;
		for (left = 0; left < nums.length; left++) {
			if (nums[left] > min) {
				break;
			}
		}	

		for (right = nums.length - 1; right >= 0; right--) {
			if (nums[right] < max) {
				break;
			}
		}

		return right - left < 0 ? 0 : right - left + 1;	
    }
}
