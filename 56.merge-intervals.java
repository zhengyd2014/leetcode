/*
 * [56] Merge Intervals
 *
 * https://leetcode.com/problems/merge-intervals/description/
 *
 * algorithms
 * Medium (31.57%)
 * Total Accepted:    177.7K
 * Total Submissions: 562.6K
 * Testcase Example:  '[[1,3],[2,6],[8,10],[15,18]]'
 *
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * 
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 * 
 */
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
		if (intervals == null || intervals.size() == 0) {
			return intervals;
		}

		Collections.sort(intervals, (a, b) -> a.start - b.start);
		Interval prev = intervals.get(0);
		List<Interval> merged = new ArrayList<>();
		for (int i = 1; i < intervals.size(); i++) {
			Interval curr = intervals.get(i);
			if (curr.start <= prev.end) {
				prev.end = Math.max(prev.end, curr.end);
			} else {
				merged.add(prev);
				prev = curr;
			}
		}		

		merged.add(prev);
		return merged;
    }
}
