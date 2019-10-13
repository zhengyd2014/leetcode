/*
 * @lc app=lintcode id=2 lang=java
 *
 * [2] Trailing Zeros
 *
 * https://www.lintcode.com/problem/trailing-zeros/description
 *
 * lintcode
 * Easy (27.00%)
 * Total Accepted:    37808
 * Total Submissions: 137651
 * Testcase Example:  '11\n\n'
 *
 * Write an algorithm which computes the number of trailing zeros in n
 * factorial.
 * 
 */
public class Solution {
    /*
     * @param n: An integer
     * @return: An integer, denote the number of trailing zeros in n!
     */
    public long trailingZeros(long n) {
        // write your code here, try to do it without arithmetic operators.
		long num = 0;
		for (long i = 0; i <= n; i++) {
			long a = i;
			while (a > 0) {
				if (a % 5 == 0) {
					num++;
					a /= 5;
				} else {
					break;
				}
			}
		}
		return num;
    }
}
