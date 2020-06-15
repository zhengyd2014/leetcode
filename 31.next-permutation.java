/*
 * @lc app=leetcode id=31 lang=java
 *
 * [31] Next Permutation
 *
 * https://leetcode.com/problems/next-permutation/description/
 *
 * algorithms
 * Medium (31.95%)
 * Likes:    3086
 * Dislikes: 1110
 * Total Accepted:    352.2K
 * Total Submissions: 1.1M
 * Testcase Example:  '[1,2,3]'
 *
 * Implement next permutation, which rearranges numbers into the
 * lexicographically next greater permutation of numbers.
 * 
 * If such arrangement is not possible, it must rearrange it as the lowest
 * possible order (ie, sorted in ascending order).
 * 
 * The replacement must be in-place and use only constant extra memory.
 * 
 * Here are some examples. Inputs are in the left-hand column and its
 * corresponding outputs are in the right-hand column.
 * 
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * 
 */

// @lc code=start

// 注意：

class Solution {
    public void nextPermutation(int[] nums) {
       
        if (nums.length <= 1) return;
        
        int i = nums.length - 2;
        while (i >= 0) {
            if (nums[i] < nums[i+1]) break;
            i--;
        }
        
        if (i < 0) {            // 判断全反序
            Arrays.sort(nums);
            return;
        }
        
        int j = nums.length - 1;
        while(j > i) {
            if (nums[j] > nums[i]) break;
            j--;
        }
        
        swap(nums, i, j);
        reverse(nums, i+1, nums.length - 1);   // 后面reverse
    }
    
    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
// @lc code=end

