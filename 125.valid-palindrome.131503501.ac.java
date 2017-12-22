class Solution {
    public boolean isPalindrome(String s) {
        return helper(s, 0, s.length() - 1);
    }
    
    private boolean helper(String s, int start, int end) {
        while (start < end) {
            while (start < end && !isValid(s.charAt(start))) {
                start++;
            }
            
            while (start < end && !isValid(s.charAt(end))) {
                end--;
            }
            
            if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                return false;
            }
            start++;
            end--;
        }
        
        return true;
    }
    
    private boolean isValid(char c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }
}