/**
 * 
 */
package dynamic_programming;

/**
 * @author PRATAP
 *
 */
public class LongestCommonSubstring {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S1 = "ABCDGH", S2 = "ACDGHR";
		int ans = longestCommonSubstr(S1, S2, S1.length(), S2.length());
		System.out.println(ans);
	}

	public static int longestCommonSubstr(String S1, String S2, int n, int m) {
		// code here
		int[][] dp = new int[n + 1][m + 1];
		int max = 0;
		int posI = -1, posJ = -1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (S1.charAt(i - 1) == S2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = 0;
				}
				if (dp[i][j] > max) {
					max = dp[i][j];
					posI = i;
					posJ = j;
				}
			}
		}
		System.out.println(getSubstring(dp, posI, posJ, S1, S2));
		return max;
	}

	private static String getSubstring(int[][] dp, int posI, int posJ, String s1, String s2) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		while (dp[posI][posJ] != 0) {
			sb.append(s1.charAt(posI - 1));
			posI--;
			posJ--;
		}
		return sb.reverse().toString();
	}

}
