/**
 * 
 */
package miscellaneous;

/**
 * @author PRATAP
 *
 */
public class PaintingAGridWithThreeDifferentColors {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m = 5, n = 7;
		PaintingAGridWithThreeDifferentColors obj = new PaintingAGridWithThreeDifferentColors();
		int ans = obj.colorTheGrid(m, n);
		System.out.println(ans);
	}

	public int[][] adj = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	public int count = 0;
	public int mod = (int) (1e9 + 7);

	public int colorTheGrid(int m, int n) {
		int[][] grid = new int[m][n];
		solve(grid, m, n, 0, 0, 0);
		return count % mod;
	}

	private void solve(int[][] grid, int m, int n, int i, int j, int colored) {
		// TODO Auto-generated method stub
		if (colored == m * n) {
			count++;
			count %= mod;
			return;
		}
		if (i >= m && j >= n)
			return;
		if (j == n) {
			i++;
			j = 0;
		}
		if (i >= m)
			return;

		for (int k = 1; k <= 3; k++) {
			grid[i][j] = k;
			if (check(grid, i, j)) {
				solve(grid, m, n, i, j + 1, colored + 1);
			}
			grid[i][j] = 0;
		}
	}

	private boolean check(int[][] grid, int i, int j) {
		// TODO Auto-generated method stub
		int color = grid[i][j];
		int m = grid.length, n = grid[0].length;
		for (int k = 0; k < adj.length; k++) {
			int currI = i + adj[k][0];
			int currJ = j + adj[k][1];
			if (currI >= 0 && currI < m && currJ >= 0 && currJ < n && grid[currI][currJ] == color
					&& grid[currI][currJ] != 0)
				return false;
		}
		return true;
	}
}
