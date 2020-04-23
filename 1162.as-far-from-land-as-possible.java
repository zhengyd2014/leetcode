/*
 * @lc app=leetcode id=1162 lang=java
 *
 * [1162] As Far from Land as Possible
 *
 * https://leetcode.com/problems/as-far-from-land-as-possible/description/
 *
 * algorithms
 * Medium (42.09%)
 * Likes:    282
 * Dislikes: 16
 * Total Accepted:    13.2K
 * Total Submissions: 31.4K
 * Testcase Example:  '[[1,0,1],[0,0,0],[1,0,1]]'
 *
 * Given an N x N grid containing only values 0 and 1, where 0 represents water
 * and 1 represents land, find a water cell such that its distance to the
 * nearest land cell is maximized and return the distance.
 * 
 * The distance used in this problem is the Manhattan distance: the distance
 * between two cells (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1|.
 * 
 * If no land or water exists in the grid, return -1.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * Input: [[1,0,1],[0,0,0],[1,0,1]]
 * Output: 2
 * Explanation: 
 * The cell (1, 1) is as far as possible from all the land with distance 2.
 * 
 * 
 * Example 2:
 * 
 * 
 * 
 * 
 * Input: [[1,0,0],[0,0,0],[0,0,0]]
 * Output: 4
 * Explanation: 
 * The cell (2, 2) is as far as possible from all the land with distance
 * 4.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= grid.length == grid[0].length <= 100
 * grid[i][j] is 0 or 1
 * 
 * 
 */

// @lc code=start

// explanation
// https://www.acwing.com/solution/LeetCode/content/3971/
class Solution {
    public int maxDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        int m = grid.length;
        int n = grid[0].length;
        int[][] dist = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) {
                    dist[r][c] = 0;
                    q.offer(new int[] {r, c});
                }
                else if (grid[r][c] == 0) dist[r][c] = Integer.MAX_VALUE;
            }
        }

        int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while(!q.isEmpty()) {
            int[] curr = q.poll();

            for (int[] d : directions) {
                int r = curr[0] + d[0];
                int c = curr[1] + d[1];
                if (r < 0 || r >= m || c < 0 || c >= n) continue;

                if (dist[r][c] > dist[curr[0]][curr[1]] + 1) {
                    dist[r][c] = dist[curr[0]][curr[1]] + 1;
                    q.offer(new int[] {r, c});
                }
            }
        }
        
        int ans = -1;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (dist[r][c] == 0 || dist[r][c] == Integer.MAX_VALUE) continue;
                ans = Math.max(ans, dist[r][c]);
            }
        } 

        return ans;
    }
}
// @lc code=end

