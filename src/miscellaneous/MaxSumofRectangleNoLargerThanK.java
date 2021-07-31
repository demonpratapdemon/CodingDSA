/**
 * 
 */
package miscellaneous;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * @author PRATAP
 *
 */
public class MaxSumofRectangleNoLargerThanK {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int matrix[][] = { { 2, 4, -2 } }, k = 3;
		int ans = maxSumSubmatrix(matrix, k);
		System.out.println(ans);
	}

	public static int maxSumSubmatrix(int[][] matrix, int k) {
		int ans = Integer.MIN_VALUE;
		int m = matrix.length;
		int n = matrix[0].length;
		int[] arr = new int[m];
		int right;
		boolean flag = false;
		for (int j = 0; j < n; j++) {
			right = j;
			Arrays.fill(arr, 0);
			while (right < n) {
				for (int i = 0; i < m; i++) {
					arr[i] += matrix[i][right];
				}
				ans = Math.max(ans,find(arr, k));
				if (ans == k) {
					flag = true;
					break;
				}
				right++;
			}
			if (flag)
				break;
		}

		return ans;
	}

	public static int find(int[] arr, int k) {
		int ans = Integer.MIN_VALUE;
		TreeSet<Integer> set = new TreeSet<Integer>();
		set.add(0);
		int pref = 0;
		for (int i = 0; i < arr.length; i++) {
			pref += arr[i];
			Integer tar = set.ceiling(pref - k);
			if (tar != null) {
				ans = Math.max(ans, pref - tar);
			}
			set.add(pref);
		}
		return ans;
	}

}
