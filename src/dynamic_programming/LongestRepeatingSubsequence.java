/**
 * 
 */
package dynamic_programming;

/**
 * @author PRATAP
 *
 */
public class LongestRepeatingSubsequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "axxxy";
		int ans = longestRepeatingSubsequence(str);
		System.out.println(ans);
	}

	public static int longestRepeatingSubsequence(String str) {
		// code here
		String str2 = str;
		int n = str.length();
		int[][] dp = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				char f = str.charAt(i - 1);
				char s = str2.charAt(j - 1);
				if (f == s && i != j) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}
			}
		}
		return dp[n][n];
	}
}
