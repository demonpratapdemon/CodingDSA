/**
 * 
 */
package october_leetcode_challenge;

import java.util.HashMap;

/**
 * @author PRATAP LeetCode 396
 *
 */
public class Day19_NextGreaterElementI {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = { 4, 1, 2 }, nums2 = { 1, 3, 4, 2 };
		Day19_NextGreaterElementI obj = new Day19_NextGreaterElementI();
		int[] ans = obj.nextGreaterElement(nums1, nums2);
		for (int i : ans)
			System.out.print(i + " ");
	}

	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums2.length; i++) {
			map.put(nums2[i], i);
		}
		int n = nums1.length;
		int[] res = new int[n];
		for (int i = 0; i < n; i++) {
			int pos = map.get(nums1[i]);
			if (pos == nums2.length - 1) {
				res[i] = -1;
			} else {
				for (int j = pos + 1; j < nums2.length; j++) {
					if (nums2[j] > nums1[i]) {
						res[i] = nums2[j];
						break;
					}
				}
				if (res[i] == 0)
					res[i] = -1;
			}
		}
		return res;
	}
}
