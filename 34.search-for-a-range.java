/*
 * [34] Search for a Range
 *
 * https://leetcode.com/problems/search-for-a-range/description/
 *
 * algorithms
 * Medium (31.58%)
 * Total Accepted:    173.7K
 * Total Submissions: 549.8K
 * Testcase Example:  '[5,7,7,8,8,10]\n8'
 *
 * Given an array of integers sorted in ascending order, find the starting and
 * ending position of a given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * 
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 * 
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return new int[] {-1, -1};
		}

		int targetStart = findStartOfGreatOrEqual(nums, target);
		int targetPlusOneStart = findStartOfGreatOrEqual(nums, target + 1);
		if (targetPlusOneStart == targetStart) {
			return new int[] {-1, -1};
		} else {
			return new int[] {targetStart, targetPlusOneStart - 1};
		}
    }

	private int findStartOfGreatOrEqual(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		while (start < end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] < target) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}

		return nums[end] < target ? end + 1 : end;
	}
}
