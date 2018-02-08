/*
 * [46] Permutations
 *
 * https://leetcode.com/problems/permutations/description/
 *
 * algorithms
 * Medium (46.32%)
 * Total Accepted:    213.7K
 * Total Submissions: 461.4K
 * Testcase Example:  '[1,2,3]'
 *
 * 
 * Given a collection of distinct numbers, return all possible permutations.
 * 
 * 
 * 
 * For example,
 * [1,2,3] have the following permutations:
 * 
 * [
 * ⁠ [1,2,3],
 * ⁠ [1,3,2],
 * ⁠ [2,1,3],
 * ⁠ [2,3,1],
 * ⁠ [3,1,2],
 * ⁠ [3,2,1]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return result;
		}

		permute(nums, result, new ArrayList<Integer>(), new HashSet<Integer>());
		return result;
	}

	private void permute(int[] nums, List<List<Integer>> result, List<Integer> path, Set<Integer> seen) {
			if (path.size() == nums.length) {
				result.add(new ArrayList<Integer>(path));
				return;
			}

			for (int i = 0; i < nums.length; i++) {
				if (seen.contains(i)) {
					continue;
				}

				path.add(nums[i]);
				seen.add(i);
				permute(nums, result, path, seen);
				path.remove(path.size() - 1);
				seen.remove(i);
			}
		}		
}
