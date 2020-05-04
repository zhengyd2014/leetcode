/*
 * @lc app=leetcode id=1248 lang=java
 *
 * [1248] Count Number of Nice Subarrays
 *
 * https://leetcode.com/problems/count-number-of-nice-subarrays/description/
 *
 * algorithms
 * Medium (54.66%)
 * Likes:    296
 * Dislikes: 9
 * Total Accepted:    12.1K
 * Total Submissions: 22K
 * Testcase Example:  '[1,1,2,1,1]\n3'
 *
 * Given an array of integers nums and an integer k. A subarray is called nice
 * if there are k odd numbers on it.
 * 
 * Return the number of nice sub-arrays.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,1,2,1,1], k = 3
 * Output: 2
 * Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and
 * [1,2,1,1].
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [2,4,6], k = 1
 * Output: 0
 * Explanation: There is no odd numbers in the array.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
 * Output: 16
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 50000
 * 1 <= nums[i] <= 10^5
 * 1 <= k <= nums.length
 * 
 * 
 */

// @lc code=start


// 1248. Count Number of Nice Subarrays

// when moving right pointer, if there are matching before, add them into ans

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        
        if (nums.length == 0 || k < 0) return 0;
        
        int left = 0;
        int match = 0;     // record how many matches from moving left pointer
        int oddCount = 0;
        int ans = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] % 2 == 1) oddCount++;
            
            if (oddCount == k) match = 0;
            while (oddCount == k) {
                match++;
                if (nums[left++] % 2 == 1) oddCount--;
            }
            
            ans += match;
        }
        
        return ans;
    }
}

// @lc code=end

