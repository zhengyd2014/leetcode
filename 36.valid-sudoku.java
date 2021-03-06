/*
 * @lc app=leetcode id=36 lang=java
 *
 * [36] Valid Sudoku
 *
 * https://leetcode.com/problems/valid-sudoku/description/
 *
 * algorithms
 * Medium (45.07%)
 * Likes:    1362
 * Dislikes: 424
 * Total Accepted:    327.1K
 * Total Submissions: 693K
 * Testcase Example:  '[["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]'
 *
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be
 * validated according to the following rules:
 * 
 * 
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without
 * repetition.
 * 
 * 
 * 
 * A partially filled sudoku which is valid.
 * 
 * The Sudoku board could be partially filled, where empty cells are filled
 * with the character '.'.
 * 
 * Example 1:
 * 
 * 
 * Input:
 * [
 * ⁠ ["5","3",".",".","7",".",".",".","."],
 * ⁠ ["6",".",".","1","9","5",".",".","."],
 * ⁠ [".","9","8",".",".",".",".","6","."],
 * ⁠ ["8",".",".",".","6",".",".",".","3"],
 * ⁠ ["4",".",".","8",".","3",".",".","1"],
 * ⁠ ["7",".",".",".","2",".",".",".","6"],
 * ⁠ [".","6",".",".",".",".","2","8","."],
 * ⁠ [".",".",".","4","1","9",".",".","5"],
 * ⁠ [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * [
 * ["8","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: false
 * Explanation: Same as Example 1, except with the 5 in the top left corner
 * being 
 * ⁠   modified to 8. Since there are two 8's in the top left 3x3 sub-box, it
 * is invalid.
 * 
 * 
 * Note:
 * 
 * 
 * A Sudoku board (partially filled) could be valid but is not necessarily
 * solvable.
 * Only the filled cells need to be validated according to the mentioned
 * rules.
 * The given board contain only digits 1-9 and the character '.'.
 * The given board size is always 9x9.
 * 
 * 
 */

// @lc code=start
class Solution {


    public boolean isValidSudoku(char[][] board) {
		for (int i = 0; i < 9; i++) {
			HashSet<Character> row = new HashSet<>();
			HashSet<Character> column = new HashSet<>();
			HashSet<Character> cube = new HashSet<>();
			for (int j = 0; j < 9; j++) {
				// 检查第i行，在横坐标位置
				if (board[i][j] != '.' && !row.add(board[i][j]))
					return false;
				// 检查第i列，在纵坐标位置
				if (board[j][i] != '.' && !column.add(board[j][i]))
					return false;
				// 行号+偏移量
				int RowIndex = 3 * (i / 3) + j / 3;
				// 列号+偏移量
				int ColIndex = 3 * (i % 3) + j % 3;
				//每个小九宫格，总共9个
				if (board[RowIndex][ColIndex] != '.' 
						&& !cube.add(board[RowIndex][ColIndex]))
					return false;
			}
		}
		return true;
	}

    public boolean isValidSudoku2(char[][] board) {

        for (int i = 0; i < 9; i++) {
            if (!isRowValid(board, i)) return false;
            if (!isColValid(board, i)) return false;
            if (!isSubValid(board, i)) return false;
        }
        
        return true;
    }

    private boolean isSubValid(char[][] board, int s) {
        boolean[] visited = new boolean[10];
        for (int i = 0; i < 9; i++) {
            int col = 3 * (s % 3) + i % 3;
            int row = 3 * (s / 3) + i / 3;
            if (board[row][col] != '.') {
                int num = Integer.parseInt(board[row][col]+"");
                if (visited[num]) return false;
                visited[num] = true;
            } 
        }
        return true;
    }

    private boolean isRowValid(char[][] board, int row) {
        boolean[] visited = new boolean[10];
        for (int i = 0; i < 9; i++) {
            if (board[row][i] != '.') {
                int num = Integer.parseInt(board[row][i]+"");
                if (visited[num]) return false;
                visited[num] = true;
            }
        }

        return true;
    }

    private boolean isColValid(char[][] board, int col) {
        boolean[] visited = new boolean[10];
        for (int i = 0; i < 9; i++) {
            if (board[i][col] != '.') {
                int num = Integer.parseInt(board[i][col]+"");
                if (visited[num]) return false;
                visited[num] = true;
            }
        }

        return true;
    }


}
// @lc code=end

