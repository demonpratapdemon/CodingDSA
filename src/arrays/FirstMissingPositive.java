/**
 * 
 */
package arrays;

import java.util.TreeSet;

/**
 * @author PRATAP LeetCode 41
 *
 */
public class FirstMissingPositive {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 2, 0 };
		int ans = firstMissingPositiveWithoutExtraSpace(nums);
		System.out.println(ans);
	}

	public static int firstMissingPositive(int[] nums) {
		TreeSet<Integer> set = new TreeSet<Integer>();
		for (int i : nums)
			set.add(i);
		int miss = 1;
		while (!set.isEmpty()) {
			int curr = set.pollFirst();
			if (curr <= 0)
				continue;
			if (curr == miss)
				miss++;
			else
				break;
		}
		return miss;
	}

	public static int firstMissingPositiveWithoutExtraSpace(int[] nums) {
		int n = nums.length;
		boolean onePresent = false;
		for (int i = 0; i < n; i++) {
			if (nums[i] == 1) {
				onePresent = true;
				break;
			}
		}
		if (!onePresent)
			return 1;
		for (int i = 0; i < n; i++) {
			if (nums[i] <= 0 || nums[i] > n) {
				nums[i] = 1;
			}
		}
		for (int i = 0; i < n; i++) {
			int pos = Math.abs(nums[i]) - 1;
			if (nums[pos] > 0)
				nums[pos] = -nums[pos];
		}
		int i = 0;
		for (; i < n; i++) {
			if (nums[i] > 0) {
				return i + 1;
			}
		}
		return i + 1;
	}

}
