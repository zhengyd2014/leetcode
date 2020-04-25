import java.util.Set;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=968 lang=java
 *
 * [968] Binary Tree Cameras
 *
 * https://leetcode.com/problems/binary-tree-cameras/description/
 *
 * algorithms
 * Hard (36.75%)
 * Likes:    580
 * Dislikes: 12
 * Total Accepted:    16.3K
 * Total Submissions: 44.2K
 * Testcase Example:  '[0,0,null,0,0]'
 *
 * Given a binary tree, we install cameras on the nodes of the tree. 
 * 
 * Each camera at a node can monitor its parent, itself, and its immediate
 * children.
 * 
 * Calculate the minimum number of cameras needed to monitor all nodes of the
 * tree.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * Input: [0,0,null,0,0]
 * Output: 1
 * Explanation: One camera is enough to monitor all nodes if placed as
 * shown.
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [0,0,null,0,null,0,null,null,0]
 * Output: 2
 * Explanation: At least two cameras are needed to monitor all nodes of the
 * tree. The above image shows one of the valid configurations of camera
 * placement.
 * 
 * 
 * 
 * Note:
 * 
 * 
 * The number of nodes in the given tree will be in the range [1, 1000].
 * Every node has value 0.
 * 
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



 /*
  *   greedy, bottom up, just to check if need to place a camera 
  *   at current node.  
  *
  *   if any child is not covered, need to 
  *   or if itself is not covered, and parent is null, need to.
  */
class Solution {

    int ans;
    Set<TreeNode> covered;
    public int minCameraCover(TreeNode root) {
        ans = 0;
        covered = new HashSet<>();
        covered.add(null);
        dfs(root, null);
        return ans;
    }

    private void dfs(TreeNode node, TreeNode parent) {
        if (node == null) return;

        dfs(node.left, node);
        dfs(node.right, node);

        if (!covered.contains(node.left) 
            || !covered.contains(node.right) 
            || (!covered.contains(node) && parent == null)) {
                ans++;
                covered.add(node);
                covered.add(node.left);
                covered.add(node.right);
                covered.add(parent);
            }
    }
}
// @lc code=end

