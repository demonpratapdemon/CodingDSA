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

/**
 * @author PRATAP
 *
 */
public class BFS {

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
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
		ArrayList<Integer> ans = bfsOfGraph(n, adj);
		System.out.println(ans);
	}

	public static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
		// Code here
		boolean[] visited = new boolean[adj.size()];
		ArrayList<Integer> ans = new ArrayList<Integer>();
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(0);
		visited[0] = true;
		while (!q.isEmpty()) {
			int curr = q.poll();
			ans.add(curr);
			for (int i = 0; i < adj.get(curr).size(); i++) {
				if (!visited[adj.get(curr).get(i)]) {
					q.add(adj.get(curr).get(i));
					visited[adj.get(curr).get(i)] = true;
				}
			}
		}
		return ans;
	}

}
