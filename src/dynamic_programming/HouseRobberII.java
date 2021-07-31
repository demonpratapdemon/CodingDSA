/**
 * 
 */
package dynamic_programming;

/**
 * @author PRATAP LeetCode 213
 *
 */
public class HouseRobberII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 2, 3, 4 };
		HouseRobberII obj = new HouseRobberII();
		int ans = obj.rob(nums);
		System.out.println(ans);
	}

	public int rob(int[] nums) {
		if (nums.length == 1)
			return nums[0];
		if (nums.length == 2)
			return Math.max(nums[0], nums[1]);
		int n = nums.length;
		int with = solve(nums, 0, n - 2);
		int without = solve(nums, 1, n - 1);
		return Math.max(with, without);
	}

	private int solve(int[] nums, int start, int end) {
		// TODO Auto-generated method stub
		int prev1 = nums[start];
		int prev2 = 0;
		for (int i = start + 1; i <= end; i++) {
			int max = Math.max(nums[i] + prev2, prev1);
			prev2 = prev1;
			prev1 = max;
		}
		return prev1;
	}

}
