/**
 * 
 */
package binarytrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author PRATAP
 *
 */
public class CheckMirrorInNAryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3, e = 2, A[] = { 1, 2, 1, 3 }, B[] = { 1, 3, 1, 2 };
		int ans = checkMirrorTree(n, e, A, B);
		System.out.println(ans == 1 ? "Yes Mirror Image" : "Not Mirror Image");
	}

	public static int checkMirrorTree(int n, int e, int[] A, int[] B) {
		// code here
		List<Stack<Integer>> stack = new ArrayList<Stack<Integer>>();
		List<Queue<Integer>> q = new ArrayList<Queue<Integer>>();
		for (int i = 0; i <= n; i++) {
			stack.add(new Stack<Integer>());
			Queue<Integer> q1 = new LinkedList<Integer>();
			q.add(q1);
		}
		for (int i = 0; i < 2 * e; i += 2) {
			stack.get(A[i]).add(A[i + 1]);
			q.get(B[i]).add(B[i + 1]);
		}
		for (int i = 0; i <= n; i++) {
			Stack<Integer> currStack = stack.get(i);
			Queue<Integer> currQ = q.get(i);
			if (currQ.size() != currStack.size())
				return 0;
			while (!currStack.isEmpty() && !currQ.isEmpty()) {
				if (currStack.pop() != currQ.poll())
					return 0;
			}
		}
		return 1;
	}

}
