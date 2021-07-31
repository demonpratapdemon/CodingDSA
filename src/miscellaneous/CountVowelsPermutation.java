/**
 * 
 */
package miscellaneous;

import java.util.Arrays;

/**
 * @author PRATAP LeetCode 1220
 *
 */
public class CountVowelsPermutation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 144;
		int ans = countVowelPermutation(n);
		System.out.println(ans);
	}

	public static int countVowelPermutation(int n) {
		long[][] dp = new long[n + 1][5];
		// End			// Possibilities
		//  a				3(e,i,u)
		//  e				2(a,i)
		//  i				2(e,o)
		//  o				1(i)
		//  u				2(i,o)
		//  a=0, e=1, i=2, o=3, u=4

		Arrays.fill(dp[1], 1);
		int mod = (int) (1e9 + 7);
		for (int i = 2; i <= n; i++) {
			dp[i][0] = (dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][4]) % mod;
			dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % mod;
			dp[i][2] = (dp[i - 1][1] + dp[i - 1][3]) % mod;
			dp[i][3] = dp[i - 1][2] % mod;
			dp[i][4] = (dp[i - 1][2] + dp[i - 1][3]) % mod;
		}
		long count = 0;
		for (int j = 0; j < 5; j++)
			count = (count + dp[n][j]) % mod;
		return (int) count;
	}

}
