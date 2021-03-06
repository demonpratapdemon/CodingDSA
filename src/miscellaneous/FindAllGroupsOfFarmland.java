/**
 * 
 */
package miscellaneous;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author PRATAP LeetCode 1992
 *
 */
public class FindAllGroupsOfFarmland {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] land = { { 1, 0, 0 }, { 0, 1, 1 }, { 0, 1, 1 } };
		FindAllGroupsOfFarmland obj = new FindAllGroupsOfFarmland();
		int[][] ans = obj.findFarmland(land);
		for (int i = 0; i < ans.length; i++) {
			System.out.println(ans[i][0] + " " + ans[i][1] + " " + ans[i][2] + " " + ans[i][3]);
		}
	}

	public int[][] findFarmland(int[][] land) {
		int m = land.length, n = land[0].length;
		boolean[][] visited = new boolean[m][n];
		List<List<Integer>> list = new ArrayList<List<Integer>>();

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (land[i][j] == 1 && !visited[i][j]) {
					bfs(land, visited, i, j, m, n, list);
				}
			}
		}
		int[][] res = new int[list.size()][4];
		for (int i = 0; i < list.size(); i++) {
			res[i][0] = list.get(i).get(0);
			res[i][1] = list.get(i).get(1);
			res[i][2] = list.get(i).get(2);
			res[i][3] = list.get(i).get(3);
		}
		return res;
	}

	static int[][] adj = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	private void bfs(int[][] land, boolean[][] visited, int i, int j, int m, int n, List<List<Integer>> list) {
		// TODO Auto-generated method stub
		Queue<Pos> q = new LinkedList<Pos>();
		q.add(new Pos(i, j));
		visited[i][j] = true;
		Pos curr = null;
		while (!q.isEmpty()) {
			curr = q.poll();
			for (int k = 0; k < adj.length; k++) {
				int currI = curr.i + adj[k][0];
				int currJ = curr.j + adj[k][1];
				if (currI >= 0 && currI < m && currJ >= 0 && currJ < n && !visited[currI][currJ]
						&& land[currI][currJ] == 1) {
					visited[currI][currJ] = true;
					q.add(new Pos(currI, currJ));
				}
			}
		}
		List<Integer> l = new ArrayList<Integer>();
		l.add(i);
		l.add(j);
		l.add(curr.i);
		l.add(curr.j);
		list.add(l);
	}
}

class Pos {
	public int i;
	public int j;

	public Pos(int i, int j) {
		super();
		this.i = i;
		this.j = j;
	}

}
