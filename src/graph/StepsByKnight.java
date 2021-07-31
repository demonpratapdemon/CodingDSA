/**
 * 
 */
package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author PRATAP
 *
 */
public class StepsByKnight {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int[][] neighbs = { { -2, -1 }, { -2, 1 }, { -1, -2 }, { -1, 2 }, { 2, -1 }, { 2, 1 }, { 1, -2 },
			{ 1, 2 } };

	public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N) {
		// Code here
		Queue<KPair> q = new LinkedList<KPair>();
		q.add(new KPair(KnightPos[0], KnightPos[1], 0));
		int minSteps = Integer.MAX_VALUE;
		boolean[][] visited = new boolean[N + 1][N + 1];
		while (!q.isEmpty()) {
			KPair curr = q.poll();
			for (int i = 0; i < neighbs.length; i++) {
				int[] pair = neighbs[i];
				int r = curr.i + pair[0];
				int c = curr.j + pair[1];
				if (r == TargetPos[0] && c == TargetPos[1]) {
					minSteps = Math.min(curr.step + 1, minSteps);
					continue;
				}
				if (r >= 1 && r <= N && c >= 1 && c <= N && !visited[r][c]) {
					visited[r][c] = true;
					q.add(new KPair(r, c, curr.step + 1));
				}

			}
		}
		return minSteps;
	}
}

class KPair {
	public int i;
	public int j;
	public int step;

	public KPair(int i, int j, int step) {
		super();
		this.i = i;
		this.j = j;
		this.step = step;
	}

}
