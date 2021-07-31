/**
 * 
 */
package dynamic_programming;

/**
 * @author PRATAP LeetCode 279
 *
 */
public class PerfectSquares {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 13;
		PerfectSquares obj = new PerfectSquares();
		int ans = obj.numSquares(n);
		System.out.println(ans);
	}

	public int numSquares(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			int count = Integer.MAX_VALUE;
			for (int j = 1; j <= Math.sqrt(i); j++) {
				if (i - j * j >= 0) {
					count = Math.min(count, 1 + dp[i - j * j]);
				}
			}
			dp[i] = count;
		}
		return dp[n];
	}
}
