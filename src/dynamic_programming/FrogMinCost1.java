/**
 * 
 */
package dynamic_programming;

/**
 * @author PRATAP
 *
 */
public class FrogMinCost1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] heights = { 30, 10, 60, 10, 60, 50 };
		int minCost = minCost(heights, heights.length);
		System.out.println(minCost);
	}

	private static int minCost(int[] heights, int n) {
		// TODO Auto-generated method stub
		int[] dp = new int[n];
		dp[1] = Math.abs(heights[1] - heights[0]);
		for (int i = 2; i < n; i++) {
			dp[i] = Math.min(dp[i - 1] + Math.abs(heights[i] - heights[i - 1]),
					dp[i - 2] + Math.abs(heights[i] - heights[i - 2]));
		}
		return dp[n - 1];
	}

}
