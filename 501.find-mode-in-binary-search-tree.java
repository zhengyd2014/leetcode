/*
 * [501] Find Mode in Binary Search Tree
 *
 * https://leetcode.com/problems/find-mode-in-binary-search-tree/description/
 *
 * algorithms
 * Easy (37.80%)
 * Total Accepted:    27.9K
 * Total Submissions: 73.9K
 * Testcase Example:  '[1,null,2,2]'
 *
 * Given a binary search tree (BST) with duplicates, find all the mode(s) (the
 * most frequently occurred element) in the given BST.
 * 
 * 
 * Assume a BST is defined as follows:
 * 
 * The left subtree of a node contains only nodes with keys less than or equal
 * to the node's key.
 * The right subtree of a node contains only nodes with keys greater than or
 * equal to the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * 
 * 
 * 
 * 
 * For example:
 * Given BST [1,null,2,2],
 * 
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  2
 * 
 * 
 * 
 * return [2].
 * 
 * 
 * Note:
 * If a tree has more than one mode, you can return them in any order.
 * 
 * 
 * Follow up:
 * Could you do that without using any extra space? (Assume that the implicit
 * stack space incurred due to recursion does not count).
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
	int maxCount = 0;
	List<Integer> maxElements = new ArrayList<>();
	Integer curr;
	int curCount = 0;

    public int[] findMode(TreeNode root) {
        inorder(root);
		int[] result = new int[maxElements.size()];
		for (int i = 0; i < maxElements.size(); i++) {
			result[i] = maxElements.get(i);
		}

		return result;
    }

	private void inorder(TreeNode root) {
		if (root == null) {
			return;
		}

		inorder(root.left);
		handleValue(root.val);
		inorder(root.right);
	}

	private void handleValue(int val) {
		if (curr != null && curr == val) {
			curCount++;
		} else {
			curCount = 1;
			curr = val;
		}

		if (curCount == maxCount) {
			maxElements.add(val);
		} else if (curCount > maxCount) {
			maxElements.clear();
			maxElements.add(val);
			maxCount = curCount;
		}
	}
}
