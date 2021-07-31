/**
 * 
 */
package dynamic_programming;

/**
 * @author PRATAP LeetCode 10
 *
 */
public class RegularExpressionMatching {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aab", p = ".*";
		boolean ans = isMatch(s, p);
		System.out.println(ans);
	}

	public static boolean isMatch(String s, String p) {
		int m = p.length();
		int n = s.length();
		boolean[][] dp = new boolean[m + 1][n + 1];
		dp[0][0] = true;
		for (int i = 1; i <= m; i++) {
			if (p.charAt(i - 1) == '*')
				dp[i][0] = dp[i - 2][0];
			else
				dp[i][0] = false;
		}
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (p.charAt(i - 1) == '*') {
					boolean without = dp[i - 2][j];
					boolean with = (p.charAt(i - 2) == s.charAt(j - 1) || p.charAt(i - 2) == '.') ? dp[i][j - 1]
							: false;
					dp[i][j] = without || with;
				} else if (p.charAt(i - 1) == '.') {
					dp[i][j] = dp[i - 1][j - 1];
				} else if (p.charAt(i - 1) == s.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = false;
				}
			}
		}
		return dp[m][n];
	}
}
