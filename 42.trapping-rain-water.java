/*
 * [42] Trapping Rain Water
 *
 * https://leetcode.com/problems/trapping-rain-water/description/
 *
 * algorithms
 * Hard (37.41%)
 * Total Accepted:    147.6K
 * Total Submissions: 394.1K
 * Testcase Example:  '[]'
 *
 * 
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it is able to trap after
 * raining. 
 * 
 * 
 * 
 * For example, 
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * 
 * 
 * 
 * 
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
 * In this case, 6 units of rain water (blue section) are being trapped. Thanks
 * Marcos for contributing this image!
 */
class Solution {
    public int trap(int[] height) {
		int total = 0;
		if (height == null || height.length <= 2) {
			return total;
		}

		int bar = Integer.MIN_VALUE;
		int left = 0;
		int right = height.length - 1;
		while (left < right) {
			int min = Math.min(height[left], height[right]);
			if (bar >= min) {
				total += bar - min;
			} else {
				bar = min;
			}

			if (height[left] > height[right]) {
				right--;
			} else {
				left++;
			}
		}

		return total;
        
    }
}
