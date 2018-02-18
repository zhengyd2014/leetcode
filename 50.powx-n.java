/*
 * [50] Pow(x, n)
 *
 * https://leetcode.com/problems/powx-n/description/
 *
 * algorithms
 * Medium (26.05%)
 * Total Accepted:    197.4K
 * Total Submissions: 757.7K
 * Testcase Example:  '2.00000\n10'
 *
 * Implement pow(x, n).
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: 2.00000, 10
 * Output: 1024.00000
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: 2.10000, 3
 * Output: 9.26100
 * 
 * 
 */
class Solution {
    public double myPow(double x, int n) {
		if (x == 0) return 0.0;
		long N = n;
		if (N < 0) {
			x = 1.0 / x;
			N = -N;
		}		

		return fastPow(x, N);
    }

	private double fastPow(double x, long n) {
		if (n == 0) return 1.0;
		double half = fastPow(x, n / 2);
		if (n % 2 == 0) {
			return half * half;
		} else {
			return half * half * x;
		}
	}
}
