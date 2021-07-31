/**
 * 
 */
package search_sort;

/**
 * @author PRATAP
 *
 */
public class PaintersPartitionProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 10, 5, 20, 25, 17, 23, 2, 9, 4, 13 };
		int k = 7;
		long minTime = minTime(arr, arr.length, k);
		System.out.println(minTime);
	}

	public static long minTime(int[] arr, int n, int k) {
		long sum = 0;
		for (int i : arr)
			sum += i;
		long lb = 0, ub = sum;
		long ans = 0;
		while (lb <= ub) {
			long mid = lb + (ub - lb) / 2;
			if (solve(arr, mid, k)) {
				ans = mid;
				ub = mid - 1;
			} else {
				lb = mid + 1;
			}
		}
		return ans;
	}

	private static boolean solve(int[] arr, long mid, int k) {
		// TODO Auto-generated method stub
		int painters = 1;
		long curr = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > mid && painters < k)
				return false;
			if (curr + arr[i] <= mid) {
				curr += arr[i];
			} else {
				painters++;
				curr = arr[i];
			}
			if (painters > k)
				return false;
		}
		return true;
	}

	public static long minTime1(int[] arr, int n, int k) {
		// code here
		int[] range = new int[n];
		int prefix = 0;
		for (int i = 0; i < n; i++) {
			prefix += arr[i];
			range[i] = prefix;
		}
		int[][] dp = new int[k + 1][n + 1];
		for (int i = 1; i <= k; i++) {
			dp[i][1] = arr[0];
		}
		for (int j = 2; j <= n; j++) {
			dp[1][j] = range[j - 1];
		}
		for (int i = 2; i <= k; i++) {
			for (int j = 2; j <= n; j++) {
				int best = Integer.MAX_VALUE;
				for (int p = 1; p <= j; p++) {
					best = Math.min(best, Math.max(dp[i - 1][p], findSum(range, p, j)));
				}
				dp[i][j] = best;
			}
		}
		return dp[k][n];
	}

	private static int findSum(int[] range, int p, int j) {
		// TODO Auto-generated method stub
		return range[j - 1] - range[p - 1];
	}

}
