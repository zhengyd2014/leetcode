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
		ListNode dummyHead = new ListNode(0);
		ListNode prev = dummyHead;
		Queue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

		for (ListNode node : lists) {
			if (node != null) {
				minHeap.offer(node);
			}
		}		

		while (!minHeap.isEmpty()) {
			ListNode curr = minHeap.poll();
			prev.next = curr;
			prev = curr;
			if (curr.next != null) {
				minHeap.offer(curr.next);
			}
		}

		return dummyHead.next;
    }
}
