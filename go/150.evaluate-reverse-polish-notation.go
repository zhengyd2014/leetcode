/*
 * [150] Evaluate Reverse Polish Notation
 *
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
 *
 * algorithms
 * Medium (28.50%)
 * Total Accepted:    114.8K
 * Total Submissions: 402.6K
 * Testcase Example:  '["2","1","+","3","*"]'
 *
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * 
 * Valid operators are +, -, *, /. Each operand may be an integer or another
 * expression.
 * 
 * Some examples:
 * 
 * 
 * ⁠ ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ⁠ ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 * 
 * 
 * 
 * 
 */
func evalRPN(tokens []string) int {
	stack := []int{}

	for _, token := range tokens {
		switch token {
			case "+":
				v := stack[len(stack) - 2] + stack[len(stack) - 1]
				stack = append(stack[:len(stack) - 2], v)
			case "-":
				v := stack[len(stack) - 2] - stack[len(stack) - 1]
				stack = append(stack[:len(stack) - 2], v)
			case "*":
				v := stack[len(stack) - 2] * stack[len(stack) - 1]
				stack = append(stack[:len(stack) - 2], v)
			case "/":
				v := stack[len(stack) - 2] / stack[len(stack) - 1]
				stack = append(stack[:len(stack) - 2], v)
			default:
				v, _ := strconv.Atoi(token)
				stack = append(stack, v)
		}

	}
	
	return stack[0]
}
