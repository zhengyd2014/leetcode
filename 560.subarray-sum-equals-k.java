/*
 * [560] Subarray Sum Equals K
 *
 * https://leetcode.com/problems/subarray-sum-equals-k/description/
 *
 * algorithms
 * Medium (40.44%)
 * Total Accepted:    25.4K
 * Total Submissions: 62.7K
 * Testcase Example:  '[1,1,1]\n2'
 *
 * Given an array of integers and an integer k, you need to find the total
 * number of continuous subarrays whose sum equals to k.
 * 
 * Example 1:
 * 
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 * 
 * 
 * 
 * Note:
 * 
 * The length of the array is in range [1, 20,000].
 * The range of numbers in the array is [-1000, 1000] and the range of the
 * integer k is [-1e7, 1e7].
 * 
 * 
 * 
 */
class Solution {
    public int subarraySum(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return 0;		
		}

		Map<Integer, Integer> sumCount = new HashMap<>();
		int count = 0;
		int runningSum = 0;
		sumCount.put(0, 1);
		for (int i = 0; i < nums.length; i++) {
			runningSum += nums[i];
			count += sumCount.getOrDefault((runningSum - k), 0);
			sumCount.put(runningSum, sumCount.getOrDefault(runningSum, 0) + 1);
		}

		return count;
    }
}
