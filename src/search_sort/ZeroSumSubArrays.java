/**
 * 
 */
package search_sort;

import java.util.HashMap;

/**
 * @author PRATAP
 *
 */
public class ZeroSumSubArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long[] arr = { 0, 0, 5, 5, 0, 0 };
		long ans = findSubarray(arr, arr.length);
		System.out.println(ans);
	}

	public static long findSubarray(long[] arr, int n) {
		// Your code here
		HashMap<Long, Integer> map = new HashMap<Long, Integer>();
		long count = 0, prefix = 0;
		map.put(prefix, 1);
		for (int i = 0; i < n; i++) {
			prefix += arr[i];
			if (map.containsKey(prefix)) {
				count += map.get(prefix);
				map.put(prefix, map.get(prefix) + 1);
			} else
				map.put(prefix, 1);
		}
		return count;
	}
}
