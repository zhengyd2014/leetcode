/*
 * @lc app=leetcode id=154 lang=java
 *
 * [154] Find Minimum in Rotated Sorted Array II
 *
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/description/
 *
 * algorithms
 * Hard (40.36%)
 * Likes:    754
 * Dislikes: 199
 * Total Accepted:    168.5K
 * Total Submissions: 417.4K
 * Testcase Example:  '[1,3,5]'
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * 
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 * 
 * Find the minimum element.
 * 
 * The array may contain duplicates.
 * 
 * Example 1:
 * 
 * 
 * Input: [1,3,5]
 * Output: 1
 * 
 * Example 2:
 * 
 * 
 * Input: [2,2,2,0,1]
 * Output: 0
 * 
 * Note:
 * 
 * 
 * This is a follow up problem to Find Minimum in Rotated Sorted Array.
 * Would allow duplicates affect the run-time complexity? How and why?
 * 
 * 
 */

// @lc code=start

// check nums[mid] aginst nums[h]
// if equals: h--

class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int h = nums.length - 1;
        while (l + 1 < h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] < nums[h]) h = mid;
            else if (nums[mid] > nums[h]) l = mid;
            else h--;
        }

        if (nums[l] > nums[h]) return nums[h];
        return nums[l];
    }
}
// @lc code=end

