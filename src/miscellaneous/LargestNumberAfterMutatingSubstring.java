/**
 * 
 */
package miscellaneous;

import java.util.Stack;

/**
 * @author PRATAP LeetCode 1946
 *
 */
public class LargestNumberAfterMutatingSubstring {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String num = "021";
		int[] change = { 9, 4, 3, 5, 7, 2, 1, 9, 0, 6 };
		String ans = maximumNumber(num, change);
		System.out.println(ans);
	}

	public static String maximumNumber(String num, int[] change) {
		Stack<Integer> stack = new Stack<Integer>();
		int i = 0;
		boolean flag = false;
		for (; i < num.length(); i++) {
			char ch = num.charAt(i);
			int d = Integer.parseInt(String.valueOf(ch));
			if (d < change[d]) {
				flag = true;
				stack.push(change[d]);
			} else if (!flag) {
				stack.push(d);
			} else if (flag && d == change[d]) {
				stack.push(d);
			} else {
				break;
			}
		}
		while (i < num.length()) {
			char ch = num.charAt(i);
			int d = Integer.parseInt(String.valueOf(ch));
			stack.push(d);
			i++;
		}
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty())
			sb.append(stack.pop());
		sb = sb.reverse();
		return sb.toString();
	}
}
