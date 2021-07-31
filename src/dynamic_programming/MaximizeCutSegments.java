/**
 * 
 */
package dynamic_programming;

/**
 * @author PRATAP
 *
 */
public class MaximizeCutSegments {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		int x = 3, y = 5, z = 0;
		int cuts = maximizeCuts(n, x, y, z);
		System.out.println(cuts);
	}

	/*
	 * public static int maximizeCuts(int n, int x, int y, int z) { // Your code
	 * here if (n == 0) return 0; int[] cuts = { x, y, z }; int[] dp = new int[n +
	 * 1]; for (int i = 0; i < cuts.length; i++) { for (int j = 1; j <= n; j++) { if
	 * () { dp[j] = Math.max(dp[j], 1 + dp[j - cuts[i]]); } } } return dp[n]; }
	 */

	public static int maximizeCuts(int n, int x, int y, int z) {
		// Your code here
		if (n == 0)
			return 0;
		int[] dp = new int[n + 1];
		for (int i = 0; i <= n; i++)
			dp[i] = -1;
		int ans = solve(n, x, y, z, dp);
		if (ans < 0)
			return 0;
		return ans;
	}

	public static int solve(int n, int x, int y, int z, int[] dp) {
		if (n <= 0)
			return 0;
		if (dp[n] != -1)
			return dp[n];
		int a = Integer.MIN_VALUE, b = Integer.MIN_VALUE, c = Integer.MIN_VALUE;
		if (n - x >= 0 && x > 0)
			a = solve(n - x, x, y, z, dp);
		if (n - y >= 0 && y > 0)
			b = solve(n - y, x, y, z, dp);
		if (n - z >= 0 && z > 0)
			c = solve(n - z, x, y, z, dp);
		return dp[n] = 1 + Math.max(a, Math.max(b, c));
	}
}
