/*
 * @lc app=leetcode id=621 lang=java
 *
 * [621] Task Scheduler
 *
 * https://leetcode.com/problems/task-scheduler/description/
 *
 * algorithms
 * Medium (47.79%)
 * Likes:    2677
 * Dislikes: 574
 * Total Accepted:    146.5K
 * Total Submissions: 306.1K
 * Testcase Example:  '["A","A","A","B","B","B"]\n2'
 *
 * Given a char array representing tasks CPU need to do. It contains capital
 * letters A to Z where different letters represent different tasks. Tasks
 * could be done without original order. Each task could be done in one
 * interval. For each interval, CPU could finish one task or just be idle.
 * 
 * However, there is a non-negative cooling interval n that means between two
 * same tasks, there must be at least n intervals that CPU are doing different
 * tasks or just be idle.
 * 
 * You need to return the least number of intervals the CPU will take to finish
 * all the given tasks.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
 * Output: 8
 * Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of tasks is in the range [1, 10000].
 * The integer n is in the range [0, 100].
 * 
 * 
 */

// @lc code=start
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int count[] = new int[26];
        for (char c : tasks) count[c - 'A']++;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int f : count) {
            if (f > 0) pq.offer(f);
        }
        
        int ans = 0;
        int cycle = n + 1;
        while (!pq.isEmpty()) {
            int cnt = 0;
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < cycle; i++) {
                if (!pq.isEmpty()) {
                    cnt++;
                    temp.add(pq.poll());
                }
            }
            
            for (int task : temp) {
                if (--task > 0) pq.offer(task);
            }
            
            ans += pq.isEmpty() ? cnt : cycle;
        }
        
        return ans;
    }
}
// @lc code=end

