/**
 * 
 */
package backtracking;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author PRATAP
 *
 */
public class RatInMazeI {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m[][] = { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };
		ArrayList<String> ans = findPath(m, m.length);
		System.out.println(ans);
	}

//										up		  down		left		right	
	final static int[][] neighbs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static ArrayList<String> findPath(int[][] m, int n) {
		// Your code here
		ArrayList<String> ans = new ArrayList<String>();
		if (m[0][0] == 0)
			return ans;
		findPathsInMaze(m, n, 0, 0, "", ans);
		Collections.sort(ans);
		return ans;
	}

	private static void findPathsInMaze(int[][] m, int n, int i, int j, String curr, ArrayList<String> ans) {
		// TODO Auto-generated method stub
		if (i < 0 || j < 0)
			return;
		if (i >= n || j >= n)
			return;
		if (i == n - 1 && j == n - 1 && m[i][j] == 1) {
			ans.add(curr);
			return;
		}
		if (m[i][j] == 0) {
			return;
		}
		int[] up = neighbs[0];
		int[] down = neighbs[1];
		int[] left = neighbs[2];
		int[] right = neighbs[3];

		m[i][j] = 0;

		findPathsInMaze(m, n, i + up[0], j + up[1], curr + "U", ans);
		findPathsInMaze(m, n, i + down[0], j + down[1], curr + "D", ans);
		findPathsInMaze(m, n, i + left[0], j + left[1], curr + "L", ans);
		findPathsInMaze(m, n, i + right[0], j + right[1], curr + "R", ans);

		m[i][j] = 1;
	}
}
