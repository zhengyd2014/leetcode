/*
 * @lc app=leetcode id=542 lang=java
 *
 * [542] 01 Matrix
 *
 * https://leetcode.com/problems/01-matrix/description/
 *
 * algorithms
 * Medium (38.70%)
 * Likes:    1378
 * Dislikes: 102
 * Total Accepted:    82.9K
 * Total Submissions: 210.7K
 * Testcase Example:  '[[0,0,0],[0,1,0],[0,0,0]]'
 *
 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for
 * each cell.
 * 
 * The distance between two adjacent cells is 1.
 * 
 * 
 * 
 * Example 1: 
 * 
 * 
 * Input:
 * [[0,0,0],
 * ⁠[0,1,0],
 * ⁠[0,0,0]]
 * 
 * Output:
 * [[0,0,0],
 * [0,1,0],
 * [0,0,0]]
 * 
 * 
 * Example 2: 
 * 
 * 
 * Input:
 * [[0,0,0],
 * ⁠[0,1,0],
 * ⁠[1,1,1]]
 * 
 * Output:
 * [[0,0,0],
 * ⁠[0,1,0],
 * ⁠[1,2,1]]
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * The number of elements of the given matrix will not exceed 10,000.
 * There are at least one 0 in the given matrix.
 * The cells are adjacent in only four directions: up, down, left and right.
 * 
 * 
 */

// @lc code=start

// start from all '0's in queue

class Solution {
    int[][] dirs = new int[][] {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return matrix;
        int m = matrix.length;
        int n = matrix[0].length;
        
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (matrix[r][c] == 0) {
                    q.offer(new int[] {r, c});
                    visited[r][c] = true;
                }
            }
        }
        
        int step = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];
                matrix[r][c] = step;
                
                for (int[] dir : dirs) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n || matrix[nr][nc] == 0 || visited[nr][nc]) continue;
                    visited[nr][nc] = true;
                    q.offer(new int[] {nr, nc});
                }
            }
            step++;
        }
        
        return matrix;
    }
}
// @lc code=end

