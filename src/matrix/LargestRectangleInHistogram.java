/**
 * 
 */
package matrix;

import java.util.Stack;

/**
 * @author PRATAP LeetCode 84
 *
 */
public class LargestRectangleInHistogram {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] heights = { 6, 2, 5, 4, 5, 1, 6 };
		int largestRectArea = largestRectangleArea(heights);
		System.out.println(largestRectArea);
	}

	public static int largestRectangleArea(int[] heights) {
		Stack<Integer> stack = new Stack<Integer>();
		int n = heights.length;
		int[] left = new int[n];
		int[] right = new int[n];
		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
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
			while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
				stack.pop();
			}
			if (stack.isEmpty())
				right[i] = n - 1;
			else
				right[i] = stack.peek() - 1;
			stack.push(i);
		}
//		for (int i : right)
//			System.out.print(i + " ");
		int maxArea = 0;
		for (int i = 0; i < n; i++) {
			maxArea = Math.max(maxArea, (right[i] - left[i] + 1) * heights[i]);
		}
		return maxArea;
	}

}
