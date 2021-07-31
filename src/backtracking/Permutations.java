/**
 * 
 */
package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author PRATAP LeetCode 46
 *
 */
public class Permutations {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 0, 1 };
		permute(nums);
	}

	public static List<List<Integer>> permute(int[] nums) {
		int[] boxes = new int[nums.length];
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		for (int i = 0; i < boxes.length; i++)
			boxes[i] = -1;
		solve(nums, boxes, 0, res);
		return res;
	}

	private static void solve(int[] nums, int[] boxes, int ci, List<List<Integer>> res) {
		// TODO Auto-generated method stub
		if (ci >= nums.length) {
			List<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < boxes.length; i++) {
//				System.out.print(boxes[i] + " ");
				list.add(boxes[i]);
			}
			res.add(list);
//			System.out.println();
			return;
		}
		for (int i = 0; i < boxes.length; i++) {
			if (boxes[i] == -1) {
				boxes[i] = nums[ci];
				solve(nums, boxes, ci + 1, res);
				boxes[i] = -1;
			}
		}
	}

}
