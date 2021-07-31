/**
 * 
 */
package arrays;

/**
 * @author PRATAP
 *
 */
public class MaximumProductSubarray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 6, -3, -10, 0, 2 };
		long ans = maxProduct(arr, arr.length);
		System.out.println(ans);
	}

	public static long maxProduct(int[] arr, int n) {
		// code here
		Long max_overall = (long) arr[0];
		long max_ending = (long) arr[0], min_ending = (long) arr[0];
		for (int i = 1; i < n; i++) {
			long temp = max_ending;
			max_ending = Math.max(arr[i], Math.max(arr[i] * temp, arr[i] * min_ending));
			min_ending = Math.min(arr[i], Math.min(arr[i] * temp, arr[i] * min_ending));
			max_overall = Math.max(max_overall, max_ending);
		}
		return max_overall;
	}
}
