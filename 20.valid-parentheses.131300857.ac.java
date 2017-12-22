class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<Character, Character>() {{
            put('(', ')');
            put('{', '}');
            put('[', ']');
        }};
        
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                stack.push(map.get(c));
            } else {
                if (stack.isEmpty() || c != stack.pop()) {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
}