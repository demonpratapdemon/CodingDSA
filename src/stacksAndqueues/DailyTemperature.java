/**
 * 
 */
package stacksAndqueues;

import java.util.Stack;

/**
 * @author PRATAP LeetCode 739
 *
 */
public class DailyTemperature {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] temperatures = { 73, 74, 75, 71, 69, 72, 76, 73 };
		int[] ans = dailyTemperatures(temperatures);
		for (int i : ans)
			System.out.print(i + " ");
	}

	public static int[] dailyTemperatures(int[] temperatures) {
		Stack<Integer> stack = new Stack<Integer>();
		int n = temperatures.length;
		int[] ans = new int[n];
		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
				int idx = stack.pop();
				ans[idx] = i - idx;
			}
			stack.push(i);
		}
		while (!stack.isEmpty()) {
			ans[stack.pop()] = 0;
		}
		return ans;
	}
}
