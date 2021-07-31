/**
 * 
 */
package matrix;

import java.util.Arrays;

/**
 * @author PRATAP
 *
 */
public class RowWithMax1s {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = { { 0, 1, 1, 1 }, { 0, 0, 1, 1 }, { 1, 1, 1, 1 }, { 0, 0, 0, 0 } };
		int ans = rowWithMax1s(matrix, matrix.length, matrix[0].length);
		System.out.println(ans);
	}

	public static int rowWithMax1s(int arr[][], int n, int m) {
		// code here
		int row = -1;
		int max1s = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			int pos = Arrays.binarySearch(arr[i], 0);
			if (pos >= 0) {
				if (pos < m - 1 && arr[i][pos + 1] == 0) {
					while (pos < m - 1 && arr[i][pos + 1] == 0) {
						pos++;
					}
				}
				if (m - (pos + 1) > max1s) {
					row = i;
					max1s = m - (pos + 1);
				}
//				max1s = Math.max(max1s, m - (pos + 1));
			} else {
				return i;
			}
		}
		if(max1s == 0)
			return -1;
		return row;
	}

}
