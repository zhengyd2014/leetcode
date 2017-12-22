/*
 * [349] Intersection of Two Arrays
 *
 * https://leetcode.com/problems/intersection-of-two-arrays/description/
 *
 * algorithms
 * Easy (47.67%)
 * Total Accepted:    112.8K
 * Total Submissions: 236.6K
 * Testcase Example:  '[]\n[]'
 *
 * 
 * Given two arrays, write a function to compute their intersection.
 * 
 * 
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 * 
 * 
 * Note:
 * 
 * Each element in the result must be unique.
 * The result can be in any order.
 * 
 * 
 */
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> set1 = new HashSet<>();
		Set<Integer> intersection = new HashSet<>();
		for (int num : nums1) {
			set1.add(num);
		}

		for (int num : nums2) {
			if (set1.contains(num)) {
				intersection.add(num);
			}
		}

		int[] result = new int[intersection.size()];
		int len = 0;
		for (int num : intersection) {
			result[len++] = num;
		}	
		return result;
    }
}
