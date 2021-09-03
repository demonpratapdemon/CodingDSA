/**
 * 
 */
package september_leetcode_challenge;

/**
 * @author PRATAP LeetCode 565
 *
 */
public class Day1_ArrayNesting {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 5, 4, 0, 3, 1, 6, 2 };
		Day1_ArrayNesting obj = new Day1_ArrayNesting();
		int ans = obj.arrayNesting(nums);
		System.out.println(ans);
	}

	int count = 0;

	public int arrayNesting(int[] nums) {
		int max = Integer.MIN_VALUE;
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			dfs(i, nums);
			max = Math.max(max, count);
			count = 0;
		}
		return max;
	}

	private void dfs(int i, int[] nums) {
		// TODO Auto-generated method stub
		if (nums[i] == Integer.MIN_VALUE) {
			return;
		}
		int num = nums[i];
		nums[i] = Integer.MIN_VALUE;
		count++;
		dfs(num, nums);
	}
}
