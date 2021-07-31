/**
 * 
 */
package greedy;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author PRATAP
 *
 */
public class WaterConnectionProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a1[] = { 7, 5, 4, 2, 9, 3 }, b1[] = { 4, 9, 6, 8, 7, 1 }, d1[] = { 98, 72, 10, 22, 17, 66 };
		int n = 9, p = 6;
		ArrayList<Integer> a = new ArrayList<Integer>();
		ArrayList<Integer> b = new ArrayList<Integer>();
		ArrayList<Integer> d = new ArrayList<Integer>();
		for (int i = 0; i < p; i++) {
			a.add(a1[i]);
			b.add(b1[i]);
			d.add(d1[i]);
		}
		ArrayList<ArrayList<Integer>> ans = solve(n, p, a, b, d);
		System.out.println(ans);
	}

	public static int[] start = new int[200];
	public static int[] end = new int[200];
	public static int[] dia = new int[200];

	public static ArrayList<ArrayList<Integer>> solve(int n, int p, ArrayList<Integer> a, ArrayList<Integer> b,
			ArrayList<Integer> d) {
		// code here
		Arrays.fill(start, 0);
		Arrays.fill(end, 0);
		Arrays.fill(dia, 0);
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < p; i++) {
			int s = a.get(i);
			int e = b.get(i);
			int di = d.get(i);
			end[e] = s;
			start[s] = e;
			dia[s] = di;
		}
		boolean[] visited = new boolean[1000];
		for (int j = 1; j <= n; j++) {
			if (end[j] == 0 && start[j] != 0) {
				// System.out.println(j);
				visited[j] = true;
				WaterPair wp = dfs(j, Integer.MAX_VALUE, visited);
				ArrayList<Integer> curr = new ArrayList<Integer>();
				curr.add(j);
				curr.add(wp.end);
				curr.add(wp.dia);
				res.add(curr);
			}
		}
		return res;
	}

	private static WaterPair dfs(int j, int di, boolean[] visited) {
		// TODO Auto-generated method stub
		if (start[j] == 0 && !visited[j]) {
			visited[j] = true;
			return new WaterPair(j, di);
		}
		visited[j] = true;
		return dfs(start[j], Math.min(di, dia[j]), visited);
	}
}

class WaterPair {
	public int end;
	public int dia;

	public WaterPair(int end, int dia) {
		super();
		this.end = end;
		this.dia = dia;
	}

}
