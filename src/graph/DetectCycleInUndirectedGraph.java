/**
 * 
 */
package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @author PRATAP
 *
 */
public class DetectCycleInUndirectedGraph {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] buff = br.readLine().split("\\s+");
		int n = Integer.parseInt(buff[0]);
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < n; i++) {
			adj.add(new ArrayList<Integer>());
		}
		int edges = Integer.parseInt(buff[1]);
		for (int i = 0; i < edges; i++) {
			String[] input = br.readLine().split("\\s+");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			adj.get(a).add(b);
			adj.get(b).add(a);
		}
		boolean ans = isCycle(n, adj);
		System.out.println(ans);
	}

	public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
		// Code here
		boolean[] visited = new boolean[V];
		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				if (dfs(adj, visited, i, -1)) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int node, int parent) {
		// TODO Auto-generated method stub
		visited[node] = true;
		for (int i : adj.get(node)) {
			if (!visited[i]) {
				if (dfs(adj, visited, i, node))
					return true;
			} else if (i != parent) {
				return true;
			}
		}
		return false;
	}

}
