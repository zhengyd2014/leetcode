import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
 * @lc app=leetcode id=743 lang=java
 *
 * [743] Network Delay Time
 *
 * https://leetcode.com/problems/network-delay-time/description/
 *
 * algorithms
 * Medium (45.40%)
 * Likes:    1207
 * Dislikes: 207
 * Total Accepted:    77.1K
 * Total Submissions: 170K
 * Testcase Example:  '[[2,1,1],[2,3,1],[3,4,1]]\n4\n2'
 *
 * There are N network nodes, labelled 1 to N.
 * 
 * Given times, a list of travel times as directed edges times[i] = (u, v, w),
 * where u is the source node, v is the target node, and w is the time it takes
 * for a signal to travel from source to target.
 * 
 * Now, we send a signal from a certain node K. How long will it take for all
 * nodes to receive the signal? If it is impossible, return -1.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * Input: times = [[2,1,1],[2,3,1],[3,4,1]], N = 4, K = 2
 * Output: 2
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * N will be in the range [1, 100].
 * K will be in the range [1, N].
 * The length of times will be in the range [1, 6000].
 * All edges times[i] = (u, v, w) will have 1 <= u, v <= N and 0 <= w <= 100.
 * 
 * 
 */

// @lc code=start
class Solution {

    public int networkDelayTime(int[][] times, int N, int K) {

        // build graph
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : times) {
            graph.putIfAbsent(edge[0], new ArrayList<int[]>());
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }

        Map<Integer, Integer> dist = new HashMap<>();
        dist.put(K, 0);
        Queue<Integer> q = new LinkedList<>();
        q.add(K);
        while (!q.isEmpty()) {
            int curr = q.poll();
            if (!graph.containsKey(curr)) continue;

            for (int[] neighbor : graph.get(curr)) {
                if (!dist.containsKey(neighbor[0])) {
                    dist.put(neighbor[0], dist.get(curr) + neighbor[1]);
                    q.offer(neighbor[0]);
                } else if (dist.get(neighbor[0]) > dist.get(curr) + neighbor[1]) {
                    dist.put(neighbor[0], dist.get(curr) + neighbor[1]);
                    q.offer(neighbor[0]);
                }
            }
        }

        if (dist.size() != N) return -1;
        int ans = 0;
        for (int t : dist.values()) {
            if (t > ans) {
                ans = t;
            }
        }

        return ans;

    }
}
// @lc code=end

