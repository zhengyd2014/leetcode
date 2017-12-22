class Solution {
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        Map<Character, Integer> romanCharToNumberMap = new HashMap<>();
        romanCharToNumberMap.put('I', 1);
        romanCharToNumberMap.put('V', 5);
        romanCharToNumberMap.put('X', 10);
        romanCharToNumberMap.put('L', 50);
        romanCharToNumberMap.put('C', 100);
        romanCharToNumberMap.put('D', 500);
        romanCharToNumberMap.put('M', 1000);
        
        int prev = 0;
        int result = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int curr = romanCharToNumberMap.get(s.charAt(i));
            if (curr >= prev) {
                result += curr;
                prev = curr;
            } else {
                result -= curr;
            }
        }
        
        return result;
    }
}