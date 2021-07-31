/**
 * 
 */
package matrix;

/**
 * @author PRATAP Transpose + Row-wise Reverse
 *
 */
public class RotateImage {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		rotate(matrix);
	}

	public static void rotate(int[][] matrix) {
		int m = matrix.length;
		transpose(matrix, m);
		for (int i = 0; i < m; i++) {
			int l = 0, r = m - 1;
			while (l <= r) {
				int temp = matrix[i][l];
				matrix[i][l] = matrix[i][r];
				matrix[i][r] = temp;
				l++;
				r--;
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void transpose(int[][] matrix, int m) {
		// TODO Auto-generated method stub
		for (int i = 0; i < m; i++) {
			for (int j = 0; j <= i && j < m; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
	}

}
