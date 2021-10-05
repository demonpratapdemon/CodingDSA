/**
 * 
 */
package miscellaneous;

import java.util.Stack;

/**
 * @author PRATAP LeetCode 735
 *
 */
public class AsteroidCollission {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] asteroids = { -2, -1, 1, 2 };
//		int[] asteroids = { 5, 10, -5 };
//		int[] asteroids = { -2, -2, 1, -2 };
		int[] asteroids = { -2, -2, -2, 1 };
		AsteroidCollission obj = new AsteroidCollission();
		int[] ans = obj.asteroidCollision(asteroids);
		for (int i : ans)
			System.out.println(i);
	}

	public int[] asteroidCollision(int[] asteroids) {
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < asteroids.length; i++) {
			if (stack.isEmpty())
				stack.push(asteroids[i]);
			else if (stack.peek() > 0 && asteroids[i] < 0) {
				while (!stack.isEmpty() && stack.peek() > 0 && Math.abs(stack.peek()) < Math.abs(asteroids[i]))
					stack.pop();
				if (stack.isEmpty())
					stack.push(asteroids[i]);
				else if (stack.peek() > 0 && stack.peek() == Math.abs(asteroids[i]))
					stack.pop();
				else if (stack.peek() > 0 && stack.peek() > Math.abs(asteroids[i]))
					continue;
				else
					stack.push(asteroids[i]);
			} else {
				stack.push(asteroids[i]);
			}
		}
		int n = stack.size();
		int[] res = new int[n];
		for (int i = n - 1; i >= 0; i--)
			res[i] = stack.pop();
		return res;
	}
}
