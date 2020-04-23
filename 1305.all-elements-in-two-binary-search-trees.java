/*
 * @lc app=leetcode id=1305 lang=java
 *
 * [1305] All Elements in Two Binary Search Trees
 *
 * https://leetcode.com/problems/all-elements-in-two-binary-search-trees/description/
 *
 * algorithms
 * Medium (74.99%)
 * Likes:    232
 * Dislikes: 10
 * Total Accepted:    19.4K
 * Total Submissions: 25.9K
 * Testcase Example:  '[2,1,4]\r\n[1,0,3]\r'
 *
 * Given two binary search trees root1 and root2.
 * 
 * Return a list containing all the integers from both trees sorted in
 * ascending order.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root1 = [2,1,4], root2 = [1,0,3]
 * Output: [0,1,1,2,3,4]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root1 = [0,-10,10], root2 = [5,1,7,0,2]
 * Output: [-10,0,0,1,2,5,7,10]
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: root1 = [], root2 = [5,1,7,0,2]
 * Output: [0,1,2,5,7]
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: root1 = [0,-10,10], root2 = []
 * Output: [-10,0,10]
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: root1 = [1,null,8], root2 = [8,1]
 * Output: [1,1,8,8]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * Each tree has at most 5000 nodes.
 * Each node's value is between [-10^5, 10^5].
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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        
        List<Integer> result = new ArrayList<>();
        TreeIterator it1 = new TreeIterator(root1);
        TreeIterator it2 = new TreeIterator(root2);
        while (it1.hasNext() && it2.hasNext()) {
            int v1 = it1.peek();
            int v2 = it2.peek();
            if (v1 <= v2) {
                result.add(v1);
                it1.next();
            } else {
                result.add(v2);
                it2.next();
            }
        }
        
        while (it1.hasNext()) {
            result.add(it1.next().val);
        }
        
        while (it2.hasNext()) {
            result.add(it2.next().val);
        }
        
        return result;
    }
    
}

class TreeIterator {
        
        Stack<TreeNode> stack;
        public TreeIterator(TreeNode root) {
            stack = new Stack<TreeNode>();
            pushLeft(root);
        }
        
        public boolean hasNext() {
            return !stack.isEmpty();
        }
        
        public TreeNode next() {
            if (stack.isEmpty()) return null;
            TreeNode node = stack.pop();
            pushLeft(node.right);
            return node;
        }
        
        public int peek() {
            return stack.peek().val;
        }
        
        private void pushLeft(TreeNode node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
    }
// @lc code=end

