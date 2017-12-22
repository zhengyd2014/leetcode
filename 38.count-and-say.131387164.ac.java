class Solution {
    public String countAndSay(int n) {
        String s = "1";
        for (int i = 1; i < n; i++) {
            s =countAndSay(s);
        }
        
        return s;
    }
    
    private String countAndSay(String s) {
        if (s.length() == 1) {
            return "1" + s;
        }
        
        StringBuilder sb = new StringBuilder();
        int count = 1; 
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)){
                count++;
            } else {
                sb.append(count + "" + s.charAt(i - 1));
                count = 1;
            }
        }
        
        sb.append(count + "" + s.charAt(s.length() - 1));
        return sb.toString();
    }
}