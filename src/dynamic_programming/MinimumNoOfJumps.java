/**
 * 
 */
package dynamic_programming;

import java.util.Arrays;

/**
 * @author PRATAP LeetCode 45
 *
 */
public class MinimumNoOfJumps {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { -1, -1, -1 };
		int minSteps = minJumps(arr);
		System.out.println(minSteps);
	}

	static int minJumps(int[] arr) {
		// your code here
		int[] dp = new int[arr.length + 1];
		Arrays.fill(dp, -1);
		int steps = solve(arr, arr.length, 0, dp);
		return steps;
	}

	private static int solve(int[] arr, int n, int i, int[] dp) {
		// TODO Auto-generated method stub
		if (i == n - 1) {
			return 0;
		}
		if (i >= n) {
			return 1;
		}
		if (dp[i] != -1)
			return dp[i];
		int ans = Integer.MAX_VALUE;
		for (int k = 1; k <= arr[i]; k++) {
			int subprob = solve(arr, n, i + k, dp);
			if (subprob != Integer.MAX_VALUE)
				ans = Math.min(ans, subprob + 1);
		}
		dp[i] = ans;
		return ans;
	}

}
