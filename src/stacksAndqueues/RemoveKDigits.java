/**
 * 
 */
package stacksAndqueues;

import java.util.Stack;

/**
 * @author PRATAP LeetCode 402
 *
 */
public class RemoveKDigits {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String num = "10";
		int k = 2;
		RemoveKDigits obj = new RemoveKDigits();
		String ans = obj.removeKdigits(num, k);
		System.out.println(ans);
	}

	public String removeKdigits(String num, int k) {
		int n = num.length();
		if (k == n) {
			return "0";
		}
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < n; i++) {
			char ch = num.charAt(i);
			while (!stack.isEmpty() && k > 0 && stack.peek() > ch) {
				stack.pop();
				k--;
			}
			stack.push(ch);
		}
		while (!stack.isEmpty() && k > 0) {
			stack.pop();
			k--;
		}
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		sb = sb.reverse();
		int d = 0;
		while (d < sb.length() && sb.charAt(d) == '0')
			d++;
		return sb.toString().substring(d).equalsIgnoreCase("") ? "0" : sb.toString().substring(d);
	}
}
