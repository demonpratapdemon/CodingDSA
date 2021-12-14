/**
 * 
 */
package miscellaneous;

/**
 * @author PRATAP LeetCode 867
 *
 */
public class TransposeMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 } };
		int[][] newMat = transpose(matrix);
		for (int i = 0; i < newMat.length; i++) {
			for (int j = 0; j < newMat[0].length; j++) {
				System.out.print(newMat[i][j] + "   ");
			}
			System.out.println();
		}
	}

	public static int[][] transpose(int[][] matrix) {
		int m = matrix.length, n = matrix[0].length;
		int newMat[][] = new int[n][m];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				newMat[j][i] = matrix[i][j];
			}
		}
		return newMat;
	}

}
