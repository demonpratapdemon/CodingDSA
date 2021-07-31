/**
 * 
 */
package miscellaneous;

/**
 * @author PRATAP LeetCode 1749
 *
 */
public class MaximumAbsoluteSumOfAnySubarray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 2, -5 };
		int ans = maxAbsoluteSum(nums);
		System.out.println(ans);
	}

	public static int maxAbsoluteSum(int[] nums) {
		int o = nums[0], max = nums[0], min = nums[0];
		for (int i = 1; i < nums.length; i++) {
			int temp = max;
			max = Math.max(nums[i], Math.max(max + nums[i], min + nums[i]));
			min = Math.min(nums[i], Math.min(temp + nums[i], min + nums[i]));
			int x = Math.abs(o);
			int y = Math.abs(min);
			int z = Math.abs(max);
			o = Math.max(x, Math.max(y, z));
		}
		return Math.abs(o);
	}
}
