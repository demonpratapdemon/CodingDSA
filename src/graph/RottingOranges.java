/**
 * 
 */
package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author PRATAP LeetCode 994
 *
 */
public class RottingOranges {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = { { 2, 2, 0, 1 } };
		int time = orangesRotting(grid);
		System.out.println(time);
	}

	public static int[][] adj = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static int orangesRotting(int[][] grid) {
		Queue<Rotten> q = new LinkedList<Rotten>();
		int m = grid.length;
		int n = grid[0].length;
		int fresh = 0;
		boolean[][] visited = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 2) {
					q.add(new Rotten(i, j));
					visited[i][j] = true;
				} else if (grid[i][j] == 1)
					fresh++;
			}
		}
		int time = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			boolean flag = false;
			while (size-- > 0) {
				Rotten curr = q.poll();
				for (int i = 0; i < adj.length; i++) {
					int currI = curr.i + adj[i][0];
					int currJ = curr.j + adj[i][1];
					if (currI >= 0 && currI < m && currJ >= 0 && currJ < n && grid[currI][currJ] == 1
							&& !visited[currI][currJ]) {
						visited[currI][currJ] = true;
						flag = true;
						q.add(new Rotten(currI, currJ));
						fresh--;
					}
				}
			}
			if (flag)
				time++;
			if (fresh <= 0)
				break;
		}
		if (fresh > 0)
			return -1;
		return time;
	}

}

class Rotten {
	public int i;
	public int j;

	public Rotten(int i, int j) {
		super();
		this.i = i;
		this.j = j;
	}

}
