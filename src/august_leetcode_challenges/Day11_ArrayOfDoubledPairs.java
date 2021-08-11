/**
 * 
 */
package august_leetcode_challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author PRATAP LeetCode 954
 *
 */
public class Day11_ArrayOfDoubledPairs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { -33, 0 };
		Day11_ArrayOfDoubledPairs obj = new Day11_ArrayOfDoubledPairs();
		boolean ans = obj.canReorderDoubled(arr);
		System.out.println(ans);
	}

	public boolean canReorderDoubled(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int x : arr) {
			map.put(x, map.getOrDefault(x, 0) + 1);
		}
		Arrays.sort(arr);
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			int x = arr[i];
			int y = 2 * x;
			if (!map.containsKey(x)) {
				continue;
			}
			if (y == x && map.get(y) <= 1)
				return false;
			if (map.containsKey(y)) {
				list.add(x);
				list.add(y);
				map.put(x, map.get(x) - 1);
				if (map.get(x) == 0)
					map.remove(x);
				map.put(y, map.get(y) - 1);
				if (map.get(y) == 0)
					map.remove(y);
			}
		}
		if (list.size() != arr.length)
			return false;
		return true;
	}
}
