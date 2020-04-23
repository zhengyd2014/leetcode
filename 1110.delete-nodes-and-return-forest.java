/*
 * @lc app=leetcode id=1110 lang=java
 *
 * [1110] Delete Nodes And Return Forest
 *
 * https://leetcode.com/problems/delete-nodes-and-return-forest/description/
 *
 * algorithms
 * Medium (65.72%)
 * Likes:    810
 * Dislikes: 32
 * Total Accepted:    44.5K
 * Total Submissions: 67.5K
 * Testcase Example:  '[1,2,3,4,5,6,7]\n[3,5]'
 *
 * Given the root of a binary tree, each node in the tree has a distinct
 * value.
 * 
 * After deleting all nodes with a value in to_delete, we are left with a
 * forest (a disjoint union of trees).
 * 
 * Return the roots of the trees in the remaining forest.  You may return the
 * result in any order.
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
 * Output: [[1,2,null,4],[6],[7]]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the given tree is at most 1000.
 * Each node has a distinct value between 1 and 1000.
 * to_delete.length <= 1000
 * to_delete contains distinct values between 1 and 1000.
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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> result = new ArrayList<>();
        Set<Integer> delete = new HashSet<>();
        for (int d : to_delete) delete.add(d);

        TreeNode node = dfs(root, delete, result);
        if (node != null) result.add(node);
        
        return result;
    }

    private TreeNode dfs(TreeNode root, Set<Integer> delete, List<TreeNode> result) {
        if (root == null) return null;

        root.left = dfs(root.left, delete, result);
        root.right = dfs(root.right, delete, result);

        if (delete.contains(root.val)) {
            if (root.left != null) result.add(root.left);
            if (root.right != null) result.add(root.right);

            return null;
        } else {
            return root;
        }
    }
}
// @lc code=end

