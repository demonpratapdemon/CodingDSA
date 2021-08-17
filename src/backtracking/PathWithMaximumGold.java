/**
 * 
 */
package backtracking;

/**
 * @author PRATAP LeetCode 1219
 *
 */
public class PathWithMaximumGold {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = { { 0, 6, 0 }, { 5, 8, 7 }, { 0, 9, 0 } };
		PathWithMaximumGold obj = new PathWithMaximumGold();
		int ans = obj.getMaximumGold(grid);
		System.out.println(ans);
	}

	public static int[][] adj = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	public int max1 = 0;

	public int getMaximumGold(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int max = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] != 0) {
					boolean[][] visited = new boolean[m][n];
					max1 = 0;
					dfs(grid, i, j, visited, grid[i][j], m, n);
					max = Math.max(max, max1);
				}
			}
		}
		return max;
	}

	private void dfs(int[][] grid, int i, int j, boolean[][] visited, int sum, int m, int n) {
		// TODO Auto-generated method stub
		max1 = Math.max(max1, sum);
		visited[i][j] = true;
		for (int k = 0; k < adj.length; k++) {
			int currI = i + adj[k][0];
			int currJ = j + adj[k][1];
			if (currI >= 0 && currI < m && currJ >= 0 && currJ < n && !visited[currI][currJ]
					&& grid[currI][currJ] != 0) {
				dfs(grid, currI, currJ, visited, sum + grid[currI][currJ], m, n);
			}
		}
		visited[i][j] = false;
	}
}
