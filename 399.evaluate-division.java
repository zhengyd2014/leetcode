import java.util.Queue;

/*
 * @lc app=leetcode id=399 lang=java
 *
 * [399] Evaluate Division
 *
 * https://leetcode.com/problems/evaluate-division/description/
 *
 * algorithms
 * Medium (50.36%)
 * Likes:    1949
 * Dislikes: 147
 * Total Accepted:    115K
 * Total Submissions: 228.4K
 * Testcase Example:  '[["a","b"],["b","c"]]\n[2.0,3.0]\n[["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]'
 *
 * Equations are given in the format A / B = k, where A and B are variables
 * represented as strings, and k is a real number (floating point number).
 * Given some queries, return the answers. If the answer does not exist, return
 * -1.0.
 * 
 * Example:
 * Given  a / b = 2.0, b / c = 3.0.
 * queries are:  a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
 * return  [6.0, 0.5, -1.0, 1.0, -1.0 ].
 * 
 * The input is:  vector<pair<string, string>> equations, vector<double>&
 * values, vector<pair<string, string>> queries , where equations.size() ==
 * values.size(), and the values are positive. This represents the equations.
 * Return  vector<double>.
 * 
 * According to the example above:
 * 
 * 
 * equations = [ ["a", "b"], ["b", "c"] ],
 * values = [2.0, 3.0],
 * queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"]
 * ]. 
 * 
 * 
 * 
 * The input is always valid. You may assume that evaluating the queries will
 * result in no division by zero and there is no contradiction.
 * 
 */

// @lc code=start
class Solution {

    class Edge {
        String to;
        double weight;
        public Edge (String to, double weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Edge>> graph = buildGraph(equations, values);
        double[] result = new double[queries.size()];
    
        for (int i = 0; i < queries.size(); i++) {
            result[i] = dfs(graph, queries.get(i).get(0), queries.get(i).get(1), new HashSet<String>());
        }

        return result;
    }

    private double dfs(Map<String, List<Edge>> graph, String start, String end, Set<String> visited) {
        if (!graph.containsKey(start) || !graph.containsKey(end)) return -1.0;

        if (start.equals(end)) return 1.0;
        visited.add(start);
        for (Edge edge : graph.get(start)) {
            if (visited.contains(edge.to)) continue;
            double d = dfs(graph, edge.to, end, visited);
            if (d > 0) return d * edge.weight;
        }

        return -1.0;
    }

    private Map<String, List<Edge>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, List<Edge>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equattion = equations.get(i);
            String a = equattion.get(0);
            String b = equattion.get(1);
            if (!graph.containsKey(a)) {
                graph.put(a, new ArrayList<Edge>());
            }
            if (!graph.containsKey(b)) {
                graph.put(b, new ArrayList<Edge>());
            }

            graph.get(a).add(new Edge(b, values[i]));
            graph.get(b).add(new Edge(a, 1.0 / values[i]));
        }

        return graph;
    }
}


// @lc code=end

