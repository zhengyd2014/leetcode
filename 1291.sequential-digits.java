/*
 * @lc app=leetcode id=1291 lang=java
 *
 * [1291] Sequential Digits
 *
 * https://leetcode.com/problems/sequential-digits/description/
 *
 * algorithms
 * Medium (52.04%)
 * Likes:    129
 * Dislikes: 14
 * Total Accepted:    9K
 * Total Submissions: 17.3K
 * Testcase Example:  '100\n300'
 *
 * An integer has sequential digits if and only if each digit in the number is
 * one more than the previous digit.
 * 
 * Return a sorted list of all the integers in the range [low, high] inclusive
 * that have sequential digits.
 * 
 * 
 * Example 1:
 * Input: low = 100, high = 300
 * Output: [123,234]
 * Example 2:
 * Input: low = 1000, high = 13000
 * Output: [1234,2345,3456,4567,5678,6789,12345]
 * 
 * 
 * Constraints:
 * 
 * 
 * 10 <= low <= high <= 10^9
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();
        
        for (int i = 1; i <= 9; i++) {
            int num = i;
            while (num <= high) {
                if (num >= low) result.add(num);
                int reminder = num % 10;
                if (reminder == 9) break;
                num = num * 10 + reminder + 1;
            }
        }

        Collections.sort(result);
        return result;
    }
}
// @lc code=end

