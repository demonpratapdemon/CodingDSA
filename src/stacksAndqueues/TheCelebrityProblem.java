/**
 * 
 */
package stacksAndqueues;

import java.util.Stack;

/**
 * @author PRATAP
 *
 */
public class TheCelebrityProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int M[][] = { { 0, 1 }, { 1, 0 } };
		int celebrity = celebrity(M, M.length);
		System.out.println(celebrity);
	}

	public static int celebrity(int M[][], int n) {
		// code here
		Stack<Integer> stack = new Stack<Integer>();
		int k = 0;
		while (k < n) {
			stack.push(k++);
			if(stack.size() == 2) {
				int b = stack.pop();
				int a = stack.pop();
				if (M[a][b] == 1) {
					stack.push(b);
				} else {
					stack.push(a);
				}
			}
		}

		int possible = stack.peek();

		// Need to check row 1
		for (int i = 0; i < n; i++) {
			if (i != possible) {
				if (M[i][possible] == 0 || M[possible][i] == 1)
					return -1;
			}
		}

		return possible;
	}

}
