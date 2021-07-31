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
public class DetectCycleInDirectedGraph {

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
		boolean ans = isCyclic(n, adj);
		System.out.println(ans);
	}

	public static boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
		// code here
		boolean[] visited = new boolean[V];
		int[] proc = new int[V];
		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				if (cycle(adj, i, visited, proc)) {
					return true;
				} else {
					if (proc[i] == 1)
						proc[i] = 0;
				}
			}
		}
		return false;
	}

	private static boolean cycle(ArrayList<ArrayList<Integer>> adj, int node, boolean[] visited, int[] proc) {
		// TODO Auto-generated method stub
		visited[node] = true;
		proc[node] = 1;
		for (int i : adj.get(node)) {
			if (visited[i] && proc[i] == 1) {
				return true;
			} else if (!visited[i]) {
				boolean flag = cycle(adj, i, visited, proc);
				if (flag)
					return true;
				proc[i] = 0;
			}
		}
		return false;
	}

}
