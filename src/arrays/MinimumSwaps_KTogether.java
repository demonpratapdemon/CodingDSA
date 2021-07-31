/**
 * 
 */
package arrays;

/**
 * @author PRATAP Sliding Window Technique
 */
public class MinimumSwaps_KTogether {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = { 14, 12, 11, 3, 19, 1, 2, 7, 5, 18, 16, 16, 5, 3, 12, 5, 2, 13, 16, 1 };
		int[] arr = { 2, 1, 5, 6, 3 };
		int swaps = minSwap(arr, arr.length, 3);
		System.out.println(swaps);
	}

	public static int minSwap(int arr[], int n, int k) {
		// Complete the function
//		int swaps = Integer.MAX_VALUE;
		int good = 0;
		int bad = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] <= k)
				good++;
		}

		for (int i = 0; i < good; i++) {
			if (arr[i] > k) {
				bad++;
			}

		}
		int i = 0, j = good, res = bad;
		while (j < n) {
			if (arr[i] > k)
				bad--;
			if (arr[j] > k)
				bad++;
			res = Math.min(res, bad);
			i++;
			j++;
		}
		return res;
	}

}
