/*
 * [47] Permutations II
 *
 * https://leetcode.com/problems/permutations-ii/description/
 *
 * algorithms
 * Medium (34.60%)
 * Total Accepted:    152.7K
 * Total Submissions: 441.2K
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
		if (nums == null || nums.length == 0) {
			return result;
		}

		Map<Integer, Integer> charFreq = buildCharFreqMap(nums);
		dfs(charFreq, nums.length, result, new ArrayList<Integer>());		
		return result;
    }

	private Map<Integer, Integer> buildCharFreqMap(int[] nums) {
		Map<Integer, Integer> charFreq = new HashMap<>();
		for (int num : nums) {
			charFreq.put(num, charFreq.getOrDefault(num, 0) + 1);
		}
		return charFreq;
	}

	private void dfs(Map<Integer, Integer> charFreq, int remaining, List<List<Integer>> result, List<Integer> path) {
		if (remaining == 0) {
			result.add(new ArrayList<Integer>(path));
			return;
		}

		for (int key : charFreq.keySet()) {
			int count = charFreq.get(key);
			if (count > 0) {
				path.add(key);
				charFreq.put(key, count - 1);
				dfs(charFreq, remaining - 1, result, path);
				charFreq.put(key, count);
				path.remove(path.size() - 1);
			}
		}
	}

}
