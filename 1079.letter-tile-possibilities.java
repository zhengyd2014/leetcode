/*
 * @lc app=leetcode id=1079 lang=java
 *
 * [1079] Letter Tile Possibilities
 *
 * https://leetcode.com/problems/letter-tile-possibilities/description/
 *
 * algorithms
 * Medium (74.96%)
 * Likes:    525
 * Dislikes: 22
 * Total Accepted:    24.9K
 * Total Submissions: 33.1K
 * Testcase Example:  '"AAB"'
 *
 * You have a set of tiles, where each tile has one letter tiles[i] printed on
 * it.  Return the number of possible non-empty sequences of letters you can
 * make.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: "AAB"
 * Output: 8
 * Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB",
 * "ABA", "BAA".
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "AAABBC"
 * Output: 188
 * 
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= tiles.length <= 7
 * tiles consists of uppercase English letters.
 * 
 */

// @lc code=start
class Solution {
    
    int total = 0;
    public int numTilePossibilities(String tiles) {
        Set<Integer> visited = new HashSet<>();
        char[] cs = tiles.toCharArray();
        Arrays.sort(cs);
        dfs(cs, visited);
        return total;
    }
    
    private void dfs(char[] tiles, Set<Integer> visited) {
        
        for (int i = 0; i < tiles.length; i++) {
            if (visited.contains(i)) continue;
            if (i > 0 && tiles[i] == tiles[i - 1] && !visited.contains(i-1)) continue;
            
            total++;
            visited.add(i);
            dfs(tiles, visited);
            visited.remove(i);
        }
    }
}
// @lc code=end

