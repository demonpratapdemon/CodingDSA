/**
 * 
 */
package august_leetcode_challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author PRATAP
 *
 */
public class Day3_SubsetsII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 2, 1, 2, 1, 3 };
		Day3_SubsetsII obj = new Day3_SubsetsII();
		List<List<Integer>> ans = obj.subsetsWithDup1(nums);
		System.out.println(ans);
	}

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		int n = nums.length;
		Arrays.sort(nums);
		HashMap<Integer, List<List<Integer>>> map = new HashMap<Integer, List<List<Integer>>>();
		subsets(nums, ans, n, 0, "", map);
		return ans;
	}

	private void subsets(int[] nums, List<List<Integer>> ans, int n, int i, String curr,
			HashMap<Integer, List<List<Integer>>> map) {
		// TODO Auto-generated method stub
		if (i == n) {
			List<Integer> list = new ArrayList<Integer>();
			if (!curr.equalsIgnoreCase("")) {
				String[] buff = curr.trim().split("\\s+");
				for (String st : buff) {
					list.add(Integer.parseInt(st));
				}
			}
			if (!checkMap(list, map)) {
				ans.add(list);
			}
			return;
		}
		subsets(nums, ans, n, i + 1, curr, map);
		subsets(nums, ans, n, i + 1, curr + " " + String.valueOf(nums[i]), map);
	}

	private boolean checkMap(List<Integer> list, HashMap<Integer, List<List<Integer>>> map) {
		// TODO Auto-generated method stub
		int size = list.size();
		List<List<Integer>> mapList = map.getOrDefault(size, null);
		if (mapList == null) {
			List<List<Integer>> newList = new ArrayList<List<Integer>>();
			newList.add(list);
			map.put(size, newList);
			return false;
		}
		HashMap<Integer, Integer> map2 = new HashMap<Integer, Integer>();
		for (int x : list)
			map2.put(x, map2.getOrDefault(x, 0) + 1);
		for (int i = 0; i < mapList.size(); i++) {
			List<Integer> l = mapList.get(i);
			HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();
			for (int x : l) {
				map1.put(x, map1.getOrDefault(x, 0) + 1);
			}
			if (map1.equals(map2))
				return true;
		}
		mapList.add(list);
		map.put(size, mapList);
		return false;
	}

	public List<List<Integer>> subsetsWithDup1(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		findSubsets(nums, 0, ans, new ArrayList<Integer>());
		return ans;
	}

	private void findSubsets(int[] nums, int idx, List<List<Integer>> ans, ArrayList<Integer> arrayList) {
		// TODO Auto-generated method stub
		ans.add(new ArrayList<Integer>(arrayList));
		for (int i = idx; i < nums.length; i++) {
			if (i != idx && nums[i] == nums[i - 1])
				continue;
			arrayList.add(nums[i]);
			findSubsets(nums, i + 1, ans, arrayList);
			arrayList.remove(arrayList.size() - 1);
		}
	}
}
