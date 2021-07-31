/**
 * 
 */
package miscellaneous;

/**
 * @author PRATAP
 *
 */
public class CountCyclicPaths {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 100;
		int ans = countPaths(N);
		System.out.println(ans);
	}

	public static int ways = 0;

	public static int countPaths(int N) {
		// code here
		if (N == 0)
			return 0;
		long mod = (long) (1e9 + 7);
		long[][] dp = new long[4][N + 1];
		dp[0][0] = 1;
		dp[1][0] = 0;
		dp[2][0] = 0;
		dp[3][0] = 0;
		for (int i = 1; i <= N; i++) {
			long forO = (dp[1][i - 1] + dp[2][i - 1] + dp[3][i - 1]) % mod;
			long forA = (dp[0][i - 1] + dp[2][i - 1] + dp[3][i - 1]) % mod;
			long forB = (dp[0][i - 1] + dp[1][i - 1] + dp[3][i - 1]) % mod;
			long forC = (dp[0][i - 1] + dp[1][i - 1] + dp[2][i - 1]) % mod;
			dp[0][i] = forO % mod;
			dp[1][i] = forA % mod;
			dp[2][i] = forB % mod;
			dp[3][i] = forC % mod;
		}
		return (int)(dp[0][N] % mod);
	}

}
