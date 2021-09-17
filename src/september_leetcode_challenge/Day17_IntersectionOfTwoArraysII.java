/**
 * 
 */
package september_leetcode_challenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * @author PRATAP LeetCode 350
 *
 */
public class Day17_IntersectionOfTwoArraysII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = { 4, 9, 5 }, nums2 = { 9, 4, 9, 8, 4 };
		Day17_IntersectionOfTwoArraysII obj = new Day17_IntersectionOfTwoArraysII();
		int[] res = obj.intersect(nums1, nums2);
		for (int i : res)
			System.out.print(i + " ");
	}

	public int[] intersect(int[] nums1, int[] nums2) {
		HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> map2 = new HashMap<Integer, Integer>();
		for (int i : nums1) {
			map1.put(i, map1.getOrDefault(i, 0) + 1);
		}
		for (int i : nums2) {
			map2.put(i, map2.getOrDefault(i, 0) + 1);
		}
		Iterator<Integer> itr = map1.keySet().iterator();
		List<Integer> list = new ArrayList<Integer>();
		while (itr.hasNext()) {
			int num = itr.next();
			if (map2.containsKey(num)) {
				int k = Math.min(map1.get(num), map2.get(num));
				while (k-- > 0)
					list.add(num);
			}
		}
		int n = list.size();
		int[] res = new int[n];
		for (int i = 0; i < n; i++)
			res[i] = list.get(i);
		return res;
	}
}
