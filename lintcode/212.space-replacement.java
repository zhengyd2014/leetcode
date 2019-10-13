/*
 * @lc app=lintcode id=212 lang=java
 *
 * [212] Space Replacement
 *
 * https://www.lintcode.com/problem/space-replacement/description
 *
 * lintcode
 * Easy (20.00%)
 * Total Accepted:    11501
 * Total Submissions: 56916
 * Testcase Example:  '"Mr John Smith"\n13'
 *
 * Write a method to replace all spaces in a string with `%20`. The string is
 * given in a characters array, you can assume it has enough space for
 * replacement and you are given the true length of the string.
 * 
 * You code should also return the new length of the string after replacement.
 */
public class Solution {
    /*
     * @param string: An array of Char
     * @param length: The true length of the string
     * @return: The true length of new string
     */
    public int replaceBlank(char[] string, int length) {
        // write your code here
        int newLen = 0;
        for (int i = 0; i < length; i++) {
            if (string[i] == ' ') newLen += 3;
            else newLen++;
		}

		int p2 = newLen - 1;
		for (int p1 = length - 1; p1 >=0; p1--) {
			if (string[p1] == ' ') {
				string[p2--] = '0';
				string[p2--] = '2';
				string[p2--] = '%';
			} else {
				string[p2--] = string[p1];
			}
		}
		return newLen;
    }
}
