/**
 * 
 */
package arrays;

/**
 * @author PRATAP
 *
 */
public class TicTacToe {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		char board[] = { 'X', 'X', 'O', 'O', 'O', 'X', 'X', 'O', 'X' };
//		char board[] = { 'O', 'X', 'X', 'O', 'X', 'X', 'O', 'O', 'X' };
		char board[] = { 'X', 'X', 'X', 'X', 'O', 'O', 'O', 'X', 'O' };
		boolean ans = isValid(board);
		System.out.println(ans);
	}

	public static int[][] pos = { { 0, 0 }, { 0, 1 }, { 0, 2 }, { 1, 0 }, { 1, 1 }, { 1, 2 }, { 2, 0 }, { 2, 1 },
			{ 2, 2 } };

	public static boolean isValid(char[] board) {
		// code here
		int[] row = new int[3];
		int[] col = new int[3];
		int dlr = 0, drl = 0;
		int countX = 0, count0 = 0;
		for (int i = 0; i < board.length; i++) {
			char ch = board[i];
			int[] p = pos[i];
			if (ch == 'X') {
				row[p[0]]++;
				col[p[1]]++;
				if (p[0] == p[1])
					dlr++;
				if (p[0] + p[1] == 2)
					drl++;
				countX++;
			} else {
				row[p[0]]--;
				col[p[1]]--;
				if (p[0] == p[1])
					dlr--;
				if (p[0] + p[1] == 2)
					drl--;
				count0++;
			}

		}
		for (int i = 0; i < board.length; i++) {
			int[] p = pos[i];
			if (row[p[0]] == 3 || col[p[1]] == 3 || dlr == 3 || drl == 3) {
				if (countX != count0 + 1)
					return false;
			}
			if (row[p[0]] == -3 || col[p[1]] == -3 || dlr == -3 || drl == -3) {
				if (countX != count0)
					return false;
			}
		}
		if (countX != count0 && countX != count0 + 1)
			return false;
		return true;
	}
}
