/*
 * @lc app=leetcode id=528 lang=java
 *
 * [528] Random Pick with Weight
 *
 * https://leetcode.com/problems/random-pick-with-weight/description/
 *
 * algorithms
 * Medium (43.58%)
 * Likes:    524
 * Dislikes: 987
 * Total Accepted:    58.6K
 * Total Submissions: 134.4K
 * Testcase Example:  '["Solution", "pickIndex"]\n[[[1]], []]'
 *
 * Given an array w of positive integers, where w[i] describes the weight of
 * index i, write a function pickIndex which randomly picks an index in
 * proportion to its weight.
 * 
 * Note:
 * 
 * 
 * 1 <= w.length <= 10000
 * 1 <= w[i] <= 10^5
 * pickIndex will be called at most 10000 times.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: 
 * ["Solution","pickIndex"]
 * [[[1]],[]]
 * Output: [null,0]
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 
 * ["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
 * [[[1,3]],[],[],[],[],[]]
 * Output: [null,0,1,1,1,0]
 * 
 * 
 * Explanation of Input Syntax:
 * 
 * The input is two lists: the subroutines called and their arguments.
 * Solution's constructor has one argument, the array w. pickIndex has no
 * arguments. Arguments are always wrapped with a list, even if there aren't
 * any.
 * 
 */

// @lc code=start

// 528. Random Pick with Weight

// TreeMap:  key : weight, value: index

class Solution {
    int totalWeight = 0;
    TreeMap<Integer, Integer> idxMap = new TreeMap<>();
    Random rand = new Random();
    int[] w;
    public Solution(int[] w) {
        this.w = w;
        
        for (int weight : w) {
            totalWeight += weight;
            idxMap.put(totalWeight, idxMap.size());
        }
    }
    
    public int pickIndex() {
        int r = rand.nextInt(totalWeight);
        int index = idxMap.get(idxMap.higherKey(r));
        return index;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
// @lc code=end

