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
		int[] nums = { 1, 1, 1 };
		int k = 2;
		int ans = subarraySum(nums, k);
		System.out.println(ans);
	}

	public static int subarraySum(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int prefix = 0;
		map.put(0, 1);
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			prefix += nums[i];
			int rem = (prefix % k + k) % k;
			if (map.containsKey(rem))
				count += map.get(rem);
			map.put(rem, map.getOrDefault(rem, 0) + 1);
		}
		return count;
	}

}
