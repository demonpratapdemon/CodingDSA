/**
 * 
 */
package dynamic_programming;

/**
 * @author PRATAP LeetCode 44
 *
 */
public class WildCardMatching {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "geeksforgeeks";
		String p = "ge*ks";
		boolean ans = isMatch(s, p);
		System.out.println(ans);
	}

	public static boolean isMatch(String s, String p) {
		int m = p.length();
		int n = s.length();
		boolean[][] dp = new boolean[m + 1][n + 1];
		for (int i = m; i >= 0; i--) {
			for (int j = n; j >= 0; j--) {
				if (i == m && j == n) {
					dp[i][j] = true;
				} else if (i == m) {
					dp[i][j] = false;
				} else if (j == n) {
					if (p.charAt(i) == '*') {
						dp[i][j] = dp[i + 1][j];
					}
				} else {
					if (p.charAt(i) == '?') {
						dp[i][j] = dp[i + 1][j + 1];
					} else if (p.charAt(i) == '*') {
						dp[i][j] = dp[i][j + 1] || dp[i + 1][j];
					} else if (p.charAt(i) == s.charAt(j)) {
						dp[i][j] = dp[i + 1][j + 1];
					} else {
						dp[i][j] = false;
					}
				}
			}
		}
		return dp[0][0];
	}

}
