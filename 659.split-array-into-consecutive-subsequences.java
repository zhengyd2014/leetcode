/*
 * @lc app=leetcode id=659 lang=java
 *
 * [659] Split Array into Consecutive Subsequences
 *
 * https://leetcode.com/problems/split-array-into-consecutive-subsequences/description/
 *
 * algorithms
 * Medium (42.98%)
 * Likes:    933
 * Dislikes: 362
 * Total Accepted:    38.7K
 * Total Submissions: 89.8K
 * Testcase Example:  '[1,2,3,3,4,5]'
 *
 * Given an array nums sorted in ascending order, return true if and only if
 * you can split it into 1 or more subsequences such that each subsequence
 * consists of consecutive integers and has length at least 3.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: [1,2,3,3,4,5]
 * Output: True
 * Explanation:
 * You can split them into two consecutive subsequences : 
 * 1, 2, 3
 * 3, 4, 5
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [1,2,3,3,4,4,5,5]
 * Output: True
 * Explanation:
 * You can split them into two consecutive subsequences : 
 * 1, 2, 3, 4, 5
 * 3, 4, 5
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: [1,2,3,4,4,5]
 * Output: False
 * 
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 10000
 * 
 * 
 * 
 * 
 */

// @lc code=start

// 659. Split Array into Consecutive Subsequences

// Map + PQ
// pq records the len of the chain ending for current element

// https://www.junhaow.com/lc/problems/heap/659_split-array-into-consecutive-subsequences.html

class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        
        for (int num : nums) {
            if (map.containsKey(num-1) && map.get(num-1).size() > 0) {
                int len = map.get(num-1).poll();
                map.putIfAbsent(num, new PriorityQueue<Integer>());
                map.get(num).offer(len + 1);
            } else {
                map.putIfAbsent(num, new PriorityQueue<Integer>());
                map.get(num).offer(1);
            }
        }
        
        for (PriorityQueue<Integer> pq : map.values()) {
            while (!pq.isEmpty()) {
                if (pq.poll() < 3) return false;
            }
        }
        return true;
    }
}

// @lc code=end

