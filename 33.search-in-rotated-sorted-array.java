/*
 * [33] Search in Rotated Sorted Array
 *
 * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 *
 * algorithms
 * Medium (32.05%)
 * Total Accepted:    218.9K
 * Total Submissions: 683K
 * Testcase Example:  '[]\n5'
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * You are given a target value to search. If found in the array return its
 * index, otherwise return -1.
 * 
 * You may assume no duplicate exists in the array.
 */

 // 33. Search in Rotated Sorted Array

// check the in order half.

class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        
        int l = 0;
        int h = nums.length - 1;
        while (l + 1 < h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < nums[h]) {   // right side in order
                if (nums[mid] < target && target <= nums[h]) l = mid;
                else h = mid;
            } else {  // left side in order
                if (nums[l] <= target && target < nums[mid]) h = mid;
                else l = mid;
            }
        }
        
        if (nums[l] == target) return l;
        if (nums[h] == target) return h;
        return -1;
    }
}
