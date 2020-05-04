/*
 * @lc app=leetcode id=986 lang=java
 *
 * [986] Interval List Intersections
 *
 * https://leetcode.com/problems/interval-list-intersections/description/
 *
 * algorithms
 * Medium (65.91%)
 * Likes:    874
 * Dislikes: 32
 * Total Accepted:    67.9K
 * Total Submissions: 102.8K
 * Testcase Example:  '[[0,2],[5,10],[13,23],[24,25]]\n[[1,5],[8,12],[15,24],[25,26]]'
 *
 * Given two lists of closed intervals, each list of intervals is pairwise
 * disjoint and in sorted order.
 * 
 * Return the intersection of these two interval lists.
 * 
 * (Formally, a closed interval [a, b] (with a <= b) denotes the set of real
 * numbers x with a <= x <= b.  The intersection of two closed intervals is a
 * set of real numbers that is either empty, or can be represented as a closed
 * interval.  For example, the intersection of [1, 3] and [2, 4] is [2,
 * 3].)
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * Input: A = [[0,2],[5,10],[13,23],[24,25]], B =
 * [[1,5],[8,12],[15,24],[25,26]]
 * Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 * Reminder: The inputs and the desired output are lists of Interval objects,
 * and not arrays or lists.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 0 <= A.length < 1000
 * 0 <= B.length < 1000
 * 0 <= A[i].start, A[i].end, B[i].start, B[i].end < 10^9
 * 
 * 
 * NOTE: input types have been changed on April 15, 2019. Please reset to
 * default code definition to get new method signature.
 * 
 * 
 */

// @lc code=start


//  986. Interval List Intersections
// just simulate 

class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        if (A.length == 0 || A.length == 0) return new int[][]{};
        
        int p1 = 0;
        int p2 = 0;
        List<int[]> list = new ArrayList<>();
        while(p1 < A.length && p2 < B.length) {
            int[] currA = A[p1];
            int[] currB = B[p2];
            if (currA[1] < currB[0]) p1++;
            else if (currA[0] > currB[1]) p2++;
            else {
                list.add(new int[] {Math.max(currA[0], currB[0]), Math.min(currA[1], currB[1])});
                if (currA[1] >= currB[1]) p2++;
                else p1++;
            }
        }
        
        int[][] result = new int[list.size()][2];
        list.toArray(result);
        return result;
    }
}

// @lc code=end

