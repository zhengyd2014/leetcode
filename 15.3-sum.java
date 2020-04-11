/*
 * [15] 3Sum
 *
 * https://leetcode.com/problems/3sum/description/
 *
 * algorithms
 * Medium (21.80%)
 * Total Accepted:    273.6K
 * Total Submissions: 1.3M
 * Testcase Example:  '[-1,0,1,2,-1,-4]'
 *
 * Given an array S of n integers, are there elements a, b, c in S such that a
 * + b + c = 0? Find all unique triplets in the array which gives the sum of
 * zero.
 * 
 * Note: The solution set must not contain duplicate triplets.
 * 
 * 
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 * 
 * A solution set is:
 * [
 * ⁠ [-1, 0, 1],
 * ⁠ [-1, -1, 2]
 * ]
 * 
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums.length <= 2) {
			return result;
		}
       
		Arrays.sort(nums);
		for (int i = 0; i < nums.length -2; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}

			int j = i + 1;
			int k = nums.length - 1;
			while (j < k) {
				if (nums[j] + nums[k] + nums[i] > 0) {
					k--;
				} else if (nums[j] + nums[k] + nums[i] < 0) {
					j++;
				} else {
					result.add(Arrays.asList(nums[i], nums[j], nums[k]));
					while (j < k && nums[j + 1] == nums[j]) {
						j++;
					}
					j++;
				}
			}
		} 

		return result;
    }
}
