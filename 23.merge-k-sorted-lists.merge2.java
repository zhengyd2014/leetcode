/*
 * [23] Merge k Sorted Lists
 *
 * https://leetcode.com/problems/merge-k-sorted-lists/description/
 *
 * algorithms
 * Hard (28.01%)
 * Total Accepted:    202.9K
 * Total Submissions: 724.3K
 * Testcase Example:  '[]'
 *
 * 
 * Merge k sorted linked lists and return it as one sorted list. Analyze and
 * describe its complexity.
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
    public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
			return null; 
		}		

		int end = lists.length - 1;
		while (end > 0) {
			int begin = 0;
			while (begin < end) {
				lists[begin] = merge2SortedList(lists[begin], lists[end]);
				begin++;
				end--;
			}
		}

		return lists[0];
    }

	private ListNode merge2SortedList(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode prev = dummy;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				prev.next = l1;
				l1 = l1.next;
			} else {
				prev.next = l2;
				l2 = l2.next;
			}
			prev = prev.next;
		}

		prev.next = l1 == null ? l2 : l1;
		return dummy.next;
	}
}
