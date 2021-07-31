/**
 * 
 */
package dynamic_programming;

/**
 * @author PRATAP
 *
 */
public class WineSelling {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int prices[] = { 2, 3, 5, 1, 4 };
		int maxProfit = sellWines(prices, prices.length);
		System.out.println(maxProfit);
	}

	private static int sellWines(int[] prices, int n) {
		// TODO Auto-generated method stub
		int[][] dp = new int[n][n];
		for (int i = n - 1; i >= 0; i--) {
			for (int j = 0; j < n; j++) {
				if (i == j) {
					dp[i][j] = n * prices[i];
				} else if (i < j) {
					int bottlesLeft = j - i;
					int year = n - bottlesLeft;
					int left = prices[i] * year + dp[i + 1][j];
					int right = prices[j] * year + dp[i][j - 1];
					dp[i][j] = Math.max(left, right);
				}
			}
		}
		return dp[0][n - 1];
	}

}
