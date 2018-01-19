/*
 * [445] Add Two Numbers II
 *
 * https://leetcode.com/problems/add-two-numbers-ii/description/
 *
 * algorithms
 * Medium (45.99%)
 * Total Accepted:    39.8K
 * Total Submissions: 86.5K
 * Testcase Example:  '[7,2,4,3]\n[5,6,4]'
 *
 * You are given two non-empty linked lists representing two non-negative
 * integers. The most significant digit comes first and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the
 * lists is not allowed.
 * 
 * 
 * 
 * Example:
 * 
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
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
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = listToStack(l1);
		Stack<Integer> stack2 = listToStack(l2);
		int carry = 0;
		ListNode head = null;
		while (!stack1.isEmpty() || !stack2.isEmpty()) {
			int num1 = !stack1.isEmpty() ? stack1.pop() : 0;
			int num2 = !stack2.isEmpty() ? stack2.pop() : 0;
			int sum = num1 + num2 + carry;
			carry = sum / 10;
			ListNode node = new ListNode(sum % 10);
			node.next = head;
			head = node;
		}

		if (carry != 0) {
			ListNode node = new ListNode(carry);
			node.next = head;
			head = node;
		}

		return head;
    }

	public Stack<Integer> listToStack(ListNode l) {
		Stack<Integer> stack = new Stack<>();
		while (l != null) {
			stack.push(l.val);
			l = l.next;
		}

		return stack;
	}
}
