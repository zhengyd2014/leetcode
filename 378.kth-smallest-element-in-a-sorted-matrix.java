/*
 * @lc app=leetcode id=378 lang=java
 *
 * [378] Kth Smallest Element in a Sorted Matrix
 *
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/
 *
 * algorithms
 * Medium (52.72%)
 * Likes:    2032
 * Dislikes: 115
 * Total Accepted:    169.5K
 * Total Submissions: 319.5K
 * Testcase Example:  '[[1,5,9],[10,11,13],[12,13,15]]\n8'
 *
 * Given a n x n matrix where each of the rows and columns are sorted in
 * ascending order, find the kth smallest element in the matrix.
 * 
 * 
 * Note that it is the kth smallest element in the sorted order, not the kth
 * distinct element.
 * 
 * 
 * Example:
 * 
 * matrix = [
 * ⁠  [ 1,  5,  9],
 * ⁠  [10, 11, 13],
 * ⁠  [12, 13, 15]
 * ],
 * k = 8,
 * 
 * return 13.
 * 
 * 
 * 
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ n^2.
 */

// @lc code=start

// 378. Kth Smallest Element in a Sorted Matrix

// pq: like m-way merge

class Solution {

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        
        // a[row][col][val], sort by val
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2] - b[2]);
        for (int c = 0; c < n; c++) pq.offer(new int[] {0, c, matrix[0][c]});
        
        for (int i = 0; i < k - 1; i++) {
            int[] element = pq.poll();
            int row = element[0] + 1;
            int col = element[1];
            if (row < n) pq.offer(new int[] {row, col, matrix[row][col]});
        }
        
        return pq.poll()[2];
    }
}

// @lc code=end

