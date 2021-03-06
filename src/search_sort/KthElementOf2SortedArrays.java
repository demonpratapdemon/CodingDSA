/**
 * 
 */
package search_sort;

/**
 * @author PRATAP
 *
 */
public class KthElementOf2SortedArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr1[] = { 2, 3, 6, 7, 9 };
		int arr2[] = { 1, 4, 8, 10 };
		int k = 5;
		long ans = kthElement(arr1, arr2, arr1.length, arr2.length, k);
		System.out.println(ans);
	}

	public static long kthElement(int arr1[], int arr2[], int n, int m, int k) {
		if (arr1.length > arr2.length) {
			return kthElement(arr2, arr1, m, n, k);
		}
		int low = Math.max(0, k - m);
		int high = Math.min(n, k);
		long kth = 0;
		while (low <= high) {
			int cut1 = low + (high - low) / 2;
			int cut2 = k - cut1;

			int l1 = (cut1 == 0) ? Integer.MIN_VALUE : arr1[cut1 - 1];
			int l2 = (cut2 == 0) ? Integer.MIN_VALUE : arr2[cut2 - 1];
			int r1 = (cut1 == n) ? Integer.MAX_VALUE : arr1[cut1];
			int r2 = (cut2 == m) ? Integer.MAX_VALUE : arr2[cut2];

			if (l1 > r2) {
				high = cut1 - 1;
			} else if (l2 > r1) {
				low = cut1 + 1;
			} else {
				kth = Math.max(l1, l2);
				return kth;
			}
		}
		return kth;
	}

}
