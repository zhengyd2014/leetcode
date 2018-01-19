/*
 * [239] Sliding Window Maximum
 *
 * https://leetcode.com/problems/sliding-window-maximum/description/
 *
 * algorithms
 * Hard (33.83%)
 * Total Accepted:    78.8K
 * Total Submissions: 232.9K
 * Testcase Example:  '[]\n0'
 *
 * Given an array nums, there is a sliding window of size k which is moving
 * from the very left of the array to the very right. You can only see the k
 * numbers in the window. Each time the sliding window moves right by one
 * position.
 * 
 * For example,
 * Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
 * 
 * 
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * ⁠1 [3  -1  -3] 5  3  6  7       3
 * ⁠1  3 [-1  -3  5] 3  6  7       5
 * ⁠1  3  -1 [-3  5  3] 6  7       5
 * ⁠1  3  -1  -3 [5  3  6] 7       6
 * ⁠1  3  -1  -3  5 [3  6  7]      7
 * 
 * 
 * Therefore, return the max sliding window as [3,3,5,5,6,7].
 * 
 * Note: 
 * You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for
 * non-empty array.
 * 
 * Follow up:
 * Could you solve it in linear time?
 */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
		int n = nums.length;
		if (k == 0) {
			return nums;
		}

		Deque<Integer> q = new LinkedList<>();
		int[] max = new int[n - k + 1];
		for (int i = 0; i < n; i++) {
			addToDeque(q, nums[i]);
			if (i >= k - 1) {
				max[i - k + 1] = q.peekFirst();
				if (q.peekFirst() == nums[i - k + 1]) {
					q.removeFirst();
				}
			}
		}

		return max;
    }

	private void addToDeque(Deque<Integer> q, int data) {
		while (!q.isEmpty() && q.peekLast() < data) {
			q.removeLast();
		}

		q.addLast(data);
	}
}
