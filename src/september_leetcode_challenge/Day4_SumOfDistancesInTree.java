/**
 * 
 */
package september_leetcode_challenge;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author PRATAP LeetCode 834
 *
 */
public class Day4_SumOfDistancesInTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int edges[][] = { { 0, 1 }, { 0, 2 }, { 2, 3 }, { 2, 4 }, { 2, 5 } }, n = 6;
		Day4_SumOfDistancesInTree obj = new Day4_SumOfDistancesInTree();
		int ans[] = obj.sumOfDistancesInTree(n, edges);
		for (int i : ans)
			System.out.print(i + " ");
		System.out.println();
	}

	public int[] sumOfDistancesInTree(int n, int[][] edges) {
		int[] res = new int[n];
		List<HashSet<Integer>> adj = new ArrayList<HashSet<Integer>>();
		int[] count = new int[n];
		for (int i = 0; i < n; i++)
			adj.add(new HashSet<>());
		for (int i = 0; i < edges.length; i++) {
			adj.get(edges[i][0]).add(edges[i][1]);
			adj.get(edges[i][1]).add(edges[i][0]);
		}
		postorder(adj, 0, -1, count, res);
		preorder(adj, 0, -1, res, count);
		return res;
	}

	private void preorder(List<HashSet<Integer>> adj, int root, int prev, int[] res, int[] count) {
		// TODO Auto-generated method stub
		for (int i : adj.get(root)) {
			if (i == prev)
				continue;
			res[i] = res[root] - count[i] + count.length - count[i];
			preorder(adj, i, root, res, count);
		}
	}

	private void postorder(List<HashSet<Integer>> adj, int root, int prev, int[] count, int[] res) {
		// TODO Auto-generated method stub
		for (int i : adj.get(root)) {
			if (i == prev)
				continue;
			postorder(adj, i, root, count, res);
			count[root] += count[i];
			res[root] += res[i] + count[i];
		}
		count[root]++;
	}

}
