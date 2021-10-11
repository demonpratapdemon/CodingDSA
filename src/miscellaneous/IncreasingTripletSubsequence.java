/**
 * 
 */
package miscellaneous;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author PRATAP LeetCode 334
 *
 */
public class IncreasingTripletSubsequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 2, 1, 5, 0, 4, 6 };
		IncreasingTripletSubsequence obj = new IncreasingTripletSubsequence();
		boolean ans = obj.increasingTriplet3(nums);
		System.out.println(ans);
	}

	public boolean increasingTriplet(int[] nums) {
		int n = nums.length;
		int[] res = new int[n];
		Arrays.fill(res, 1);
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i : nums)
			set.add(i);
		if (set.size() <= 2)
			return false;
		for (int i = 1; i < n; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (nums[j] < nums[i]) {
					res[i] = Math.max(res[i], res[j] + 1);
				}
			}
			if (res[i] == 3)
				return true;
		}
		return false;
	}

	public boolean increasingTriplet1(int[] nums) {
		int n = nums.length;
		int leftMin[] = new int[n];
		int rightMax[] = new int[n];
		leftMin[0] = nums[0];
		rightMax[n - 1] = nums[n - 1];
		for (int i = 1; i < n; i++) {
			leftMin[i] = Math.min(nums[i], leftMin[i - 1]);
		}
		for (int i = n - 2; i >= 0; i--) {
			rightMax[i] = Math.max(rightMax[i + 1], nums[i]);
		}
		for (int i = 0; i < n; i++) {
			if (leftMin[i] < nums[i] && nums[i] < rightMax[i])
				return true;
		}
		return false;
	}

	public boolean increasingTriplet3(int[] nums) {
		int f = Integer.MAX_VALUE, s = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] <= f) {
				f = nums[i];
			} else if (nums[i] <= s) {
				s = nums[i];
			} else {
				return true;
			}
		}
		return false;
	}
}
