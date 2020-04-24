/*
 * @lc app=leetcode id=113 lang=java
 *
 * [113] Path Sum II
 *
 * https://leetcode.com/problems/path-sum-ii/description/
 *
 * algorithms
 * Medium (44.91%)
 * Likes:    1475
 * Dislikes: 52
 * Total Accepted:    307.1K
 * Total Submissions: 681.7K
 * Testcase Example:  '[5,4,8,11,null,13,4,7,2,null,null,5,1]\n22'
 *
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's
 * sum equals the given sum.
 * 
 * Note: A leaf is a node with no children.
 * 
 * Example:
 * 
 * Given the below binary tree and sum = 22,
 * 
 * 
 * ⁠     5
 * ⁠    / \
 * ⁠   4   8
 * ⁠  /   / \
 * ⁠ 11  13  4
 * ⁠/  \    / \
 * 7    2  5   1
 * 
 * 
 * Return:
 * 
 * 
 * [
 * ⁠  [5,4,11,2],
 * ⁠  [5,8,4,5]
 * ]
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, sum, new ArrayList<Integer>(), result);
        return result;
    }
    
    private void dfs(TreeNode root, int sum, List<Integer> path, List<List<Integer>> result) {
        if (root == null) return;

        path.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            result.add(new ArrayList<Integer>(path));
        }
        dfs(root.left, sum - root.val, path, result);
        dfs(root.right, sum - root.val, path ,result);
        path.remove(path.size() - 1);
    }
}
// @lc code=end

