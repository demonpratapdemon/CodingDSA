/**
 * 
 */
package backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * @author PRATAP LeetCode 47
 *
 */
public class PermutationII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 2, 3 };
		List<List<Integer>> res = permuteUnique(nums);
		System.out.println(res);
	}

	public static List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		int n = nums.length;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i : nums)
			map.put(i, map.getOrDefault(i, 0) + 1);
		solve(map, res, n, "");
		return res;
	}

	private static void solve(HashMap<Integer, Integer> map, List<List<Integer>> res, int n, String curr) {
		// TODO Auto-generated method stub
		if (n <= 0) {
			String[] ans = curr.trim().split(" ");
			List<Integer> list = new ArrayList<Integer>();
			for (String s : ans)
				list.add(Integer.parseInt(s));
			res.add(list);
			return;
		}
		Iterator<Integer> itr = map.keySet().iterator();
		while (itr.hasNext()) {
			Integer key = itr.next();
			if (map.get(key) > 0) {
				map.put(key, map.get(key) - 1);
				solve(map, res, n - 1, curr + key + " ");
				map.put(key, map.get(key) + 1);
			}
		}
	}

}
