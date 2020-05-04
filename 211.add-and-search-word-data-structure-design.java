/*
 * @lc app=leetcode id=211 lang=java
 *
 * [211] Add and Search Word - Data structure design
 *
 * https://leetcode.com/problems/add-and-search-word-data-structure-design/description/
 *
 * algorithms
 * Medium (34.77%)
 * Likes:    1485
 * Dislikes: 77
 * Total Accepted:    165.4K
 * Total Submissions: 471.9K
 * Testcase Example:  '["WordDictionary","addWord","addWord","addWord","search","search","search","search"]\n[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]'
 *
 * Design a data structure that supports the following two operations:
 * 
 * 
 * void addWord(word)
 * bool search(word)
 * 
 * 
 * search(word) can search a literal word or a regular expression string
 * containing only letters a-z or .. A . means it can represent any one
 * letter.
 * 
 * Example:
 * 
 * 
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * 
 * 
 * Note:
 * You may assume that all words are consist of lowercase letters a-z.
 * 
 */

// @lc code=start
class WordDictionary {
    
    class Node {
        Node[] children;
        boolean isWord;
        public Node() {
            children = new Node[26];
        }
    }

    Node root = new Node();
    /** Initialize your data structure here. */
    public WordDictionary() {
        
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        addWord(word, root, 0);
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(word, root, 0);
    }
    
    private boolean search(String word, Node node, int index) {
        if (index == word.length()) {
            return node.isWord;
        }
        
        char c = word.charAt(index);
        if (c == '.') {
            for (int i = 0; i < node.children.length; i++) {
                if (node.children[i] != null && search(word, node.children[i], index+1)) return true; 
            }
        } else if (node.children[c - 'a'] != null) {
            return search(word, node.children[c - 'a'], index + 1);
        }
        
        return false;
    }
    
    private void addWord(String word, Node node, int index) {
        if (index == word.length()) {
            node.isWord = true;
            return;
        };
        
        char c = word.charAt(index);
        if (node.children[c - 'a'] == null) node.children[c - 'a'] = new Node();
        addWord(word, node.children[c - 'a'], index + 1);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
// @lc code=end

