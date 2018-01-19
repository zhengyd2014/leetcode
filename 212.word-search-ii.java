/*
 * [212] Word Search II
 *
 * https://leetcode.com/problems/word-search-ii/description/
 *
 * algorithms
 * Hard (24.27%)
 * Total Accepted:    57.5K
 * Total Submissions: 236.9K
 * Testcase Example:  '[["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]]\n["oath","pea","eat","rain"]'
 *
 * 
 * Given a 2D board and a list of words from the dictionary, find all words in
 * the board.
 * 
 * 
 * Each word must be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring. The
 * same letter cell may not be used more than once in a word.
 * 
 * 
 * 
 * For example,
 * Given words = ["oath","pea","eat","rain"] and board = 
 * 
 * [
 * ⁠ ['o','a','a','n'],
 * ⁠ ['e','t','a','e'],
 * ⁠ ['i','h','k','r'],
 * ⁠ ['i','f','l','v']
 * ]
 * 
 * 
 * Return ["eat","oath"].
 * 
 * 
 * 
 * Note:
 * You may assume that all inputs are consist of lowercase letters a-z.
 * 
 * 
 * click to show hint.
 * 
 * You would need to optimize your backtracking to pass the larger test. Could
 * you stop backtracking earlier?
 * 
 * If the current candidate does not exist in all words' prefix, you could stop
 * backtracking immediately. What kind of data structure could answer such
 * query efficiently? Does a hash table work? Why or why not? How about a Trie?
 * If you would like to learn how to implement a basic trie, please work on
 * this problem: Implement Trie (Prefix Tree) first.
 * 
 */
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
		TrieNode root = buildTrieTree(words);
		List<String> result = new ArrayList<>();
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[0].length; c++) {
				findWords(board, r, c, root, result);
			}
		}		
		Collections.sort(result);
		return result;
    }

	private void findWords(char[][] board, int r, int c, TrieNode root, List<String> result) {
		if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] == '#') {
			return;
		}

		char originalChar = board[r][c];
		int index = board[r][c] - 'a';
		if (root.children[index] == null) {
			return;
		}

		if (root.children[index].word != null) {
			result.add(root.children[index].word);
			root.children[index].word = null;
		}

		board[r][c] = '#';
		findWords(board, r + 1, c, root.children[index], result);
		findWords(board, r - 1, c, root.children[index], result);
		findWords(board, r, c + 1, root.children[index], result);
		findWords(board, r, c - 1, root.children[index], result);
		board[r][c] = originalChar;
	}

	private TrieNode buildTrieTree(String[] words) {
		TrieNode root = new TrieNode();
		for (String w : words) {
			TrieNode current = root;
			for (int i = 0; i < w.length(); i++) {
				int index = w.charAt(i) - 'a';
				if (current.children[index] == null) {
					current.children[index] = new TrieNode();
				}
				current = current.children[index];
			}
			current.word = w;
		}

		return root;
	}
}

class TrieNode {
	String word;
	TrieNode[] children = new TrieNode[26];
}

