/*
 * @lc app=leetcode id=74 lang=java
 *
 * [74] Search a 2D Matrix
 *
 * https://leetcode.com/problems/search-a-2d-matrix/description/
 *
 * algorithms
 * Medium (36.02%)
 * Likes:    1520
 * Dislikes: 150
 * Total Accepted:    305.8K
 * Total Submissions: 846.1K
 * Testcase Example:  '[[1,3,5,7],[10,11,16,20],[23,30,34,50]]\n3'
 *
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * 
 * 
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the
 * previous row.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input:
 * matrix = [
 * ⁠ [1,   3,  5,  7],
 * ⁠ [10, 11, 16, 20],
 * ⁠ [23, 30, 34, 50]
 * ]
 * target = 3
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * matrix = [
 * ⁠ [1,   3,  5,  7],
 * ⁠ [10, 11, 16, 20],
 * ⁠ [23, 30, 34, 50]
 * ]
 * target = 13
 * Output: false
 * 
 */

// @lc code=start

// 74. Search a 2D Matrix

// pay attent to corner case of not entering while loop. make sure l / h still valid as index.
//  ex. [[1, 1]], 0  

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0;
        int h = m * n - 1;
        while (l + 1 < h) {
            int mid = l + (h - l) / 2;
            int r = mid / n;
            int c = mid % n;
            if (matrix[r][c] == target) return true;
            else if (matrix[r][c] > target) h = mid;
            else l = mid;
        }
        
        if (matrix[l/n][l%n] == target || matrix[h/n][h%n] == target) return true;
        return false;
    }
}

// @lc code=end

