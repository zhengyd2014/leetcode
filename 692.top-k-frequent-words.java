/*
 * @lc app=leetcode id=692 lang=java
 *
 * [692] Top K Frequent Words
 *
 * https://leetcode.com/problems/top-k-frequent-words/description/
 *
 * algorithms
 * Medium (49.84%)
 * Likes:    1523
 * Dislikes: 126
 * Total Accepted:    145.7K
 * Total Submissions: 290.1K
 * Testcase Example:  '["i", "love", "leetcode", "i", "love", "coding"]\n2'
 *
 * Given a non-empty list of words, return the k most frequent elements.
 * Your answer should be sorted by frequency from highest to lowest. If two
 * words have the same frequency, then the word with the lower alphabetical
 * order comes first.
 * 
 * Example 1:
 * 
 * Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * Output: ["i", "love"]
 * Explanation: "i" and "love" are the two most frequent words.
 * ⁠   Note that "i" comes before "love" due to a lower alphabetical order.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is",
 * "is"], k = 4
 * Output: ["the", "is", "sunny", "day"]
 * Explanation: "the", "is", "sunny" and "day" are the four most frequent
 * words,
 * ⁠   with the number of occurrence being 4, 3, 2 and 1 respectively.
 * 
 * 
 * 
 * Note:
 * 
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Input words contain only lowercase letters.
 * 
 * 
 * 
 * Follow up:
 * 
 * Try to solve it in O(n log k) time and O(n) extra space.
 * 
 * 
 */

// @lc code=start


// 692. Top K Frequent Words

// pq, o(nlgk)
// note: 
//   1. pq order is the reverse order of output required.
//   2. pq compare can leverage variables outside of pq element.


class Solution {
    
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> count = new HashMap<>();
        for (String w : words) count.put(w, count.getOrDefault(w, 0) + 1);
    
        PriorityQueue<String> pq = new PriorityQueue<String>(k+1,
            (w1, w2) -> count.get(w1) == count.get(w2) ?
            w2.compareTo(w1) : count.get(w1) - count.get(w2) );
        
        for (String w : count.keySet()) {
            pq.offer(w);
            if (pq.size() > k) pq.poll();
        }
        
        List<String> ans = new ArrayList<>();
        while(!pq.isEmpty()) ans.add(pq.poll());
        Collections.reverse(ans);
        return ans;
    }
}

// @lc code=end

