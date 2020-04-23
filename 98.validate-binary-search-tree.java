/*
 * [98] Validate Binary Search Tree
 *
 * https://leetcode.com/problems/validate-binary-search-tree/description/
 *
 * algorithms
 * Medium (23.93%)
 * Total Accepted:    211.1K
 * Total Submissions: 882.1K
 * Testcase Example:  '[2,1,3]'
 *
 * 
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * 
 * 
 * Assume a BST is defined as follows:
 * 
 * The left subtree of a node contains only nodes with keys less than the
 * node's key.
 * The right subtree of a node contains only nodes with keys greater than the
 * node's key.
 * Both the left and right subtrees must also be binary search trees.
 * 
 * 
 * 
 * Example 1:
 * 
 * ⁠   2
 * ⁠  / \
 * ⁠ 1   3
 * 
 * Binary tree [2,1,3], return true.
 * 
 * 
 * Example 2:
 * 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   3
 * 
 * Binary tree [1,2,3], return false.
 * 
 */
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
    public boolean isValidBST(TreeNode root) {
		return isValidBST(root, null, null);
    }

	public boolean isValidBST(TreeNode root, Integer low, Integer high) {
		if (root == null) {
			return true;
		}

		if (low != null && root.val <= low) {
			return false;
		}

		if (high != null && root.val >= high) {
			return false;
		}

		return isValidBST(root.left, low, root.val) && isValidBST(root.right, root.val, high);
	}
}


class Solution2 {
    TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        if (!isValidBST(root.left)) return false;
        if (prev != null && root.val <= prev.val) return false;
        prev = root;
        if (!isValidBST(root.right)) return false;
        return true;
    }
}
