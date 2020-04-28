/*
 * @lc app=leetcode id=875 lang=java
 *
 * [875] Koko Eating Bananas
 *
 * https://leetcode.com/problems/koko-eating-bananas/description/
 *
 * algorithms
 * Medium (50.03%)
 * Likes:    599
 * Dislikes: 62
 * Total Accepted:    32.6K
 * Total Submissions: 64.7K
 * Testcase Example:  '[3,6,7,11]\n8'
 *
 * Koko loves to eat bananas.  There are N piles of bananas, the i-th pile has
 * piles[i] bananas.  The guards have gone and will come back in H hours.
 * 
 * Koko can decide her bananas-per-hour eating speed of K.  Each hour, she
 * chooses some pile of bananas, and eats K bananas from that pile.  If the
 * pile has less than K bananas, she eats all of them instead, and won't eat
 * any more bananas during this hour.
 * 
 * Koko likes to eat slowly, but still wants to finish eating all the bananas
 * before the guards come back.
 * 
 * Return the minimum integer K such that she can eat all the bananas within H
 * hours.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: piles = [3,6,7,11], H = 8
 * Output: 4
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: piles = [30,11,23,4,20], H = 5
 * Output: 30
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: piles = [30,11,23,4,20], H = 6
 * Output: 23
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= piles.length <= 10^4
 * piles.length <= H <= 10^9
 * 1 <= piles[i] <= 10^9
 * 
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        // Write your code here
        int l = 1, r = piles[0];
        for (int p : piles) r = Math.max(p, r);
     
        while (l + 1 < r) {
            int m = (l + r) / 2, total = 0;
            if (getHours(piles, m) > H) {
                l = m;
            } else 
                r = m;
        }
        
        if (getHours(piles, l) <= H) return l;
        if (getHours(piles, r) <= H) return r;
        return 0;
    }
    
    int getHours(int[] piles, int m) {
        int cnt = 0;
        for (int p : piles) {
            cnt += p / m;
            if (p % m != 0) cnt++;
        }
        
        return cnt;
    }
}
// @lc code=end

