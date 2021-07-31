/**
 * 
 */
package miscellaneous;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 * @author PRATAP LeetCode 1743
 *
 */
public class RestorArrayFromAdjacentPairs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[][] adjacentPairs = { { 100000, -100000 } };
//		int[][] adjacentPairs = { { 4, -2 }, { 1, 4 }, { -3, 1 } };
		int[][] adjacentPairs = { { 2, 1 }, { 3, 4 }, { 3, 2 } };
		RestorArrayFromAdjacentPairs obj = new RestorArrayFromAdjacentPairs();
		int[] ans = obj.restoreArray(adjacentPairs);
		for (int i : ans)
			System.out.print(i + " ");
	}

	public int[] restoreArray(int[][] adjacentPairs) {
		ArrayList<ArrayList<AjNode>> adj = new ArrayList<ArrayList<AjNode>>();
		int n = adjacentPairs.length;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();
		for (int i = 0; i <= n; i++) {
			adj.add(new ArrayList<AjNode>());
		}
		int start = 0;
		for (int i = 0; i < n; i++) {
			int val1 = adjacentPairs[i][0];
			int val2 = adjacentPairs[i][1];
			int u = -1, v = -1;
			if (!map.containsKey(val1))
				map.put(val1, start++);
			if (!map.containsKey(val2))
				map.put(val2, start++);
			u = map.get(val1);
			v = map.get(val2);
			map1.put(u, val1);
			map1.put(v, val2);
			adj.get(u).add(new AjNode(u, v));
			adj.get(v).add(new AjNode(v, u));
		}
		start = 0;
		for (int i = 0; i < adj.size(); i++) {
			if (adj.get(i).size() == 1) {
				start = i;
				break;
			}
		}
		boolean[] visited = new boolean[map.size()];
		Stack<Integer> stack = new Stack<Integer>();
		dfs(adj, start, visited, stack);
		int[] res = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			res[i] = map1.get(stack.pop());
		}
		return res;
	}

	private void dfs(ArrayList<ArrayList<AjNode>> adj, int node, boolean[] visited, Stack<Integer> stack) {
		// TODO Auto-generated method stub
		visited[node] = true;
		for (int i = 0; i < adj.get(node).size(); i++) {
			int adjacent = adj.get(node).get(i).v;
			if (!visited[adjacent]) {
				dfs(adj, adjacent, visited, stack);
			}
		}
		stack.push(node);
	}
}

class AjNode {
	public int u;
	public int v;

	public AjNode(int u, int v) {
		super();
		this.u = u;
		this.v = v;
	}

}
