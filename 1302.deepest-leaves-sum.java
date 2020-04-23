/*
 * @lc app=leetcode id=1302 lang=java
 *
 * [1302] Deepest Leaves Sum
 *
 * https://leetcode.com/problems/deepest-leaves-sum/description/
 *
 * algorithms
 * Medium (83.50%)
 * Likes:    318
 * Dislikes: 21
 * Total Accepted:    27.9K
 * Total Submissions: 33.4K
 * Testcase Example:  '[1,2,3,4,5,null,6,7,null,null,null,null,8]'
 *
 * Given a binary tree, return the sum of values of its deepest leaves.
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
 * Output: 15
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is between 1 and 10^4.
 * The value of nodes is between 1 and 100.
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
    
    int deepestLevel = -1;
    int deepestSum = 0;
    
    public int deepestLeavesSum(TreeNode root) {
        dfs(root, 0);
        return deepestSum;
    }
    
    private void dfs(TreeNode root, int level) {
        if (root == null) return;
        
        if (root.left != null || root.right != null) {
            dfs(root.left, level + 1);
            dfs(root.right, level + 1);
        } else {
            if (level > deepestLevel) {
                deepestLevel = level;
                deepestSum = root.val;
            } else if (level == deepestLevel) {
                deepestSum += root.val;
            }
        }
    }
}
// @lc code=end

