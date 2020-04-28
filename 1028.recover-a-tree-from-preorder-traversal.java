/*
 * @lc app=leetcode id=1028 lang=java
 *
 * [1028] Recover a Tree From Preorder Traversal
 *
 * https://leetcode.com/problems/recover-a-tree-from-preorder-traversal/description/
 *
 * algorithms
 * Hard (69.39%)
 * Likes:    359
 * Dislikes: 14
 * Total Accepted:    16.1K
 * Total Submissions: 23.2K
 * Testcase Example:  '"1-2--3--4-5--6--7"'
 *
 * We run a preorder depth first search on the root of a binary tree.
 * 
 * At each node in this traversal, we output D dashes (where D is the depth of
 * this node), then we output the value of this node.  (If the depth of a node
 * is D, the depth of its immediate child is D+1.  The depth of the root node
 * is 0.)
 * 
 * If a node has only one child, that child is guaranteed to be the left
 * child.
 * 
 * Given the output S of this traversal, recover the tree and return its
 * root.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * Input: "1-2--3--4-5--6--7"
 * Output: [1,2,5,3,4,6,7]
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * 
 * 
 * Input: "1-2--3---4-5--6---7"
 * Output: [1,2,5,3,null,6,null,4,null,7]
 * 
 * 
 * 
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * 
 * 
 * Input: "1-401--349---90--88"
 * Output: [1,401,null,349,88,90]
 * 
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * The number of nodes in the original tree is between 1 and 1000.
 * Each node will have a value between 1 and 10^9.
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
    public TreeNode recoverFromPreorder(String S) {
        if (S == null || S.length() == 0) return null;
        
        Stack<TreeNode> stack = new Stack<>();
        int n = S.length();
        int i = 0;
        while (i < n) {
            int depth = 0;
            for (; i < n && S.charAt(i) == '-'; i++) {
                depth++;
            }
            
            int number = 0;
            for (; i < n && S.charAt(i) >= '0' && S.charAt(i)  <= '9'; i++) {
                number = number * 10 + S.charAt(i) - '0';
            }

            TreeNode node = new TreeNode(number);
            while(stack.size() > depth) stack.pop();
            if (!stack.isEmpty()) {
                TreeNode parent = stack.peek();
                if (parent.left == null) parent.left = node;
                else parent.right = node;
            }
            
            stack.push(node);
        }
        
        while(stack.size() > 1) stack.pop();
        return stack.pop();
    }
}
// @lc code=end

