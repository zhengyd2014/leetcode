/*
 * [137] Single Number II
 *
 * https://leetcode.com/problems/single-number-ii/description/
 *
 * algorithms
 * Medium (42.12%)
 * Total Accepted:    127K
 * Total Submissions: 301.4K
 * Testcase Example:  '[1]'
 *
 * 
 * Given an array of integers, every element appears three times except for
 * one, which appears exactly once. Find that single one.
 * 
 * 
 * 
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement
 * it without using extra memory?
 * 
 */
class Solution {
    public int singleNumber(int[] nums) {
	int ans = 0;
	for (int i = 0; i < 32; i++) {
	 	int mask = 1 << i;
		int count = 0;
		for (int num : nums) {
        		if ( (num & mask) != 0) {
				count++;
			}
		}
		if (count % 3 != 0) {
             	   ans |= mask;
            	}
	}

	return ans;
    }
}
