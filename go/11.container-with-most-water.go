/*
 * [11] Container With Most Water
 *
 * https://leetcode.com/problems/container-with-most-water/description/
 *
 * algorithms
 * Medium (37.13%)
 * Total Accepted:    195.4K
 * Total Submissions: 526.4K
 * Testcase Example:  '[1,1]'
 *
 * Given n non-negative integers a1, a2, ..., an, where each represents a point
 * at coordinate (i, ai). n vertical lines are drawn such that the two
 * endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together
 * with x-axis forms a container, such that the container contains the most
 * water.
 * 
 * Note: You may not slant the container and n is at least 2.
 * 
 */
func maxArea(height []int) int {
	maxArea := 0
	l, r := 0, len(height) - 1

	for l < r {
		area := (r - l) * min(height[l], height[r])
		maxArea = max(maxArea, area)

		if height[l] < height[r] {
			l++
		} else {
			r--
		}
	}

	return maxArea
}

func max(a, b int) int {
	if a > b {
		return a
	}

	return b
}

func min(a, b int) int {
	if a < b {
		return a
	}

	return b
}
