/*
 * @lc app=leetcode id=630 lang=java
 *
 * [630] Course Schedule III
 *
 * https://leetcode.com/problems/course-schedule-iii/description/
 *
 * algorithms
 * Hard (32.92%)
 * Likes:    695
 * Dislikes: 30
 * Total Accepted:    19.9K
 * Total Submissions: 59.9K
 * Testcase Example:  '[[100,200],[200,1300],[1000,1250],[2000,3200]]'
 *
 * There are n different online courses numbered from 1 to n. Each course has
 * some duration(course length) t and closed on dth day. A course should be
 * taken continuously for t days and must be finished before or on the dth day.
 * You will start at the 1st day.
 * 
 * Given n online courses represented by pairs (t,d), your task is to find the
 * maximal number of courses that can be taken.
 * 
 * Example:
 * 
 * 
 * Input: [[100, 200], [200, 1300], [1000, 1250], [2000, 3200]]
 * Output: 3
 * Explanation: 
 * There're totally 4 courses, but you can take 3 courses at most:
 * First, take the 1st course, it costs 100 days so you will finish it on the
 * 100th day, and ready to take the next course on the 101st day.
 * Second, take the 3rd course, it costs 1000 days so you will finish it on the
 * 1100th day, and ready to take the next course on the 1101st day. 
 * Third, take the 2nd course, it costs 200 days so you will finish it on the
 * 1300th day. 
 * The 4th course cannot be taken now, since you will finish it on the 3300th
 * day, which exceeds the closed date.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * The integer 1 <= d, t, n <= 10,000.
 * You can't take two courses simultaneously.
 * 
 * 
 * 
 * 
 */

// @lc code=start


// greedy
// when need to remove a course, remove the one with longest duration.

// https://www.cnblogs.com/grandyang/p/7126289.html

/*这道题给的提示是用贪婪算法，那么我们首先给课程排个序，按照结束时间的顺序来排序，
我们维护一个当前的时间，初始化为0，再建立一个优先数组，然后我们遍历每个课程，
对于每一个遍历到的课程，当前时间加上该课程的持续时间，然后将该持续时间放入优先数组中，
然后我们判断如果当前时间大于课程的结束时间，说明这门课程无法被完成，我们并不是直
接减去当前课程的持续时间，而是取出优先数组的顶元素，即用时最长的一门课，这也make sense，
因为我们的目标是尽可能的多上课，既然非要去掉一门课，那肯定是去掉耗时最长的课，这样省下来
的时间说不定能多上几门课呢，最后返回优先队列中元素的个数就是能完成的课程总数啦，
*/

class Solution {
    
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b)-> a[1] - b[1]);
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);

        int time = 0;
        for (int i = 0; i < courses.length; i++) {
            int[] curr = courses[i];
            time += curr[0];
            q.offer(curr[0]);
            while (time > curr[1]) {
                time -= q.poll();
            }
        }
        return q.size();
    }
    
}

// @lc code=end

