/*
 * @lc app=leetcode id=513 lang=java
 *
 * [513] Find Bottom Left Tree Value
 *
 * https://leetcode.com/problems/find-bottom-left-tree-value/description/
 *
 * algorithms
 * Medium (60.51%)
 * Likes:    785
 * Dislikes: 126
 * Total Accepted:    96K
 * Total Submissions: 158.4K
 * Testcase Example:  '[2,1,3]'
 *
 * 
 * Given a binary tree, find the leftmost value in the last row of the tree. 
 * 
 * 
 * Example 1:
 * 
 * Input:
 * 
 * ⁠   2
 * ⁠  / \
 * ⁠ 1   3
 * 
 * Output:
 * 1
 * 
 * 
 * 
 * ⁠ Example 2: 
 * 
 * Input:
 * 
 * ⁠       1
 * ⁠      / \
 * ⁠     2   3
 * ⁠    /   / \
 * ⁠   4   5   6
 * ⁠      /
 * ⁠     7
 * 
 * Output:
 * 7
 * 
 * 
 * 
 * Note:
 * You may assume the tree (i.e., the given root node) is not NULL.
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
    
    int leftmost;
    int deepestLevel = -1;
    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);
        return leftmost;
    }
    
    private void dfs(TreeNode root, int level) {
        if (root == null) return;
        
        if (level > deepestLevel) {
            deepestLevel = level;
            leftmost = root.val;
        }
        
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
}
// @lc code=end

