/**
 * 
 */
package miscellaneous;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author PRATAP
 *
 */
public class Matrix01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] mat = { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };
//		int[][] mat = { { 0, 1, 0 }, { 0, 1, 0 }, { 0, 1, 0 }, { 0, 1, 0 } };
		Matrix01 obj = new Matrix01();
		int[][] ans = obj.updateMatrix(mat);
		for (int i = 0; i < ans.length; i++) {
			for (int j = 0; j < ans[0].length; j++)
				System.out.print(ans[i][j] + " ");
			System.out.println();
		}
	}

	public static int[][] adj = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public int[][] updateMatrix(int[][] mat) {
		int m = mat.length, n = mat[0].length;
		int[][] dp = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (mat[i][j] != 0) {
					int step = bfs(mat, i, j, dp, m, n);
					dp[i][j] = step;
				}
			}
		}
		return dp;
	}

	private int bfs(int[][] mat, int i, int j, int[][] dp, int m, int n) {
		// TODO Auto-generated method stub
		Queue<PairMat> q = new LinkedList<PairMat>();
		q.add(new PairMat(i, j, 0));
		boolean[][] visited = new boolean[m][n];
		visited[i][j] = true;
		while (!q.isEmpty()) {
			PairMat curr = q.poll();
			for (int k = 0; k < adj.length; k++) {
				int currI = curr.i + adj[k][0];
				int currJ = curr.j + adj[k][1];
				if (currI >= 0 && currI < m && currJ >= 0 && currJ < n && mat[currI][currJ] == 0) {
					return curr.step + 1;
				}
				if (currI >= 0 && currI < m && currJ >= 0 && currJ < n && mat[currI][currJ] != 0
						&& !visited[currI][currJ]) {
					visited[currI][currJ] = true;
					q.add(new PairMat(currI, currJ, curr.step + 1));
				}
			}
		}
		return 0;
	}
}

class PairMat {
	public int i;
	public int j;
	public int step;

	public PairMat(int i, int j, int step) {
		super();
		this.i = i;
		this.j = j;
		this.step = step;
	}

}