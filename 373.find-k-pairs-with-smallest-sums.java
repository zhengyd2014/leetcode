/*
 * @lc app=leetcode id=373 lang=java
 *
 * [373] Find K Pairs with Smallest Sums
 *
 * https://leetcode.com/problems/find-k-pairs-with-smallest-sums/description/
 *
 * algorithms
 * Medium (35.68%)
 * Likes:    1129
 * Dislikes: 90
 * Total Accepted:    92K
 * Total Submissions: 257.4K
 * Testcase Example:  '[1,7,11]\n[2,4,6]\n3'
 *
 * You are given two integer arrays nums1 and nums2 sorted in ascending order
 * and an integer k.
 * 
 * Define a pair (u,v) which consists of one element from the first array and
 * one element from the second array.
 * 
 * Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
 * 
 * Example 1:
 * 
 * 
 * Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * Output: [[1,2],[1,4],[1,6]] 
 * Explanation: The first 3 pairs are returned from the sequence: 
 * [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * 
 * Example 2:
 * 
 * 
 * Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 * Output: [1,1],[1,1]
 * Explanation: The first 2 pairs are returned from the sequence: 
 * [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 * 
 * Example 3:
 * 
 * 
 * Input: nums1 = [1,2], nums2 = [3], k = 3
 * Output: [1,3],[2,3]
 * Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]
 * 
 * 
 */

// @lc code=start


// 373. Find K Pairs with Smallest Sums

// pq<int[2]>:   a[0]: index of nums1, a[1]: index of nums2
// pair of nums1 and nums2 like a m-way merge.
/*
 *   Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 *        1    2    3
 *     ---------------------
 *   1 |  2    3    4         <--- row into PriorityQueue
 *   1 |  2    3    4
 *   2 |  3    4    5
 */

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums1.length == 0 ||nums2.length == 0) return result;
        
        PriorityQueue<int[]> q = new PriorityQueue<>(
            (a, b) -> (nums1[a[0]] + nums2[a[1]] - nums1[b[0]] - nums2[b[1]])
        );
        
        for (int i = 0; i < nums2.length; i++) {
            q.offer(new int[] {0, i});
        }
        
        while (!q.isEmpty() && k > 0) {
            int[] pair = q.poll();
            System.out.println("[" + pair[0] + "," + pair[1] + "]");
            List<Integer> list = new ArrayList<>();
            list.add(nums1[pair[0]]);
            list.add(nums2[pair[1]]);
            result.add(list);
            if (pair[0] < nums1.length - 1) {
                q.offer(new int[] {pair[0] + 1, pair[1]});
            }
            k--;
        }
        
        return result;
    }
}

// @lc code=end

