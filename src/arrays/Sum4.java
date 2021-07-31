/**
 * 
 */
package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * @author PRATAP LeetCode 18
 *
 */
public class Sum4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 0, -1, 0, -2, 2 };
		List<List<Integer>> ans = fourSum(nums, 0);
		System.out.println("Using Hashmap");
		for (List<Integer> list : ans) {
			System.out.println(list.toString());
		}
		System.out.println("Using Hashset");

		System.out.println(fourSumUsingSet(nums, 0));
	}

	public static List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);
		int n = nums.length;
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (n < 4)
			return res;
		HashMap<Integer, List<Pair>> map = new HashMap<Integer, List<Pair>>();
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				int key = nums[i] + nums[j];
				if (map.containsKey(key)) {
					List<Pair> pairs = map.get(key);
					pairs.add(new Pair(i, j));
					map.put(key, pairs);
				} else {
					ArrayList<Pair> pairs = new ArrayList<Pair>();
					pairs.add(new Pair(i, j));
					map.put(key, pairs);
				}
			}
		}
		for (int i = 0; i < n - 1; i++) {
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			for (int j = i + 1; j < n; j++) {
				if (j > i + 1 && nums[j] == nums[j - 1])
					continue;
				int sum = target - (nums[i] + nums[j]);
				if (map.containsKey(sum)) {
					List<Pair> pairs = map.get(sum);
					for (Pair pair : pairs) {
						int k = pair.i;
						int l = pair.j;
						if (k > j) {
							if (!res.isEmpty()) {
								List<Integer> list = res.get(res.size() - 1);
								if (list.get(0) == nums[i] && list.get(1) == nums[j] && list.get(2) == nums[k]
										&& list.get(3) == nums[l])
									continue;
								List<Integer> list1 = new ArrayList<Integer>();
								list1.add(nums[i]);
								list1.add(nums[j]);
								list1.add(nums[k]);
								list1.add(nums[l]);
								res.add(list1);
							} else {
								List<Integer> list1 = new ArrayList<Integer>();
								list1.add(nums[i]);
								list1.add(nums[j]);
								list1.add(nums[k]);
								list1.add(nums[l]);
								res.add(list1);
							}
						}
					}
				}
			}
		}
		return res;
	}

	public static List<List<Integer>> fourSumUsingSet(int[] nums, int target) {
		Arrays.sort(nums);
		int n = nums.length;
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		HashSet<List<Integer>> set = new HashSet<List<Integer>>();
		for (int i = 0; i < n - 3; i++) {
			for (int j = i + 1; j < n - 2; j++) {
				int l = j + 1;
				int r = n - 1;
				while (l < r) {
					int sum = nums[i] + nums[j] + nums[l] + nums[r];
					if (sum == target) {
						List<Integer> a = new ArrayList<Integer>();
						a.add(nums[i]);
						a.add(nums[j]);
						a.add(nums[l]);
						a.add(nums[r]);
						set.add(a);
						l++;
					} else if (sum > target) {
						r--;
					} else {
						l++;
					}
				}
			}
		}
		Iterator<List<Integer>> itr = set.iterator();
		while (itr.hasNext()) {
			res.add(itr.next());
		}
		return res;

	}
}

class Pair {
	public int i;
	public int j;

	public Pair(int i, int j) {
		super();
		this.i = i;
		this.j = j;
	}

}
