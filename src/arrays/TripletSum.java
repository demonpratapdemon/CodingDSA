/**
 * 
 */
package arrays;

import java.util.Arrays;

/**
 * @author PRATAP
 *
 */
public class TripletSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 23, 42, 113, 130, 217, 230, 272, 338, 358, 358, 362, 424, 527, 557, 560, 566, 586, 618, 627, 697,
				718, 870, 897, 933 };
		String ans = find3Numbers(arr, arr.length, 985) ? "1" : "0";
		System.out.println(ans);
	}

	public static boolean find3Numbers(int arr[], int n, int X) {
		// Your code Here
		Arrays.sort(arr);
		for (int i = 0; i < n - 2; i++) {
			int l = i + 1, r = n - 1;
			while (l < r) {
				int sum = arr[i] + arr[l] + arr[r];
				if (sum == X)
					return true;
				else if (sum < X)
					l++;
				else
					r--;
			}
		}
		return false;
	}

}
