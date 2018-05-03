/*
 * [14] Longest Common Prefix
 *
 * https://leetcode.com/problems/longest-common-prefix/description/
 *
 * algorithms
 * Easy (31.60%)
 * Total Accepted:    266.9K
 * Total Submissions: 844.4K
 * Testcase Example:  '["flower","flow","flight"]'
 *
 * Write a function to find the longest common prefix string amongst an array
 * of strings.
 * 
 * If there is no common prefix, return an empty string "".
 * 
 * Example 1:
 * 
 * 
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * 
 * 
 * Note:
 * 
 * All given inputs are in lowercase letters a-z.
 * 
 */
func longestCommonPrefix(strs []string) string {
	if len(strs) == 0 {
		return ""
	}

//	if len(strs) == 1 {
//		return strs[0]
//	}
//
	length := len(strs[0])
	for i := 0; i < length; i++ {
		for j := 0; j < len(strs); j++ {
			if i >= len(strs[j]) || strs[0][i] != strs[j][i] {
				return strs[0][0:i]
			}
		}
	} 

	return strs[0]
}
