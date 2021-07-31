/**
 * 
 */
package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author PRATAP LeetCode 77
 *
 */
public class Combinations {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		int k = 2;
		List<List<Integer>> ans = combine(n, k);
		System.out.println(ans);
	}

	public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		solve(n, k, res, 1, "", 0);
		return res;
	}

	private static void solve(int n, int k, List<List<Integer>> res, int cb, String asf, int ssf) {
		// TODO Auto-generated method stub
		if (cb > n) {
			if (ssf == k) {
				String[] buff = asf.trim().split("\\s+");
				List<Integer> list = new ArrayList<Integer>();
				for(String str : buff)
					list.add(Integer.parseInt(str));
				res.add(list);
			}
			return;
		}
		solve(n, k, res, cb + 1, asf + cb + " ", ssf + 1);
		solve(n, k, res, cb + 1, asf + " ", ssf);
	}
}
