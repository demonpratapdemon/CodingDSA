/**
 * 
 */
package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;

/**
 * @author PRATAP
 *
 */
public class BipartiteGraph {

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
		boolean ans = isBipartite(adj.size(), adj);
		System.out.println(ans);
	}

	public static boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
		// Code here
		boolean[] visited = new boolean[V];
		for (int v = 0; v < V; v++) {
			boolean check = checkBipartite(adj, visited, v);
			if (!check)
				return false;
		}
		return true;
	}

	private static boolean checkBipartite(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int v) {
		// TODO Auto-generated method stub
		TreeSet<Integer> set0 = new TreeSet<Integer>();
		TreeSet<Integer> set1 = new TreeSet<Integer>();
		Queue<Bipartite> q = new LinkedList<Bipartite>();
		q.add(new Bipartite(v, v + " ", 0));

		while (!q.isEmpty()) {
			Bipartite curr = q.poll();
			if (!visited[curr.node]) {
				if (curr.level % 2 == 0) {
					set0.add(curr.node);
				} else {
					set1.add(curr.node);
				}
			} else {
				int level = curr.level;
				if (level % 2 == 0) {
					if (set1.contains(curr.node))
						return false;
				} else {
					if (set0.contains(curr.node))
						return false;
				}
			}
			visited[curr.node] = true;
			for (int i = 0; i < adj.get(curr.node).size(); i++) {
				int adjacent = adj.get(curr.node).get(i);
				if (!visited[adjacent]) {
					q.add(new Bipartite(adjacent, curr.path + " " + adjacent, curr.level + 1));
				}
			}
		}
		return true;
	}
}

class Bipartite {
	public int node;
	public String path;
	public int level;

	public Bipartite(int node, String path, int level) {
		super();
		this.node = node;
		this.path = path;
		this.level = level;
	}

}
