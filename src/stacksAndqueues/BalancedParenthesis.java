/**
 * 
 */
package stacksAndqueues;

import java.util.Stack;

/**
 * @author PRATAP
 *
 */
public class BalancedParenthesis {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String x = "{([])}";
		String ans = ispar(x) ? "balanced" : "not balanced";
		System.out.println(ans);
	}

	public static boolean ispar(String x) {
		// add your code here
		Stack<String> stack = new Stack<String>();
		for (int i = 0; i < x.length(); i++) {
			char curr = x.charAt(i);
			if (curr == '(' || curr == '{' || curr == '[') {
				stack.push(String.valueOf(curr));
			} else if (stack.size() > 0 && ((curr == ')' && stack.peek().equalsIgnoreCase("("))
					|| (curr == '}' && stack.peek().equalsIgnoreCase("{"))
					|| (curr == ']' && stack.peek().equalsIgnoreCase("[")))) {
				stack.pop();
			} else {
				return false;
			}
		}
		if (stack.size() > 0)
			return false;
		return true;
	}

}
