/**
 * 
 */
package arrays;

import java.util.HashMap;

/**
 * @author PRATAP
 *
 */
public class CountPairsWithGivenSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 4, K = 2, arr[] = { 1, 1, 1, 1 };
		int ans = getPairsCount(arr, N, K);
		System.out.println(ans);
	}

	public static int getPairsCount(int[] arr, int n, int k) {
		// code here
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i : arr)
			map.put(i, map.getOrDefault(i, 0) + 1);
		int count = 0;
		for (Integer key : map.keySet()) {
			int reqd = k - key;
			if (map.containsKey(reqd) && reqd != key) {
				count += map.get(key) * map.get(reqd);
				map.put(key, 0);
				map.put(reqd, 0);
			} else if (map.containsKey(key) && reqd == key) {
				int sum = 0;
				for (int i = 1; i <= map.get(key); i++) {
					sum += map.get(key) - i;
				}
				count += sum;
				map.put(key, 0);
				map.put(reqd, 0);
			}
		}
		return count;
	}

}
