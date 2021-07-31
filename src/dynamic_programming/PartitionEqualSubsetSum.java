/**
 * 
 */
package dynamic_programming;

/**
 * @author PRATAP LeetCode 416
 *
 */
public class PartitionEqualSubsetSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 3, 3, 3, 4, 5 };
		int ans = equalPartition(arr.length, arr);
		System.out.println(ans);
	}

	static int equalPartition(int N, int arr[]) {
		// code here
		int sum = 0;
		for (int i : arr)
			sum += i;
		if (sum % 2 > 0)
			return 0;
		sum /= 2;
		int[][] dp = new int[N + 1][sum + 1];	
		for (int j = 1; j <= sum; j++)
			dp[0][j] = 0;
		for (int i = 0; i <= N; i++)
			dp[i][0] = 1;

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= sum; j++) {
				int with = 0, without = 0;
				if (j - arr[i - 1] < 0)
					with = 0;
				else
					with = dp[i - 1][j - arr[i - 1]] == 1 ? 1 : 0;
				without = dp[i - 1][j];
				dp[i][j] = with | without;
			}
		}
		int count = 0;
		for (int i = 1; i <= N; i++)
			if (dp[i][sum] == 1)
				count++;
		if (count >= 2)
			return 1;
		return 0;
	}
}
