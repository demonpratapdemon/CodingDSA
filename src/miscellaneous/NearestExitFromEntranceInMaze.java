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
public class NearestExitFromEntranceInMaze {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		char[][] maze = { { '+', '+', '.', '+' }, { '.', '.', '.', '+' }, { '+', '+', '+', '.' } };
//		int[] entrance = { 1, 2 };
//		char[][] maze = { { '+', '+', '+' }, { '.', '.', '.' }, { '+', '+', '+' } };
//		int[] entrance = { 1, 0 };
		char[][] maze = { { '.', '+' } };
		int[] entrance = { 0, 0 };
		NearestExitFromEntranceInMaze obj = new NearestExitFromEntranceInMaze();
		int ans = obj.nearestExit(maze, entrance);
		System.out.println(ans);
	}

	public int[][] adj = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public int nearestExit(char[][] maze, int[] entrance) {
		Queue<Exit> q = new LinkedList<Exit>();
		q.add(new Exit(entrance[0], entrance[1], 0));
		int m = maze.length, n = maze[0].length;
		boolean[][] visited = new boolean[m][n];
		visited[entrance[0]][entrance[1]] = true;
		int minSteps = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			Exit curr = q.poll();
			for (int k = 0; k < adj.length; k++) {
				int currI = curr.i + adj[k][0];
				int currJ = curr.j + adj[k][1];
				if ((currI == 0 || currI == m - 1 || currJ == 0 || currJ == n - 1)
						&& (currI != entrance[0] || currJ != entrance[1])
						&& (currI >= 0 && currI < m && currJ >= 0 && currJ < n && maze[currI][currJ] != '+')) {
					minSteps = Math.min(minSteps, curr.steps + 1);
					visited[currI][currJ] = true;
				} else {
					if (currI >= 0 && currI < m && currJ >= 0 && currJ < n && !visited[currI][currJ]
							&& maze[currI][currJ] == '.') {
						visited[currI][currJ] = true;
						q.add(new Exit(currI, currJ, curr.steps + 1));
					}
				}
			}
		}
		if (minSteps == Integer.MAX_VALUE)
			return -1;
		return minSteps;
	}
}

class Exit {
	public int i;
	public int j;
	public int steps;

	public Exit(int i, int j, int steps) {
		super();
		this.i = i;
		this.j = j;
		this.steps = steps;
	}

}