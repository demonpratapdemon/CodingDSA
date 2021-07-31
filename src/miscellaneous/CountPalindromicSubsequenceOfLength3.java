/**
 * 
 */
package miscellaneous;

/**
 * @author PRATAP
 *
 */
public class CountPalindromicSubsequenceOfLength3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "adc";
		CountPalindromicSubsequenceOfLength3 obj = new CountPalindromicSubsequenceOfLength3();
		int ans = obj.countPalindromicSubsequence(str);
		System.out.println(ans);
	}

	public int countPalindromicSubsequence(String str) {
		int mod = (int) (1e9 + 7);
		int n = str.length();
		int[][] dp = new int[n][n];
		int count = 0;
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
		return count;
	}
}
