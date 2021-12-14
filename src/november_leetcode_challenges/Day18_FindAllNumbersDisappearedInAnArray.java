/**
 * 
 */
package november_leetcode_challenges;

import java.util.ArrayList;
import java.util.List;

/**
 * @author PRATAP LeetCode 448
 *
 */
public class Day18_FindAllNumbersDisappearedInAnArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
		Day18_FindAllNumbersDisappearedInAnArray obj = new Day18_FindAllNumbersDisappearedInAnArray();
		List<Integer> res = obj.findDisappearedNumbers(nums);
		System.out.println(res);
	}

	public List<Integer> findDisappearedNumbers(int[] nums) {
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			int pos = Math.abs(nums[i]) - 1;
			if (nums[pos] > 0) {
				nums[pos] = -nums[pos];
			}
		}
		List<Integer> missingNos = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			if (nums[i] > 0) {
				missingNos.add(i + 1);
			}
		}
		return missingNos;
	}
}
