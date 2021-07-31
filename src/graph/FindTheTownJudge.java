/**
 * 
 */
package graph;

import java.util.ArrayList;

/**
 * @author PRATAP
 *
 */
public class FindTheTownJudge {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] trust = { { 1, 3 }, { 1, 4 }, { 2, 3 }, { 2, 4 }, { 4, 3 } };
		int n = 4;
		int judge = findJudge(n, trust);
		System.out.println(judge);
	}

	public static int findJudge(int n, int[][] trust) {
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < n + 1; i++)
			adj.add(new ArrayList<Integer>());
		for (int i = 0; i < trust.length; i++) {
			int u = trust[i][0];
			int v = trust[i][1];
			adj.get(u).add(v);
		}
		int judge = -1;
		for (int i = 1; i < n + 1; i++) {
			if (adj.get(i).size() == 0 && judge != -1)
				return -1;
			if (adj.get(i).size() == 0)
				judge = i;
		}
		boolean flag = false;
		for (int i = 1; i < n + 1; i++) {
			if (i == judge)
				continue;
			for (int j : adj.get(i)) {
				if (j == judge)
					flag = true;
			}
			if (!flag)
				return -1;
		}
		return judge;
	}
}
