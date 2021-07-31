/**
 * 
 */
package graph;

import java.util.ArrayList;

/**
 * @author PRATAP
 *
 */
public class WordBoggle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String dictionary[] = { "GEEKS", "FOR", "QUIZ", "GO" };
		char[][] board = { { 'G', 'I', 'Z' }, { 'U', 'E', 'K' }, { 'Q', 'S', 'E' } };
//		String dictionary[] = { "CAT" };
//		char[][] board = { { 'C', 'A', 'P' }, { 'A', 'N', 'D' }, { 'T', 'I', 'E' } };
		WordBoggle obj = new WordBoggle();
		String[] ans = obj.wordBoggle(board, dictionary);
		for (String str : ans)
			System.out.println(str);
	}

	public static int[][] adj = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, -1 }, { -1, 1 }, { 1, -1 },
			{ 1, 1 } };

	public String[] wordBoggle(char board[][], String[] dictionary) {
		// Write your code here
		ArrayList<String> list = new ArrayList<String>();
		int m = board.length, n = board[0].length;
		for (int k = 0; k < dictionary.length; k++) {
			String word = dictionary[k];
			boolean flag = false;
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (board[i][j] == word.charAt(0)) {
						boolean[][] visited = new boolean[m][n];
						flag = dfs(board, m, n, word, i, j, 1, visited);
						if (flag)
							list.add(word);
					}
					if (flag)
						break;
				}
				if (flag)
					break;
			}
		}

		String[] ans = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			ans[i] = list.get(i);
		}
		return ans;
	}

	private boolean dfs(char[][] board, int m, int n, String word, int currI, int currJ, int pos, boolean[][] visited) {
		// TODO Auto-generated method stub
		if (pos == word.length())
			return true;
		visited[currI][currJ] = true;
		boolean flag = false;
		for (int i = 0; i < adj.length; i++) {
			int nI = currI + adj[i][0];
			int nJ = currJ + adj[i][1];
			if (nI >= 0 && nI < m && nJ >= 0 && nJ < n && !visited[nI][nJ] && board[nI][nJ] == word.charAt(pos)) {
				flag = dfs(board, m, n, word, nI, nJ, pos + 1, visited);

			}
			if (flag)
				break;
		}
		visited[currI][currJ] = false;
		return flag;
	}
}