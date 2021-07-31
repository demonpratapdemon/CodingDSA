/**
 * 
 */
package dynamic_programming;

import java.util.Arrays;

/**
 * @author PRATAP
 *
 */
public class MobileNumberKeypad {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 2;
		long ans = getCount(N);
		System.out.println(ans);
	}

	public static long getCount(int N) {
		// Your code goes here
		long[][] dp = new long[N + 1][10];
		Arrays.fill(dp[1], 1);
		int[][] data = { { 0, 8 }, { 1, 2, 4 }, { 1, 2, 3, 5 }, { 2, 3, 6 }, { 1, 4, 5, 7 }, { 2, 4, 5, 6, 8 },
				{ 3, 5, 6, 9 }, { 4, 7, 8 }, { 0, 5, 7, 8, 9 }, { 6, 8, 9 }, };
		for (int i = 2; i <= N; i++) {
			for (int j = 0; j < 10; j++) {
				long sum = 0;
				for (int k = 0; k < data[j].length; k++) {
					sum += dp[i - 1][data[j][k]];
				}
				dp[i][j] = sum;
			}
		}
		long count = 0;
		for (int j = 0; j < 10; j++)
			count += dp[N][j];
		return count;
	}
}
