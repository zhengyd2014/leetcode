/*
 * [231] Power of Two
 *
 * https://leetcode.com/problems/power-of-two/description/
 *
 * algorithms
 * Easy (40.76%)
 * Total Accepted:    170.5K
 * Total Submissions: 418.1K
 * Testcase Example:  '1'
 *
 * 
 * Given an integer, write a function to determine if it is a power of two.
 * 
 * 
 * Credits:Special thanks to @jianchao.li.fighter for adding this problem and
 * creating all test cases.
 */
func isPowerOfTwo(n int) bool {
	return n > 0 && (n & (n - 1)) == 0
}
