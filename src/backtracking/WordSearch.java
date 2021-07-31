/**
 * 
 */
package backtracking;

/**
 * @author PRATAP
 *
 */
public class WordSearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char board[][] = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		String word = "ABCCED";
		WordSearch obj = new WordSearch();
		boolean ans = obj.exist(board, word);
		System.out.println(ans);
	}

	public int[][] adj = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public boolean exist(char[][] board, String word) {
		int m = board.length;
		int n = board[0].length;
		boolean[][] visited = new boolean[m][n];
		boolean flag = false;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == word.charAt(0)) {
					visited[i][j] = true;
					flag = solve(board, i, j, word, "" + board[i][j], visited, 1);
					visited[i][j] = false;
				}
				if (flag)
					break;
			}
			if (flag)
				break;
		}
		return flag;
	}

	private boolean solve(char[][] board, int i, int j, String word, String res, boolean[][] visited, int idx) {
		// TODO Auto-generated method stub
		if (res.length() > word.length())
			return false;
		if (res.length() == word.length()) {
			if (res.equalsIgnoreCase(word))
				return true;
			return false;
		}
		if (idx > word.length())
			return false;
		boolean flag = false;

		for (int k = 0; k < adj.length; k++) {
			int currI = i + adj[k][0];
			int currJ = j + adj[k][1];
			if (currI >= 0 && currI < board.length && currJ >= 0 && currJ < board[0].length && !visited[currI][currJ]
					&& board[currI][currJ] == word.charAt(idx)) {
				visited[currI][currJ] = true;
				flag = solve(board, currI, currJ, word, res + board[currI][currJ], visited, idx + 1);
				visited[currI][currJ] = false;
			}
			if (flag)
				break;
		}
		return flag;
	}
}
