/**
 * 
 */
package strings;

/**
 * @author PRATAP LeetCode 97
 *
 */
public class InterleavingString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbbaccc";
		boolean ans = isInterleave(s1, s2, s3);
		System.out.println(ans);
	}

	public static boolean isInterleave(String s1, String s2, String s3) {
		int n1 = s1.length();
		int n2 = s2.length();
		int nr = s3.length();
		if (nr != n1 + n2)
			return false;
		boolean[][] dp = new boolean[n1 + 1][n2 + 1];
		dp[0][0] = true;
		for (int j = 1; j <= n2; j++) {
			if (s2.charAt(j - 1) == s3.charAt(j - 1) && dp[0][j - 1])
				dp[0][j] = true;
		}
		for (int i = 1; i <= n1; i++) {
			if (s1.charAt(i - 1) == s3.charAt(i - 1) && dp[i - 1][0])
				dp[i][0] = true;
		}
		for (int i = 1; i <= n1; i++) {
			for (int j = 1; j <= n2; j++) {
				if (s1.charAt(i - 1) == s3.charAt(i + j - 1) && s2.charAt(j - 1) != s3.charAt(i + j - 1)) {
					if (dp[i - 1][j])
						dp[i][j] = true;
				} else if (s2.charAt(j - 1) == s3.charAt(i + j - 1) && s1.charAt(i - 1) != s3.charAt(i + j - 1)) {
					if (dp[i][j - 1])
						dp[i][j] = true;
				} else if (s1.charAt(i - 1) == s3.charAt(i + j - 1) && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
					dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
				}
			}
		}
		return dp[n1][n2];
	}

}
