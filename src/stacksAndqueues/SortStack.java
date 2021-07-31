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
public class SortStack {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Stack<Integer> stack = new Stack<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split("\\s+");
		for (String str : s) {
			stack.push(Integer.parseInt(str));
		}
		Stack<Integer> out = sort(stack);
		while (!out.isEmpty()) {
			System.out.print(out.pop() + " ");
		}
	}

	public static Stack<Integer> sort(Stack<Integer> s) {
		// add code here.
		sortStack(s);
		return s;
	}

	private static void sortStack(Stack<Integer> s) {
		// TODO Auto-generated method stub
		if (!s.isEmpty()) {
			int popped = s.pop();
			sortStack(s);
			sortedInsert(s, popped);
		}
	}

	private static void sortedInsert(Stack<Integer> s, int popped) {
		// TODO Auto-generated method stub
		if (s.isEmpty() || s.peek() <= popped) {
			s.push(popped);
			return;
		}
		int temp = s.pop();
		sortedInsert(s, popped);
		s.push(temp);
	}

}
