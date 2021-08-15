/**
 * 
 */
package august_leetcode_challenges;

import java.util.ArrayList;

/**
 * @author PRATAP
 *
 */
public class Day13_SetMatrixZeroes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[][] matrix = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
//		int[][] matrix = { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 0, 7, 8 }, { 0, 10, 11, 12 }, { 13, 14, 15, 0 } };
		Day13_SetMatrixZeroes obj = new Day13_SetMatrixZeroes();
		obj.setZeroes(matrix);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public void setZeroes(int[][] matrix) {
		ArrayList<MatLoc> list = new ArrayList<MatLoc>();
		int m = matrix.length, n = matrix[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					list.add(new MatLoc(i, j));
				}
			}
		}
//		System.out.println(list);
		for (MatLoc loc : list) {
			// row
			for (int j = 0; j < n; j++) {
				if (matrix[loc.i][j] != 0) {
					matrix[loc.i][j] = 0;
				} 
			}
			// column
			for (int i = 0; i < m; i++) {
				if (matrix[i][loc.j] != 0) {
					matrix[i][loc.j] = 0;
				} 
			}
		}
	}
}

class MatLoc {
	public int i;
	public int j;

	public MatLoc(int i, int j) {
		super();
		this.i = i;
		this.j = j;
	}

	@Override
	public String toString() {
		return "MatLoc [i=" + i + ", j=" + j + "]";
	}

}
