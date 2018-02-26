/*
 * [127] Word Ladder
 *
 * https://leetcode.com/problems/word-ladder/description/
 *
 * algorithms
 * Medium (19.84%)
 * Total Accepted:    151.4K
 * Total Submissions: 763.1K
 * Testcase Example:  '"hit"\n"cog"\n["hot","dot","dog","lot","log","cog"]'
 *
 * 
 * Given two words (beginWord and endWord), and a dictionary's word list, find
 * the length of shortest transformation sequence from beginWord to endWord,
 * such that:
 * 
 * 
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is
 * not a transformed word.
 * 
 * 
 * 
 * For example,
 * 
 * 
 * Given:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * 
 * 
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * 
 * 
 * 
 * Note:
 * 
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * 
 * 
 * 
 * 
 * UPDATE (2017/1/20):
 * The wordList parameter had been changed to a list of strings (instead of a
 * set of strings). Please reload the code definition to get the latest
 * changes.
 * 
 */
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Set<String> words = new HashSet<>();
		for (String word : wordList) {
			words.add(word);
		}		

		int steps = 0;
		Set<String> visited = new HashSet<>();
		Queue<String> fromBegin = new LinkedList<>();
		fromBegin.offer(beginWord);
		visited.add(beginWord);
		Queue<String> fromEnd = new LinkedList<>();
		fromEnd.offer(endWord);
		visited.add(endWord);
		while (!fromBegin.isEmpty()  && !fromEnd.isEmpty()) {
			int size = fromBegin.size();
			steps++;
			for (int i = 0; i < size; i++) {
				String word = fromBegin.poll();
				if (fromEnd.contains(word)) {
					return steps;
				}

				enqueueNeighbors(fromBegin, word, words, visited);
			}

			Queue<String> temp = fromBegin;
			fromBegin = fromEnd;
			fromEnd = temp;
		}

		return 0;
    }

	private void enqueueNeighbors(Queue<String> search, String word, Set<String> words, Set<String> visited) {
		for (int i = 0; i < word.length(); i++) {
			for (char c = 'a'; c <= 'z'; c++) {
				String newWord = word.substring(0,i) + c + word.substring(i+1);
				if (words.contains(newWord) && !visited.contains(newWord)) {
					search.offer(newWord);
					visited.add(newWord);
				}
			}
		}
	}
}
