/*
 * [79] Word Search
 *
 * https://leetcode.com/problems/word-search/description/
 *
 * algorithms
 * Medium (27.69%)
 * Total Accepted:    158.1K
 * Total Submissions: 571.1K
 * Testcase Example:  '[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]\n"ABCCED"'
 *
 * 
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 * 
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring. The
 * same letter cell may not be used more than once.
 * 
 * 
 * 
 * For example,
 * Given board = 
 * 
 * [
 * ⁠ ['A','B','C','E'],
 * ⁠ ['S','F','C','S'],
 * ⁠ ['A','D','E','E']
 * ]
 * 
 * 
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 * 
 */
class Solution {
    public boolean exist(char[][] board, String word) {
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[0].length; c++) {
				if (find(board, r, c, word, 0)) {
					return true;
				}
			}
		}
        return false;
    }

	private boolean find(char[][] board, int r, int c, String word, int index) {
		if (index == word.length()) {
			return true;
		}

		if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != word.charAt(index)) {
			return false;
		}

		char originalChar = board[r][c];
		board[r][c] = '#';
		if (find(board, r + 1, c, word, index + 1)) return true;
		if (find(board, r, c + 1, word, index + 1)) return true;
		if (find(board, r - 1, c, word, index + 1)) return true;
		if (find(board, r, c - 1, word, index + 1)) return true;

		board[r][c] = originalChar;
		return false;
	}
}
