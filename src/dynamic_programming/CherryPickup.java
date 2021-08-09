/**
 * 
 */
package dynamic_programming;

/**
 * @author PRATAP LeetCode 741
 *
 */
public class CherryPickup {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][]  grid = {{0,1,-1},{1,0,-1},{1,1,1}};
		CherryPickup obj = new CherryPickup();
		int ans = obj.cherryPickup(grid);
		System.out.println(ans);
	}

	public int cherryPickup(int[][] grid) {
		int n = grid.length;
		int[][][] dp = new int[n][n][n];
		int ans = solve(0, 0, 0, grid, dp);
		if (ans <= 0)
            return 0;
		return ans;
	}

//	r1 + c1 = r2 + c2
	private int solve(int r1, int c1, int r2, int[][] grid, int[][][] dp) {
		// TODO Auto-generated method stub
		int c2 = r1 + c1 - r2;
		if (r1 >= grid.length || r2 == grid.length || c1 >= grid[0].length || c2 >= grid[0].length || grid[r1][c1] == -1
				|| grid[r2][c2] == -1) {
			return Integer.MIN_VALUE;
		}

		// both have reached destination
		if (r1 == grid.length - 1 && c1 == grid[0].length - 1) {
			return grid[r1][c1];
		}

		if (dp[r1][c1][r2] != 0)
			return dp[r1][c1][r2];
		int cherries = 0;
		if (r1 == r2 && c1 == c2) {
			cherries = grid[r1][c1];
		} else {
			cherries = grid[r1][c1] + grid[r2][c2];
		}

		int f1 = solve(r1, c1 + 1, r2, grid, dp); // h, h
		int f2 = solve(r1, c1 + 1, r2 + 1, grid, dp); // h, v
		int f3 = solve(r1 + 1, c1, r2, grid, dp); // v, h
		int f4 = solve(r1 + 1, c1, r2 + 1, grid, dp); // v, v

		cherries += Math.max(Math.max(f1, f2), Math.max(f3, f4));
		dp[r1][c1][r2] = cherries;
		return cherries;
	}
}
