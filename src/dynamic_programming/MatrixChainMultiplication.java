/**
 * 
 */
package dynamic_programming;

import java.util.Arrays;

/**
 * @author PRATAP
 *
 */
public class MatrixChainMultiplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 10, 30, 5, 60 };
		int N = arr.length;
		int ans = matrixMultiplication(N, arr);
		System.out.println(ans);
	}

	public static int matrixMultiplication(int N, int arr[]) {
		// code here
		int m = N - 1;
		int[][] dp = new int[m][m];
		for (int i = 0; i < m; i++)
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		for (int gap = 0; gap < m; gap++) {
			int i = 0;
			int j = i + gap;
			while (j < m) {
				if (gap == 0) {
					dp[i][j] = 0;
				}
				if (gap == 1) {
					int p0 = arr[i];
					int p1 = arr[i + 1];
					int p2 = arr[i + 2];
					int prod = p0 * p1 * p2;
					dp[i][j] = Math.min(dp[i][j], prod);
				} else {
					for (int k = i; k < j; k++) {
						int p0 = arr[i];
						int p1 = arr[k + 1];
						int p2 = arr[j + 1];
						int sum = dp[i][k] + dp[k + 1][j] + p0 * p1 * p2;
						dp[i][j] = Math.min(dp[i][j], sum);
					}
				}
				i++;
				j++;
			}
		}
		return dp[0][m - 1];
	}

}
