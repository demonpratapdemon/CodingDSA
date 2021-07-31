/**
 * 
 */
package matrix;

import java.util.Arrays;

/**
 * @author PRATAP
 *
 */
public class KthSmallestElementInMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mat[][] = { { 1, 3, 5 }, { 6, 7, 12 }, { 11, 14, 14 } };
		int k = 8;

		int ans = kthSmallest(mat, mat.length, k);
		System.out.println(ans);
	}

	public static int kthSmallest(int[][] mat, int n, int k) {
		// code here.
		if (mat.length <= 0)
			return -1;
		int low = mat[0][0];
		int high = mat[n - 1][n - 1];
		if (k == 1)
			return low;
		while (low < high) {
			Double mid = Math.floor(low + (high - low) / 2);
			Pair pair = count(mat, mid.intValue());
			if (pair.count >= k) {
				high = mid.intValue();
			} else {
				low = mid.intValue() + 1;
			}
		}
		return low;
	}

	public static Pair count(int[][] mat, int target) {
		int count = 0;
		Pair pair = new Pair();
		for (int i = 0; i < mat.length; i++) {
			int pos = Arrays.binarySearch(mat[i], target);
			if (pos < 0) {
				count += Math.abs(pos) - 1;
			} else {
				pair.present = true;
				if (pos < mat.length - 1 && mat[i][pos + 1] == target)
					pos++;
				count += pos + 1;
			}
		}
		pair.count = count;
		return pair;
	}
}

class Pair {
	public int count;
	public boolean present = false;
}
