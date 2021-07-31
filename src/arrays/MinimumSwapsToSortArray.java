/**
 * 
 */
package arrays;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author PRATAP
 *
 */
public class MinimumSwapsToSortArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 7, 16, 14, 17, 6, 9, 5, 3, 18 };
		System.out.println(minSwaps(nums));
	}

	public static int minSwaps(int nums[]) {
		// Code here
		int swaps = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		Object[] sorted = map.keySet().toArray();
		Arrays.sort(sorted);
		for (int i = 0; i < nums.length; i++) {
			if ((int) sorted[i] != nums[i]) {
				swaps++;
				int actPos = map.get(sorted[i]);
				int temp = nums[i];
				nums[i] = (int) sorted[i];
				nums[actPos] = temp;
				map.put(temp, actPos);
				map.put((int) sorted[i], i);
			}
		}
		return swaps;
	}

}
