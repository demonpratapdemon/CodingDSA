/**
 * 
 */
package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author PRATAP LeetCode 40
 *
 */
public class CombinationSumII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int candidates[] = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, target = 27;
		List<List<Integer>> res = combinationSum2(candidates, target);
		System.out.println(res);
	}

	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		HashSet<String> set = new HashSet<String>();
		int sum = 0;
		for (int i : candidates)
			sum += i;
		if (sum < target) {
			return res;
		}
		Arrays.sort(candidates);
		solve(candidates, target, 0, "", 0, res, set);
		System.out.println(set.size());
		return res;
	}

	private static void solve(int[] candidates, int target, int i, String asf, int ssf, List<List<Integer>> res,
			HashSet<String> set) {
		// TODO Auto-generated method stub
		if (i == candidates.length) {
			if (ssf == target && !set.contains(asf.trim())) {
				set.add(asf.trim());
				String[] buff = asf.trim().split("\\s+");
				List<Integer> list = new ArrayList<Integer>();
				for (String str : buff)
					list.add(Integer.parseInt(str));
				if (!res.contains(list))
					res.add(list);
			}
			return;
		}
		if (ssf == target && !set.contains(asf.trim())) {
			set.add(asf.trim());
			String[] buff = asf.trim().split("\\s+");
			List<Integer> list = new ArrayList<Integer>();
			for (String str : buff)
				list.add(Integer.parseInt(str));
			if (!res.contains(list))
				res.add(list);
			return;
		}
		if (ssf > target)
			return;
		solve(candidates, target, i + 1, asf + candidates[i] + " ", ssf + candidates[i], res, set);
		solve(candidates, target, i + 1, asf + " ", ssf, res, set);
	}

}
