/**
 * 
 */
package november_leetcode_challenges;

/**
 * @author PRATAP LeetCode 130
 *
 */
public class Day1_SurroundedRegions {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' },
				{ 'X', 'O', 'X', 'X' } };
		Day1_SurroundedRegions obj = new Day1_SurroundedRegions();
		obj.solve(board);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static int[][] adj = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public void solve(char[][] board) {
		int m = board.length, n = board[0].length;
		for (int i = 0; i < m; i++) {
			if (board[i][0] == 'O')
				dfs(board, i, 0, m, n);
			if (board[i][n - 1] == 'O')
				dfs(board, i, n - 1, m, n);
		}
		for (int j = 1; j < n - 1; j++) {
			if (board[0][j] == 'O')
				dfs(board, 0, j, m, n);
			if (board[m - 1][j] == 'O')
				dfs(board, m - 1, j, m, n);
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'O')
					board[i][j] = 'X';
				else if (board[i][j] == '1')
					board[i][j] = 'O';
			}
		}
	}

	public void dfs(char[][] board, int i, int j, int m, int n) {
		if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] == 'X' || board[i][j] == '1')
			return;
		board[i][j] = '1';
		for (int k = 0; k < adj.length; k++) {
			int currI = i + adj[k][0];
			int currJ = j + adj[k][1];
			dfs(board, currI, currJ, m, n);
		}
	}
}
