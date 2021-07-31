/**
 * 
 */
package arrays;

/**
 * @author PRATAP using merge technique
 *
 */
public class CountInversions {

	int inversionCounts = 0;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long[] arr = { 5, 3, 2, 4, 1 };
		System.out.println(inversionCount(arr, arr.length));
	}

	public static long inversionCount(long arr[], long N) {
		// Your Code Here
		long[] temp = new long[arr.length];
		long invCounts = mergeSort(arr, temp, 0, arr.length - 1);
		return invCounts;
	}

	public static long mergeSort(long[] arr, long[] temp, int left, int right) {
		long inversionCounts = 0;
		if (left < right) {
			int mid = (left + right) / 2;
			inversionCounts += mergeSort(arr, temp, left, mid);
			inversionCounts += mergeSort(arr, temp, mid + 1, right);
			inversionCounts += merge(arr, temp, left, mid + 1, right);
		}
		return inversionCounts;
	}

	private static long merge(long[] arr, long[] temp, int left, int mid, int right) {
		// TODO Auto-generated method stub
		int i = left, j = mid;
		long invCounts = 0;
		int k = 0;
		temp = new long[right - left + 1];
		while ((i <= mid - 1) && (j <= right)) {
			if (arr[i] <= arr[j]) {
				temp[k++] = arr[i++];
			} else {
				temp[k++] = arr[j++];
				invCounts += (mid - i);
			}
		}
		while (i <= mid - 1) {
			temp[k++] = arr[i++];
		}
		while (j <= right) {
			temp[k++] = arr[j++];
		}
		i = left;
		k = 0;
		while (i <= right) {
			arr[i] = temp[k++];
			i++;
		}
		return invCounts;
	}

}
