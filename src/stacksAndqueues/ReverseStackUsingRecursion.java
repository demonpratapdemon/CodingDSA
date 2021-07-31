/**
 * 
 */
package stacksAndqueues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @author PRATAP
 *
 */
public class ReverseStackUsingRecursion {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Stack<Integer> stack = new Stack<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split("\\s+");
		for (String s : arr)
			stack.push(Integer.parseInt(s));
		System.out.println("Original Stack : ");
		System.out.println(stack);
		reverseStack(stack);
		System.out.println("Reversed Stack : ");
		System.out.println(stack);
	}

	private static void reverseStack(Stack<Integer> stack) {
		// TODO Auto-generated method stub
		if (!stack.isEmpty()) {
			int curr = stack.pop();
			reverseStack(stack);
			insertAtBottom(stack, curr);
		}
	}

	private static void insertAtBottom(Stack<Integer> stack, int curr) {
		// TODO Auto-generated method stub
		if (stack.isEmpty()) {
			stack.push(curr);
			return;
		} else {
			int popped = stack.pop();
			insertAtBottom(stack, curr);
			stack.push(popped);
		}
	}

}
