/**
 * 
 */
package dynamic_programming;

/**
 * @author PRATAP
 *
 */
public class MaximumSumIncreasingSubsequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 44, 47, 32, 22, 26 };
		int size = arr.length;
		int sum = maxSumIS(arr, size);
		System.out.println(sum);
	}

	public static int maxSumIS(int arr[], int size) {
		if (size == 1)
			return arr[0];
		int[] dp = new int[size];
		dp[0] = arr[0];
		int res = dp[0];
		for (int i = 1; i < size; i++) {
			int max = Integer.MIN_VALUE;
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					max = Math.max(max, dp[j] + arr[i]);
				}
			}
			dp[i] = max == Integer.MIN_VALUE ? arr[i] : max;
			res = Math.max(res, dp[i]);
		}
		return res;
	}
}
