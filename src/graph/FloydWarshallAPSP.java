/**
 * 
 */
package graph;

/**
 * @author PRATAP
 *
 */
public class FloydWarshallAPSP {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = { { 0, 1, 43 }, { 1, 0, 6 }, { -1, -1, 0 } };
		shortest_distance(matrix);
	}

	public static void shortest_distance(int[][] matrix) {
		// Code here
		int n = matrix.length;
		int[][] curr = new int[n][n];

		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int a = matrix[i][j] == -1 ? 999999 : matrix[i][j];
					int b = matrix[i][k] == -1 ? 999999 : matrix[i][k];
					int c = matrix[k][j] == -1 ? 999999 : matrix[k][j];
					curr[i][j] = Math.min(a, b + c);
					if (curr[i][j] == 999999)
						curr[i][j] = -1;
				}
			}
			matrix = curr;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.println(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
