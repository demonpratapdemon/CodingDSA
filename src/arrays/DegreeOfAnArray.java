/**
 * 
 */
package arrays;

import java.util.HashMap;

/**
 * @author PRATAP LeetCode 697
 *
 */
public class DegreeOfAnArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 2, 2, 3, 1, 4, 2 };
		DegreeOfAnArray obj = new DegreeOfAnArray();
		int ans = obj.findShortestSubArray(nums);
		System.out.println(ans);
	}

	public int findShortestSubArray(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int degree = 0;
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
			if (map.get(nums[i]) > degree) {
				degree = map.get(nums[i]);
			}
		}
		if (degree == 1)
			return 1;
		HashMap<Integer, String> map1 = new HashMap<Integer, String>();
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			if (map1.containsKey(nums[i])) {
				String[] val = map1.get(nums[i]).split("#");
				if (Integer.parseInt(val[0]) + 1 == degree) {
					ans = Math.min(ans, i - Integer.parseInt(val[1]) + 1);
				} else {
					val[0] = String.valueOf(Integer.parseInt(val[0]) + 1);
					map1.put(nums[i], val[0] + "#" + val[1]);

				}
			} else {
				map1.put(nums[i], String.valueOf(1) + "#" + String.valueOf(i));
			}
		}
		return ans;
	}
}
