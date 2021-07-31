/**
 * 
 */
package search_sort;

/**
 * @author PRATAP
 *
 */
public class AllocateMinimumNumberOfPages {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = { 12, 34, 67, 90 };
		int n = A.length;
		int m = 2;
		int ans = findPages(A, n, m);
		System.out.println(ans);
	}

	public static int findPages(int[] arr, int n, int m) {
		// Your code here
		int sum = 0;
		for (int i : arr)
			sum += i;
		int low = 0, high = sum;
		int ans = 0;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (solve(arr, m, mid)) {
				ans = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return ans;
	}

	private static boolean solve(int[] arr, int m, int mid) {
		// TODO Auto-generated method stub
		int curr = 0;
		int stud = 1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > mid && stud < m)
				return false;
			if (curr + arr[i] <= mid) {
				curr += arr[i];
			} else {
				stud++;
				curr = 0;
				curr += arr[i];
			}
			if (stud > m)
				return false;
		}
		return true;
	}
}
