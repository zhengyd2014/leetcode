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

// @lc code=start
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return true;

        int[] indegree = new int[numCourses];
        List<Integer>[] dependants = (List<Integer>[]) new List[numCourses];
        for (int i = 0; i < numCourses; i++) dependants[i] = new ArrayList<>();
        
        for (int[] prerequisite : prerequisites) {
            indegree[prerequisite[0]]++;
            dependants[prerequisite[1]].add(prerequisite[0]);
        }

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                visited.add(i);
                q.add(i);
            }
        }

        while(!q.isEmpty()) {
            int course = q.poll();
            
            for (int dependant : dependants[course]) {
                if (!visited.contains(dependant)) {
                    indegree[dependant]--;
                    if (indegree[dependant] == 0) {
                        visited.add(dependant);
                        q.offer(dependant);
                    } 
                }
            }
        }

        return visited.size() == numCourses;

    }
}
// @lc code=end

