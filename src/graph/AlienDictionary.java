/**
 * 
 */
package graph;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author PRATAP
 *
 */
public class AlienDictionary {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] dict = { "baa", "abcd", "abca", "cab", "cad" };
		int N = 5, K = 4;
		AlienDictionary obj = new AlienDictionary();
		String ans = obj.findOrder(dict, N, K);
		System.out.println(ans);
	}

	public String findOrder(String[] dict, int N, int K) {
		// Write your code here
		ArrayList<ArrayList<ANode>> adj = new ArrayList<ArrayList<ANode>>();
		for (int i = 0; i < K; i++)
			adj.add(new ArrayList<ANode>());
		for (int i = 0; i < N - 1; i++) {
			String word1 = dict[i];
			String word2 = dict[i + 1];
			for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
				if (word1.charAt(j) != word2.charAt(j)) {
					int u = word1.charAt(j) - 'a';
					int v = word2.charAt(j) - 'a';
					adj.get(u).add(new ANode(u, v));
					break;
				}
			}
		}
		Stack<Integer> stack = topoSort(adj, K);
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append((char) (stack.pop() + 'a'));
		}
		return sb.toString();
	}

	private Stack<Integer> topoSort(ArrayList<ArrayList<ANode>> adj, int k) {
		// TODO Auto-generated method stub
		Stack<Integer> stack = new Stack<Integer>();
		boolean[] visited = new boolean[26];
		for (int i = 0; i < adj.size(); i++) {
			if (adj.get(i).size() == 0)
				continue;
			if (!visited[i]) {
				topo(adj, i, visited, stack);
			}
		}
		return stack;
	}

	private void topo(ArrayList<ArrayList<ANode>> adj, int node, boolean[] visited, Stack<Integer> stack) {
		// TODO Auto-generated method stub
		visited[node] = true;
		for (int i = 0; i < adj.get(node).size(); i++) {
			int v = adj.get(node).get(i).v;
			if (!visited[v]) {
				topo(adj, v, visited, stack);
			}
		}
		stack.push(node);
	}
}

class ANode {
	public int u;
	public int v;

	public ANode(int u, int v) {
		super();
		this.u = u;
		this.v = v;
	}

}