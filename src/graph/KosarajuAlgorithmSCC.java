/**
 * 
 */
package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

/**
 * @author PRATAP Strongly Connected Components
 *
 */
public class KosarajuAlgorithmSCC {

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
		int scc = kosaraju(n, adj);
		System.out.println(scc);
	}

	public static int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
		// code here
		Stack<Integer> stack = new Stack<Integer>();
		boolean[] visited = new boolean[V];
		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				dfs(adj, i, stack, visited);
			}
		}
		ArrayList<ArrayList<Integer>> rev = reversed(adj, V);
		for (int i = 0; i < V; i++)
			visited[i] = false;
		int count = 0;
		while (!stack.isEmpty()) {
			int curr = stack.pop();
			if (!visited[curr]) {
				dfs2(rev, visited, curr);
				count++;
			}
		}
		return count;
	}

	private static void dfs2(ArrayList<ArrayList<Integer>> rev, boolean[] visited, int node) {
		// TODO Auto-generated method stub
		visited[node] = true;
		for (int i : rev.get(node)) {
			if (!visited[i]) {
				dfs2(rev, visited, i);
			}
		}
	}

	private static ArrayList<ArrayList<Integer>> reversed(ArrayList<ArrayList<Integer>> adj, int V) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> rev = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < V; i++)
			rev.add(new ArrayList<Integer>());
		for (int i = 0; i < V; i++) {
			for (int j : adj.get(i)) {
				rev.get(j).add(i);
			}
		}
		return rev;
	}

	private static void dfs(ArrayList<ArrayList<Integer>> adj, int node, Stack<Integer> stack, boolean[] visited) {
		// TODO Auto-generated method stub
		visited[node] = true;
		for (int i : adj.get(node)) {
			if (!visited[i]) {
				dfs(adj, i, stack, visited);
			}
		}
		stack.push(node);
	}

}
