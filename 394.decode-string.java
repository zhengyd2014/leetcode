/*
 * @lc app=leetcode id=394 lang=java
 *
 * [394] Decode String
 *
 * https://leetcode.com/problems/decode-string/description/
 *
 * algorithms
 * Medium (48.51%)
 * Likes:    2757
 * Dislikes: 137
 * Total Accepted:    186.5K
 * Total Submissions: 382.5K
 * Testcase Example:  '"3[a]2[bc]"'
 *
 * Given an encoded string, return its decoded string.
 * 
 * The encoding rule is: k[encoded_string], where the encoded_string inside the
 * square brackets is being repeated exactly k times. Note that k is guaranteed
 * to be a positive integer.
 * 
 * You may assume that the input string is always valid; No extra white spaces,
 * square brackets are well-formed, etc.
 * 
 * Furthermore, you may assume that the original data does not contain any
 * digits and that digits are only for those repeat numbers, k. For example,
 * there won't be input like 3a or 2[4].
 * 
 * Examples:
 * 
 * 
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 * 
 * 
 * 
 * 
 */

// @lc code=start

// 394. Decode String

// simulation: 


class Solution {

    // recursive: *global* variable i to record progress.
    int j = 0;
    public String decodeString(String s) {
        int num = 0;
        StringBuilder sb = new StringBuilder();
        
        while (j < s.length()) {
            char c = s.charAt(j++);
            if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
            } else if (c == '[') {
                String sub = decodeString(s);
                for (int i = 0; i < num; i++) {
                    sb.append(sub);
                }
                num = 0;
            } else if (c == ']') {
                break;
            } else {
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
        
        
    // iterative
    //   * 2 stacks, one for string, one for number
        
        public String decodeString2(String s) {
            String curr = "";
            int num = 0;
            Stack<String> stack = new Stack<>();
            Stack<Integer> nstack = new Stack<>();
            
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c >= '0' && c <= '9') {
                    num = num * 10 + c - '0';
                } else if (c == '[') {
                    nstack.push(num);
                    stack.push(curr);
                    num = 0;
                    curr = "";
                } else if (c == ']') {
                    int times = nstack.pop();
                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < times; j++) {
                        sb.append(curr);
                    }
                    curr = stack.pop() + sb.toString();
                } else {
                    curr = curr + c;
                }
            }
            
            return curr;
        }
        
        
        
    }

// @lc code=end

