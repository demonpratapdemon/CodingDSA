/**
 * 
 */
package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author PRATAP LeetCode 909
 *
 */
public class SnakeAndLadder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] board = { { -1, -1, -1, 46, 47, -1, -1, -1 }, { 51, -1, -1, 63, -1, 31, 21, -1 },
				{ -1, -1, 26, -1, -1, 38, -1, -1 }, { -1, -1, 11, -1, 14, 23, 56, 57 },
				{ 11, -1, -1, -1, 49, 36, -1, 48 }, { -1, -1, -1, 33, 56, -1, 57, 21 },
				{ -1, -1, -1, -1, -1, -1, 2, -1 }, { -1, -1, -1, 8, 3, -1, 6, 56 } };
		int steps = snakesAndLadders(board);
		System.out.println(steps);
	}

	public static int[] dice = { 1, 2, 3, 4, 5, 6 };

	public static int snakesAndLadders(int[][] board) {
		int r = board.length;
		int c = board[0].length;
		HashMap<Integer, Loc> map = new HashMap<Integer, Loc>();
		getLocations(board, r, c, map);
		boolean[] visited = new boolean[r * c + 1];
		Queue<Board> q = new LinkedList<Board>();
		q.add(new Board(1, 0));
		int minSteps = Integer.MAX_VALUE;
		visited[1] = true;
		while (!q.isEmpty()) {
			Board curr = q.poll();
			for (int k = 0; k < dice.length; k++) {
				int newPos = curr.pos + dice[k];
				if (newPos > r * c)
					break;
				Loc loc = map.get(newPos);
				if (loc != null && board[loc.i][loc.j] != -1) {
					int jump = board[loc.i][loc.j];
					newPos = jump;
				}
				if (newPos == r * c) {
					minSteps = Math.min(minSteps, curr.steps + 1);
					continue;
				}
				if (!visited[newPos]) {
					visited[newPos] = true;
					q.add(new Board(newPos, curr.steps + 1));
				}
			}
		}
		if (minSteps == Integer.MAX_VALUE)
			return -1;
		return minSteps;
	}

	private static void getLocations(int[][] board, int r, int c, HashMap<Integer, Loc> map) {
		// TODO Auto-generated method stub
		int alt = 0;
		int count = 1;
		for (int i = r - 1; i >= 0; i--) {
			if (alt == 0) {
				for (int j = 0; j < c; j++) {
					map.put(count++, new Loc(i, j));
				}
				alt = 1;
			} else {
				for (int j = c - 1; j >= 0; j--) {
					map.put(count++, new Loc(i, j));
				}
				alt = 0;
			}
		}
	}
}

class Loc {
	public int i;
	public int j;

	public Loc(int i, int j) {
		super();
		this.i = i;
		this.j = j;
	}

}

class Board {
	public int pos;
	public int steps;

	public Board(int pos, int steps) {
		super();
		this.pos = pos;
		this.steps = steps;
	}
}
