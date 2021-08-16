/**
 * 
 */
package problem_of_the_day;

/**
 * @author PRATAP
 *
 */
public class NumberOfPalindromicStrings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 19, K = 14;
		int ans = palindromicStrings(N, K);
		System.out.println(ans);
	}

	public static int palindromicStrings(int N, int K) {
		// code here
		long mod = (long) (1e9 + 7);
		long[] dp = new long[N + 1];
		if (N == 1)
			return K;
		dp[1] = K;
		dp[2] = K;
		long sum = dp[1] + dp[2];
		for (int i = 3; i <= N; i++) {
			if (i % 2 == 0) {
				dp[i] = dp[i - 1];
			} else {
				int temp = (i / 2);
				dp[i] = (dp[i - 1] * (K - temp) ) % mod;
			}
			sum = (sum + dp[i]) % mod;
		}
		return (int)(sum % mod);
	}

}
