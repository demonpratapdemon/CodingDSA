/**
 * 
 */
package stacksAndqueues;

import java.util.Stack;

/**
 * @author PRATAP LeetCode 32
 *
 */
public class LongestValidParenthesis {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = ")()())()()(";
		int ans = longestValidParentheses(s);
		System.out.println(ans);
	}

	public static int longestValidParentheses(String s) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(-1);
		int n = s.length();
		int largest = 0;
		for (int i = 0; i < n; i++) {
			char ch = s.charAt(i);
			if (!stack.isEmpty() && ch == '(') {
				stack.push(i);
			} else if (stack.isEmpty() && ch == '(') {
				stack.push(i - 1);
				stack.push(i);
			} else if (!stack.isEmpty() && ch == ')') {
				stack.pop();
				if (stack.size() > 0)
					largest = Math.max(largest, i - stack.peek());
			}
		}
		return largest;
	}

	public static int longestValidParenthesesANotherWay(String s) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(-1);
		int n = s.length();
		int largest = 0;
		for (int i = 0; i < n; i++) {
			char ch = s.charAt(i);
			if (!stack.isEmpty() && ch == '(') {
				stack.push(i);
			} else if (!stack.isEmpty() && ch == ')') {
				stack.pop();
				if (stack.size() > 0)
					largest = Math.max(largest, i - stack.peek());
				else
					stack.push(i);
			}
		}
		return largest;
	}

}
