/**
 * 
 */
package graph;

import java.util.ArrayList;

/**
 * @author PRATAP
 *
 */
public class CircleOfStrings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String arr[] = { "ab", "bc", "cd", "da" };
		int ans = isCircle(arr.length, arr);
		System.out.println(ans);
	}

	public static int isCircle(int N, String A[]) {
		// code here
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < 26; i++) {
			adj.add(new ArrayList<Integer>());
		}
		int[] ind = new int[26];
		for (int i = 0; i < N; i++) {
			String s = A[i];
			int u = s.charAt(0) - 'a';
			int v = s.charAt(s.length() - 1) - 'a';
			adj.get(u).add(v);
			ind[v]++;
		}
		boolean sc = stronglyConnected(adj, N);
		if (!sc)
			return 0;
		// check in and out degree
		for (int i = 0; i < 26; i++) {
			if (adj.get(i).size() != ind[i]) {
				return 0;
			}
		}
		return 1;
	}

	private static boolean stronglyConnected(ArrayList<ArrayList<Integer>> adj, int N) {
		// TODO Auto-generated method stub
		boolean[] visited = new boolean[26];
		int start = 0;
		for (int i = 0; i < adj.size(); i++) {
			if (adj.get(i).size() > 0) {
				start = i;
				break;
			}
		}
		dfs(start, adj, visited);
		for (int i = 0; i < 26; i++) {
			if (!visited[i] && adj.get(i).size() > 0)
				return false;
		}
		ArrayList<ArrayList<Integer>> trans = transpose(adj);
		for (int i = 0; i < 26; i++)
			visited[i] = false;
		dfs(start, trans, visited);
		for (int i = 0; i < 26; i++) {
			if (!visited[i] && adj.get(i).size() > 0)
				return false;
		}
		return true;
	}

	private static ArrayList<ArrayList<Integer>> transpose(ArrayList<ArrayList<Integer>> adj) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> trans = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < 26; i++) {
			trans.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < adj.size(); i++) {
			for (int j = 0; j < adj.get(i).size(); j++) {
				int u = i;
				int v = adj.get(i).get(j);
				trans.get(v).add(u);
			}
		}
		return trans;
	}

	private static void dfs(int start, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
		// TODO Auto-generated method stub
		visited[start] = true;
		for (int node : adj.get(start)) {
			if (!visited[node])
				dfs(node, adj, visited);
		}
	}
}
