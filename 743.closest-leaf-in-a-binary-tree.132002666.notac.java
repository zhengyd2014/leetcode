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
    
    
    public int findClosestLeaf(TreeNode root, int k) {
        Map<Integer, Set<TreeNode>> graph = new HashMap<>();
        addNodeToGraph(graph, root);
        
        Queue<TreeNode> q = new LinkedList<>();
        if (root.val == k && root.left == null && root.right == null) {
            return root.val;
        } 
        
        for (TreeNode node: graph.get(k)) {
            q.offer(node);
        }
        
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node.left == null && node.right == null) {
                return node.val;
            }
            
            if (node.left != null) {
                q.offer(node.left);
            } 
            
            if (node.right != null) {
                q.offer(node.right);
            }
        }
        
        return 0;
    }
    
    
    private void addNodeToGraph(Map<Integer, Set<TreeNode>> graph, TreeNode root) {
        if (root == null) {
            return;
        }

        connect(graph, root, root.left);
        addNodeToGraph(graph, root.left);
        connect(graph, root, root.right);
        addNodeToGraph(graph, root.right);
    }

    private void connect(Map<Integer, Set<TreeNode>> graph, TreeNode node1, TreeNode node2) {
        if (node1 == null || node2 == null) {
            return;
        }

        if (!graph.containsKey(node1.val)) {
            graph.put(node1.val, new HashSet<TreeNode>());
        }
        graph.get(node1.val).add(node2);

        if (!graph.containsKey(node2.val)) {
            graph.put(node2.val, new HashSet<TreeNode>());
        }
        graph.get(node2.val).add(node1);
    }
}

