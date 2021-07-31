/**
 * 
 */
package matrix;

import java.util.ArrayList;

/**
 * @author PRATAP
 *
 */
public class SpiralTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = { { 6, 6, 2, 28, 2 }, { 12, 26, 3, 28, 7 }, { 22, 25, 3, 4, 23 } };
		ArrayList<Integer> ans = spirallyTraverse(matrix, matrix.length, matrix[0].length);
		System.out.println(ans);
	}

	public static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c) {
		// code here
		int row = 0, col = 0;
		ArrayList<Integer> ans = new ArrayList<Integer>();
		while (row < r && col < c) {
			int colFront = col;
			while (colFront < c) {
				ans.add(matrix[row][colFront++]);
			}
			row++;
			int rowDown = row;
			while (rowDown < r) {
				ans.add(matrix[rowDown++][c - 1]);
			}
			c--;
			if (row < r) {
				int colBack = c - 1;
				while (colBack >= col) {
					ans.add(matrix[r - 1][colBack--]);
				}
				r--;
			}
			if (col < c) {
				int rowBack = r - 1;
				while (rowBack >= row) {
					ans.add(matrix[rowBack--][col]);
				}
				col++;
			}
		}
		return ans;
	}

}
