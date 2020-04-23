/*
 * @lc app=leetcode id=1339 lang=java
 *
 * [1339] Maximum Product of Splitted Binary Tree
 *
 * https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/description/
 *
 * algorithms
 * Medium (35.54%)
 * Likes:    167
 * Dislikes: 18
 * Total Accepted:    9.5K
 * Total Submissions: 26.7K
 * Testcase Example:  '[1,2,3,4,5,6]'
 *
 * Given a binary tree root. Split the binary tree into two subtrees by
 * removing 1 edge such that the product of the sums of the subtrees are
 * maximized.
 * 
 * Since the answer may be too large, return it modulo 10^9 + 7.
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * Input: root = [1,2,3,4,5,6]
 * Output: 110
 * Explanation: Remove the red edge and get 2 binary trees with sum 11 and 10.
 * Their product is 110 (11*10)
 * 
 * 
 * Example 2:
 * 
 * 
 * 
 * 
 * Input: root = [1,null,2,3,4,null,null,5,6]
 * Output: 90
 * Explanation:  Remove the red edge and get 2 binary trees with sum 15 and
 * 6.Their product is 90 (15*6)
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: root = [2,3,9,10,7,8,6,5,4,11,1]
 * Output: 1025
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: root = [1,1]
 * Output: 1
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * Each tree has at most 50000 nodes and at least 2 nodes.
 * Each node's value is between [1, 10000].
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
    long max = Integer.MIN_VALUE;
    long M = (long) Math.pow(10, 9) + 7;
    long totalsum;
    Map<TreeNode, Long> sumMap = new HashMap<>();
    
    public int maxProduct(TreeNode root) {
        totalsum = sum(root);
        System.out.println("totalsum: " + totalsum);
        helper(root);
        return (int) (max % M);
    }
    
    public void helper(TreeNode root) {
        if (root == null) return;
        
        long leftSum = sum(root.left);
        long rightSum = sum(root.right);
        long production = Math.max(leftSum * (totalsum - leftSum), rightSum * (totalsum - rightSum));
        max = Math.max(production, max);
        
        helper(root.left);
        helper(root.right);
    }
    
    public long sum(TreeNode root) {
        if (root == null) return 0L;
        
        if (sumMap.containsKey(root)) return sumMap.get(root);
        long sum = root.val + sum(root.left) + sum(root.right);
        sumMap.put(root, sum);
        return sum;
    }
}
// @lc code=end

