/**
 * 
 */
package miscellaneous;

import java.util.Arrays;

/**
 * @author PRATAP
 *
 */
public class UniquePathsInAGrid {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3, m = 3, grid[][] = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
		int ans = uniquePaths(n, m, grid);
		System.out.println(ans);
	}

	static int mod = (int) (1e9 + 7);

	static int uniquePaths(int n, int m, int[][] grid) {
		// code here
		int[][] dp = new int[n][m];
		for (int j = 0; j < m; j++) {
			if (grid[0][j] == 1)
				dp[0][j] = 1;
			else
				break;
		}
		for (int i = 0; i < n; i++) {
			if (grid[i][0] == 1)
				dp[i][0] = 1;
			else
				break;
		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				if (grid[i][j] == 1)
					dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % mod;
			}
		}
		return dp[n - 1][m - 1] % mod;
	}
}
