/**
 * 
 */
package december_leetcode_challenges;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @author PRATAP LeetCode 310
 *
 */
public class Day16_MinimumHeightTrees {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4, edges[][] = { { 1, 0 }, { 1, 2 }, { 1, 3 } };
		Day16_MinimumHeightTrees obj = new Day16_MinimumHeightTrees();
		List<Integer> ans = obj.findMinHeightTrees(n, edges);
		System.out.println(ans);
	}

	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		List<Integer> ans = new ArrayList<Integer>();
		if (n < 2) {
			for (int i = 0; i < n; i++)
				ans.add(i);
			return ans;
		}
		List<Set<Integer>> adj = new ArrayList<Set<Integer>>();
		for (int i = 0; i < n; i++) {
			adj.add(new HashSet<Integer>());
		}
		for (int i = 0; i < edges.length; i++) {
			int u = edges[i][0], v = edges[i][1];
			adj.get(u).add(v);
			adj.get(v).add(u);
		}
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < n; i++) {
			if (adj.get(i).size() == 1)
				q.add(i);
		}
		int remNodes = n;
		while (remNodes > 2) {
			int len = q.size();
			remNodes -= len;
			while (len-- > 0) {
				int node = q.poll();
				Iterator<Integer> itr = adj.get(node).iterator();
				while (itr.hasNext()) {
					int adjacent = itr.next();
					adj.get(adjacent).remove(node);
					if (adj.get(adjacent).size() == 1) {
						q.add(adjacent);
					}
				}
			}
		}
		while (!q.isEmpty()) {
			ans.add(q.poll());
		}
		return ans;
	}

}
