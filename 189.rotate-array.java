/*
 * [189] Rotate Array
 *
 * https://leetcode.com/problems/rotate-array/description/
 *
 * algorithms
 * Easy (25.07%)
 * Total Accepted:    154K
 * Total Submissions: 614.1K
 * Testcase Example:  '[1]\n0'
 *
 * Rotate an array of n elements to the right by k steps.
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to
 * [5,6,7,1,2,3,4]. 
 * 
 * Note:
 * Try to come up as many solutions as you can, there are at least 3 different
 * ways to solve this problem.
 * 
 * 
 * [show hint]
 * Hint:
 * Could you do it in-place with O(1) extra space?
 * 
 * 
 * Related problem: Reverse Words in a String II
 * 
 * Credits:Special thanks to @Freezen for adding this problem and creating all
 * test cases.
 */
class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length <= 1 || k <= 0) {
			return;
		}

		k = k % nums.length;
		reverse(nums, 0, nums.length - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, nums.length - 1);
    }

	private void reverse(int[] nums, int left, int right) {
		while (left < right) {
			int tmp = nums[left];
			nums[left] = nums[right];
			nums[right] = tmp;
			left++;
			right--;
		}
	}
}
