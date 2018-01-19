/*
 * [43] Multiply Strings
 *
 * https://leetcode.com/problems/multiply-strings/description/
 *
 * algorithms
 * Medium (27.76%)
 * Total Accepted:    125.3K
 * Total Submissions: 451.3K
 * Testcase Example:  '"0"\n"0"'
 *
 * Given two non-negative integers num1 and num2 represented as strings, return
 * the product of num1 and num2.
 * 
 * Note:
 * 
 * The length of both num1 and num2 is < 110.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to
 * integer directly.
 * 
 * 
 */
class Solution {
    public String multiply(String num1, String num2) {
		int[] product = multiply(num1.toCharArray(), num2.toCharArray());

		StringBuilder sb = new StringBuilder();
		boolean leadingZero = true;
		for (int i = 0; i < product.length; i++) {
			if (product[i] == 0 && leadingZero) {
			   continue;
			}

			leadingZero = false;
			sb.append(product[i]);		
		}		

		return sb.length() == 0 ? "0" : sb.toString();
    }

	private int[] multiply(char[] num1, char[] num2) {
		int n = num1.length;
		int m = num2.length;
		int[] product = new int[n + m];
		for (int i = n - 1; i >= 0; i--) {
			int op1 = num1[i] - '0';
			for (int j = m - 1; j >= 0; j--) {
				int op2 = num2[j] - '0';
				int p = op1 * op2;
				product[i + j + 1] += p;
			}
		}

		int carry = 0;
		for (int i = product.length - 1; i >= 0; i--) {
			int sum = carry + product[i];
			product[i] = sum % 10;
			carry = sum / 10;
		}
		return product;
	}
}
