/**
 * 
 */
package dynamic_programming;

import java.util.HashSet;
import java.util.Set;

/**
 * @author PRATAP
 *
 */
public class LongestCommonSubsequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "ABCD";
		String s2 = "ABEDG";
		int lcs = lcs(s1.length(), s2.length(), s1, s2);
		System.out.println(lcs);
	}

	static int lcs(int x, int y, String s1, String s2) {
		// your code here
		int[][] dp = new int[x + 1][y + 1];
		for (int j = 0; j <= y; j++) {
			dp[0][j] = 0;
		}
		for (int i = 0; i <= x; i++)
			dp[i][0] = 0;
		for (int i = 1; i <= x; i++) {
			for (int j = 1; j <= y; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1))
					dp[i][j] = 1 + dp[i - 1][j - 1];
				else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}
			}
		}
//		Finding the LCSs
		Set<String> list = new HashSet<String>();
		findLcs(s1, s2, dp, x, y, list, "");
		System.out.println(list);
		return dp[x][y];
	}

	private static void findLcs(String s1, String s2, int[][] dp, int i, int j, Set<String> list, String curr) {
		// TODO Auto-generated method stub
		if (i <= 0 || j <= 0) {
			list.add(curr);
			return;
		}
		if (s1.charAt(i - 1) == s2.charAt(j - 1) && dp[i][j] == 1 + dp[i - 1][j - 1]) {
			findLcs(s1, s2, dp, i - 1, j - 1, list, s1.charAt(i - 1) + curr);
		} else {
			if (dp[i][j] == dp[i][j - 1]) {
				findLcs(s1, s2, dp, i, j - 1, list, curr);
			}
			if (dp[i][j] == dp[i - 1][j]) {
				findLcs(s1, s2, dp, i - 1, j, list, curr);
			}
		}
	}
}
