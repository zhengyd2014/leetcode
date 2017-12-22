class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        
        int originalNumber = x;
        int reverseNumber = 0;
        while (x != 0) {
            if (reverseNumber > Integer.MAX_VALUE / 10) {
                return false;
            }
            
            reverseNumber = reverseNumber * 10 + x % 10;
            x /= 10;
        }
        
        return originalNumber == reverseNumber;
    }
}