/**
 * 
 */
package dynamic_programming;

/**
 * @author PRATAP
 *
 */
public class EggDroppingPuzzle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 2, k = 10;
		int attempts = eggDrop(n, k);
		System.out.println(attempts);
	}

	static int eggDrop(int n, int k) {
		// Your code here
		int[][] dp = new int[n + 1][k + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= k; j++) {
				if (i == 1) {
					dp[i][j] = j;
				} else if (j == 1) {
					dp[i][j] = 1;
				} else {
					int min = Integer.MAX_VALUE;
					for (int mj = j - 1, pj = 0; mj >= 0; mj--, pj++) {
						int val1 = dp[i][mj]; // egg survives
						int val2 = dp[i - 1][pj]; // egg breaks
						int max = Math.max(val1, val2);
						min = Math.min(min, max);
					}
					dp[i][j] = min + 1;
				}
			}
		}
		return dp[n][k];
	}

}
