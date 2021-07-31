/**
 * 
 */
package graph;

import java.util.Arrays;

/**
 * @author PRATAP LeetCode 1334
 *
 */
public class CityWithSmallestNeighbourAtThresholdDistance {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] edges = { { 0, 1, 2 }, { 0, 4, 8 }, { 1, 2, 3 }, { 1, 4, 2 }, { 2, 3, 1 }, { 3, 4, 1 } };
		int distanceThreshold = 2;
		int n = 5;
		int city = findTheCity(n, edges, distanceThreshold);
		System.out.println(city);
	}

	public static int max = 999999;

	public static int findTheCity(int n, int[][] edges, int distanceThreshold) {
		int[][] adj = new int[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(adj[i], max);
			adj[i][i] = 0;
		}

		for (int i = 0; i < edges.length; i++) {
			int x = edges[i][0];
			int y = edges[i][1];
			int w = edges[i][2];
			adj[x][y] = w;
			adj[y][x] = w;
		}

		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
				}
			}
		}

		int count = 0, city = -1, lowestCount = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			count = 0;
			for (int j = 0; j < n; j++) {
				if (i != j && adj[i][j] <= distanceThreshold) {
					count++;
				}
			}
			if (count <= lowestCount) {
				city = i;
				lowestCount = count;
			}
		}
		return city;
	}

}
