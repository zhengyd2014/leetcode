/*
 * @lc app=leetcode id=331 lang=java
 *
 * [331] Verify Preorder Serialization of a Binary Tree
 *
 * https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/description/
 *
 * algorithms
 * Medium (39.84%)
 * Likes:    696
 * Dislikes: 44
 * Total Accepted:    69.1K
 * Total Submissions: 173K
 * Testcase Example:  '"9,3,4,#,#,1,#,#,2,#,6,#,#"'
 *
 * One way to serialize a binary tree is to use pre-order traversal. When we
 * encounter a non-null node, we record the node's value. If it is a null node,
 * we record using a sentinel value such as #.
 * 
 * 
 * ⁠    _9_
 * ⁠   /   \
 * ⁠  3     2
 * ⁠ / \   / \
 * ⁠4   1  #  6
 * / \ / \   / \
 * # # # #   # #
 * 
 * 
 * For example, the above binary tree can be serialized to the string
 * "9,3,4,#,#,1,#,#,2,#,6,#,#", where # represents a null node.
 * 
 * Given a string of comma separated values, verify whether it is a correct
 * preorder traversal serialization of a binary tree. Find an algorithm without
 * reconstructing the tree.
 * 
 * Each comma separated value in the string must be either an integer or a
 * character '#' representing null pointer.
 * 
 * You may assume that the input format is always valid, for example it could
 * never contain two consecutive commas such as "1,,3".
 * 
 * Example 1:
 * 
 * 
 * Input: "9,3,4,#,#,1,#,#,2,#,6,#,#"
 * Output: true
 * 
 * Example 2:
 * 
 * 
 * Input: "1,#"
 * Output: false
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: "9,#,#,1"
 * Output: false
 */

// @lc code=start

// stack way: add current node in queue, then check last 3 elements
// cleanup, if last 2 is "#"

// use list to replace stack, as it need 

// observe way, no time degree will be equals to zero, till the end.

// https://www.cnblogs.com/grandyang/p/5174738.html


class Solution {
    public boolean isValidSerialization(String preorder) {
        int degree = 1;
        // boolean degree_is_zero = false;
        String[] nodes = preorder.split(",");
        
        for (String node : nodes) {
            //if (degree_is_zero) return false;
            if (degree == 0) return false;
            if (node.equals("#")) {
                degree--;
                // if (degree == 0) degree_is_zero = true;
            } else degree++;
        }

        return degree == 0;
    }
}
// @lc code=end

