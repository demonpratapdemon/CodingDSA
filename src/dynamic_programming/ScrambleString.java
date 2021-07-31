/**
 * 
 */
package dynamic_programming;

/**
 * @author PRATAP LeetCode 87
 *
 */
public class ScrambleString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String s1 = "great", s2 = "rgeat";
		String s1 = "abcde", s2 = "caebd";
		ScrambleString obj = new ScrambleString();
		boolean ans = obj.isScramble(s1, s2);
		System.out.println(ans);
	}

	public boolean isScramble(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		int n = s1.length();
		boolean[][][] dp = new boolean[n][n][n + 1]; // last index is of length 0, 1,2,3,4...
		for (int len = 1; len <= n; len++) {
			for (int i = 0; i <= n - len; i++) {
				for (int j = 0; j <= n - len; j++) {
					if (len == 1) {
						dp[i][j][len] = s1.charAt(i) == s2.charAt(j) ? true : false;
					} else {
						for (int k = 1; k < len && !dp[i][j][len]; k++) {
							dp[i][j][len] = (dp[i][j][k] && dp[i + k][j + k][len - k])
									|| (dp[i][j + len - k][k] && dp[i + k][j][len - k]);
						}
					}
				}
			}
		}

		return dp[0][0][n];
	}
}
