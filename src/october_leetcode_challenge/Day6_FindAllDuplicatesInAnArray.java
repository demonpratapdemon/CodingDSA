/**
 * 
 */
package october_leetcode_challenge;

import java.util.ArrayList;
import java.util.List;

/**
 * @author PRATAP LeetCode 442
 *
 */
public class Day6_FindAllDuplicatesInAnArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
		Day6_FindAllDuplicatesInAnArray obj = new Day6_FindAllDuplicatesInAnArray();
		List<Integer> ans = obj.findDuplicates(nums);
		System.out.println(ans);
	}

	public List<Integer> findDuplicates(int[] nums) {
		List<Integer> res = new ArrayList<Integer>();
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			int idx = Math.abs(nums[i]) - 1;
			if (nums[idx] < 0) {
				res.add(idx + 1);
			} else {
				nums[idx] = -nums[idx];
			}
		}
		return res;
	}
}
