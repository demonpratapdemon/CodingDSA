/**
 * 
 */
package dynamic_programming;

/**
 * @author PRATAP
 *
 */
public class CoinChangeMinimumNoOfCoins {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] coins = { 2 };
		int amount = 3;
		int ans = coinChange(coins, amount);
		System.out.println(ans);
	}

	public static int coinChange(int[] coins, int amount) {
		int n = coins.length;
		int[] dp = new int[amount + 1];
		if (amount == 0)
			return 0;
		for (int i = 1; i <= amount; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < n; j++) {
				if (i - coins[j] >= 0) {
					min = Math.min(min, dp[i - coins[j]]);
				}
			}
			if (min == Integer.MAX_VALUE)
				dp[i] = min;
			else
				dp[i] = min + 1;
		}
		if (dp[amount] == Integer.MAX_VALUE)
			return -1;
		return dp[amount];
	}

}
