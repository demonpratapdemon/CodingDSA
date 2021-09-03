/**
 * 
 */
package dynamic_programming;

/**
 * @author PRATAP LeetCode 132
 *
 */
public class PalindromePartitioning {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String str = "ababbbabbababa";
		String str = "abaaabba";
		int ans = palindromicPartition(str);
		System.out.println(ans);
	}

	public static int palindromicPartition(String str) {
		// code here
		int n = str.length();
		boolean[][] dp = new boolean[n][n];
		for (int g = 0; g < n; g++) {
			int i = 0;
			int j = i + g;
			while (j < n) {
				if (g == 0) {
					dp[i][j] = true;
				} else if (g == 1) {
					if (str.charAt(i) == str.charAt(j))
						dp[i][j] = true;
				} else {
					if (str.charAt(i) == str.charAt(j) && dp[i + 1][j - 1]) {
						dp[i][j] = true;
					}
				}
				i++;
				j++;
			}
		}
		int[] strg = new int[n];
		for (int i = 1; i < n; i++) {
			if (dp[0][i]) {
				strg[i] = 0;
			} else {
				int min = Integer.MAX_VALUE;
				for (int j = i; j > 0; j--) {
					if (dp[j][i]) {
						min = Math.min(min, strg[j - 1]);
					}
				}
				strg[i] = min + 1;
			}
		}
		return strg[n - 1];
	}
}
