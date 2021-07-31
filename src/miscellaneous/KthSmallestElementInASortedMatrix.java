/**
 * 
 */
package miscellaneous;

/**
 * @author PRATAP
 *
 */
public class KthSmallestElementInASortedMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } };
//		int[][] matrix = { { 1, 2 }, { 3, 3 } };
//		int[][] matrix = { { 3, 8, 8 }, { 3, 8, 8 }, { 3, 9, 13 } };
		int k = 8;
		int ans = kthSmallest(matrix, k);
		System.out.println(ans);
	}

	public static int kthSmallest(int[][] matrix, int k) {
		int m = matrix.length, n = matrix[0].length;
		int[] arr = new int[m * n];
		int p = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				arr[p++] = matrix[i][j];
			}
		}
		int ans = findKth(arr, k - 1, 0, arr.length - 1);
		return ans;
	}

	public static int findKth(int[] nums, int k, int lo, int hi) {
		int pivot = nums[hi];
		int pi = partition(nums, lo, hi, pivot);
		if (pi > k)
			return findKth(nums, k, lo, pi - 1);
		else if (pi < k)
			return findKth(nums, k, pi + 1, hi);
		else
			return pivot;
	}

	public static int partition(int[] nums, int lo, int hi, int pivot) {
		int j = lo, i = lo;
		while (i < hi) {
			if (nums[i] <= pivot) {
				swap(nums, i, j);
				j++;
			}
			i++;
		}
		swap(nums, i, j);
		return j;
	}

	public static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

}
