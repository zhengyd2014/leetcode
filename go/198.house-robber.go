/*
 * [198] House Robber
 *
 * https://leetcode.com/problems/house-robber/description/
 *
 * algorithms
 * Easy (39.99%)
 * Total Accepted:    197.8K
 * Total Submissions: 494.8K
 * Testcase Example:  '[]'
 *
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money stashed, the only constraint stopping
 * you from robbing each of them is that adjacent houses have security system
 * connected and it will automatically contact the police if two adjacent
 * houses were broken into on the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight
 * without alerting the police.
 * 
 * Credits:Special thanks to @ifanchu for adding this problem and creating all
 * test cases. Also thanks to @ts for adding additional test cases.
 */
func rob(nums []int) int {
	result, previous1, previous2 := 0, 0, 0

	for _, v := range nums {
		result = max(previous1, v + previous2)
		previous2 = previous1
		previous1 = result
	}

	return result
}

func max(a, b int) int {
	if a > b {
		return a
	}

	return b
}
