import java.util.HashMap;

/*
 * @lc app=leetcode id=721 lang=java
 *
 * [721] Accounts Merge
 *
 * https://leetcode.com/problems/accounts-merge/description/
 *
 * algorithms
 * Medium (43.15%)
 * Likes:    1119
 * Dislikes: 266
 * Total Accepted:    65.6K
 * Total Submissions: 141.4K
 * Testcase Example:  '[["John","johnsmith@mail.com","john_newyork@mail.com"],["John","johnsmith@mail.com","john00@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]'
 *
 * Given a list accounts, each element accounts[i] is a list of strings, where
 * the first element accounts[i][0] is a name, and the rest of the elements are
 * emails representing emails of the account.
 * 
 * Now, we would like to merge these accounts.  Two accounts definitely belong
 * to the same person if there is some email that is common to both accounts.
 * Note that even if two accounts have the same name, they may belong to
 * different people as people could have the same name.  A person can have any
 * number of accounts initially, but all of their accounts definitely have the
 * same name.
 * 
 * After merging the accounts, return the accounts in the following format: the
 * first element of each account is the name, and the rest of the elements are
 * emails in sorted order.  The accounts themselves can be returned in any
 * order.
 * 
 * Example 1:
 * 
 * Input: 
 * accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John",
 * "johnnybravo@mail.com"], ["John", "johnsmith@mail.com",
 * "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
 * Output: [["John", 'john00@mail.com', 'john_newyork@mail.com',
 * 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary",
 * "mary@mail.com"]]
 * Explanation: 
 * The first and third John's are the same person as they have the common email
 * "johnsmith@mail.com".
 * The second John and Mary are different people as none of their email
 * addresses are used by other accounts.
 * We could return these lists in any order, for example the answer [['Mary',
 * 'mary@mail.com'], ['John', 'johnnybravo@mail.com'], 
 * ['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']]
 * would still be accepted.
 * 
 * 
 * 
 * Note:
 * The length of accounts will be in the range [1, 1000].
 * The length of accounts[i] will be in the range [1, 10].
 * The length of accounts[i][j] will be in the range [1, 30].
 * 
 */

// @lc code=start
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> emailToAccount = new HashMap<>();

        Map<String, Set<String>> g = new HashMap<>();
        buildGraph(accounts, emailToAccount, g);

        List<List<String>> result = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        for (String email : g.keySet()) {
            if (visited.contains(email)) continue;
            
            List<String> list = new ArrayList<>();
            dfs(g, email, visited, list);
            Collections.sort(list);
            list.add(0, emailToAccount.get(email));
            result.add(list);
        }

        return result;
    }

    private void dfs(Map<String, Set<String>> g, String email, Set<String> visited, List<String> list) {
        list.add(email);
        visited.add(email);

        for (String neighbor : g.get(email)) {
            if (visited.contains(neighbor)) continue;
            dfs(g, neighbor, visited, list);
        }
    }

    private void buildGraph(List<List<String>> accounts, Map<String, String> emailToAccount, Map<String, Set<String>> g) {
        for (List<String> account : accounts) {
            String owner = account.get(0);

            for (int i = 1; i < account.size(); i++) {
                emailToAccount.put(account.get(i), owner);
                if (!g.containsKey(account.get(i))) {
                    g.put(account.get(i), new HashSet<String>());
                }
                g.get(account.get(i)).add(account.get(1));
                g.get(account.get(1)).add(account.get(i));
            }
        }
    }
}
// @lc code=end

