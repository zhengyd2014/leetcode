import java.util.Collections;
import java.util.Queue;

/*
 * @lc app=leetcode id=310 lang=java
 *
 * [310] Minimum Height Trees
 *
 * https://leetcode.com/problems/minimum-height-trees/description/
 *
 * algorithms
 * Medium (31.61%)
 * Likes:    1576
 * Dislikes: 89
 * Total Accepted:    86.6K
 * Total Submissions: 274K
 * Testcase Example:  '4\n[[1,0],[1,2],[1,3]]'
 *
 * For an undirected graph with tree characteristics, we can choose any node as
 * the root. The result graph is then a rooted tree. Among all possible rooted
 * trees, those with minimum height are called minimum height trees (MHTs).
 * Given such a graph, write a function to find all the MHTs and return a list
 * of their root labels.
 * 
 * Format
 * The graph contains n nodes which are labeled from 0 to n - 1. You will be
 * given the number n and a list of undirected edges (each edge is a pair of
 * labels).
 * 
 * You can assume that no duplicate edges will appear in edges. Since all edges
 * are undirected, [0, 1] is the same as [1, 0] and thus will not appear
 * together in edges.
 * 
 * Example 1 :
 * 
 * 
 * Input: n = 4, edges = [[1, 0], [1, 2], [1, 3]]
 * 
 * ⁠       0
 * ⁠       |
 * ⁠       1
 * ⁠      / \
 * ⁠     2   3 
 * 
 * Output: [1]
 * 
 * 
 * Example 2 :
 * 
 * 
 * Input: n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
 * 
 * ⁠    0  1  2
 * ⁠     \ | /
 * ⁠       3
 * ⁠       |
 * ⁠       4
 * ⁠       |
 * ⁠       5 
 * 
 * Output: [3, 4]
 * 
 * Note:
 * 
 * 
 * According to the definition of tree on Wikipedia: “a tree is an undirected
 * graph in which any two vertices are connected by exactly one path. In other
 * words, any connected graph without simple cycles is a tree.”
 * The height of a rooted tree is the number of edges on the longest downward
 * path between the root and a leaf.
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();
        if (n == 0 || edges.length != n - 1) return result;
        if (n == 1) return Collections.singletonList(0);

        List<Integer>[] graph = (List<Integer>[]) new List[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<Integer>();
        int[] degree = new int[n];
        buildGraph(edges, graph, degree);

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) q.offer(i);
        }

        while(n > 2) {
            int size = q.size();
            n -= size;
            for (int i = 0; i < size; i++) {
                int leave = q.poll();
                for (int neighbor : graph[leave]) {
                    degree[neighbor]--;
                    if (degree[neighbor] == 1) {
                        q.offer(neighbor);
                    }
                }
            }
        }

        while(!q.isEmpty()) {
            result.add(q.poll());
        }
        return result;
    }

    private void buildGraph(int[][] edges, List<Integer>[] graph, int[] degree) {
        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
            degree[e[0]]++;
            degree[e[1]]++;
        }
    }
}
// @lc code=end

