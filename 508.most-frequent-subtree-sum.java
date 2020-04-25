/*
 * @lc app=leetcode id=508 lang=java
 *
 * [508] Most Frequent Subtree Sum
 *
 * https://leetcode.com/problems/most-frequent-subtree-sum/description/
 *
 * algorithms
 * Medium (56.84%)
 * Likes:    556
 * Dislikes: 105
 * Total Accepted:    65.1K
 * Total Submissions: 114.3K
 * Testcase Example:  '[5,2,-3]'
 *
 * 
 * Given the root of a tree, you are asked to find the most frequent subtree
 * sum. The subtree sum of a node is defined as the sum of all the node values
 * formed by the subtree rooted at that node (including the node itself). So
 * what is the most frequent subtree sum value? If there is a tie, return all
 * the values with the highest frequency in any order.
 * 
 * 
 * Examples 1
 * Input:
 * 
 * ⁠ 5
 * ⁠/  \
 * 2   -3
 * 
 * return [2, -3, 4], since all the values happen only once, return all of them
 * in any order.
 * 
 * 
 * Examples 2
 * Input:
 * 
 * ⁠ 5
 * ⁠/  \
 * 2   -5
 * 
 * return [2], since 2 happens twice, however -5 only occur once.
 * 
 * 
 * Note:
 * You may assume the sum of values in any subtree is in the range of 32-bit
 * signed integer.
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    Map<Integer, Integer> count = new HashMap();
    int mostFrequent = 0;
    Set<Integer> result = new HashSet();
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) return new int[]{};
        
        dfs(root);
        int[] ans = new int[result.size()];
        int i = 0;
        for (int sum : result) {
            ans[i++] = sum;
        }
        return ans;
    }
    
    private void dfs(TreeNode root) {
        if (root == null) return;
        
        int sum = sum(root);
        count.put(sum, count.getOrDefault(sum, 0) + 1);
        if (count.get(sum) > mostFrequent) {
            mostFrequent = count.get(sum);
            result.clear();
            result.add(sum);
        } else if (count.get(sum) == mostFrequent) {
            result.add(sum);
        }
        
        dfs(root.left);
        dfs(root.right);
    }
    
    private int sum(TreeNode root) {
        if (root == null) return 0;
        return root.val + sum(root.left) + sum(root.right);
    }
}
// @lc code=end

