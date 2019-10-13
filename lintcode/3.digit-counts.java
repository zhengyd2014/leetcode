/*
 * @lc app=lintcode id=3 lang=java
 *
 * [3] Digit Counts
 *
 * https://www.lintcode.com/problem/digit-counts/description
 *
 * lintcode
 * Medium (31.00%)
 * Total Accepted:    25512
 * Total Submissions: 81830
 * Testcase Example:  '1\n1'
 *
 * Count the number of *k*'s between *0* and *n*. *k* can be *0* - *9*.
 */
public class Solution {
    /**
     * @param k: An integer
     * @param n: An integer
     * @return: An integer denote the count of digit k in 1..n
     */
    public int digitCounts(int k, int n) {
        // write your code here
        int count = 0;
        for (int i = k; i <= n; i++) {
            count += singleCount(k, i);
        }
        return count;
    }

    public int singleCount(int k, int i) {
        if (k == 0 && i == 0) return 1;

        int count = 0;
        while (i > 0) {
            if (i % 10 == k) count++;
            i /= 10;
        }
        return count;
    }
}
