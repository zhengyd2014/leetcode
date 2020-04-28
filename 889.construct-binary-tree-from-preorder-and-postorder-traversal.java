/*
 * @lc app=leetcode id=889 lang=java
 *
 * [889] Construct Binary Tree from Preorder and Postorder Traversal
 *
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/description/
 *
 * algorithms
 * Medium (64.94%)
 * Likes:    704
 * Dislikes: 45
 * Total Accepted:    32.8K
 * Total Submissions: 50.4K
 * Testcase Example:  '[1,2,4,5,3,6,7]\n[4,5,2,6,7,3,1]'
 *
 * Return any binary tree that matches the given preorder and postorder
 * traversals.
 * 
 * Values in the traversals pre and post are distinct positive integers.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
 * Output: [1,2,3,4,5,6,7]
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= pre.length == post.length <= 30
 * pre[] and post[] are both permutations of 1, 2, ..., pre.length.
 * It is guaranteed an answer exists. If there exists multiple answers, you can
 * return any of them.
 * 
 * 
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
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        int n = pre.length;

        if (n == 0) return null;
        TreeNode root = new TreeNode(pre[0]);
        if (n == 1) return root;

        int index = 0;
        while(index < n) {
            if (pre[index] == post[n - 2]) break;
            index++;
        }

        root.left = constructFromPrePost(Arrays.copyOfRange(pre, 1, index), Arrays.copyOfRange(post, 0, index - 1));
        root.right = constructFromPrePost(Arrays.copyOfRange(pre, index, n), Arrays.copyOfRange(post, index - 1, n - 1));
        return root;
    }
}
// @lc code=end

