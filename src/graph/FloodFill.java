/**
 * 
 */
package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author PRATAP LeetCode 733
 *
 */
public class FloodFill {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int image[][] = { { 0, 0, 0 }, { 0, 0, 0 } }, sr = 0, sc = 0, newColor = 2;
		FloodFill obj = new FloodFill();
		int[][] ans = obj.floodFill(image, sr, sc, newColor);
		for (int i = 0; i < ans.length; i++) {
			for (int j = 0; j < ans[0].length; j++)
				System.out.print(ans[i][j] + "\t");
			System.out.println();
		}
	}

	public static int[][] neighbs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		int m = image.length;
		int n = image[0].length;
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(sr, sc));
		boolean[][] visited = new boolean[image.length][image[0].length];
		int color = image[sr][sc];
		image[sr][sc] = newColor;
		visited[sr][sc] = true;
		while (!q.isEmpty()) {
			Pair curr = q.poll();
			for (int k = 0; k < neighbs.length; k++) {
				int pair[] = neighbs[k];
				int i = curr.i + pair[0];
				int j = curr.j + pair[1];
				if (i >= 0 && i < m && j >= 0 && j < n && image[i][j] == color && !visited[i][j]) {
					visited[i][j] = true;
					q.add(new Pair(i, j));
					image[i][j] = newColor;
				}
			}
		}
		return image;
	}
}

class Pair {
	public int i;
	public int j;

	public Pair(int i, int j) {
		this.i = i;
		this.j = j;
	}

}
