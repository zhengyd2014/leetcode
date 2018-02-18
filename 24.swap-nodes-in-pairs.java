/*
 * [24] Swap Nodes in Pairs
 *
 * https://leetcode.com/problems/swap-nodes-in-pairs/description/
 *
 * algorithms
 * Medium (38.97%)
 * Total Accepted:    202.1K
 * Total Submissions: 518.5K
 * Testcase Example:  '[]'
 *
 * 
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * 
 * 
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 * 
 * 
 * Your algorithm should use only constant space. You may not modify the values
 * in the list, only nodes itself can be changed.
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
    public ListNode swapPairs(ListNode head) {
		ListNode dummyHead = new ListNode(0);
		ListNode prev = dummyHead;
		dummyHead.next = head;
		while (head != null && head.next != null) {
			ListNode next = head.next;
			ListNode nextHead = head.next.next;
			prev.next = next;
			next.next = head;
			head.next = nextHead;
			prev = head;
			head = nextHead;
		}
		return dummyHead.next;		
    }
}
