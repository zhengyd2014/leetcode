import java.util.List;

/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 */

// @lc code=start
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, String cur, int left, int right, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        } 

        if (left < max) {
            backtrack(ans, cur + "(", left + 1, right, max);
        }

        if (right < left) {
            backtrack(ans, cur + ")", left, right + 1, max);
        }
    }
}
// @lc code=end

