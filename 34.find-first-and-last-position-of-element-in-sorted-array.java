/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 *
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 *
 * algorithms
 * Medium (35.35%)
 * Likes:    3004
 * Dislikes: 134
 * Total Accepted:    463.4K
 * Total Submissions: 1.3M
 * Testcase Example:  '[5,7,7,8,8,10]\n8'
 *
 * Given an array of integers nums sorted in ascending order, find the starting
 * and ending position of a given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * 
 */

// @lc code=start

// 34. Find First and Last Position of Element in Sorted Array

// 2 rounds.

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[] {-1, -1};
        return new int[] {findLeftEdge(nums, target), findRightEdge(nums, target) };
    }
    
    private int findLeftEdge(int[] nums, int target) {
        int l = 0;
        int h = nums.length - 1;
        
        while (l + 1 < h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] >= target) h = mid;
            else l = mid;
        }
        
        if (nums[l] == target) return l;
        if (nums[h] == target) return h;
        return -1;
    }
    
    private int findRightEdge(int[] nums, int target) {
        int l = 0;
        int h = nums.length - 1;
        
        while (l + 1 < h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] <= target) l = mid;
            else h = mid;
        }
        
        if (nums[h] == target) return h;
        if (nums[l] == target) return l;
        return -1;
    }
}

// @lc code=end

