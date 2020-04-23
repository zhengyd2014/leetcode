/*
 * @lc app=leetcode id=130 lang=java
 *
 * [130] Surrounded Regions
 *
 * https://leetcode.com/problems/surrounded-regions/description/
 *
 * algorithms
 * Medium (25.79%)
 * Likes:    1269
 * Dislikes: 569
 * Total Accepted:    194.2K
 * Total Submissions: 753.3K
 * Testcase Example:  '[["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]'
 *
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions
 * surrounded by 'X'.
 * 
 * A region is captured by flipping all 'O's into 'X's in that surrounded
 * region.
 * 
 * Example:
 * 
 * 
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 
 * 
 * After running your function, the board should be:
 * 
 * 
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 
 * 
 * Explanation:
 * 
 * Surrounded regions shouldn’t be on the border, which means that any 'O' on
 * the border of the board are not flipped to 'X'. Any 'O' that is not on the
 * border and it is not connected to an 'O' on the border will be flipped to
 * 'X'. Two cells are connected if they are adjacent cells connected
 * horizontally or vertically.
 * 
 */

// @lc code=start
class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;

        int m = board.length;
        int n = board[0].length;

        for (int r = 0; r < m; r++) {
            dfs(board, r, 0, 'O', '.');
            dfs(board, r, n - 1, 'O', '.');
        }

        for (int c = 0; c < n; c++) {
            dfs(board, 0, c, 'O', '.');
            dfs(board, m - 1, c, 'O', '.');
        }

        for (int r = 1; r < m; r++) {
            for (int c = 1; c < n; c++) {
                dfs(board, r, c, 'O', 'X');
            }
        }

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                dfs(board, r, c, '.', 'O');
            }
        }

    }

    private void dfs(char[][] board, int r, int c, char original, char changeto) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length) return;
        if (board[r][c] != original) return;

        board[r][c] = changeto;
        dfs(board, r + 1, c, original, changeto);
        dfs(board, r - 1, c, original, changeto);
        dfs(board, r, c + 1, original, changeto);
        dfs(board, r, c - 1, original, changeto);
    }
}
// @lc code=end

