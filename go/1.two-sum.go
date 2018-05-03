/*
 * [1] Two Sum
 *
 * https://leetcode.com/problems/two-sum/description/
 *
 * algorithms
 * Easy (38.06%)
 * Total Accepted:    884.2K
 * Total Submissions: 2.3M
 * Testcase Example:  '[2,7,11,15]\n9'
 *
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * 
 * Example:
 * 
 * 
 * Given nums = [2, 7, 11, 15], target = 9,
 * 
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * 
 * 
 * 
 * 
 */
func twoSum(nums []int, target int) []int {
	valToInx := make(map[int]int)

	for i, val := range nums {
		if j, ok := valToInx[target - val]; ok {
			return []int{j, i}
		}

		valToInx[val] = i
	}

	return []int{}
}
