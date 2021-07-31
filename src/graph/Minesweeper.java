/**
 * 
 */
package graph;

/**
 * @author PRATAP LeetCode 529
 *
 */
public class Minesweeper {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = { { 'E', 'E', 'E', 'E', 'E' }, { 'E', 'E', 'M', 'E', 'E' }, { 'E', 'E', 'E', 'E', 'E' },
				{ 'E', 'E', 'E', 'E', 'E' } };
		int[] click = { 1, 2 };
		char[][] finalBoard = updateBoard(board, click);
		for (int i = 0; i < finalBoard.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + "	");
			}
			System.out.println("\n");
		}
	}

	public static int[][] adj = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 },
			{ 1, 1 } };

	public static char[][] updateBoard(char[][] board, int[] click) {
		int row = click[0], col = click[1];
		int m = board.length, n = board[0].length;
		if (board[row][col] == 'M') {
			board[row][col] = 'X';
			return board;
		}
		dfs(board, m, n, row, col);
		return board;
	}

	private static void dfs(char[][] board, int m, int n, int row, int col) {
		// TODO Auto-generated method stub
		// BFS
		int num = bfs(board, row, col, m, n);
		if (num > 0) {
			board[row][col] = (char) (num + 48);
			return;
		}
		board[row][col] = 'B';
		// DFS
		for (int i = 0; i < adj.length; i++) {
			int currI = row + adj[i][0];
			int currJ = col + adj[i][1];
			if (currI >= 0 && currI < m && currJ >= 0 && currJ < n && board[currI][currJ] == 'E') {
				dfs(board, m, n, currI, currJ);
			}
		}
	}

	private static int bfs(char[][] board, int row, int col, int m, int n) {
		// TODO Auto-generated method stub
		int num = 0;
		for (int i = 0; i < adj.length; i++) {
			int currI = row + adj[i][0];
			int currJ = col + adj[i][1];
			if (currI >= 0 && currI < m && currJ >= 0 && currJ < n && board[currI][currJ] == 'M') {
				num++;
			}
		}
		return num;
	}
}
