/**
 * 
 */
package dynamic_programming;

/**
 * @author PRATAP LeetCode 516
 *
 */
public class LongestPalindromicSubsequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "bbbab";
		LongestPalindromicSubsequence obj = new LongestPalindromicSubsequence();
		int ans = obj.longestPalindromeSubseq(s);
		System.out.println(ans);
	}

	public int longestPalindromeSubseq(String s) {
		int n = s.length();
		int[][] dp = new int[n][n];
		for (int gap = 0; gap < n; gap++) {
			int i = 0;
			int j = i + gap;
			while (j < n) {
				if (gap == 0) {
					dp[i][j] = 1;
				} else if (gap == 1) {
					if (s.charAt(i) == s.charAt(j)) {
						dp[i][j] = 2;
					} else {
						dp[i][j] = 1;
					}
				} else {
					if (s.charAt(i) == s.charAt(j)) {
						dp[i][j] = 2 + dp[i + 1][j - 1];
					} else {
						dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
					}
				}
				i++;
				j++;
			}
		}
		return dp[0][n - 1];
	}
}
