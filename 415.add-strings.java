/*
 * [415] Add Strings
 *
 * https://leetcode.com/problems/add-strings/description/
 *
 * algorithms
 * Easy (41.70%)
 * Total Accepted:    48.9K
 * Total Submissions: 117.3K
 * Testcase Example:  '"0"\n"0"'
 *
 * Given two non-negative integers num1 and num2 represented as string, return
 * the sum of num1 and num2.
 * 
 * Note:
 * 
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to
 * integer directly.
 * 
 * 
 */
class Solution {
    public String addStrings(String num1, String num2) {
		if (num1 == null) {
			return num2;
		}

		if (num2 == null) {
			return num1;
		}

		int carry = 0;
		StringBuilder sb = new StringBuilder();
		int i = num1.length() - 1;
		int j = num2.length() - 1;
		while (i >=0 || j >= 0) {
			int op1 = i >= 0 ? num1.charAt(i) - '0' : 0;
			int op2 = j >= 0 ? num2.charAt(j) - '0' : 0;
			int sum = op1 + op2 + carry;
			carry = sum / 10;
			sb.append(sum % 10);
			i--;
			j--;
		}		

		if (carry != 0) {
			sb.append(carry);
		}

		return sb.reverse().toString();
    }
}
