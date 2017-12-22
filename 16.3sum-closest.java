/*
 * [16] 3Sum Closest
 *
 * https://leetcode.com/problems/3sum-closest/description/
 *
 * algorithms
 * Medium (31.41%)
 * Total Accepted:    154.3K
 * Total Submissions: 491K
 * Testcase Example:  '[0,0,0]\n1'
 *
 * Given an array S of n integers, find three integers in S such that the sum
 * is closest to a given number, target. Return the sum of the three integers.
 * You may assume that each input would have exactly one solution.
 * 
 * 
 * ⁠   For example, given array S = {-1 2 1 -4}, and target = 1.
 * 
 * ⁠   The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 */
class Solution {
    public int threeSumClosest(int[] nums, int target) {
		if (nums.length <= 2) {
			return 0;
		}

		Arrays.sort(nums);
		int min = nums[0] + nums[1] + nums[2];
		for (int left = 0; left < nums.length - 2; left++) {
			int mid = left + 1;
			int right = nums.length - 1;
			while (mid < right) {
				int tmp = nums[left] + nums[mid] + nums[right];
				if (Math.abs(target - tmp) < Math.abs(target - min)) {
					min = tmp;
				}

				if (nums[mid] + nums[right] > target - nums[left]) {
					right--;
				} else if (nums[mid] + nums[right] < target - nums[left]) {
					mid++;
				} else {
					return min;
				}
			}
		}
		return min;
    }
}
