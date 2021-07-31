/**
 * 
 */
package stacksAndqueues;

import java.util.Stack;

/**
 * @author PRATAP
 *
 */
public class NextGreaterElement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long[] arr = { 1, 3, 2, 4 };
		long[] ans = nextLargerElement(arr, arr.length);
		for (long item : ans)
			System.out.print(item + " ");
		System.out.println();
	}

	public static long[] nextLargerElement(long[] arr, int n) {
		// Your code here
		Stack<Integer> stack = new Stack<Integer>();
		long[] ans = new long[n];
		stack.push(0);
		for (int i = 1; i < n; i++) {
			if (arr[i] <= arr[stack.peek()]) {
				stack.push(i);
				continue;
			}
			while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
				int curr = stack.pop();
				ans[curr] = arr[i];
			}
			stack.push(i);
		}
		while (!stack.isEmpty()) {
			int curr = stack.pop();
			ans[curr] = -1;
		}
		return ans;
	}

}
