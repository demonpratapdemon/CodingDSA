/**
 * 
 */
package miscellaneous;

/**
 * @author PRATAP LeetCode 91
 *
 */
public class DecodeWays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "230";
		int ans = numDecodings(s);
		System.out.println(ans);
	}

	public static int numDecodings(String s) {
		if (s.contains("00") || s.charAt(0) == '0')
			return 0;
		int n = s.length();
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			if (s.charAt(i - 1) == '0' && Integer.parseInt(
					String.valueOf(String.valueOf(s.charAt(i - 2)) + String.valueOf(s.charAt(i - 1)))) <= 26) {
				dp[i] = dp[i - 2];
			} else if (s.charAt(i - 1) != '0' && s.charAt(i - 2) == '0') {
				dp[i] = dp[i - 1];
			} else if (s.charAt(i - 1) != '0') {
				dp[i] = dp[i - 1];
				if (Integer.parseInt(
						String.valueOf(String.valueOf(s.charAt(i - 2)) + String.valueOf(s.charAt(i - 1)))) <= 26) {
					dp[i] += dp[i - 2];
				}
			}
		}
		return dp[n];
	}
}
