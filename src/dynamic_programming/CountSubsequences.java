/**
 * 
 */
package dynamic_programming;

/**
 * @author PRATAP
 *
 */
public class CountSubsequences {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "ABCBCECDGCC";
		String s2 = "ABC";
		int res = countSubsequences(s1, s2);
		System.out.println(res);
	}

	private static int countSubsequences(String s1, String s2) {
		// TODO Auto-generated method stub
		int n = s1.length();
		int m = s2.length();
		int[][] dp = new int[n + 1][m + 1];
		for (int j = 1; j <= m; j++)
			dp[0][j] = 0;
		for (int i = 0; i <= n; i++)
			dp[i][0] = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[n][m];
	}

}
