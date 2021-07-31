/**
 * 
 */
package dynamic_programming;

/**
 * @author PRATAP
 *
 */
public class GoldMine {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] M = { { 1, 3, 1, 5 }, { 2, 2, 4, 1 }, { 5, 0, 2, 3 }, { 0, 6, 1, 2 } };
		int ans = maxGold(M.length, M[0].length, M);
		System.out.println(ans);
	}

	static int[][] neighbs = { { -1, -1 }, { 0, -1 }, { 1, -1 } };

	static int maxGold(int n, int m, int M[][]) {
		// code here
		int max = Integer.MIN_VALUE;
		int[][] dp = new int[n][m];
		for (int i = 0; i < n; i++)
			dp[i][0] = M[i][0];
		for (int j = 1; j < m; j++) {
			for (int i = 0; i < n; i++) {
				for (int k = 0; k < neighbs.length; k++) {
					int currI = i + neighbs[k][0];
					int currJ = j + neighbs[k][1];
					if (currI >= 0 && currI < n && currJ >= 0 && currJ < m) {
						dp[i][j] = Math.max(dp[i][j], M[i][j] + dp[currI][currJ]);
					}
				}
			}
		}
		for (int i = 0; i < n; i++)
			max = Math.max(max, dp[i][m - 1]);
		return max;
	}

}
