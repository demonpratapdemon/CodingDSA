/**
 * 
 */
package matrix;

import java.util.Stack;

/**
 * @author PRATAP LeetCode 85
 *
 */
public class MaximalRectangle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] M = { { 0, 1, 1, 0 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 0, 0 } };
		int maxArea = maxArea(M, M.length, M[0].length);
		System.out.println(maxArea);
	}

	public static int maxArea(int M[][], int m, int n) {
		// add code here.
		int[] succAdd = new int[n];
		int maxArea = 0;
		for (int i = 0; i < m; i++) {
			for (int k = 0; k < n; k++) {
				if (M[i][k] == 0)
					succAdd[k] = 0;
				else
					succAdd[k] += M[i][k];
			}
			int area = maxRectangle(succAdd);
			maxArea = Math.max(maxArea, area);
		}
		return maxArea;
	}

	private static int maxRectangle(int[] succAdd) {
		// TODO Auto-generated method stub
		Stack<Integer> stack = new Stack<Integer>();
		int n = succAdd.length;
		int left[] = new int[n];
		int right[] = new int[n];
		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && succAdd[stack.peek()] >= succAdd[i]) {
				stack.pop();
			}
			if (stack.isEmpty())
				left[i] = 0;
			else
				left[i] = stack.peek() + 1;
			stack.push(i);
		}
		stack.clear();
		for (int i = n - 1; i >= 0; i--) {
			while (!stack.isEmpty() && succAdd[stack.peek()] >= succAdd[i]) {
				stack.pop();
			}
			if (stack.isEmpty())
				right[i] = (n - 1);
			else
				right[i] = (stack.peek() - 1);
			stack.push(i);
		}
		int maxArea = 0;
		for (int i = 0; i < n; i++) {
			maxArea = Math.max(maxArea, (right[i] - left[i] + 1) * succAdd[i]);
		}
		return maxArea;
	}
}
