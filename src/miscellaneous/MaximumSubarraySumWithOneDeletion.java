/**
 * 
 */
package miscellaneous;

/**
 * @author PRATAP LeetCode 1186
 *
 */
public class MaximumSubarraySumWithOneDeletion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = { 1, -2, 0, 3 };
		int[] arr = { 11, -10, -11, 8, 7, -6, 9, 4, 11, 6, 5, 0 };
//		int[] arr = { 1, -2, -2, 3 };
		int maxSum = maximumSum(arr);
		System.out.println(maxSum);
	}

	public static int maximumSum(int[] arr) {
		// All negative elements
		int max = Integer.MIN_VALUE;
		for (int i : arr)
			max = Math.max(max, i);
		if (max < 0)
			return max;

		int n = arr.length;
		int[] forward = new int[n];
		int[] backward = new int[n];
		int curr = arr[0];
		forward[0] = arr[0];
		int best = arr[0];
		for (int i = 1; i < n; i++) {
			if (curr < 0) {
				curr = arr[i];
			} else {
				curr += arr[i];
			}
			forward[i] = curr;
			best = Math.max(best, forward[i]);
		}
		backward[n - 1] = arr[n - 1];
		curr = arr[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			if (curr < 0) {
				curr = arr[i];
			} else {
				curr += arr[i];
			}
			backward[i] = curr;
			best = Math.max(best, backward[i]);
		}

		for (int i = 1; i < n - 1; i++) {
			best = Math.max(best, forward[i - 1] + backward[i + 1]);
		}
		return best;
	}

}
