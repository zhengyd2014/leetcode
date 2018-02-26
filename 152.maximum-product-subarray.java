/*
 * [152] Maximum Product Subarray
 *
 * https://leetcode.com/problems/maximum-product-subarray/description/
 *
 * algorithms
 * Medium (26.33%)
 * Total Accepted:    124.1K
 * Total Submissions: 470.1K
 * Testcase Example:  '[-2]'
 *
 * 
 * Find the contiguous subarray within an array (containing at least one
 * number) which has the largest product.
 * 
 * 
 * 
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 * 
 */
class Solution {
    public int maxProduct(int[] nums) {
		int n = nums.length;
		int[] max = new int[n];
		int[] min = new int[n];
		max[0] = nums[0];
		min[0] = nums[0];
		int globalmax = max[0];
		for (int i = 1; i < n; i++) {
			max[i] = Math.max(nums[i], Math.max(max[i-1] * nums[i], min[i - 1] * nums[i]));
			min[i] = Math.min(nums[i], Math.min(max[i-1] * nums[i], min[i - 1] * nums[i]));
			globalmax = Math.max(globalmax, max[i]);
		}		
		return globalmax;
    }
}
