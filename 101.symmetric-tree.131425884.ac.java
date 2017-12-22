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
    public boolean isSymmetric(TreeNode root) {
        return isSysmmetric(root, root);
    }
    
    private boolean isSysmmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        }
        
        return left.val == right.val && isSysmmetric(left.left, right.right) && isSysmmetric(left.right, right.left);
    }
}