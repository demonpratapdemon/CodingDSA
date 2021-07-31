/**
 * 
 */
package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author PRATAP LeetCode 51
 *
 */
public class NQueen {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		List<List<String>> ans = solveNQueens(n);
		System.out.println(ans);
	}

	public static boolean[] cols, ndiag, rdiag;
	public static List<List<String>> res;

	public static List<List<String>> solveNQueens(int n) {
		cols = new boolean[n];
		ndiag = new boolean[2 * n - 1];
		rdiag = new boolean[2 * n - 1];
		res = new ArrayList<List<String>>();
		findNQueens(n, 0, "");
		return res;
	}

	private static void findNQueens(int n, int row, String curr) {
		// TODO Auto-generated method stub
		if (row == n) {
			String[] buff = curr.split("\\s+");
			List<String> list = new ArrayList<String>();
			StringBuilder dots = new StringBuilder("");
			for (int i = 0; i < n; i++)
				dots.append(".");
			for (int i = 0; i < n; i++) {
				int pos = Integer.parseInt(buff[i]);
				dots.setCharAt(pos, 'Q');
				list.add(dots.toString());
				dots.setCharAt(pos, '.');
			}
			res.add(list);
			return;
		}
		for (int i = 0; i < n; i++) {
			if (!cols[i] && !ndiag[row + i] && !rdiag[row - i + n - 1]) {
				cols[i] = true;
				ndiag[row + i] = true;
				rdiag[row - i + n - 1] = true;
				findNQueens(n, row + 1, curr + i + " ");
				cols[i] = false;
				ndiag[row + i] = false;
				rdiag[row - i + n - 1] = false;
			}
		}
	}
}
