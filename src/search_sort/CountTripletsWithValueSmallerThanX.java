/**
 * 
 */
package search_sort;

import java.util.Arrays;

/**
 * @author PRATAP
 *
 */
public class CountTripletsWithValueSmallerThanX {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long[] arr = { 30, 8, 23, 6, 10, 9, 31, 7, 19, 20, 1, 33, 21, 27, 28, 3, 25, 26 };
		int sum = 86;
		long ans = countTriplets(arr, arr.length, sum);
		System.out.println(ans);
	}

	public static long countTriplets(long arr[], int n, int sum) {
		Arrays.sort(arr);
		long count = 0;
		for (int i = 0; i < n - 2; i++) {
			int j = i + 1;
			int k = n - 1;
			while (j < k) {
				long curr = arr[i] + arr[j] + arr[k];
				if (curr < sum) {
					count += (k - j);
					j++;
				} else
					k--;
			}
		}
		return count;
	}

}
