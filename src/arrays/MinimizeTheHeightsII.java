/**
 * 
 */
package arrays;

import java.util.Arrays;

/**
 * @author PRATAP
 *
 */
public class MinimizeTheHeightsII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 5, 8, 10 };
		int k = 2;
		int ans = getMinDiff(arr, arr.length, k);
		System.out.println(ans);
	}

	public static int getMinDiff(int[] arr, int n, int k) {
		// code here
		Arrays.sort(arr);
		int ans = arr[n - 1] - arr[0];
		int smallest = arr[0] + k;
		int largest = arr[n - 1] - k;
		int min, max;
		for (int i = 0; i < n - 1; i++) {
			min = Math.min(smallest, arr[i + 1] - k);
			max = Math.max(largest, arr[i] + k);
			if (min < 0)
				continue;
			ans = Math.min(ans, max - min);
		}
		return ans;
	}

}
