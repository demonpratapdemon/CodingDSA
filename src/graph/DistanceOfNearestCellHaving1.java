/**
 * 
 */
package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author PRATAP
 *
 */
public class DistanceOfNearestCellHaving1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = { { 1, 0, 1 }, { 1, 1, 0 }, { 1, 0, 0 } };
		int[][] ans = nearest(grid);
		for (int i = 0; i < ans.length; i++) {
			for (int j = 0; j < ans[0].length; j++) {
				System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static int[][] adj = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static int[][] nearest(int[][] grid) {
		// Code here
		int m = grid.length, n = grid[0].length;
		int[][] ans = new int[m][n];
		Queue<DistNode> q = new LinkedList<DistNode>();
		for (int i = 0; i < m; i++) {
			Arrays.fill(ans[i], Integer.MAX_VALUE);
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					ans[i][j] = 0;
					q.add(new DistNode(i, j, 0));
				}
			}
		}
		while (!q.isEmpty()) {
			DistNode curr = q.poll();
			for (int i = 0; i < adj.length; i++) {
				int currI = curr.i + adj[i][0];
				int currJ = curr.j + adj[i][1];
				if (currI >= 0 && currI < m && currJ >= 0 && currJ < n
						&& (grid[currI][currJ] == 0 && curr.dist + 1 < ans[currI][currJ])) {
					ans[currI][currJ] = curr.dist + 1;
					q.add(new DistNode(currI, currJ, curr.dist + 1));
				}
			}
		}
		return ans;
	}
}

class DistNode {
	public int i;
	public int j;
	public int dist;

	public DistNode(int i, int j, int dist) {
		super();
		this.i = i;
		this.j = j;
		this.dist = dist;
	}

}
