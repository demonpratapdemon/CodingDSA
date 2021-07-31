/**
 * 
 */
package strings;

import java.util.ArrayList;

/**
 * @author PRATAP
 *
 */
public class StringInGrid {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		char[][] grid = { { 'a', 'b', 'a', 'b' }, { 'a', 'b', 'e', 'b' }, { 'e', 'b', 'e', 'b' } };
//		String word = "abe";
//		char[][] grid = { { 'a', 'c' }, { 'c', 'e' }, { 'd', 'a' }, { 'c', 'd' }, { 'e', 'e' }, { 'a', 'a' },
//				{ 'b', 'b' }, { 'd', 'a' }, { 'b', 'c' } };
//		String word = "dcb";
		char[][] grid = { { 'b', 'b', 'd', 'd', 'e', 'd', 'b', 'd', 'd' },
				{ 'b', 'c', 'b', 'c', 'e', 'c', 'a', 'd', 'c' }, { 'a', 'e', 'b', 'e', 'd', 'b', 'e', 'e', 'd' },
				{ 'd', 'c', 'd', 'e', 'c', 'b', 'b', 'b', 'e' }, { 'b', 'c', 'a', 'e', 'c', 'c', 'd', 'a', 'a' },
				{ 'a', 'a', 'c', 'b', 'a', 'c', 'a', 'c', 'a' }, { 'a', 'c', 'b', 'd', 'b', 'd', 'b', 'e', 'c' } };
		String word = "dcb";
		int[][] output = searchWord(grid, word);
		for (int i = 0; i < output.length; i++) {
			System.out.println(output[i][0] + " " + output[i][1]);
		}
	}

	public static int[][] neighbs = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 }, { -1, -1 }, { -1, 1 }, { 1, -1 },
			{ 1, 1 } };
	public static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

	public static int[][] searchWord(char[][] grid, String word) {
		// Code here
		if (list.size() > 0)
			list.clear();
		int m = grid.length;
		int n = grid[0].length;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == word.charAt(0)) {
					boolean[] visited = new boolean[neighbs.length];
					dfs(grid, word, i, j, i, j, visited, 1, m, n, 0);
				}
			}
		}
		if (list.size() == 0)
			return new int[0][0];
		int[][] ans = new int[list.size()][2];
		int p = 0;
		for (ArrayList<Integer> l : list) {
			ans[p][0] = l.get(0);
			ans[p][1] = l.get(1);
			p++;
		}
		return ans;
	}

	private static void dfs(char[][] grid, String word, int startI, int startJ, int currI, int currJ, boolean[] visited,
			int nextId, int row, int col, int k) {
		// TODO Auto-generated method stub
		if (nextId == word.length()) {
			ArrayList<Integer> newList = new ArrayList<Integer>();
			if (list.size() > 0
					&& (list.get(list.size() - 1).get(0) != startI || list.get(list.size() - 1).get(1) != startJ)) {
				newList.add(startI);
				newList.add(startJ);
				list.add(newList);
			} else if (list.size() == 0) {
				newList.add(startI);
				newList.add(startJ);
				list.add(newList);
			}

			return;
		}
		if (visited[k]) {
			int i = currI + neighbs[k][0];
			int j = currJ + neighbs[k][1];
			if (i >= 0 && i < row && j >= 0 && j < col && grid[i][j] == word.charAt(nextId)) {
				dfs(grid, word, startI, startJ, i, j, visited, nextId + 1, row, col, k);
			}
		} else {
			for (int l = 0; l < neighbs.length; l++) {
				int i = currI + neighbs[l][0];
				int j = currJ + neighbs[l][1];
				if (i >= 0 && i < row && j >= 0 && j < col && grid[i][j] == word.charAt(nextId)) {
					visited[l] = true;
					dfs(grid, word, startI, startJ, i, j, visited, nextId + 1, row, col, l);
					visited[l] = false;
				}
			}
		}

	}

}