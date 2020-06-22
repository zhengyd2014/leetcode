import java.util.HashSet;
import java.util.Queue;

/*
 * @lc app=leetcode id=207 lang=java
 *
 * [207] Course Schedule
 *
 * https://leetcode.com/problems/course-schedule/description/
 *
 * algorithms
 * Medium (39.54%)
 * Likes:    3084
 * Dislikes: 157
 * Total Accepted:    343.4K
 * Total Submissions: 833.3K
 * Testcase Example:  '2\n[[1,0]]'
 *
 * There are a total of numCourses courses you have to take, labeled from 0 to
 * numCourses-1.
 * 
 * Some courses may have prerequisites, for example to take course 0 you have
 * to first take course 1, which is expressed as a pair: [0,1]
 * 
 * Given the total number of courses and a list of prerequisite pairs, is it
 * possible for you to finish all courses?
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take. 
 * To take course 1 you should have finished course 0. So it is possible.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take. 
 * To take course 1 you should have finished course 0, and to take course 0 you
 * should
 * also have finished course 1. So it is impossible.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The input prerequisites is a graph represented by a list of edges, not
 * adjacency matrices. Read more about how a graph is represented.
 * You may assume that there are no duplicate edges in the input
 * prerequisites.
 * 1 <= numCourses <= 10^5
 * 
 * 
 */

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> dependants = new HashMap<>();
        for (int[] pre : prerequisites) {
            indegree[pre[0]]++;
            dependants.putIfAbsent(pre[1], new ArrayList<Integer>());
            dependants.get(pre[1]).add(pre[0]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        int cnt = numCourses;
        for (int i = 0; i < numCourses; i++) {   // iterate through couser number, not value of indgree.
            if (indegree[i] == 0) {
                q.offer(i);
                cnt--;
            }
        }
        
        while(!q.isEmpty()) {
            int course = q.poll();
            if (!dependants.containsKey(course)) continue;
            for (int dep : dependants.get(course)) {
                indegree[dep]--;
                if (indegree[dep] == 0) {
                    q.offer(dep);
                    cnt--;
                }
            }
        }
        
        return cnt == 0;
    }
}
// @lc code=end

