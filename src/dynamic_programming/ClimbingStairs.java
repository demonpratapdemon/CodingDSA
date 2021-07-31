/**
 * 
 */
package dynamic_programming;

import java.util.HashMap;

/**
 * @author PRATAP LeetCode 70
 *
 */
public class ClimbingStairs {

	static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int top = 2;
		int ways = climbStairs(top);
		System.out.println(ways);
	}

	public static int climbStairs(int n) {
		return differentWays(n);
	}

	public static int differentWays(int n) {
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;
		if (map.containsKey(n))
			return map.get(n);
		int result = differentWays(n - 1) + differentWays(n - 2);
		map.put(n, result);
		return result;
	}

}
