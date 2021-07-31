/**
 * 
 */
package stacksAndqueues;

import java.util.Stack;

/**
 * @author PRATAP LeetCode 456
 *
 */
public class Pattern132 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] nums = { -1, 3, 2, 0 };
		int[] nums = { 3, 5, 0, 3, 4 };
//		int[] nums = { 1, 3, 2, 4, 5, 6, 7, 8, 9, 10 };
		Pattern132 obj = new Pattern132();
		boolean ans = obj.find132pattern(nums);
		System.out.println(ans);
	}

	public boolean find132pattern(int[] nums) {
		int n = nums.length;
		int[] mins = new int[n];
		mins[0] = nums[0];
		for (int i = 1; i < n; i++) {
			mins[i] = Math.min(mins[i - 1], nums[i]);
		}
		Stack<Integer> stack = new Stack<Integer>();
		int j = n - 1;
		stack.push(nums[j]);
		j--;
		for (; j >= 0; j--) {
			while (!stack.isEmpty() && stack.peek() <= mins[j]) {
				stack.pop();
			}	
			if (!stack.isEmpty() && stack.peek() < nums[j])
				return true;
			stack.push(nums[j]);
		}
		return false;
	}
}
