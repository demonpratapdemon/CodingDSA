/**
 * 
 */
package dynamic_programming;

/**
 * @author PRATAP
 *
 */
public class OptimalStrategyForAGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 8, 15, 3, 7 };
		long ans = countMaximum(arr, arr.length);
		System.out.println(ans);
	}

	public static long countMaximum(int arr[], int n) {
		// Your code here
		long[][] dp = new long[n][n];
		for (int g = 0; g < n; g++) {
			int i = 0;
			int j = i + g;
			while (j < n) {
				if (g == 0) {
					dp[i][j] = arr[j];
				} else if (g == 1) {
					dp[i][j] = Math.max(arr[i], arr[j]);
				} else {
					long first = arr[i] + Math.min(dp[i + 2][j], dp[i + 1][j - 1]);
					long second = arr[j] + Math.min(dp[i][j - 2], dp[i + 1][j - 1]);
					dp[i][j] = Math.max(first, second);
				}
				i++;
				j++;
			}
		}
		return dp[0][n - 1];
	}
}
