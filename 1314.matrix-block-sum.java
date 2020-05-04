/*
 * @lc app=leetcode id=1314 lang=java
 *
 * [1314] Matrix Block Sum
 *
 * https://leetcode.com/problems/matrix-block-sum/description/
 *
 * algorithms
 * Medium (72.41%)
 * Likes:    205
 * Dislikes: 40
 * Total Accepted:    9.6K
 * Total Submissions: 13.3K
 * Testcase Example:  '[[1,2,3],[4,5,6],[7,8,9]]\n1'
 *
 * Given a m * n matrix mat and an integer K, return a matrix answer where each
 * answer[i][j] is the sum of all elements mat[r][c] for i - K <= r <= i + K, j
 * - K <= c <= j + K, and (r, c) is a valid position in the matrix.
 * 
 * Example 1:
 * 
 * 
 * Input: mat = [[1,2,3],[4,5,6],[7,8,9]], K = 1
 * Output: [[12,21,16],[27,45,33],[24,39,28]]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: mat = [[1,2,3],[4,5,6],[7,8,9]], K = 2
 * Output: [[45,45,45],[45,45,45],[45,45,45]]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n, K <= 100
 * 1 <= mat[i][j] <= 100
 * 
 */

// @lc code=start
class Solution {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) return mat;
        
        int m = mat.length;
        int n = mat[0].length; 
        int[][] sum = new int[m][n];
        
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                sum[r][c] = mat[r][c] + getByPosition(sum, r-1, c) + getByPosition(sum, r, c-1) - getByPosition(sum, r-1, c-1);
                System.out.println(sum[r][c]);
            }
        }
        
        int[][] ans = new int[m][n];
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                ans[r][c] = getByPosition(sum, r+K, c+K) - getByPosition(sum, r-K-1, c+K) - getByPosition(sum, r+K, c-K-1) + getByPosition(sum, r-K-1, c-K-1);
            }
        }
        
        return ans;
    }

    private int getByPosition(int[][] matrix, int r, int c) {
        if (r < 0 || c < 0) return 0;
        int row = Math.min(matrix.length - 1, r);
        int col = Math.min(matrix[0].length - 1, c);
        return matrix[row][col];
    }
}
// @lc code=end

