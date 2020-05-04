/*
 * @lc app=leetcode id=93 lang=java
 *
 * [93] Restore IP Addresses
 *
 * https://leetcode.com/problems/restore-ip-addresses/description/
 *
 * algorithms
 * Medium (34.15%)
 * Likes:    1074
 * Dislikes: 466
 * Total Accepted:    179.6K
 * Total Submissions: 522.8K
 * Testcase Example:  '"25525511135"'
 *
 * Given a string containing only digits, restore it by returning all possible
 * valid IP address combinations.
 * 
 * A valid IP address consists of exactly four integers (each integer is
 * between 0 and 255) separated by single points.
 * 
 * Example:
 * 
 * 
 * Input: "25525511135"
 * Output: ["255.255.11.135", "255.255.111.35"]
 * 
 * 
 */

// @lc code=start

// match condition:  end of s, 4 segments
// loop end condition: 
//     1. one segment length > 3, 
//     2. segment number > 4,
//     3. leading 0 with segment length > 1, 
//     4. value of one segment > 255.

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() < 4) return result;
        dfs(s, 0, 0, new ArrayList<String>(), result);
        return result;
    }
    
    
    private void dfs(String s, int start, int segmentCount, List<String> path, List<String> result) {    
        if (start == s.length() && segmentCount == 4) {
            result.add(String.join(".", path));
            return;
        }
        
        for (int i = start; i < s.length(); i++) {
            if (i >= start + 3) return;
            if (segmentCount > 4) return;
            String segment = s.substring(start, i+1);
            if (segment.charAt(0) == '0' && segment.length() > 1) return;
            if (Integer.valueOf(segment) > 255) return;
            
            path.add(segment);
            dfs(s, i+1, segmentCount+1, path, result);
            path.remove(path.size() - 1);
        }
    }
}
// @lc code=end

