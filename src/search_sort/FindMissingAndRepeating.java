/**
 * 
 */
package search_sort;

/**
 * @author PRATAP
 *
 */
public class FindMissingAndRepeating {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 21, 12, 20, 17, 15, 36, 22, 6, 29, 3, 4, 34, 5, 1, 23, 32, 14, 31, 25, 18, 19, 39, 19, 13, 8, 9,
				7, 37, 11, 27, 33, 24, 2, 26, 35, 38, 10, 16, 28 };
		int[] ans = findTwoElement(arr, arr.length);
		for (int i : ans)
			System.out.print(i + " ");
	}

	public static int[] findTwoElement(int arr[], int n) {
		// code here
		int[] ans = new int[2];
        int i;
        for (i = 0; i < n; i++) {
            int abs_val = Math.abs(arr[i]);
            if (arr[abs_val - 1] > 0)
                arr[abs_val - 1] = -arr[abs_val - 1];
            else
                ans[0] = abs_val;
        }
        for (i = 0; i < n; i++) {
            if (arr[i] > 0) ans[1] = i + 1;
        }
        return ans;
	}

}
