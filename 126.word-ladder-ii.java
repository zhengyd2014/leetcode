/*
 * [126] Word Ladder II
 *
 * https://leetcode.com/problems/word-ladder-ii/description/
 *
 * algorithms
 * Hard (14.68%)
 * Total Accepted:    78K
 * Total Submissions: 531.5K
 * Testcase Example:  '"hit"\n"cog"\n["hot","dot","dog","lot","log","cog"]'
 *
 * 
 * Given two words (beginWord and endWord), and a dictionary's word list, find
 * all shortest transformation sequence(s) from beginWord to endWord, such
 * that:
 * 
 * 
 * Only one letter can be changed at a time
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
 * Return
 * 
 * ⁠ [
 * ⁠   ["hit","hot","dot","dog","cog"],
 * ⁠   ["hit","hot","lot","log","cog"]
 * ⁠ ]
 * 
 * 
 * 
 * 
 * Note:
 * 
 * Return an empty list if there is no such transformation sequence.
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

	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            Set<String> words = new HashSet<>();
            for (String word : wordList) {
                words.add(word);
            }

            List<String> toVisit = new ArrayList<>();
            Set<String> visited = new HashSet<>();
            toVisit.add(beginWord);
            visited.add(beginWord);
            Map<String, List<String>> path = new HashMap<>();
            path.put(beginWord, null);

            while (!toVisit.isEmpty()) {
                List<String> children = new ArrayList<>();
                for (String word : toVisit) {
                    if (word.equals(endWord)) {
                        return pathes(endWord, path);
                    }

                    enqueueNeighbors(children, word, words, visited, path);
                }
                toVisit = children;
            }

            return new ArrayList<List<String>>();
        }

        private void enqueueNeighbors(List<String> toVisit, String word, Set<String> words, Set<String> visited, Map<String, List<String>> path) {
            for (int i = 0; i < word.length(); i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    String newWord = word.substring(0, i) + c + word.substring(i+1);
                    if (words.contains(newWord)) {
                        if (!visited.contains(newWord)) {
                            visited.add(newWord);
                            toVisit.add(newWord);
                        }

                        if (toVisit.contains(newWord)) {
                            if (!path.containsKey(newWord)) {
                                path.put(newWord, new ArrayList<String>());
                            }
                            path.get(newWord).add(word);
                        }
                    }
                }
            }
        }

        private List<List<String>> pathes(String endWord, Map<String, List<String>> path) {
            List<List<String>> result = new ArrayList<>();

            List<String> parents = path.get(endWord);
            if (parents == null) {
                List<String> list = new ArrayList<>();
                list.add(endWord);
                result.add(list);
                return result;
            }

            for (String parent : parents) {
                for (List<String> p : pathes(parent, path)) {
                    p.add(endWord);
                    result.add(p);
                }
            }

            return result;
        }
}
