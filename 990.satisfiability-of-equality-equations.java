/*
 * @lc app=leetcode id=990 lang=java
 *
 * [990] Satisfiability of Equality Equations
 *
 * https://leetcode.com/problems/satisfiability-of-equality-equations/description/
 *
 * algorithms
 * Medium (41.40%)
 * Likes:    348
 * Dislikes: 4
 * Total Accepted:    14.5K
 * Total Submissions: 33.8K
 * Testcase Example:  '["a==b","b!=a"]'
 *
 * Given an array equations of strings that represent relationships between
 * variables, each string equations[i] has length 4 and takes one of two
 * different forms: "a==b" or "a!=b".  Here, a and b are lowercase letters (not
 * necessarily different) that represent one-letter variable names.
 * 
 * Return true if and only if it is possible to assign integers to variable
 * names so as to satisfy all the given equations.
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
 * Input: ["a==b","b!=a"]
 * Output: false
 * Explanation: If we assign say, a = 1 and b = 1, then the first equation is
 * satisfied, but not the second.  There is no way to assign the variables to
 * satisfy both equations.
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: ["b==a","a==b"]
 * Output: true
 * Explanation: We could assign a = 1 and b = 1 to satisfy both equations.
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: ["a==b","b==c","a==c"]
 * Output: true
 * 
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: ["a==b","b!=c","c==a"]
 * Output: false
 * 
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: ["c==c","b==d","x!=z"]
 * Output: true
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= equations.length <= 500
 * equations[i].length == 4
 * equations[i][0] and equations[i][3] are lowercase letters
 * equations[i][1] is either '=' or '!'
 * equations[i][2] is '='
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean equationsPossible(String[] equations) {
        
        int n = 26;
        int[] parent = new int[n];
        for(int i = 0; i < n; i++) parent[i] = i;

        for (String e : equations) {
            if (e.charAt(1) == '=') {
                union(parent, e.charAt(0) - 'a', e.charAt(3) - 'a');
            }
        }

        for (String e : equations) {
            if (e.charAt(1) == '!') {
                if (connected(parent, e.charAt(0) - 'a', e.charAt(3) - 'a')) return false;
            }
        }

        return true;
    }

    private int find(int[] parent, int x) {
        if (x != parent[x]) parent[x] = find(parent, parent[x]);
        return parent[x];
    }

    private void union(int[] parent, int p, int q) {
        parent[find(parent, p)] = find(parent, q);
    }

    private boolean connected(int[] parent, int p, int q) {
        return find(parent, p) == find(parent, q);
    }
}
// @lc code=end

