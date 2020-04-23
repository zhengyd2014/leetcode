import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=863 lang=java
 *
 * [863] All Nodes Distance K in Binary Tree
 *
 * https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/
 *
 * algorithms
 * Medium (53.40%)
 * Likes:    1634
 * Dislikes: 37
 * Total Accepted:    61.4K
 * Total Submissions: 114.8K
 * Testcase Example:  '[3,5,1,6,2,0,8,null,null,7,4]\n5\n2'
 *
 * We are given a binary tree (with root node root), a target node, and an
 * integer value K.
 * 
 * Return a list of the values of all nodes that have a distance K from the
 * target node.  The answer can be returned in any order.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
 * 
 * Output: [7,4,1]
 * 
 * Explanation: 
 * The nodes that are a distance 2 from the target node (with value 5)
 * have values 7, 4, and 1.
 * 
 * 
 * 
 * Note that the inputs "root" and "target" are actually TreeNodes.
 * The descriptions of the inputs above are just serializations of these
 * objects.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * The given tree is non-empty.
 * Each node in the tree has unique values 0 <= node.val <= 500.
 * The target node is a node in the tree.
 * 0 <= K <= 1000.
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

    Map<TreeNode, List<TreeNode>> g = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        buildGraph(root);
        int step = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        Set<TreeNode> visited = new HashSet<>();

        while(!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (visited.contains(curr)) continue;
                visited.add(curr);

                if (step == K) {
                    result.add(curr.val);
                    continue;
                }

                if (!g.containsKey(curr)) continue;
                for (TreeNode neighbor : g.get(curr)) {
                    q.offer(neighbor);
                }
            }

            step++;
        }

        return result;
    }

    private void buildGraph(TreeNode root) {
        if (root == null) return;
        if (root.left != null) {
            g.putIfAbsent(root, new ArrayList<TreeNode>());
            g.putIfAbsent(root.left, new ArrayList<TreeNode>());
            g.get(root).add(root.left);
            g.get(root.left).add(root);
        }

        if (root.right != null) {
            g.putIfAbsent(root, new ArrayList<TreeNode>());
            g.putIfAbsent(root.right, new ArrayList<TreeNode>());
            g.get(root).add(root.right);
            g.get(root.right).add(root);
        }

        buildGraph(root.left);
        buildGraph(root.right);
    }
}
// @lc code=end

