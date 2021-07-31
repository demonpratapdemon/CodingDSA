/**
 * 
 */
package miscellaneous;

/**
 * @author PRATAP LeetCode 566
 *
 */
public class ReshapeTheMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] mat = { { 1, 2 }, { 3, 4 } };
		int r = 4, c = 1;
		int[][] ans = matrixReshape(mat, r, c);
		System.out.println(ans);
	}

	public static int[][] matrixReshape(int[][] mat, int r, int c) {
		int m = mat.length;
		int n = mat[0].length;
		if (r * c > m * n || r * c < m * n) {
			return mat;
		}
		int i = 0, j = 0;
		int[][] newMat = new int[r][c];
		for (int x = 0; x < r; x++) {
			for (int y = 0; y < c; y++) {
				if (j == n) {
					i++;
					j = 0;
					newMat[x][y] = mat[i][j++];
				} else {
					newMat[x][y] = mat[i][j++];
				}
			}
		}
		return newMat;
	}
}
