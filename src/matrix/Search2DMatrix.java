/**
 * 
 */
package matrix;

import java.util.Arrays;

/**
 * @author PRATAP LeetCode 74
 *
 */
public class Search2DMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
		int target = 0;
		boolean ans = searchMatrix(matrix, target);
		System.out.println(ans);
	}

	public static boolean searchMatrix(int[][] matrix, int target) {
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] > target) {
				continue;
			} else {
				int pos = Arrays.binarySearch(matrix[i], target);
				if (pos >= 0)
					return true;
			}
		}
		return false;
	}

}
