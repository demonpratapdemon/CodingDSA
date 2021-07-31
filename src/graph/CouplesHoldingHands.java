/**
 * 
 */
package graph;

import java.util.HashMap;

/**
 * @author PRATAP LeetCode 765
 *
 */
public class CouplesHoldingHands {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] row = { 0, 2, 4, 1, 3, 5 };
		int swaps = minSwapsCouplesUF(row);
		System.out.println(swaps);
	}

	public static int minSwapsCouples(int[] row) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < row.length; i++)
			map.put(row[i], i);
		int swaps = 0;
		for (int i = 0; i < row.length; i += 2) {
			int first = row[i];
			int second = first + (first % 2 == 0 ? 1 : -1);
			if (row[i + 1] != second) {
				int actualPos = map.get(second);
				int temp = row[i + 1];
				row[i + 1] = second;
				row[actualPos] = temp;
				map.put(second, i + 1);
				map.put(temp, actualPos);
				swaps++;
			}
		}
		return swaps;
	}

	public static int minSwapsCouplesUF(int[] row) {
		for (int i = 0; i < row.length; i++) {
			row[i] /= 2;
		}
		int n = row.length / 2;
		int edges[][] = new int[n][n];
		boolean vis[] = new boolean[n];
		for (int i = 0; i < row.length; i += 2) {
			int v1 = row[i], v2 = row[i + 1];
			if (v1 == v2)
				continue;
			edges[v1][v2] = 1;
			edges[v2][v1] = 1;
		}

		int ans = 0;
		for (int i = 0; i < n; i++) {
			if (!vis[i]) {
				ans += count(edges, i, vis) - 1;
			}
		}
		return ans;
	}

	public static int count(int edges[][], int s, boolean visited[]) {
		visited[s] = true;
		int ans = 1;
		for (int i = 0; i < edges.length; i++) {
			if (edges[s][i] == 1 && !visited[i]) {
				ans += count(edges, i, visited);
			}
		}
		return ans;
	}
}
