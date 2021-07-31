/**
 * 
 */
package search_sort;

import java.util.HashMap;

/**
 * @author PRATAP
 *
 */
public class LargestSubarrayWithSum0 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 15, -2, 2, -8, 1, 7, 10, 23 };
		int n = arr.length;
		int maxLength = maxLen(arr, n);
		System.out.println(maxLength);
	}

	public static int maxLen(int arr[], int n) {
		// Your code here
		HashMap<Long, Pair> map = new HashMap<Long, Pair>();
		long prefix = 0;
		map.put(prefix, new Pair(1, -1));
		int max = 0;
		for (int i = 0; i < n; i++) {
			prefix += arr[i];
			if (map.containsKey(prefix)) {
				int old = map.get(prefix).pos;
				max = Math.max(max, i - old);
			} else {
				map.put(prefix, new Pair(1, i));
			}
		}
		return max;
	}

}

class Pair {
	public int freq;
	public int pos;

	public Pair(int freq, int pos) {
		this.freq = freq;
		this.pos = pos;
	}
}