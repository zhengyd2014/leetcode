/*
 * [109] Convert Sorted List to Binary Search Tree
 *
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/description/
 *
 * algorithms
 * Medium (34.96%)
 * Total Accepted:    123.5K
 * Total Submissions: 353.1K
 * Testcase Example:  '[-10,-3,0,5,9]'
 *
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more
 * than 1.
 * 
 * 
 * 
 * 
 * Example:
 * 
 * Given the sorted linked list: [-10,-3,0,5,9],
 * 
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following
 * height balanced BST:
 * 
 * ⁠     0
 * ⁠    / \
 * ⁠  -3   9
 * ⁠  /   /
 * ⁠-10  5
 * 
 * 
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
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
	ListNode list;

    public TreeNode sortedListToBST(ListNode head) {
		if (head == null) {
			return null;
		}	

		list = head;
		int len = 0;
		while (head != null) {
			len++;
			head = head.next;
		}
		return sortedListToBST(0, len - 1);
    }

	private TreeNode sortedListToBST(int start, int end) {
		if (start > end) {
			return null;
		}

		int mid = start + (end - start) / 2;
		TreeNode left = sortedListToBST(start, mid - 1);
		TreeNode parent = new TreeNode(list.val);
		list = list.next;
		parent.left = left;
		parent.right = sortedListToBST(mid + 1, end);
		return parent;
	}
}
