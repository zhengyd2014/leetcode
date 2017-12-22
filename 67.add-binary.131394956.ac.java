class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        while (i >= 0 || j >= 0) {
            int valA = i >= 0 ? a.charAt(i) - '0' : 0;
            int valB = j >= 0 ? b.charAt(j) - '0' : 0;
            int val = valA + valB + carry;
            sb.insert(0, val % 2);
            carry = val / 2;
            i--;
            j--;
        }
        
        if (carry == 1) {
            sb.insert(0, 1);
        }
        return sb.toString();
    }
}