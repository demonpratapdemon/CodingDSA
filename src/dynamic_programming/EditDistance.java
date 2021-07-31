/**
 * 
 */
package dynamic_programming;

/**
 * @author PRATAP LeetCode 72
 *
 */
public class EditDistance {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abc";
		String t = "bcd";
		int distance = editDistance(s, t);
		System.out.println(distance);
	}

	public static int editDistance(String s, String t) {
		// Code here
		int n = s.length();
		int m = t.length();
		int[][] dp = new int[n + 1][m + 1];
		for (int j = 0; j <= m; j++) {
			dp[0][j] = j;
		}
		for (int i = 0; i <= n; i++) {
			dp[i][0] = i;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (s.charAt(i - 1) == t.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					int replace = dp[i - 1][j - 1] + 1;
					int remove = dp[i - 1][j] + 1;
					int insert = dp[i][j - 1] + 1;
					dp[i][j] = Math.min(replace, Math.min(remove, insert));
				}
			}
		}
		return dp[n][m];
	}
}
