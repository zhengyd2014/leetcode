/*
 * @lc app=leetcode id=162 lang=java
 *
 * [162] Find Peak Element
 *
 * https://leetcode.com/problems/find-peak-element/description/
 *
 * algorithms
 * Medium (42.77%)
 * Likes:    1491
 * Dislikes: 1890
 * Total Accepted:    334.8K
 * Total Submissions: 781K
 * Testcase Example:  '[1,2,3,1]'
 *
 * A peak element is an element that is greater than its neighbors.
 * 
 * Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element
 * and return its index.
 * 
 * The array may contain multiple peaks, in that case return the index to any
 * one of the peaks is fine.
 * 
 * You may imagine that nums[-1] = nums[n] = -∞.
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,2,3,1]
 * Output: 2
 * Explanation: 3 is a peak element and your function should return the index
 * number 2.
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1,2,1,3,5,6,4]
 * Output: 1 or 5 
 * Explanation: Your function can return either index number 1 where the peak
 * element is 2, 
 * or index number 5 where the peak element is 6.
 * 
 * 
 * Note:
 * 
 * Your solution should be in logarithmic complexity.
 * 
 */

// @lc code=start


// 162. Find Peak Element

// check nums[mid] and nums[mid+1], move towords the larger half of the array
// mid + 1 will never out of range, as when there was 2 elements left, mid = l.

class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;
        
        int l = 0;
        int h = nums.length - 1;
        while (l + 1 < h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] > nums[mid + 1]) {
                h = mid;
            } else {
                l = mid;
            }
        }
        
        if (nums[l] > nums[h]) return l;
        return h;
    }
}

// @lc code=end

