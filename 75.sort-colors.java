/*
 * @lc app=leetcode id=75 lang=java
 *
 * [75] Sort Colors
 *
 * https://leetcode.com/problems/sort-colors/description/
 *
 * algorithms
 * Medium (45.10%)
 * Likes:    2785
 * Dislikes: 204
 * Total Accepted:    440K
 * Total Submissions: 971.4K
 * Testcase Example:  '[2,0,2,1,1,0]'
 *
 * Given an array with n objects colored red, white or blue, sort them in-place
 * so that objects of the same color are adjacent, with the colors in the order
 * red, white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red,
 * white, and blue respectively.
 * 
 * Note: You are not suppose to use the library's sort function for this
 * problem.
 * 
 * Example:
 * 
 * 
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * 
 * Follow up:
 * 
 * 
 * A rather straight forward solution is a two-pass algorithm using counting
 * sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then
 * overwrite array with total number of 0's, then 1's and followed by 2's.
 * Could you come up with a one-pass algorithm using only constant space?
 * 
 * 
 */

// @lc code=start

// 75. Sort Colors

// two pointers, red pointer for 0, blue pointer for 2.
// note the 'i--', after swap with blue point!

class Solution {
    public void sortColors(int[] nums) {
        int red = 0; 
        int blue = nums.length - 1;
        for (int i = 0; i <= blue; i++) {
            if (nums[i] == 0) swap(nums, red++, i);            // after swap, nums[i] is must be 0 or 1, need to move on
            else if (nums[i] == 2) swap(nums, blue--, i--);    // after swap, nums[i] could be 0 or 1, 0, 2, need to check again.
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

// @lc code=end

