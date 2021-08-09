/**
 * 
 */
package august_leetcode_challenges;

/**
 * @author PRATAP LeetCode 877
 *
 */
public class Day5_StoneGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] piles = { 5, 3, 4, 5 };
		Day5_StoneGame obj = new Day5_StoneGame();
		boolean ans = obj.stoneGame(piles);
		System.out.println(ans);
	}

	public boolean stoneGame(int[] piles) {
		int n = piles.length;
		long[][] dp = new long[n][n];
		for (int g = 0; g < n; g++) {
			int i = 0;
			int j = i + g;
			while (j < n) {
				if (g == 0) {
					dp[i][j] = piles[j];
				} else if (g == 1) {
					dp[i][j] = Math.max(piles[i], piles[j]);
				} else {
					long first = piles[i] + Math.min(dp[i + 2][j], dp[i + 1][j - 1]);
					long second = piles[j] + Math.min(dp[i][j - 2], dp[i + 1][j - 1]);
					dp[i][j] = Math.max(first, second);
				}
				i++;
				j++;
			}
		}
		int sum = 0;
		for (int x : piles)
			sum += x;
		return sum - dp[0][n - 1] > 0 ? true : false;
	}
}
