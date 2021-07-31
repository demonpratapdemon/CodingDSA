/**
 * 
 */
package dynamic_programming;

/**
 * @author PRATAP
 *
 */
public class FriendsPairing {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 100000;
		System.out.println(countFriendsPairings(n));
	}

	public static long countFriendsPairings(int n) {
		// code here
		int mod = 1000000007;
		long[] dp = new long[n + 1];
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= n; i++) {
			dp[i] = (dp[i - 1] + (i - 1) * dp[i - 2]) % mod;
		}
		return dp[n] % mod;
	}

}
