/**
 * 
 */
package miscellaneous;

import java.util.ArrayList;
import java.util.List;

/**
 * @author PRATAP LeetCode 78
 *
 */
public class Subsets {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 2, 3 };
		List<List<Integer>> list = subsets(nums);
		System.out.println(list);
	}

	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		solve(nums, list, 0, "");
		return list;
	}

	private static void solve(int[] nums, List<List<Integer>> list, int i, String str) {
		// TODO Auto-generated method stub
		if (i == nums.length) {
			List<Integer> l = new ArrayList<Integer>();
			if (str.length() <= 0) {
				list.add(l);
				return;
			}
			String[] buff = str.split("\\s+");
			for (String s : buff) {
				l.add(Integer.parseInt(s));
			}
			list.add(l);
			return;
		}
		solve(nums, list, i + 1, str + nums[i] + " ");
		solve(nums, list, i + 1, str);
	}

}
