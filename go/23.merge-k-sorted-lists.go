/*
 * [23] Merge k Sorted Lists
 *
 * https://leetcode.com/problems/merge-k-sorted-lists/description/
 *
 * algorithms
 * Hard (28.15%)
 * Total Accepted:    219.2K
 * Total Submissions: 777.4K
 * Testcase Example:  '[[1,4,5],[1,3,4],[2,6]]'
 *
 * Merge k sorted linked lists and return it as one sorted list. Analyze and
 * describe its complexity.
 * 
 * Example:
 * 
 * 
 * Input:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 * 
 * 
 */
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func mergeKLists(lists []*ListNode) *ListNode {
	if lists == nil || len(lists) == 0 {
		return nil
	}

	start, end := 0, len(lists) - 1
	for end > 0 {
		if start >= end {
			start = 0
		}
		lists[start] = merge2Lists(lists[start], lists[end])
		start++
		end--
	}

	return lists[0]
}

func merge2Lists(l1 *ListNode, l2 *ListNode) *ListNode {
	if l1 == nil && l2 == nil {
		return nil	
	} else if l1 == nil {
		return l2
	} else if l2 == nil {
		return l1
	}

	if (l1.Val < l2.Val) {
		l1.Next = merge2Lists(l1.Next, l2)
		return l1
	} else {
		l2.Next = merge2Lists(l1, l2.Next)
		return l2
	}
}
