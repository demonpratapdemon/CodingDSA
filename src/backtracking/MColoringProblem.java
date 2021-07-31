/**
 * 
 */
package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author PRATAP
 *
 */
public class MColoringProblem {

	/**
	 * @param args
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] buff = br.readLine().split("\\s+");
		int V = Integer.parseInt(buff[0]);
		int C = Integer.parseInt(buff[1]);
		int E = Integer.parseInt(buff[2]);
		List<Integer>[] G = new ArrayList[V];
		for (int i = 0; i < V; i++) {
			G[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < E; i++) {
			String[] input = br.readLine().split("\\s+");
			int u = Integer.parseInt(input[0]) - 1;
			int v = Integer.parseInt(input[1]) - 1;
			G[u].add(v);
			G[v].add(u);
		}
		int[] color = new int[V];
		boolean ans = graphColoring(G, color, 0, C);
		System.out.println(ans);
	}

	public static boolean graphColoring(List<Integer>[] G, int[] color, int i, int C) {
		// Your code here
		int n = G.length;
		boolean flag = solve(G, color, i, C, n);
		return flag;
	}

	private static boolean solve(List<Integer>[] G, int[] color, int i, int C, int n) {
		// TODO Auto-generated method stub
		if (i == n) {
			return true;
		}
		for (int k = 1; k <= C; k++) {
			color[i] = k;
			if (check(G, color, i)) {
				boolean flag = solve(G, color, i + 1, C, n);
				if (flag)
					return true;
			}
			color[i] = 0;
		}
		return false;
	}

	private static boolean check(List<Integer>[] G, int[] color, int idx) {
		// TODO Auto-generated method stub
		int colorI = color[idx];
		for (int j = 0; j < G[idx].size(); j++) {
			int adj = G[idx].get(j);
			if (colorI == color[adj] && colorI != 0 && color[adj] != 0)
				return false;
		}
		return true;
	}

}
