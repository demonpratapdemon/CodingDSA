/**
 * 
 */
package dynamic_programming;

/**
 * @author PRATAP
 *
 */
public class CountPalindromicSubsequences {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "aaaaaaaaaaaaaaaaaaaaaaaaaaa";
		long ans = countPS(str);
		System.out.println(ans);
	}

	public static long countPS(String str) {
		// Your code here
		long mod = (long) (1e9 + 7);
		int n = str.length();
		long[][] dp = new long[n][n];
		for (int gap = 0; gap < n; gap++) {
			int i = 0;
			int j = i + gap;
			while (j < n) {
				if (gap == 0) {
					dp[i][j] = 1 % mod;
				} else if (gap == 1) {
					if (str.charAt(i) == str.charAt(j)) {
						dp[i][j] = 3;
					} else {
						dp[i][j] = 2;
					}
				} else {
					if (str.charAt(i) == str.charAt(j)) {
						dp[i][j] = (dp[i][j - 1] + dp[i + 1][j] + 1) % mod;
					} else {
						dp[i][j] = (dp[i][j - 1] + dp[i + 1][j] - dp[i + 1][j - 1] + mod) % mod;
					}
				}
				i++;
				j++;
			}
		}
		return dp[0][n - 1] % mod;
	}
}
