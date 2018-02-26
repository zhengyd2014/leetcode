/*
 * [150] Evaluate Reverse Polish Notation
 *
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
 *
 * algorithms
 * Medium (28.18%)
 * Total Accepted:    110.2K
 * Total Submissions: 390.7K
 * Testcase Example:  '["18"]'
 *
 * 
 * Evaluate the value of an arithmetic expression in Reverse Polish
 * Notation.
 * 
 * 
 * 
 * Valid operators are +, -, *, /. Each operand may be an integer or another
 * expression.
 * 
 * 
 * 
 * Some examples:
 * 
 * ⁠ ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ⁠ ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 * 
 * 
 */
class Solution {

	private static final Set<String> OPERATORS = new HashSet<>(Arrays.asList("+", "-", "*", "/"));

    public int evalRPN(String[] tokens) {
		Stack<Integer> operands = new Stack<>();
		for (String token : tokens) {
			if (OPERATORS.contains(token)) {
				int y = operands.pop();
				int x = operands.pop();
				operands.push(eval(x, y, token));
			} else {
				operands.push(Integer.parseInt(token));
			}
		}

		return operands.pop();
    }

	private int eval(int x, int y, String operator) {
		switch (operator) {
			case "+": return x + y;
			case "-": return x - y;
			case "*": return x * y;
			case "/": return x / y;
			default: throw new IllegalArgumentException(operator + " not support");
		}
	}
}
