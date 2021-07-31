/**
 * 
 */
package arrays;

/**
 * @author PRATAP Quick Select Algorithm
 *
 */
public class KthSmallest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 7, 10, 4, 3, 20, 15 };
		int k = 1;
		int ans = kthSmallest(arr, 0, arr.length - 1, k);
		System.out.println(ans);
	}

	public static int kthSmallest(int[] arr, int l, int r, int k) {
		// Your code here
		if (l <= r) {
			int partition = partition(arr, l, r);
			if (partition + 1 == k)
				return arr[partition];
			else if (partition + 1 > k) {
				return kthSmallest(arr, l, partition - 1, k);
			} else {
				return kthSmallest(arr, partition + 1, r, k);
			}
		}
		return 0;
	}

	private static int partition(int[] arr, int l, int r) {
		// TODO Auto-generated method stub
		int pivot = arr[r];
		int i = l - 1, j = l;
		while (j < r) {
			if (arr[j] < pivot) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
			j++;
		}
		i++;
		int temp = arr[i];
		arr[i] = pivot;
		arr[r] = temp;
		return i;
	}

}
