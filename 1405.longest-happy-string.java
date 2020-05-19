/*
 * @lc app=leetcode id=1405 lang=java
 *
 * [1405] Longest Happy String
 *
 * https://leetcode.com/problems/longest-happy-string/description/
 *
 * algorithms
 * Medium (44.78%)
 * Likes:    176
 * Dislikes: 56
 * Total Accepted:    7.2K
 * Total Submissions: 15.6K
 * Testcase Example:  '1\n1\n7'
 *
 * A string is called happy if it does not have any of the strings 'aaa', 'bbb'
 * or 'ccc' as a substring.
 * 
 * Given three integers a, b and c, return any string s, which satisfies
 * following conditions:
 * 
 * 
 * s is happy and longest possible.
 * s contains at most a occurrences of the letter 'a', at most b occurrences of
 * the letter 'b' and at most c occurrences of the letter 'c'.
 * s will only contain 'a', 'b' and 'c' letters.
 * 
 * 
 * If there is no such string s return the empty string "".
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: a = 1, b = 1, c = 7
 * Output: "ccaccbcc"
 * Explanation: "ccbccacc" would also be a correct answer.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: a = 2, b = 2, c = 1
 * Output: "aabbc"
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: a = 7, b = 1, c = 0
 * Output: "aabaa"
 * Explanation: It's the only correct answer in this case.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= a, b, c <= 100
 * a + b + c > 0
 * 
 * 
 */


 /*
1405. Longest Happy String

贪心。为了使得到的字符串最长，每次拼接字符时都应该尽可能消耗掉剩余数量最多的字符。
步骤为：每次选出当前剩余数量最多的字符x和第二多的字符y，若x数量大于等于2，则拼接上2个x，
否则拼接上1个x；此时判断x拼接后剩余数量是否比y多，若比y多则拼接上一个y，否则不需要拼接y，
进入下一个循环。该步的关键思想为：每一次循环尽可能消耗掉剩余数量最多的字符，
然后视情况拼接一个数量第二多的字符来当作分隔字符，以保证在下一个循环中选出的数量最多的
字符x一定可以尽可能多地拼接在结果字符串的末尾(即不会出现拼接两个字符x会导致三个连续x的情况)。
 */

// https://blog.csdn.net/mapoos/article/details/105338038

// @lc code=start
class Solution {
    public String longestDiverseString(int a, int b, int c) {
        
    }
}
// @lc code=end

