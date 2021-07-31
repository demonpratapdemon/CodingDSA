/**
 * 
 */
package miscellaneous;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author PRATAP LeetCode 239
 *
 */
public class SlidingWindowMaximum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 9, 11 };
		int k = 2;
		int[] ans = maxSlidingWindow(nums, k);
		for (int i : ans)
			System.out.print(i + " ");
	}

	public static int[] maxSlidingWindow(int[] nums, int k) {
		int n = nums.length;
		int[] nge = new int[n];
		findNGE(nums, n, nge);
		int[] res = new int[n - k + 1];
		int j = 0;
		for (int i = 0; i <= n - k; i++) {
			if (j < i || j > i + k - 1)
				j = i;
			while (nge[j] <= i + k - 1) {
				j = nge[j];
			}
			res[i] = nums[j];
		}
		return res;
	}

	private static void findNGE(int[] nums, int n, int[] nge) {
		// TODO Auto-generated method stub
		Stack<Integer> stack = new Stack<Integer>();
		Arrays.fill(nge, Integer.MAX_VALUE);
		for (int i = 0; i < n; i++) {
			if (stack.isEmpty()) {
				stack.push(i);
			} else if (nums[i] < nums[stack.peek()]) {
				stack.push(i);
			} else {
				while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
					nge[stack.pop()] = i;
				}
				stack.push(i);
			}

		}
	}
}
