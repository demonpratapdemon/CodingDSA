/**
 * 
 */
package miscellaneous;

/**
 * @author PRATAP LeetCode 62
 *
 */
public class UniquePaths {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m = 23, n = 12;
		int ans = uniquePaths(m, n);
		System.out.println(ans);
	}

	public static int[][] adj = { { 0, 1 }, { 1, 0 } };

	public static int uniquePaths(int m, int n) {
		int[][] dp = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 1;
				} else {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				}
			}
		}
		return dp[m - 1][n - 1];
	}

}

class UQPair {
	public int i;
	public int j;

	public UQPair(int i, int j) {
		this.i = i;
		this.j = j;
	}
}