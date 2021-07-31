/**
 * 
 */
package arrays;

/**
 * @author PRATAP
 *
 */
public class KadanesAlgorithm {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 2, 3, -2, 5 };
		int ans = maxSubarraySum(arr, arr.length);
		System.out.println(ans);
	}

	public static int maxSubarraySum(int arr[], int n) {
		// Your code here
		int overall = arr[0], max_ending = arr[0], min_ending = arr[0];
		for (int i = 1; i < n; i++) {
			int temp = max_ending;
			max_ending = Math.max(arr[i], Math.max(temp + arr[i], arr[i] + min_ending));
			min_ending = Math.min(arr[i], Math.min(temp + arr[i], arr[i] + min_ending));
			overall = Math.max(overall, max_ending);
		}
		return overall;
	}

}
