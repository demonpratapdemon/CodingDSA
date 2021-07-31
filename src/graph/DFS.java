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
public class DFS {

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
		ArrayList<Integer> ans = dfsOfGraph(n, adj);
		System.out.println(ans);
	}

	public static ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
		// Code here
		boolean[] visited = new boolean[adj.size()];
		ArrayList<Integer> ans = new ArrayList<Integer>();
		visited[0] = true;
		dfs(adj, ans, visited, 0);
		return ans;
	}

	public static void dfs(ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ans, boolean[] visited, int node) {
		if (visited[node]) {
			ans.add(node);
		}
		for (int i = 0; i < adj.get(node).size(); i++) {
			int s = adj.get(node).get(i);
			if (!visited[s]) {
				visited[s] = true;
				dfs(adj, ans, visited, s);
			}
		}
	}

}
