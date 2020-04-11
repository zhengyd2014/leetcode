/*
 * @lc app=lintcode id=1 lang=java
 *
 * [1] A + B Problem
 *
 * https://www.lintcode.com/problem/a-b-problem/description
 *
 * lintcode
 * Easy (54.00%)
 * Total Accepted:    73475
 * Total Submissions: 135667
 * Testcase Example:  '1\n2'
 *
 * Write a function that add two numbers A and B.
 */
public class Solution {
    /**
     * @param a: An integer
     * @param b: An integer
     * @return: The sum of a and b 
     */
    public int aplusb(int a, int b) {
        // write your code here
        while (a != 0 && b != 0) {
			int _a = a ^ b;
            int _b = (a & b) << 1;
            a = _a;
            b = _b;
		}
		return a == 0 ? b : a;
    }
}
