/*
 * @lc app=leetcode id=1372 lang=java
 *
 * [1372] Longest ZigZag Path in a Binary Tree
 *
 * https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/description/
 *
 * algorithms
 * Medium (52.38%)
 * Likes:    151
 * Dislikes: 3
 * Total Accepted:    6.1K
 * Total Submissions: 11.6K
 * Testcase Example:  '[1,null,1,1,1,null,null,1,1,null,1,null,null,null,1,null,1]'
 *
 * Given a binary tree root, a ZigZag path for a binary tree is defined as
 * follow:
 * 
 * 
 * Choose any node in the binary tree and a direction (right or left).
 * If the current direction is right then move to the right child of the
 * current node otherwise move to the left child.
 * Change the direction from right to left or right to left.
 * Repeat the second and third step until you can't move in the tree.
 * 
 * 
 * Zigzag length is defined as the number of nodes visited - 1. (A single node
 * has a length of 0).
 * 
 * Return the longest ZigZag path contained in that tree.
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * Input: root = [1,null,1,1,1,null,null,1,1,null,1,null,null,null,1,null,1]
 * Output: 3
 * Explanation: Longest ZigZag path in blue nodes (right -> left -> right).
 * 
 * 
 * Example 2:
 * 
 * 
 * 
 * 
 * Input: root = [1,1,1,null,1,null,null,1,1,null,1]
 * Output: 4
 * Explanation: Longest ZigZag path in blue nodes (left -> right -> left ->
 * right).
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: root = [1]
 * Output: 0
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * Each tree has at most 50000 nodes..
 * Each node's value is between [1, 100].
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
    class Solution {
        int longest = 0;
        public int longestZigZag(TreeNode root) {
            zigzag(root);
            return longest;
        }
        
        private int[] zigzag(TreeNode root) {
            if (root == null) return new int[]{-1, -1};
            
            int[] result = new int[2];
            int[] left = zigzag(root.left);
            int[] right = zigzag(root.right);
            result[0] = left[1] + 1;
            result[1] = right[0] + 1;
            longest = Math.max(longest, Math.max(result[0], result[1]));
            return result;
        }
    }
}
// @lc code=end

