/**
 * 
 */
package october_leetcode_challenge;

/**
 * @author PRATAP LeetCode 463
 *
 */
public class Day4_IslandPerimeter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } };
		Day4_IslandPerimeter obj = new Day4_IslandPerimeter();
		int ans = obj.islandPerimeter(grid);
		System.out.println(ans);
	}

	int perimeter = 0;
	static int[][] adj = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public int islandPerimeter(int[][] grid) {
		int m = grid.length, n = grid[0].length;
		boolean flag = false;
		boolean[][] vis = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					vis[i][j] = true;
					findPeri(grid, i, j, m, n, vis);
					flag = true;
					break;
				}
			}
			if (flag)
				break;
		}
		return perimeter;
	}

	private void findPeri(int[][] grid, int i, int j, int m, int n, boolean[][] vis) {
		// TODO Auto-generated method stub
		for (int k = 0; k < adj.length; k++) {
			int currI = i + adj[k][0];
			int currJ = j + adj[k][1];
			if (currI < 0 || currI >= m || currJ < 0 || currJ >= n)
				perimeter++;
			else if (currI >= 0 && currI < m && currJ >= 0 && currJ < n && grid[currI][currJ] == 0)
				perimeter++;
		}

		for (int k = 0; k < adj.length; k++) {
			int currI = i + adj[k][0];
			int currJ = j + adj[k][1];
			if (currI >= 0 && currI < m && currJ >= 0 && currJ < n && grid[currI][currJ] == 1 && !vis[currI][currJ]) {
				vis[currI][currJ] = true;
				findPeri(grid, currI, currJ, m, n, vis);
			}
		}
	}
}
