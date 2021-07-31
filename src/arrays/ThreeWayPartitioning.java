/**
 * 
 */
package arrays;

/**
 * @author PRATAP Dutch Flag Algorithm
 *
 */
public class ThreeWayPartitioning {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 44, 12, 29, 30, 77, 5, 44, 64, 14 };
		threeWayPartition(arr, 39, 45);
	}

	public static void threeWayPartition(int arr[], int a, int b) {
		// code here
		if (a > b)
			return;
		int l = 0, r = arr.length - 1;

		for (int i = 0; i <= r; i++) {
			if (arr[i] < a) {
				int temp = arr[i];
				arr[i] = arr[l];
				arr[l] = temp;
				l++;
			} else if (arr[i] > b) {
				int temp = arr[i];
				arr[i] = arr[r];
				arr[r] = temp;
				r--;
				i--;
			}
		}

		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

}
