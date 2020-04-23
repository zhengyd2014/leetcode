/*
 * @lc app=leetcode id=1315 lang=java
 *
 * [1315] Sum of Nodes with Even-Valued Grandparent
 *
 * https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/description/
 *
 * algorithms
 * Medium (83.36%)
 * Likes:    262
 * Dislikes: 12
 * Total Accepted:    19.2K
 * Total Submissions: 23K
 * Testcase Example:  '[6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]'
 *
 * Given a binary tree, return the sum of values of nodes with even-valued
 * grandparent.  (A grandparent of a node is the parent of its parent, if it
 * exists.)
 * 
 * If there are no nodes with an even-valued grandparent, return 0.
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
 * Output: 18
 * Explanation: The red nodes are the nodes with even-value grandparent while
 * the blue nodes are the even-value grandparents.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is between 1 and 10^4.
 * The value of nodes is between 1 and 100.
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
    
    int total = 0;
    public int sumEvenGrandparent(TreeNode root) {
        if (root == null) return 0;
        
        if (root.val % 2 == 0) total += sumChild(root, 2);
        sumEvenGrandparent(root.left);
        sumEvenGrandparent(root.right);
        return total;
    }
    
    private int sumChild(TreeNode root, int level) {
        if (root == null) return 0;
        
        int sum = 0;
        if (level == 0) sum += root.val;
        else {
            sum += sumChild(root.left, level - 1);
            sum += sumChild(root.right, level - 1);
        }
        
        return sum;
    }


    // another simple solution
    public int sumEvenGrandparent2(TreeNode root) {
        return helper(root, new TreeNode(1), new TreeNode(1));
    }
    
    private int helper(TreeNode root, TreeNode parent, TreeNode grandParent) {
        if (root == null) return 0;
        
        int sum = 0;
        if (grandParent.val % 2 == 0) sum += root.val;
        sum += helper(root.left, root, parent);
        sum += helper(root.right, root, parent);
        return sum;
    }
}
// @lc code=end

