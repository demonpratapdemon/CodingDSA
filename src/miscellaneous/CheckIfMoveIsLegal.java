/**
 * 
 */
package miscellaneous;

/**
 * @author PRATAP
 *
 */
public class CheckIfMoveIsLegal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = { { 'B', 'B', '.', '.', 'B', 'W', 'W', '.' }, { '.', 'W', 'W', '.', 'B', 'W', 'B', 'B' },
				{ '.', 'W', 'B', 'B', 'W', '.', 'W', '.' }, { 'B', '.', '.', 'B', 'W', 'W', 'W', '.' },
				{ 'W', 'W', 'W', 'B', 'W', '.', 'B', 'W' }, { '.', '.', '.', 'W', '.', 'W', '.', 'B' },
				{ 'B', 'B', 'W', 'B', 'B', 'W', 'W', 'B' }, { 'W', '.', 'W', 'W', '.', 'B', '.', 'W' } };
		int rMove = 2, cMove = 5;
		char color = 'W';
		CheckIfMoveIsLegal obj = new CheckIfMoveIsLegal();
		boolean ans = obj.checkMove(board, rMove, cMove, color);
		System.out.println(ans);
	}

	public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
		boolean up = checkTopColumn(board, rMove, cMove, color);
		boolean down = checkDownColumn(board, rMove, cMove, color);
		boolean left = checkLeftRow(board, rMove, cMove, color);
		boolean right = checkRightRow(board, rMove, cMove, color);
		boolean leftDUp = checkLeftDiagonalUp(board, rMove, cMove, color);
		boolean leftDDown = checkLeftDiagonalDown(board, rMove, cMove, color);
		boolean rightDUp = checkRightDiagonalUp(board, rMove, cMove, color);
		boolean rightDDown = checkRightDiagonalDown(board, rMove, cMove, color);
		System.out.println(up + " " + down + " " + left + " " + right + " " + leftDUp + " " + leftDDown + " " + rightDUp
				+ " " + rightDDown);
		return up | down | left | right | leftDUp | leftDDown | rightDUp | rightDDown;
	}

	private boolean checkRightDiagonalDown(char[][] board, int rMove, int cMove, char color) {
		// TODO Auto-generated method stub
		int m = board.length;
		boolean flag = true;
		if (cMove - 1 >= 0 && rMove + 1 < m && board[rMove + 1][cMove - 1] == color)
			return false;
		for (int i = rMove + 1, j = cMove - 1; i < m && j >= 0; i++, j--) {
			if (board[i][j] == color && !flag)
				return true;
			else if (board[i][j] == '.')
				break;
			else if (board[i][j] != color) {
				if (flag)
					flag = false;
			}
		}
		return false;
	}

	private boolean checkRightDiagonalUp(char[][] board, int rMove, int cMove, char color) {
		// TODO Auto-generated method stub
		int n = board[0].length;
		boolean flag = true;
		if (cMove + 1 < n && rMove - 1 >= 0 && board[rMove - 1][cMove + 1] == color)
			return false;
		for (int i = rMove - 1, j = cMove + 1; i >= 0 && j < n; i--, j++) {
			if (board[i][j] == color && !flag)
				return true;
			else if (board[i][j] == '.')
				break;
			else if (board[i][j] != color) {
				if (flag)
					flag = false;
			}
		}
		return false;
	}

	private boolean checkLeftDiagonalDown(char[][] board, int rMove, int cMove, char color) {
		// TODO Auto-generated method stub
		int m = board.length, n = board[0].length;
		boolean flag = true;
		if (cMove + 1 < n && rMove + 1 < m && board[rMove + 1][cMove + 1] == color)
			return false;
		for (int i = rMove + 1, j = cMove + 1; i < m && j < n; i++, j++) {
			if (board[i][j] == color && !flag)
				return true;
			else if (board[i][j] == '.')
				break;
			else if (board[i][j] != color) {
				if (flag)
					flag = false;
			}
		}
		return false;
	}

	private boolean checkLeftDiagonalUp(char[][] board, int rMove, int cMove, char color) {
		// TODO Auto-generated method stub
		boolean flag = true;
		if (cMove - 1 >= 0 && rMove - 1 >= 0 && board[rMove - 1][cMove - 1] == color)
			return false;
		for (int i = rMove - 1, j = cMove - 1; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j] == color && !flag)
				return true;
			else if (board[i][j] == '.')
				break;
			else if (board[i][j] != color) {
				if (flag)
					flag = false;
			}
		}
		return false;
	}

	private boolean checkRightRow(char[][] board, int rMove, int cMove, char color) {
		// TODO Auto-generated method stub
		int n = board[0].length;
		boolean flag = true;
		if (cMove + 1 < n && board[rMove][cMove + 1] == color)
			return false;
		for (int j = cMove + 1; j < n; j++) {
			if (board[rMove][j] == color && !flag)
				return true;
			else if (board[rMove][j] == '.')
				break;
			else if (board[rMove][j] != color) {
				if (flag)
					flag = false;
			}
		}
		return false;
	}

	private boolean checkLeftRow(char[][] board, int rMove, int cMove, char color) {
		// TODO Auto-generated method stub
		boolean flag = true;
		if (cMove - 1 >= 0 && board[rMove][cMove - 1] == color)
			return false;
		for (int j = cMove - 1; j >= 0; j--) {
			if (board[rMove][j] == color && !flag)
				return true;
			else if (board[rMove][j] == '.')
				break;
			else if (board[rMove][j] != color) {
				if (flag)
					flag = false;
			}
		}
		return false;
	}

	private boolean checkDownColumn(char[][] board, int rMove, int cMove, char color) {
		// TODO Auto-generated method stub
		int m = board.length;
		boolean flag = true;
		if (rMove + 1 < m && board[rMove + 1][cMove] == color)
			return false;
		for (int i = rMove + 1; i < m; i++) {
			if (board[i][cMove] == color && !flag)
				return true;
			else if (board[i][cMove] == '.')
				break;
			else if (board[i][cMove] != color) {
				if (flag)
					flag = false;
			}
		}
		return false;
	}

	private boolean checkTopColumn(char[][] board, int rMove, int cMove, char color) {
		// TODO Auto-generated method stub
		boolean flag = true;
		if (rMove - 1 >= 0 && board[rMove - 1][cMove] == color)
			return false;
		for (int i = rMove - 1; i >= 0; i--) {
			if (board[i][cMove] == color && !flag)
				return true;
			else if (board[i][cMove] == '.')
				break;
			else if (board[i][cMove] != color) {
				if (flag)
					flag = false;
			}
		}
		return false;
	}
}
