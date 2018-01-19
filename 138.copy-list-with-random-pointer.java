/*
 * [138] Copy List with Random Pointer
 *
 * https://leetcode.com/problems/copy-list-with-random-pointer/description/
 *
 * algorithms
 * Medium (25.99%)
 * Total Accepted:    141.5K
 * Total Submissions: 544.1K
 * Testcase Example:  '{}'
 *
 * 
 * A linked list is given such that each node contains an additional random
 * pointer which could point to any node in the list or null.
 * 
 * 
 * 
 * Return a deep copy of the list.
 * 
 */
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
		Map<RandomListNode, RandomListNode> map = new HashMap<>();
		if (head == null) {
			return null;
		}

		RandomListNode curr = head;
		RandomListNode prev = null;
		while (curr != null) {
			RandomListNode node = new RandomListNode(curr.label);
			map.put(curr, node);
			curr = curr.next;
			if (prev != null) {
				prev.next = node;
			}
			prev = node;
		}		

		curr = head;
		while (curr != null) {
			map.get(curr).random = map.get(curr.random);
			curr = curr.next;
		}

		return map.get(head);
    }
}
