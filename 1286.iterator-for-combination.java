/*
 * @lc app=leetcode id=1286 lang=java
 *
 * [1286] Iterator for Combination
 *
 * https://leetcode.com/problems/iterator-for-combination/description/
 *
 * algorithms
 * Medium (65.83%)
 * Likes:    131
 * Dislikes: 15
 * Total Accepted:    6.7K
 * Total Submissions: 10.1K
 * Testcase Example:  '["CombinationIterator","next","hasNext","next","hasNext","next","hasNext"]\r\n[["abc",2],[],[],[],[],[],[]]\r'
 *
 * Design an Iterator class, which has:
 * 
 * 
 * A constructor that takes a string characters of sorted distinct lowercase
 * English letters and a number combinationLength as arguments.
 * A function next() that returns the next combination of length
 * combinationLength in lexicographical order.
 * A function hasNext() that returns True if and only if there exists a next
 * combination.
 * 
 * 
 * 
 * 
 * Example:
 * 
 * 
 * CombinationIterator iterator = new CombinationIterator("abc", 2); // creates
 * the iterator.
 * 
 * iterator.next(); // returns "ab"
 * iterator.hasNext(); // returns true
 * iterator.next(); // returns "ac"
 * iterator.hasNext(); // returns true
 * iterator.next(); // returns "bc"
 * iterator.hasNext(); // returns false
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= combinationLength <= characters.length <= 15
 * There will be at most 10^4 function calls per test.
 * It's guaranteed that all calls of the function next are valid.
 * 
 * 
 */

// @lc code=start
class CombinationIterator {

    PriorityQueue<String> pq = new PriorityQueue<>();
    public CombinationIterator(String characters, int combinationLength) {
        generateCombination(characters, 0, "", combinationLength);
    }
    
    public String next() {
        return pq.poll();
    }
    
    public boolean hasNext() {
        return pq.size() > 0;
    }
    
    private void generateCombination(String characters, int start, String path, int length) {
        if (length == 0) {
            pq.offer(path);
            return;
        }
        
        for (int i = start; i < characters.length(); i++) {
            generateCombination(characters, i + 1, path + characters.charAt(i), length - 1);
        }
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
// @lc code=end

