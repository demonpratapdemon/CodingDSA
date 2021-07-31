/**
 * 
 */
package dynamic_programming;

/**
 * @author PRATAP
 *
 */
public class SticklerThief {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 1, 2, 3 };
		int ans = FindMaxSum(a, a.length);
		System.out.println(ans);
	}

	public static int FindMaxSum(int arr[], int n) {
		// Your code here
		int[] dp = new int[n];
		for (int i = 0; i < n; i++)
			dp[i] = -1;
		int ans = solve(arr, n - 1, dp);
		return ans;
	}

	private static int solve(int[] arr, int i, int[] dp) {
		// TODO Auto-generated method stub
		if (i < 0)
			return 0;
		if (dp[i] != -1)
			return dp[i];
		int opt1 = arr[i] + solve(arr, i - 2, dp);
		int opt2 = solve(arr, i - 1, dp);
		dp[i] = Math.max(opt1, opt2);
		return dp[i];
	}

}
