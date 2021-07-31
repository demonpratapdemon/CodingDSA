/**
 * 
 */
package dynamic_programming;

/**
 * @author PRATAP
 *
 */
public class Knapsack01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int W = 3;
		int wt[] = { 4, 5, 6 };
		int val[] = { 1, 2, 3 };
		int ans = knapSack(W, wt, val, val.length);
		System.out.println(ans);
	}

	static int knapSack(int W, int wt[], int val[], int n) {
		// your code here
		int[][] dp = new int[n][W + 1];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= W; j++)
				dp[i][j] = -1;
		}
		solve(W, wt, val, n - 1, dp);
		return dp[n - 1][W];
	}

	private static int solve(int W, int[] wt, int[] val, int n, int[][] dp) {
		// TODO Auto-generated method stub
		if (W <= 0)
			return 0;
		if (n < 0)
			return 0;
		if (dp[n][W] != -1)
			return dp[n][W];
		if (wt[n] > W)
			return dp[n][W] = solve(W, wt, val, n - 1, dp);
		else
			return dp[n][W] = Math.max(solve(W, wt, val, n - 1, dp), val[n] + solve(W - wt[n], wt, val, n - 1, dp));
	}

}
