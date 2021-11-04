/**
 * 
 */
package miscellaneous;

import java.util.Arrays;

/**
 * @author PRATAP LeetCode 324
 *
 */
public class WiggleSortII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 5, 1, 1, 6, 4 };
		wiggleSort(nums);
		for (int i : nums)
			System.out.print(i + " ");
	}

	public static void wiggleSort(int[] nums) {
		Arrays.sort(nums);
		int n = nums.length;
		int[] res = new int[n];
		int j = n - 1;
		int i = 1;
		while (i < n && j >= 0) {
			res[i] = nums[j];
			i += 2;
			j--;
		}
		i = 0;
		while (i < n && j >= 0) {
			res[i] = nums[j];
			i += 2;
			j--;
		}
		for (i = 0; i < n; i++)
			nums[i] = res[i];
	}
}
