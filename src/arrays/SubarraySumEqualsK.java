/**
 * 
 */
package arrays;

import java.util.HashMap;

/**
 * @author PRATAP LeetCode 974
 *
 */
public class SubarraySumEqualsK {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 1, 3, -1 };
		int k = 2;
		int ans = subarraySum(nums, k);
		System.out.println(ans);
	}

	public static int subarraySum(int[] nums, int k) {
		int prefix = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, 1);
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			prefix += nums[i];
			if (map.containsKey(prefix - k)) {
				count += map.get(prefix - k);
			}
			map.put(prefix, map.getOrDefault(prefix, 0) + 1);
		}
		return count;
	}

}
