/**
 * 
 */
package dynamic_programming;

/**
 * @author PRATAP LeetCode 1277
 *
 */
public class CountSquareSubmatricesWithAllOnes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = { { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 1, 1, 1 } };
		CountSquareSubmatricesWithAllOnes obj = new CountSquareSubmatricesWithAllOnes();
		int ans = obj.countSquares(matrix);
		System.out.println(ans);
	}

	public int countSquares(int[][] matrix) {
		int m = matrix.length, n = matrix[0].length;
		int count = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0)
					continue;
				if (i == 0 || j == 0) {
					matrix[i][j] = 1;
				} else {
					int up = matrix[i - 1][j], left = matrix[i][j - 1], ld = matrix[i - 1][j - 1];
					if (up > 0 && left > 0 && ld > 0) {
						matrix[i][j] = Math.min(Math.min(up, left), ld) + 1;
					} else {
						matrix[i][j] = 1;
					}
				}
				count += matrix[i][j];
			}
		}
		return count;
	}
}
