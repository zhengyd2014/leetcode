/*
 * @lc app=leetcode id=1054 lang=java
 *
 * [1054] Distant Barcodes
 *
 * https://leetcode.com/problems/distant-barcodes/description/
 *
 * algorithms
 * Medium (41.07%)
 * Likes:    277
 * Dislikes: 16
 * Total Accepted:    12.8K
 * Total Submissions: 30.9K
 * Testcase Example:  '[1,1,1,2,2,2]'
 *
 * In a warehouse, there is a row of barcodes, where the i-th barcode is
 * barcodes[i].
 * 
 * Rearrange the barcodes so that no two adjacent barcodes are equal.  You may
 * return any answer, and it is guaranteed an answer exists.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: [1,1,1,2,2,2]
 * Output: [2,1,2,1,2,1]
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [1,1,1,1,2,2,3,3]
 * Output: [1,3,1,3,2,1,2,1]
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= barcodes.length <= 10000
 * 1 <= barcodes[i] <= 10000
 * 
 * 
 * 
 * 
 * 
 */

// @lc code=start


// 1054. Distant Barcodes

// count each barcode, then priority queue sort by count

// fill even position, then odd position.

class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int n = barcodes.length;
        
        int[] ans = new int[n];
        int[] count = new int[10001];
        for (int code : barcodes) {
            count[code]++;
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) continue;
            pq.offer(new int[] {i, count[i]});
        }
        
        int[] curr = new int[]{0, 0};
        for (int i = 0; i < n; i += 2) {
            if (curr[1] == 0 && !pq.isEmpty()) curr = pq.poll();
            ans[i] = curr[0];
            curr[1]--;
        }
        
        for (int i = 1; i < n; i += 2) {
            if (curr[1] == 0 && !pq.isEmpty()) curr = pq.poll();
            ans[i] = curr[0];
            curr[1]--;
        }
        
        return ans;
    }
}

// @lc code=end

