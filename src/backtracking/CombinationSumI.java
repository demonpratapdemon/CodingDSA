/**
 * 
 */
package backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author PRATAP
 *
 */
public class CombinationSumI {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] candidates = { 2, 7, 6, 3, 5, 1 };
		int target = 9;
		List<List<Integer>> ans = combinationSum(candidates, target);
		System.out.println(ans);
	}

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		solve(candidates, target, list, 0, "");
		System.out.println(list.size());
		return list;
	}

	private static void solve(int[] nums, int target, List<List<Integer>> list, int currSum, String str) {
		// TODO Auto-generated method stub
		if (currSum == target) {
			String[] buff = str.trim().split("\\s+");
			if (list.size() == 0) {
				List<Integer> ans = new ArrayList<Integer>();
				for (String s : buff)
					ans.add(Integer.parseInt(s));
				list.add(ans);
			} else {
				HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();
				for (String s : buff)
					map1.put(Integer.parseInt(s), map1.getOrDefault(Integer.parseInt(s), 0) + 1);
				for (int i = 0; i < list.size(); i++) {
					List<Integer> prev = list.get(i);
					HashMap<Integer, Integer> map2 = new HashMap<Integer, Integer>();
					for (Integer j : prev)
						map2.put(j, map2.getOrDefault(j, 0) + 1);
					if (map1.equals(map2))
						return;
				}
				List<Integer> ans = new ArrayList<Integer>();
				for (String s : buff)
					ans.add(Integer.parseInt(s));
				list.add(ans);
			}
			return;
		}
		if (currSum > target)
			return;
		for (int i = 0; i < nums.length; i++) {
			solve(nums, target, list, currSum + nums[i], str + nums[i] + " ");
		}
	}

	static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int target) {
		// add your code here
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> temp = new ArrayList<Integer>();
		HashSet<Integer> set = new HashSet<Integer>(A);
		A.clear();
		A.addAll(set);
		Collections.sort(A);
		generate(A, target, res, temp, 0);
		return res;
	}

	private static void generate(ArrayList<Integer> A, int target, ArrayList<ArrayList<Integer>> res,
			ArrayList<Integer> temp, int idx) {
		// TODO Auto-generated method stub
		if (target == 0) {
			res.add(temp);
			return;
		}

		for (int i = idx; i < A.size(); i++) {
			if (target - A.get(i) >= 0) {
				temp.add(A.get(i));
				generate(A, target - A.get(i), res, temp, i);
				temp.remove(A.get(i));
			}
		}
	}

}
