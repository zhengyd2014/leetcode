/*
 * @lc app=leetcode id=1306 lang=java
 *
 * [1306] Jump Game III
 *
 * https://leetcode.com/problems/jump-game-iii/description/
 *
 * algorithms
 * Medium (60.59%)
 * Likes:    246
 * Dislikes: 8
 * Total Accepted:    17.2K
 * Total Submissions: 28.4K
 * Testcase Example:  '[4,2,3,0,3,1,2]\n5'
 *
 * Given an array of non-negative integers arr, you are initially positioned at
 * start index of the array. When you are at index i, you can jump to i +
 * arr[i] or i - arr[i], check if you can reach to any index with value 0.
 * 
 * Notice that you can not jump outside of the array at any time.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: arr = [4,2,3,0,3,1,2], start = 5
 * Output: true
 * Explanation: 
 * All possible ways to reach at index 3 with value 0 are: 
 * index 5 -> index 4 -> index 1 -> index 3 
 * index 5 -> index 6 -> index 4 -> index 1 -> index 3 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: arr = [4,2,3,0,3,1,2], start = 0
 * Output: true 
 * Explanation: 
 * One possible way to reach at index 3 with value 0 is: 
 * index 0 -> index 4 -> index 1 -> index 3
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: arr = [3,0,2,1,2], start = 2
 * Output: false
 * Explanation: There is no way to reach at index 1 with value 0.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= arr.length <= 5 * 10^4
 * 0 <= arr[i] < arr.length
 * 0 <= start < arr.length
 * 
 */

// @lc code=start
class Solution {
    public boolean canReach(int[] arr, int start) {
        
        if (arr == null || arr.length == 0 ||  start >= arr.length) return false;
        
        return dfs(arr, start, new boolean[arr.length]);
    }
    
    private boolean dfs(int[] arr, int start, boolean[] visited) {
        if (start < 0 || start >= arr.length || visited[start]) return false;
        
        if (arr[start] == 0) return true;
        
        visited[start] = true;
        int forward = start + arr[start];
        int backward = start - arr[start];
        return dfs(arr, forward, visited) || dfs(arr, backward, visited);
    }
}
// @lc code=end

