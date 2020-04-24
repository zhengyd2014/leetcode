/*
 * @lc app=leetcode id=655 lang=java
 *
 * [655] Print Binary Tree
 *
 * https://leetcode.com/problems/print-binary-tree/description/
 *
 * algorithms
 * Medium (54.04%)
 * Likes:    310
 * Dislikes: 737
 * Total Accepted:    29.9K
 * Total Submissions: 55.3K
 * Testcase Example:  '[1,2]'
 *
 * Print a binary tree in an m*n 2D string array following these rules: 
 * 
 * 
 * The row number m should be equal to the height of the given binary tree.
 * The column number n should always be an odd number.
 * The root node's value (in string format) should be put in the exactly middle
 * of the first row it can be put. The column and the row where the root node
 * belongs will separate the rest space into two parts (left-bottom part and
 * right-bottom part). You should print the left subtree in the left-bottom
 * part and print the right subtree in the right-bottom part. The left-bottom
 * part and the right-bottom part should have the same size. Even if one
 * subtree is none while the other is not, you don't need to print anything for
 * the none subtree but still need to leave the space as large as that for the
 * other subtree. However, if two subtrees are none, then you don't need to
 * leave space for both of them. 
 * Each unused space should contain an empty string "".
 * Print the subtrees following the same rules.
 * 
 * 
 * Example 1:
 * 
 * Input:
 * ⁠    1
 * ⁠   /
 * ⁠  2
 * Output:
 * [["", "1", ""],
 * ⁠["2", "", ""]]
 * 
 * 
 * 
 * 
 * Example 2:
 * 
 * Input:
 * ⁠    1
 * ⁠   / \
 * ⁠  2   3
 * ⁠   \
 * ⁠    4
 * Output:
 * [["", "", "", "1", "", "", ""],
 * ⁠["", "2", "", "", "", "3", ""],
 * ⁠["", "", "4", "", "", "", ""]]
 * 
 * 
 * 
 * Example 3:
 * 
 * Input:
 * ⁠     1
 * ⁠    / \
 * ⁠   2   5
 * ⁠  / 
 * ⁠ 3 
 * ⁠/ 
 * 4 
 * Output:
 * 
 * [["",  "",  "", "",  "", "", "", "1", "",  "",  "",  "",  "", "", ""]
 * ⁠["",  "",  "", "2", "", "", "", "",  "",  "",  "",  "5", "", "", ""]
 * ⁠["",  "3", "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]
 * ⁠["4", "",  "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]]
 * 
 * 
 * 
 * Note:
 * The height of binary tree is in the range of [1, 10].
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

// 
// fill out an array, demision as: height *  (2 ^ height - 1)
class Solution {
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> result = new ArrayList<>();
        if (root == null) return result;
        int height = getHeight(root);
        int width = (1 << height) - 1;

        for (int r = 0; r < height; r++ ) {
            List<String> row = new ArrayList<>();
            for (int c = 0; c < width; c++) {
                row.add("");
            }
            result.add(row);
        }

        fill(root, 0, 0, width - 1, result);
        return result;
    }

    private void fill(TreeNode root, int level, int left, int right, List<List<String>> result) {
        if (root == null) return;

        int col = (left + right) / 2;
        result.get(level).set(col, String.valueOf(root.val));

        fill(root.left, level + 1, left, col - 1, result);
        fill(root.right, level + 1, col + 1, right, result);
    }

    private int getHeight(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}
// @lc code=end

