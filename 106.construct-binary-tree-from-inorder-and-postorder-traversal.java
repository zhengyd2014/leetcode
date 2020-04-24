/*
 * @lc app=leetcode id=106 lang=java
 *
 * [106] Construct Binary Tree from Inorder and Postorder Traversal
 *
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
 *
 * algorithms
 * Medium (43.72%)
 * Likes:    1383
 * Dislikes: 29
 * Total Accepted:    201.7K
 * Total Submissions: 459.6K
 * Testcase Example:  '[9,3,15,20,7]\n[9,15,7,20,3]'
 *
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * 
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * 
 * For example, given
 * 
 * 
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
 * 
 * Return the following binary tree:
 * 
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        return helper(inorder, 0, len - 1, postorder, 0, len - 1);
    }
    
    private TreeNode helper(int[] inorder, int is, int ie, int[] postorder, int ps, int pe) {
        if (is > ie) return null;
        
        TreeNode root = new TreeNode(postorder[pe]);
        int index = is;
        while(index <= ie) {
            if (inorder[index] == root.val) break;
            index++;
        }
        
        root.left = helper(inorder, is, index - 1, postorder, ps, ps + index - is - 1);
        root.right = helper(inorder, index + 1, ie, postorder, pe - ie + index, pe - 1);
        return root;
    }
}
// @lc code=end

