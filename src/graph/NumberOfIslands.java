/**
 * 
 */
package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author PRATAP
 *
 */
public class NumberOfIslands {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		char[][] grid = { { '0', '1', '1', '1', '0', '0', '0' }, { '0', '0', '1', '1', '0', '1', '0' } };
		char[][] grid = { { '0', '1' }, { '1', '0' }, { '1', '1' }, { '1', '0' } };
		int ans = numIslands(grid);
		System.out.println(ans);
	}

	public static int[][] neighbs = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 },
			{ 1, 1 } };

	public static int numIslands(char[][] grid) {
		// Code here
		int m = grid.length;
		int n = grid[0].length;
		boolean[][] visited = new boolean[m][n];
		int islands = 0;
		boolean flag = false;
		for (int i = 0; i < m; i++) {
			flag = false;
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == '0') {
					visited[i][j] = true;
					flag = false;
					continue;
				}
				if (grid[i][j] == '1' && !visited[i][j]) {
					flag = true;
					Queue<IsPair> q = new LinkedList<IsPair>();
					q.add(new IsPair(i, j));
					visited[i][j] = true;
					while (!q.isEmpty()) {
						IsPair curr = q.poll();
						for (int k = 0; k < neighbs.length; k++) {
							int[] pair = neighbs[k];
							int currI = curr.i + pair[0];
							int currJ = curr.j + pair[1];
							if (currI >= 0 && currI < m && currJ >= 0 && currJ < n && grid[currI][currJ] == '1'
									&& !visited[currI][currJ]) {
								visited[currI][currJ] = true;
								q.add(new IsPair(currI, currJ));
							}
						}
					}
				}
				if (flag) {
					islands++;
					flag = false;
				}
			}
		}
		return islands;
	}
}

class IsPair {
	public int i;
	public int j;

	public IsPair(int i, int j) {
		super();
		this.i = i;
		this.j = j;
	}

}
