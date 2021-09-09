/**
 * 
 */
package miscellaneous;

import java.util.Arrays;

/**
 * @author PRATAP LeetCode 764
 *
 */
public class LargestPlusSign {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int orderOfLargestPlusSign(int n, int[][] mines) {
		int[][] grid = buildGrid(n, mines);
		int[][] a = new int[n][n];
		int[][] b = new int[n][n];
		int[][] c = new int[n][n];
		int[][] d = new int[n][n];
		for (int i = 0; i < n; i++) {
			int curr = 0;
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 0)
					curr = 0;
				else
					curr += grid[i][j];
				a[i][j] = curr;
			}
		}
		for (int i = 0; i < n; i++) {
			int curr = 0;
			for (int j = n - 1; j >= 0; j--) {
				if (grid[i][j] == 0)
					curr = 0;
				else
					curr += grid[i][j];
				b[i][j] = curr;
			}
		}
		for (int j = 0; j < n; j++) {
			int curr = 0;
			for (int i = 0; i < n; i++) {
				if (grid[i][j] == 0)
					curr = 0;
				else
					curr += grid[i][j];
				c[i][j] = curr;
			}
		}
		for (int j = 0; j < n; j++) {
			int curr = 0;
			for (int i = n - 1; i >= 0; i--) {
				if (grid[i][j] == 0)
					curr = 0;
				else
					curr += grid[i][j];
				d[i][j] = curr;
			}
		}
		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int min = Math.min(Math.min(a[i][j], b[i][j]), Math.min(c[i][j], d[i][j]));
				ans = Math.max(ans, min);
			}
		}
		return ans;
	}

	private int[][] buildGrid(int n, int[][] mines) {
		// TODO Auto-generated method stub
		int[][] grid = new int[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(grid[i], 1);
		}
		for (int[] mine : mines) {
			grid[mine[0]][mine[1]] = 0;
		}
		return grid;
	}
}
