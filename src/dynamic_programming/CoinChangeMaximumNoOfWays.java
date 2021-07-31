/**
 * 
 */
package dynamic_programming;

/**
 * @author PRATAP
 *
 */
public class CoinChangeMaximumNoOfWays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] S = { 2, 5, 3, 6 };
		int n = 10;
		int m = S.length;
		long ans = count(S, m, n);
		System.out.println(ans);
	}

	public static long count(int S[], int m, int n) {
		// code here.
		// n - target
		// m -length of array S
		long[][] dp = new long[m][n + 1];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n + 1; j++)
				dp[i][j] = -1;
		}
		solve(S, m - 1, n, dp);
		return dp[m - 1][n];
	}

	private static long solve(int[] s, int m, int n, long[][] dp) {
		// TODO Auto-generated method stub
		if (m < 0)
			return 0;
		if (n < 0)
			return 0;
		if (n == 0)
			return 1;
		if (dp[m][n] != -1) {
			return dp[m][n];
		}
		return dp[m][n] = solve(s, m, n - s[m], dp) + solve(s, m - 1, n, dp);
	}

}
