import java.awt.List;
import java.math.BigInteger;

/*
 * @lc app=leetcode id=306 lang=java
 *
 * [306] Additive Number
 *
 * https://leetcode.com/problems/additive-number/description/
 *
 * algorithms
 * Medium (29.04%)
 * Likes:    319
 * Dislikes: 386
 * Total Accepted:    49K
 * Total Submissions: 168.4K
 * Testcase Example:  '"112358"'
 *
 * Additive number is a string whose digits can form additive sequence.
 * 
 * A valid additive sequence should contain at least three numbers. Except for
 * the first two numbers, each subsequent number in the sequence must be the
 * sum of the preceding two.
 * 
 * Given a string containing only digits '0'-'9', write a function to determine
 * if it's an additive number.
 * 
 * Note: Numbers in the additive sequence cannot have leading zeros, so
 * sequence 1, 2, 03 or 1, 02, 3 is invalid.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: "112358"
 * Output: true
 * Explanation: The digits can form an additive sequence: 1, 1, 2, 3, 5,
 * 8. 
 * 1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "199100199"
 * Output: true
 * Explanation: The additive sequence is: 1, 99, 100, 199. 
 * 1 + 99 = 100, 99 + 100 = 199
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * num consists only of digits '0'-'9'.
 * 1 <= num.length <= 35
 * 
 * 
 * Follow up:
 * How would you handle overflow for very large input integers?
 * 
 */

// @lc code=start
class Solution {
    public boolean isAdditiveNumber(String num) {
       if (num.length() < 2) return false;
       List<java.math.BigInteger> path = new ArrayList<>();
       return dfs(num, 0, path);
    }

    private boolean dfs(String num, int start, List<java.math.BigInteger> path) {
        if (start == num.length()) {
            if (path.size() > 2) return true;
            else return false;
        }

        for (int i = start; i < num.length(); i++) {
            if (num.charAt(start) == '0' && (i - start) > 0) return false;

            java.math.BigInteger curr = new java.math.BigInteger(num.substring(start, i+1));
            if (path.size() < 2) {
                path.add(curr);
                if (dfs(num, i+1, path)) return true;
                path.remove(path.size() - 1);
            } else {
                if (curr.equals(path.get(path.size() - 1).add(path.get(path.size() - 2)))) {
                    path.add(curr);
                    if (dfs(num, i+1, path)) return true;
                    path.remove(path.size() - 1);
                }
            }
        }

        return false;
    }
}
// @lc code=end

