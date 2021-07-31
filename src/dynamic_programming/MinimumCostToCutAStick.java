/**
 * 
 */
package dynamic_programming;

import java.util.Arrays;

/**
 * @author PRATAP LeetCode 1547
 *
 */
public class MinimumCostToCutAStick {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] cuts = { 5, 6, 1, 4, 2 };
		int n = 9;
		int ans = minCost(n, cuts);
		System.out.println(ans);
	}

	static Integer dp[][];

	public static int find(int i, int j, int cuts[], int l, int r) {
		if (i > j)
			return 0;
		if (dp[i][j] != null)
			return dp[i][j];
		int min = Integer.MAX_VALUE;
		for (int index = i; index <= j; index++) {
			min = Math.min(min,
					(r - l) + find(i, index - 1, cuts, l, cuts[index]) + find(index + 1, j, cuts, cuts[index], r));
		}
		return dp[i][j] = min;
	}

	public static int minCost(int n, int[] cuts) {
		Arrays.sort(cuts);
		dp = new Integer[101][101];
		return find(0, cuts.length - 1, cuts, 0, n);
	}
}

class CutPair {
	public int start;
	public int end;

	public CutPair(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}

}
