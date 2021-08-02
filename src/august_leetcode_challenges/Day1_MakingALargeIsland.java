/**
 * 
 */
package august_leetcode_challenges;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;

/**
 * @author PRATAP LeetCode 827
 *
 */
public class Day1_MakingALargeIsland {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[][] grid = { { 1, 1 }, { 1, 0 } };
		int[][] grid = { { 0, 1, 0, 0 }, { 0, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 0, 1, 0 } };
		Day1_MakingALargeIsland obj = new Day1_MakingALargeIsland();
		int ans = obj.largestIsland(grid);
		System.out.println(ans);
		char a = 120, b = 140;
		int i;
		System.out.println(a + "  " + b);
		i = a + b;
		System.out.println(i);
	}

	public static int[][] adj = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public int largestIsland(int[][] grid) {
		int size = 0;
		int m = grid.length, n = grid[0].length;
		boolean[][] visited = new boolean[m][n];
		int[][] dp = new int[m][n];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int id = 1;
		boolean flag = false;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1 && !visited[i][j]) {
					int s = bfs(grid, i, j, m, n, visited, dp, id);
					map.put(id, s);
					id++;
				} else if (grid[i][j] == 0) {
					flag = true;
				}
			}
		}
		if (!flag) {
			return m * n;
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (dp[i][j] == 0) {
					int s = 0;
					TreeSet<Integer> set = new TreeSet<Integer>();
					for (int k = 0; k < adj.length; k++) {
						int currI = i + adj[k][0];
						int currJ = j + adj[k][1];
						if (currI >= 0 && currI < m && currJ >= 0 && currJ < n && dp[currI][currJ] != 0
								&& !set.contains(dp[currI][currJ])) {
							set.add(dp[currI][currJ]);
							s += map.get(dp[currI][currJ]);
						}

					}

					size = Math.max(size, s + 1);
				}
			}
		}
		return size;
	}

	private int bfs(int[][] grid, int i, int j, int m, int n, boolean[][] visited, int[][] dp, int id) {
		// TODO Auto-generated method stub
		int id1 = id;
		Queue<Loc> q = new LinkedList<Loc>();
		q.add(new Loc(i, j));
		int size = 1;
		visited[i][j] = true;
		dp[i][j] = id1;
		while (!q.isEmpty()) {
			Loc curr = q.poll();
			for (int k = 0; k < adj.length; k++) {
				int currI = curr.i + adj[k][0];
				int currJ = curr.j + adj[k][1];
				if (currI >= 0 && currI < m && currJ >= 0 && currJ < n && !visited[currI][currJ]
						&& grid[currI][currJ] == 1) {
					visited[currI][currJ] = true;
					size++;
					q.add(new Loc(currI, currJ));
					dp[currI][currJ] = id1;
				}
			}
		}
		return size;
	}

}

class Loc {
	public int i;
	public int j;

	public Loc(int i, int j) {
		super();
		this.i = i;
		this.j = j;
	}

}
