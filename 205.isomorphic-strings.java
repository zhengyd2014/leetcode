/*
 * [205] Isomorphic Strings
 *
 * https://leetcode.com/problems/isomorphic-strings/description/
 *
 * algorithms
 * Easy (34.50%)
 * Total Accepted:    127.2K
 * Total Submissions: 368.6K
 * Testcase Example:  '"egg"\n"add"'
 *
 * Given two strings s and t, determine if they are isomorphic.
 * 
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * 
 * All occurrences of a character must be replaced with another character while
 * preserving the order of characters. No two characters may map to the same
 * character but a character may map to itself.
 * 
 * For example,
 * Given "egg", "add", return true.
 * 
 * Given "foo", "bar", return false.
 * 
 * Given "paper", "title", return true.
 * 
 * Note:
 * You may assume both s and t have the same length.
 */
class Solution {
    public boolean isIsomorphic(String s, String t) {
		return oneWayCompare(s, t) && oneWayCompare(t, s);
    }

	private boolean oneWayCompare(String s, String t) {
		Map<Character, Character> sToT = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char sc = s.charAt(i);
			char tc = t.charAt(i);
			if (!sToT.containsKey(sc)) {
				sToT.put(sc, tc);
			} else if (sToT.get(sc) != tc) {
				return false;
			}
		}

		return true;
	}
}
