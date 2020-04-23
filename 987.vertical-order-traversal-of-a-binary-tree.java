/*
 * @lc app=leetcode id=987 lang=java
 *
 * [987] Vertical Order Traversal of a Binary Tree
 *
 * https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/description/
 *
 * algorithms
 * Medium (34.39%)
 * Likes:    399
 * Dislikes: 934
 * Total Accepted:    38.8K
 * Total Submissions: 112.9K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, return the vertical order traversal of its nodes
 * values.
 * 
 * For each node at position (X, Y), its left and right children respectively
 * will be at positions (X-1, Y-1) and (X+1, Y-1).
 * 
 * Running a vertical line from X = -infinity to X = +infinity, whenever the
 * vertical line touches some nodes, we report the values of the nodes in order
 * from top to bottom (decreasing Y coordinates).
 * 
 * If two nodes have the same position, then the value of the node that is
 * reported first is the value that is smaller.
 * 
 * Return an list of non-empty reports in order of X coordinate.  Every report
 * will have a list of values of nodes.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * 
 * Input: [3,9,20,null,null,15,7]
 * Output: [[9],[3,15],[20],[7]]
 * Explanation: 
 * Without loss of generality, we can assume the root node is at position (0,
 * 0):
 * Then, the node with value 9 occurs at position (-1, -1);
 * The nodes with values 3 and 15 occur at positions (0, 0) and (0, -2);
 * The node with value 20 occurs at position (1, -1);
 * The node with value 7 occurs at position (2, -2).
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * 
 * 
 * Input: [1,2,3,4,5,6,7]
 * Output: [[4],[2],[1,5,6],[3],[7]]
 * Explanation: 
 * The node with value 5 and the node with value 6 have the same position
 * according to the given scheme.
 * However, in the report "[1,5,6]", the node value of 5 comes first since 5 is
 * smaller than 6.
 * 
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * The tree will have between 1 and 1000 nodes.
 * Each node's value will be between 0 and 1000.
 * 
 * 
 * 
 * 
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
    Map<Integer, PriorityQueue<int[]>> map;
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        
        map = new HashMap<>();
        buildMap(root, 0, 0);
        
        int leftmost = 0, rightmost = 0;
        for (int x : map.keySet()) {
            if (x < leftmost) leftmost = x;
            if (x > rightmost) rightmost = x;
        }
        
        for (int i = leftmost; i <= rightmost; i++) {
            List<Integer> list = new ArrayList<>();
            Queue<int[]> q = map.get(i);
            while (!q.isEmpty()) {
                list.add(q.poll()[1]);
            }
            result.add(list);
        }
        
        return result;
    }
    
    
    private void buildMap(TreeNode root, int x, int y) {
        if (root == null) return;
        
        map.putIfAbsent(x, new PriorityQueue<int[]>(new NodeComparator()));
        map.get(x).offer(new int[] {y, root.val});
        buildMap(root.left, x - 1, y - 1);
        buildMap(root.right, x + 1, y - 1);
    }
       
    class NodeComparator implements Comparator<int[]> {
        
        // a[0] -- y 
        // a[1] -- val of node
        public int compare(int[] a, int[] b) {
            if (a[0] != b[0]) {
                return b[0] - a[0];
            } else {
                return a[1] - b[1];
            }
        }
    }
}
// @lc code=end

