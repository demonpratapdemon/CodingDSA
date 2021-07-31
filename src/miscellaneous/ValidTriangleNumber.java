/**
 * 
 */
package miscellaneous;

import java.util.Arrays;

/**
 * @author PRATAP
 *
 */
public class ValidTriangleNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 0, 1, 0 };
		int ans = triangleNumber(nums);
		System.out.println(ans);
	}

	public static int triangleNumber(int[] nums) {
		if (nums.length <= 2)
			return 0;
		Arrays.sort(nums);
		int count = 0;
		int n = nums.length;
		if (nums[n - 1] == 0)
			return 0;
		for (int i = n - 1; i >= 2; i--) {
			int l = 0, r = i - 1;
			while (l < r) {
				if (nums[l] + nums[r] > nums[i]) {
					count += r - l;
					r--;
				} else {
					l++;
				}
			}
		}
		return count;
	}

}
