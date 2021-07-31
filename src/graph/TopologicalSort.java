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
public class TopologicalSort {

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
		}
		int[] ans = topoSort(n, adj);
		for (int i : ans)
			System.out.print(i + " ");
	}

	static int c = 1;

	static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
		// add your code here
		c = 1;
		int[] finish = new int[V];
		boolean[] visited = new boolean[V];
		int[] L = new int[V];
		int count = 0;
		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				count = dfs(adj, V, i, count, visited, finish, L);
			}
			finish[i] = count;
		}
		return L;
	}

	private static int dfs(ArrayList<ArrayList<Integer>> adj, int V, int node, int count, boolean[] visited,
			int[] finish, int[] L) {
		// TODO Auto-generated method stub
		visited[node] = true;
		for (int j : adj.get(node)) {
			if (!visited[j]) {
				dfs(adj, V, j, count, visited, finish, L);
			}
		}
		finish[node] = count++;
		L[V - c] = node;
		c++;
		return count;
	}
}
