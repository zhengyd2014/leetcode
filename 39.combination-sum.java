/*
 * @lc app=leetcode id=39 lang=java
 *
 * [39] Combination Sum
 *
 * https://leetcode.com/problems/combination-sum/description/
 *
 * algorithms
 * Medium (51.18%)
 * Likes:    3185
 * Dislikes: 101
 * Total Accepted:    486.6K
 * Total Submissions: 902K
 * Testcase Example:  '[2,3,6,7]\n7'
 *
 * Given a set of candidate numbers (candidates) (without duplicates) and a
 * target number (target), find all unique combinations in candidates where the
 * candidate numbers sums to target.
 * 
 * The same repeated number may be chosen from candidates unlimited number of
 * times.
 * 
 * Note:
 * 
 * 
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 * ⁠ [7],
 * ⁠ [2,2,3]
 * ]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return result;
        
        dfs(candidates, 0, target, new ArrayList<Integer>(), 0, result);
        return result;
    }

    private void dfs(int[] candidates,int start, int target, List<Integer> path, int sum, List<List<Integer>> result) {
        if (sum > target) return;
        if (sum == target) {
            result.add(new ArrayList<Integer>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            path.add(candidates[i]);
            sum += candidates[i];
            dfs(candidates, i, target, path, sum, result);
            sum -= candidates[i];
            path.remove(path.size() - 1);
        }
    }
}
// @lc code=end

