/*
 * [65] Valid Number
 *
 * https://leetcode.com/problems/valid-number/description/
 *
 * algorithms
 * Hard (12.94%)
 * Total Accepted:    80.8K
 * Total Submissions: 624.5K
 * Testcase Example:  '"3"'
 *
 * Validate if a given string is numeric.
 * 
 * 
 * Some examples:
 * "0" => true
 * "   0.1  " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * 
 * 
 * Note: It is intended for the problem statement to be ambiguous. You should
 * gather all requirements up front before implementing one.
 * 
 * 
 * 
 * Update (2015-02-10):
 * The signature of the C++ function had been updated. If you still see your
 * function signature accepts a const char * argument, please click the reload
 * button  to reset your code definition.
 * 
 */
class Solution {
    public boolean isNumber(String s) {
		if (s == null || s.length() == 0) return false;
		int i = 0;
		int n = s.length();
		while (i < n && Character.isWhitespace(s.charAt(i))) i++;

		if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) i++;
		boolean isNumeric = false;
		while (i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
			isNumeric = true;
			i++;
		}		
		if (i < n && s.charAt(i) == '.') {
			i++;
			while (i < n && Character.isDigit(s.charAt(i))) {
				isNumeric = true;
				i++;
			}
		}

		if (i < n && isNumeric && s.charAt(i) == 'e') {
			i++;
			isNumeric = false;
			if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) i++;
			while (i < n && Character.isDigit(s.charAt(i))) {
				isNumeric = true;
				i++;
			}
		}

		while (i < n && Character.isWhitespace(s.charAt(i))) i++;

		return isNumeric && i == s.length();
    }
}
