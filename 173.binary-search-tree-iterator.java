/*
 * [173] Binary Search Tree Iterator
 *
 * https://leetcode.com/problems/binary-search-tree-iterator/description/
 *
 * algorithms
 * Medium (43.05%)
 * Total Accepted:    118.3K
 * Total Submissions: 274.7K
 * Testcase Example:  '[]'
 *
 * Implement an iterator over a binary search tree (BST). Your iterator will be
 * initialized with the root node of a BST.
 * 
 * Calling next() will return the next smallest number in the BST.
 * 
 * Note: next() and hasNext() should run in average O(1) time and uses O(h)
 * memory, where h is the height of the tree. 
 * 
 * Credits:Special thanks to @ts for adding this problem and creating all test
 * cases.
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
	private Stack<TreeNode> leftNodes;

    public BSTIterator(TreeNode root) {
		leftNodes = new Stack<>();
		leftNodesInStack(root);	
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !leftNodes.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode p = leftNodes.pop();
		leftNodesInStack(p.right);
		return p.val;
    }

	private void leftNodesInStack(TreeNode p) {
		while (p != null) {
			leftNodes.push(p);
			p = p.left;
		}
	}
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
