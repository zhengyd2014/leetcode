/*
 * @lc app=leetcode id=216 lang=java
 *
 * [216] Combination Sum III
 *
 * https://leetcode.com/problems/combination-sum-iii/description/
 *
 * algorithms
 * Medium (55.06%)
 * Likes:    920
 * Dislikes: 49
 * Total Accepted:    156.3K
 * Total Submissions: 283K
 * Testcase Example:  '3\n7'
 *
 * 
 * Find all possible combinations of k numbers that add up to a number n, given
 * that only numbers from 1 to 9 can be used and each combination should be a
 * unique set of numbers.
 * 
 * Note:
 * 
 * 
 * All numbers will be positive integers.
 * The solution set must not contain duplicate combinations.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: k = 3, n = 9
 * Output: [[1,2,6], [1,3,5], [2,3,4]]
 * 
 * 
 */

// @lc code=start


// match condition: sum == n && element count == k
// return condition: sum > n || element count > k
// no prune condition

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(k, n, 1, new ArrayList<>(), result);
        return result;
    }
    
    private void dfs(int k, int n, int start, List<Integer> path, List<List<Integer>> result) {
        if (k < 0 || n < 0) return;
        if (k == 0 && n == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        
        for (int i = start; i <= 9; i++) {
            path.add(i);
            dfs(k - 1, n - i, i + 1, path, result);
            path.remove(path.size() - 1);
        }
    }
}
// @lc code=end

