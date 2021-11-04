/**
 * 
 */
package november_leetcode_challenges;

/**
 * @author PRATAP LeetCode 980
 *
 */
public class Day2_UniquePathsIII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = { { 1, 2 } };
		Day2_UniquePathsIII obj = new Day2_UniquePathsIII();
		int ans = obj.uniquePathsIII(grid);
		System.out.println(ans);
	}

	static int[][] adj = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	int ways = 0;

	public int uniquePathsIII(int[][] grid) {
		int m = grid.length, n = grid[0].length;
		boolean[][] visited = new boolean[m][n];
		int countZ = 0;
		int posI = -1, posJ = -1;
		int resI = -1, resJ = -1;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 0)
					countZ++;
				else if (grid[i][j] == 1) {
					posI = i;
					posJ = j;
				} else if (grid[i][j] == 2) {
					resI = i;
					resJ = j;
				}
			}
		}
		visited[posI][posJ] = true;
		for (int k = 0; k < adj.length; k++) {
			int currI = posI + adj[k][0];
			int currJ = posJ + adj[k][1];
			if (currI >= 0 && currI < m && currJ >= 0 && currJ < n
					&& (grid[currI][currJ] == 0 || grid[currI][currJ] == 2)) {
				dfs(grid, currI, currJ, visited, countZ, m, n, resI, resJ);
			}

		}
		return ways;
	}

	private void dfs(int[][] grid, int i, int j, boolean[][] visited, int countZ, int m, int n, int resI, int resJ) {
		// TODO Auto-generated method stub
		if (i == resI && j == resJ && countZ <= 0) {
			ways++;
			return;
		}
		visited[i][j] = true;
		countZ--;
		for (int k = 0; k < adj.length; k++) {
			int currI = i + adj[k][0];
			int currJ = j + adj[k][1];
			if (currI >= 0 && currI < m && currJ >= 0 && currJ < n
					&& (grid[currI][currJ] == 0 || grid[currI][currJ] == 2) && !visited[currI][currJ]) {
				dfs(grid, currI, currJ, visited, countZ, m, n, resI, resJ);
			}
		}
		countZ++;
		visited[i][j] = false;
	}
}
