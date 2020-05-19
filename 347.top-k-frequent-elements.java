/*
 * @lc app=leetcode id=347 lang=java
 *
 * [347] Top K Frequent Elements
 *
 * https://leetcode.com/problems/top-k-frequent-elements/description/
 *
 * algorithms
 * Medium (59.51%)
 * Likes:    2680
 * Dislikes: 197
 * Total Accepted:    354.4K
 * Total Submissions: 592.7K
 * Testcase Example:  '[1,1,1,2,2,3]\n2'
 *
 * Given a non-empty array of integers, return the k most frequent elements.
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1], k = 1
 * Output: [1]
 * 
 * 
 * Note: 
 * 
 * 
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is
 * the array's size.
 * It's guaranteed that the answer is unique, in other words the set of the top
 * k frequent elements is unique.
 * You can return the answer in any order.
 * 
 * 
 */

// @lc code=start

// 347. Top K Frequent Elements

// pq: o(nlogk) 
//   note: the order function can call count func outside

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) count.put(num, count.getOrDefault(num, 0) + 1);
        
        // asc order num by its count
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(
            (a, b) -> count.get(a) - count.get(b));
        
        int index = 0;
        for (int num : count.keySet()) {
            if (index++ < k) pq.add(num);
            else if (count.get(num) > count.get(pq.peek())) {
                pq.poll();
                pq.offer(num);
            }
        }
        
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) ans[i] = pq.poll();
        return ans;
    }
}

// @lc code=end

