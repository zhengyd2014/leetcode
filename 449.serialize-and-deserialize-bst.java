/*
 * @lc app=leetcode id=449 lang=java
 *
 * [449] Serialize and Deserialize BST
 *
 * https://leetcode.com/problems/serialize-and-deserialize-bst/description/
 *
 * algorithms
 * Medium (50.84%)
 * Likes:    1113
 * Dislikes: 64
 * Total Accepted:    92.6K
 * Total Submissions: 181.8K
 * Testcase Example:  '[2,1,3]'
 *
 * Serialization is the process of converting a data structure or object into a
 * sequence of bits so that it can be stored in a file or memory buffer, or
 * transmitted across a network connection link to be reconstructed later in
 * the same or another computer environment.
 * 
 * Design an algorithm to serialize and deserialize a binary search tree. There
 * is no restriction on how your serialization/deserialization algorithm should
 * work. You just need to ensure that a binary search tree can be serialized to
 * a string and this string can be deserialized to the original tree
 * structure.
 * 
 * The encoded string should be as compact as possible.
 * 
 * Note: Do not use class member/global/static variables to store states. Your
 * serialize and deserialize algorithms should be stateless.
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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        shelper(root, sb);
        return sb.toString();
    }
    
    private void shelper(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        
        sb.append("" + root.val);
        if (root.left != null) {
            sb.append(",");
            shelper(root.left, sb);
        }
        
        if (root.right != null) {
            sb.append(",");
            shelper(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        
        String[] nodes = data.split(",");
        int[] values = new int[nodes.length];
        for (int i = 0; i < values.length; i++) {
            values[i] = Integer.valueOf(nodes[i]);
        }
        return buildTree(values, 0, nodes.length - 1);
    }
    
    private TreeNode buildTree(int[] data, int left, int right) {
        if (left > right) return null;
        
        TreeNode node = new TreeNode(data[left]);
        int index = left + 1;
        while(index <= right && data[index] < data[left]) index++;
        node.left = buildTree(data, left + 1, index - 1);
        node.right = buildTree(data, index, right);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
// @lc code=end

