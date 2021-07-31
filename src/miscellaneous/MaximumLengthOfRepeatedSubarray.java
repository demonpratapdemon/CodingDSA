/**
 * 
 */
package miscellaneous;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author PRATAP LeetCode 718
 *
 */
public class MaximumLengthOfRepeatedSubarray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] nums1 = { 1, 2, 3, 2, 1 }, nums2 = { 3, 2, 1, 4, 7 };
//		int[] nums1 = { 0, 1, 1, 1, 1 }, nums2 = { 1, 0, 1, 0, 1 };
//		int[] nums1 = { 1, 2 }, nums2 = { 1, 2, 3 };
//		int[] nums1 = { 0, 0, 0, 0, 1 }, nums2 = { 1, 0, 0, 0, 0 };
//		int[] nums1 = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
//				0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
//				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
//				nums2 = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
//						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
//						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0,
//						0, 0, 0, 0, 0 };
		int[] nums1 = { 1, 0, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 1,
				1, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0,
				0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0 },
				nums2 = { 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1,
						0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0,
						0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0,
						0, 1, 1, 0, 0 };
		int ans = findLength(nums1, nums2);
		System.out.println("ans=" + ans);
	}

	public static int findLength(int[] nums1, int[] nums2) {
		if (nums1.length > nums2.length)
			return findLength(nums2, nums1);
		int lo = 0;
		int hi = nums1.length;
		int ans = -1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (rollingHashing(nums1, nums2, mid)) {
				ans = mid;
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}
		return ans;
	}

	private static boolean rollingHashing(int[] nums1, int[] nums2, int mid) {
		// TODO Auto-generated method stub
		boolean flag = false;
		long hash1 = 0, hash2 = 0;
		long base = 1009;
		long power = 1;
		long mod = (long) (1e9 + 9);
		int i = 0;
		for (; i < mid; i++) {
			hash1 = (hash1 * base + (nums1[i])) % mod;
			hash2 = (hash2 * base + (nums2[i])) % mod;
			power = (power * base) % mod;
		}
		HashMap<Long, LinkedList<Integer>> map = new HashMap<Long, LinkedList<Integer>>();
		LinkedList<Integer> ll = new LinkedList<Integer>();
		ll.add(i - mid);
		map.put(hash1, ll);
		int j = i;
		for (; i < nums1.length; i++) {
			hash1 = ((hash1 * base + ((nums1[i]))) % mod - (((nums1[i - mid])) * power) % mod + mod) % mod;
			if (!map.containsKey(hash1)) {
				LinkedList<Integer> curr = new LinkedList<Integer>();
				curr.addFirst(i - mid + 1);
				map.put(hash1, curr);
			} else {
				map.get(hash1).add(i - mid + 1);
			}
		}
		while (j < nums2.length) {
			if (map.containsKey(hash2)) {
				LinkedList<Integer> indices = map.get(hash2);
				boolean check = checkNos(nums1, nums2, indices, mid, j - mid);
				if (check) {
					flag = true;
					break;
				}
			}
			hash2 = ((hash2 * base + ((nums2[j]))) % mod - (((nums2[j - mid])) * power) % mod + mod) % mod;
			j++;
		}
		if (map.containsKey(hash2)) {
			LinkedList<Integer> indices = map.get(hash2);
			boolean check = checkNos(nums1, nums2, indices, mid, j - mid);
			if (check) {
				flag = true;
			}
		}
		return flag;
	}

	private static boolean checkNos(int[] nums1, int[] nums2, LinkedList<Integer> indices, int mid, int j) {
		// TODO Auto-generated method stub
		while (!indices.isEmpty()) {
			int idx1 = indices.pollFirst();
			int k = j;
			for (int i = idx1; i < idx1 + mid; i++) {
				if (nums1[i] != nums2[k++])
					return false;
			}
		}
		return true;
	}

}
