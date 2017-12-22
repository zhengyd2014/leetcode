/*
 * [697] Degree of an Array
 *
 * https://leetcode.com/problems/degree-of-an-array/description/
 *
 * algorithms
 * Easy (46.64%)
 * Total Accepted:    11K
 * Total Submissions: 23.6K
 * Testcase Example:  '[1,2,2,3,1]'
 *
 * Given a non-empty array of non-negative integers nums, the degree of this
 * array is defined as the maximum frequency of any one of its elements.
 * Your task is to find the smallest possible length of a (contiguous) subarray
 * of nums, that has the same degree as nums.
 * 
 * Example 1:
 * 
 * Input: [1, 2, 2, 3, 1]
 * Output: 2
 * Explanation: 
 * The input array has a degree of 2 because both elements 1 and 2 appear
 * twice.
 * Of the subarrays that have the same degree:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * The shortest length is 2. So return 2.
 * 
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: [1,2,2,3,1,4,2]
 * Output: 6
 * 
 * 
 * 
 * Note:
 * nums.length will be between 1 and 50,000.
 * nums[i] will be an integer between 0 and 49,999.
 * 
 */
class Solution {
    public int findShortestSubArray(int[] nums) {
		int len = Integer.MAX_VALUE;
		int maxDegree = 0;
		Map<Integer, Integer> firstIndex = new HashMap<>();
		Map<Integer, Integer> degree = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (!firstIndex.containsKey(nums[i])) {
				firstIndex.put(nums[i], i);
			}
			
			degree.put(nums[i], degree.getOrDefault(nums[i], 0) + 1);
			if (degree.get(nums[i]) == maxDegree) {
				len = Math.min(len, i - firstIndex.get(nums[i]) + 1);
			} else if (degree.get(nums[i]) > maxDegree) {
				len = i - firstIndex.get(nums[i]) + 1;
				maxDegree = degree.get(nums[i]);
			}	   
		}		

		return len == Integer.MAX_VALUE ? 0 : len;
    }
}
