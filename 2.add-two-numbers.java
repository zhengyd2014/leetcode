/*
 * [2] Add Two Numbers
 *
 * https://leetcode.com/problems/add-two-numbers
 *
 * algorithms
 * Medium (28.15%)
 * Total Accepted:    399.6K
 * Total Submissions: 1.4M
 * Testcase Example:  '[2,4,3]\n[5,6,4]'
 *
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * 
 * Example
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
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
		if (l1 == null) {
			return l2;
		}

		if (l2 == null) {
			return l1;
		}

		int carry = 0;
		ListNode dummyHead = new ListNode(0);
		ListNode cur = dummyHead;
		while (l1 != null || l2 != null) {
			int num1 = l1 == null ? 0 : l1.val;
			int num2 = l2 == null ? 0 : l2.val;
			int sum = carry + num1 + num2;
			carry = sum / 10;
			cur.next = new ListNode(sum % 10);
			cur = cur.next;
			if (l1 != null) l1 = l1.next;
			if (l2 != null) l2 = l2.next;
		}		

		if (carry != 0) {
			cur.next = new ListNode(carry);
		}

		return dummyHead.next;
    }
}
