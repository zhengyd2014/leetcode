/*
 * @lc app=leetcode id=336 lang=java
 *
 * [336] Palindrome Pairs
 *
 * https://leetcode.com/problems/palindrome-pairs/description/
 *
 * algorithms
 * Hard (32.99%)
 * Likes:    1254
 * Dislikes: 147
 * Total Accepted:    95.3K
 * Total Submissions: 287K
 * Testcase Example:  '["abcd","dcba","lls","s","sssll"]'
 *
 * Given a list of unique words, find all pairs of distinct indices (i, j) in
 * the given list, so that the concatenation of the two words, i.e. words[i] +
 * words[j] is a palindrome.
 * 
 * Example 1:
 * 
 * 
 * 
 * Input: ["abcd","dcba","lls","s","sssll"]
 * Output: [[0,1],[1,0],[3,2],[2,4]] 
 * Explanation: The palindromes are
 * ["dcbaabcd","abcddcba","slls","llssssll"]
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: ["bat","tab","cat"]
 * Output: [[0,1],[1,0]] 
 * Explanation: The palindromes are ["battab","tabbat"]
 * 
 * 
 * 
 * 
 */

// @lc code=start

// 336. Palindrome Pairs

// reverse string then compare to determin if the are pair!
// remove front/back part of palindrome, then compare
// pay attention to remove duplicate:  
//    * backString length should not be 0, as it already checked for frontString. 


class Solution {
    
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> pairs = new ArrayList<List<Integer>>();
        if(words == null || words.length == 0) return pairs;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < words.length; i++) map.put(words[i], i);
        for(int i = 0; i < words.length; i++){
            for(int j = 0; j <= words[i].length(); j++){ // <= not <
                String frontStr = words[i].substring(0, j);
                String backStr = words[i].substring(j);
                
                if(isPalindrome(frontStr)){
                    String backRev = new StringBuilder(backStr).reverse().toString();
                    if(map.containsKey(backRev) && map.get(backRev) != i){
                        pairs.add(Arrays.asList(new Integer[]{map.get(backRev), i}));
                    }
                } 
                if(isPalindrome(backStr) && backStr.length() != 0){ //exam the length for backString is 0 or not
                    String frontRev = new StringBuilder(frontStr).reverse().toString();
                    if(map.containsKey(frontRev) && map.get(frontRev) != i){
                        pairs.add(Arrays.asList(new Integer[]{i,map.get(frontRev)}));
                    }
                }
            }
        }
        return pairs;
    }
    
    private boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;
        }
        return true;
    }
}

// @lc code=end

