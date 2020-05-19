/*
 * [264] Ugly Number II
 *
 * https://leetcode.com/problems/ugly-number-ii/description/
 *
 * algorithms
 * Medium (33.24%)
 * Total Accepted:    70.6K
 * Total Submissions: 212.5K
 * Testcase Example:  '1'
 *
 * 
 * Write a program to find the n-th ugly number.
 * 
 * 
 * 
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10
 * ugly numbers.
 * 
 * 
 * 
 * Note that 1 is typically treated as an ugly number, and n does not exceed
 * 1690.
 * 
 * 
 * Credits:Special thanks to @jianchao.li.fighter for adding this problem and
 * creating all test cases.
 */

// dp: 
//  dp[0] = 1
//  dp[i] = 


class Solution {
    public int nthUglyNumber(int n) {
		if (n <= 0) {
			throw new IllegalArgumentException("can't less than 0");
		}

		int[] ugly = new int[n];
		int i2 = 0, i3 = 0, i5 = 0;
		ugly[0] = 1;
		for (int i = 1; i < n; i++) {
			ugly[i] = Math.min(2 * ugly[i2], Math.min(3 * ugly[i3], 5 * ugly[i5]));
			if (ugly[i] == 2 * ugly[i2]) i2++;
			if (ugly[i] == 3 * ugly[i3]) i3++;
			if (ugly[i] == 5 * ugly[i5]) i5++;
		}

		return ugly[n - 1];
	}
	

	// 264. Ugly Number II

	// pq: need to get rid of duplicate values


    public int nthUglyNumber2(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.offer(1L);
        while (n > 1) {
            long curr = pq.poll();
            while (!pq.isEmpty() && pq.peek() == curr) pq.poll();
            pq.offer(curr * 2);
            pq.offer(curr * 3);
            pq.offer(curr * 5);
            n--;
        }
        
        return pq.peek().intValue();
    }
}
