/**
 * 
 */
package november_leetcode_challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author PRATAP LeetCode 368
 *
 */
public class Day15_LargestDivisibleSubset {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 2, 4, 8 };
		Day15_LargestDivisibleSubset obj = new Day15_LargestDivisibleSubset();
		List<Integer> ans = obj.largestDivisibleSubset(nums);
		System.out.println(ans);
	}

	public List<Integer> largestDivisibleSubset(int[] nums) {
		int n = nums.length;
		int[] dp = new int[n];
		Arrays.sort(nums);
		Arrays.fill(dp, 1);
		int pos = 0;
		List<Integer> res = new ArrayList<Integer>();
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] % nums[j] == 0 && 1 + dp[j] > dp[i]) {
					dp[i] = 1 + dp[j];
				}
			}
			if (dp[i] > dp[pos]) {
				pos = i;
			}
		}
		int max = dp[pos];
		int prev = nums[pos];
		res.add(prev);
		max--;
		for (int i = pos - 1; i >= 0; i--) {
			if (dp[i] == max && prev % nums[i] == 0) {
				res.add(nums[i]);
				max--;
				prev = nums[i];
			}
		}
		return res;
	}

}
