/*
 * @lc app=leetcode id=515 lang=java
 *
 * [515] Find Largest Value in Each Tree Row
 *
 * https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/
 *
 * algorithms
 * Medium (59.95%)
 * Likes:    717
 * Dislikes: 56
 * Total Accepted:    88K
 * Total Submissions: 146.6K
 * Testcase Example:  '[1,3,2,5,3,null,9]'
 *
 * You need to find the largest value in each row of a binary tree.
 * 
 * Example:
 * 
 * Input: 
 * 
 * ⁠         1
 * ⁠        / \
 * ⁠       3   2
 * ⁠      / \   \  
 * ⁠     5   3   9 
 * 
 * Output: [1, 3, 9]
 * 
 * 
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        
        dfs(root, 0, result);
        return result;
    }
    
    private void dfs(TreeNode root, int level, List<Integer> result) {
        if (root == null) return;
        
        if (level == result.size()) {
            result.add(root.val);
        } else {
            if (result.get(level) < root.val) {
                result.set(level, root.val);
            }
        }
        
        dfs(root.left, level + 1, result);
        dfs(root.right, level + 1, result);
    }
}
// @lc code=end

