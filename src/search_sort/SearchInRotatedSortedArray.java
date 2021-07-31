/**
 * 
 */
package search_sort;

import java.util.Arrays;

/**
 * @author PRATAP LeetCode 33
 *
 */
public class SearchInRotatedSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 3, 1 };
		int target = 3;
		int ans = search(nums, target);
		System.out.println(ans);
	}

	public static int search(int[] nums, int target) {
		int n = nums.length;
		int[] arr = new int[n];
		int min = nums[0];
		int k = 0;
		for (int i = 1; i < n; i++) {
			if (nums[i] < min) {
				k = i;
				min = nums[i];
			}
		}
		int p = 0;
		for (int i = k; i < n; i++) {
			arr[p++] = nums[i];
		}
		p = n - 1;
		for (int i = k - 1; i >= 0; i--) {
			arr[p--] = nums[i];
		}
//		for (int i : arr)
//			System.out.print(i + " ");
		int pos = Arrays.binarySearch(arr, target);
		// System.out.println(k + " " + pos);
		if (pos < 0)
			return -1;
		if (pos + k >= n)
			return (pos + k) % n;
		return pos + k;
	}

}
