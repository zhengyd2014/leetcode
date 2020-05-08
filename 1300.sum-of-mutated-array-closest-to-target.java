/*
 * @lc app=leetcode id=1300 lang=java
 *
 * [1300] Sum of Mutated Array Closest to Target
 *
 * https://leetcode.com/problems/sum-of-mutated-array-closest-to-target/description/
 *
 * algorithms
 * Medium (45.63%)
 * Likes:    159
 * Dislikes: 28
 * Total Accepted:    6.9K
 * Total Submissions: 15.1K
 * Testcase Example:  '[4,9,3]\n10'
 *
 * Given an integer array arr and a target value target, return the integer
 * value such that when we change all the integers larger than value in the
 * given array to be equal to value, the sum of the array gets as close as
 * possible (in absolute difference) to target.
 * 
 * In case of a tie, return the minimum such integer.
 * 
 * Notice that the answer is not neccesarilly a number from arr.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: arr = [4,9,3], target = 10
 * Output: 3
 * Explanation: When using 3 arr converts to [3, 3, 3] which sums 9 and that's
 * the optimal answer.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: arr = [2,3,5], target = 10
 * Output: 5
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: arr = [60864,25176,27249,21296,20204], target = 56803
 * Output: 11361
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= arr.length <= 10^4
 * 1 <= arr[i], target <= 10^5
 * 
 */

// @lc code=start

// 1300. Sum of Mutated Array Closest to Target

// search: low - 0, high = max(arr)
// pay attention to range moving condition and direction.

class Solution {
    public int findBestValue(int[] arr, int target) {
        int l = 0;
        int h = arr[0];
        for (int num : arr) h = Math.max(h, num);
        
        while (l + 1 < h) {
            int mid = l + (h - l) / 2;
            int sum = sum(arr, mid);
            if ( sum < target ) {
                l = mid;
            } else {
                h = mid;
            }
        }
        
        if (Math.abs(target - sum(arr, l)) <= Math.abs(target - sum(arr, h))) return l;
        return h;
    }
    
    private int sum(int[] arr, int mid) {
        int sum = 0;
        for (int num : arr) {
            if (num > mid) sum += mid;
            else sum += num;
        }
        return sum;
    }
}

// @lc code=end

