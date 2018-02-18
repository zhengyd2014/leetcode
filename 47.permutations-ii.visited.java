/*
 * [47] Permutations II
 *
 * https://leetcode.com/problems/permutations-ii/description/
 *
 * algorithms
 * Medium (34.46%)
 * Total Accepted:    150.3K
 * Total Submissions: 436.3K
 * Testcase Example:  '[1,1,2]'
 *
 * 
 * Given a collection of numbers that might contain duplicates, return all
 * possible unique permutations.
 * 
 * 
 * 
 * For example,
 * [1,1,2] have the following unique permutations:
 * 
 * [
 * ⁠ [1,1,2],
 * ⁠ [1,2,1],
 * ⁠ [2,1,1]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		permuteUnique(nums, result, new ArrayList<Integer>(), new boolean[nums.length]);
		return result;		
    }

	private void permuteUnique(int[] nums, List<List<Integer>> result, List<Integer> path, boolean[] visited) {
		if (path.size() == nums.length) {
			result.add(new ArrayList<Integer>(path));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (visited[i]) {
			   continue;
			}

			if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
				continue;
			}

			path.add(nums[i]);
			visited[i] = true;
			permuteUnique(nums, result, path, visited);
			path.remove(path.size() - 1);
			visited[i] = false;		
		}
	}
}
