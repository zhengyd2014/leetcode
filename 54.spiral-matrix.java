/*
 * @lc app=leetcode id=54 lang=java
 *
 * [54] Spiral Matrix
 *
 * https://leetcode.com/problems/spiral-matrix/description/
 *
 * algorithms
 * Medium (33.06%)
 * Likes:    2234
 * Dislikes: 558
 * Total Accepted:    359K
 * Total Submissions: 1.1M
 * Testcase Example:  '[[1,2,3],[4,5,6],[7,8,9]]'
 *
 * Given a matrix of m x n elements (m rows, n columns), return all elements of
 * the matrix in spiral order.
 * 
 * Example 1:
 * 
 * 
 * Input:
 * [
 * ⁠[ 1, 2, 3 ],
 * ⁠[ 4, 5, 6 ],
 * ⁠[ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * 
 * 
 * Example 2:
 * 
 * Input:
 * [
 * ⁠ [1, 2, 3, 4],
 * ⁠ [5, 6, 7, 8],
 * ⁠ [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 * 
 */

// @lc code=start
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) return ans;
        int m = matrix.length;
        int n = matrix[0].length;
        int up = 0, down = m-1, left = 0, right = n-1;
       
        while (true) {
            for (int i = left; i <= right; i++) ans.add(matrix[up][i]);
            if (++up > down) break;
            for (int i = up; i <= down; i++) ans.add(matrix[i][right]);
            if (--right < left) break;
            for (int i = right; i >= left; i--) ans.add(matrix[down][i]);
            if (--down < up) break;
            for (int i = down; i >= up; i--) ans.add(matrix[i][left]);
            if (++left > right) break;
        }

        return ans;
    }
}
// @lc code=end

