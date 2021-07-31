/**
 * 
 */
package dynamic_programming;

/**
 * @author PRATAP LeetCode 494
 *
 */
public class TargetSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = { 0, 0, 0, 0, 0, 0, 0, 0, 1 }, target = 1;
		TargetSum obj = new TargetSum();
		int ans = obj.findTargetSumWays(nums, target);
		System.out.println(ans);
	}

	public int findTargetSumWays(int[] nums, int target) {
		int sum = 0;
		for (int i : nums) {
			sum += i;
		}
		if ((sum + target) % 2 > 0)
			return 0;
		int s = (sum + target) / 2;
		int find = findSubsetSum(nums, s);
		return find;
	}

	private int findSubsetSum(int[] nums, int s) {
		// TODO Auto-generated method stub
		int n = nums.length;
		int[][] dp = new int[n + 1][s + 1];
		for (int i = 0; i <= n; i++) {
			dp[i][0] = 1;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= s; j++) {
				int with = 0, without = 0;
				without = dp[i - 1][j];
				if (j - nums[i - 1] >= 0) {
					with = dp[i - 1][j - nums[i - 1]];
				}
				dp[i][j] = with + without;
			}
		}
		return dp[n][s];
	}
}
