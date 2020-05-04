/*
 * @lc app=leetcode id=90 lang=java
 *
 * [90] Subsets II
 *
 * https://leetcode.com/problems/subsets-ii/description/
 *
 * algorithms
 * Medium (45.70%)
 * Likes:    1450
 * Dislikes: 61
 * Total Accepted:    261.8K
 * Total Submissions: 570.6K
 * Testcase Example:  '[1,2,2]'
 *
 * Given a collection of integers that might contain duplicates, nums, return
 * all possible subsets (the power set).
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * Example:
 * 
 * 
 * Input: [1,2,2]
 * Output:
 * [
 * ⁠ [2],
 * ⁠ [1],
 * ⁠ [1,2,2],
 * ⁠ [2,2],
 * ⁠ [1,2],
 * ⁠ []
 * ]
 * 
 * 
 */

// @lc code=start

// contain dup: need sort first
// 
// match condition: every time into dfs
// return condition: reach the end of nums
// loop prune condition:
//     1. visited before, return
//     2. if equals to previous element, and previous element is not visited, skip it

// attention:  skip and return are not the same thing.

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        Arrays.sort(nums);
        dfs(nums, 0, new boolean[nums.length], new ArrayList<Integer>(), result);
        return result;
    }
    
    private void dfs(int[] nums, int start, boolean[] visited, List<Integer> path, List<List<Integer>> result) {
        if (start > nums.length) return;
        result.add(new ArrayList<Integer>(path));
        
        for (int i = start; i < nums.length; i++) {
            if (visited[i]) return;
            if (i > 0 && (nums[i] == nums[i-1] && !visited[i-1])) continue;   // skip, not return!!!
            visited[i] = true;
            path.add(nums[i]);
            dfs(nums, i+1, visited, path, result);
            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }
}
// @lc code=end

