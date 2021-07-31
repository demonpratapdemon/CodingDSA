/**
 * 
 */
package miscellaneous;

/**
 * @author PRATAP LeetCode 1574
 *
 */
public class ShortestSubarrayToBeRemovedToMakeArraySorted {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 3, 2, 1 };
		int small = findLengthOfShortestSubarray(arr);
		System.out.println(small);
	}

	public static int findLengthOfShortestSubarray(int[] arr) {
		int n = arr.length;
		if (n == 1)
			return 0;
		int s = 0;
		while (s < n - 1 && arr[s] <= arr[s + 1])
			s++;
		if (s == n - 1)
			return 0;
		int e = n - 1;
		while (e > s && arr[e] >= arr[e - 1])
			e--;
		int res = Math.min(n - s - 1, e);
		int i = 0, j = e;
		while (i <= s && j < n) {
			if (arr[i] <= arr[j]) {
				res = Math.min(res, j - i - 1);
				i++;
			} else {
				j++;
			}
		}
		return res;
	}
}
