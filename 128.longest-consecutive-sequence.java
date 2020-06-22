/*
 * @lc app=leetcode id=128 lang=java
 *
 * [128] Longest Consecutive Sequence
 *
 * https://leetcode.com/problems/longest-consecutive-sequence/description/
 *
 * algorithms
 * Hard (44.12%)
 * Likes:    3158
 * Dislikes: 173
 * Total Accepted:    294.6K
 * Total Submissions: 659.6K
 * Testcase Example:  '[100,4,200,1,3,2]'
 *
 * Given an unsorted array of integers, find the length of the longest
 * consecutive elements sequence.
 * 
 * Your algorithm should run in O(n) complexity.
 * 
 * Example:
 * 
 * 
 * Input: [100, 4, 200, 1, 3, 2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4].
 * Therefore its length is 4.
 * 
 * 
 */

// @lc code=start
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        
        int longest = 0;
        for (int num : nums) {
            if (!set.contains(num)) continue;
            
            int cnt = 1;
            set.remove(num);
            
            int curr = num+1;
            while(set.contains(curr)) {
                cnt++;
                set.remove(curr);
                curr++;
            }
            
            curr = num-1;
            while(set.contains(curr)) {
                cnt++;
                set.remove(curr);
                curr--;
            }
            
            longest = Math.max(longest, cnt);
        }
        
        return longest;
    }
}

// @lc code=end

