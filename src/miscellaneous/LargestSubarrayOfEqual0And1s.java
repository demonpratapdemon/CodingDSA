/**
 * 
 */
package miscellaneous;

import java.util.HashMap;

/**
 * @author PRATAP LeetCode 525
 *
 */
public class LargestSubarrayOfEqual0And1s {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int arr[] = { 1, 0, 1, 1, 1, 0, 0 };
		int arr[] = { 0, 0, 1, 0, 0 };
		LargestSubarrayOfEqual0And1s obj = new LargestSubarrayOfEqual0And1s();
		int ans = obj.maxLen(arr, arr.length);
		System.out.println(ans);
	}

	int maxLen(int[] arr, int N) {
		// Your code here
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, -1);
		int sum = 0;
		int ans = 0;
		for (int i = 0; i < N; i++) {
			sum += arr[i] == 0 ? -1 : 1;
			if (map.containsKey(sum)) {
				ans = Math.max(ans, i - map.get(sum));
			} else
				map.put(sum, i);

		}
		return ans;
	}
}
