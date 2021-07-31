/**
 * 
 */
package problem_of_the_day;

import java.util.HashMap;

/**
 * @author PRATAP
 *
 */
public class SubarraysWithSumK {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 5, Arr[] = { 10, 2, -2, -20, 10 }, k = -10;
		int ans = findSubArraySum(Arr, N, k);
		System.out.println(ans);
	}

	static int findSubArraySum(int nums[], int N, int k) {
		// code here
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int prefix = 0;
		map.put(0, 1);
		int count = 0;
		for (int i = 0; i < N; i++) {
			prefix += nums[i];
			int rem = prefix - k;
			if (map.containsKey(rem))
				count += map.get(rem);
			map.put(prefix, map.getOrDefault(prefix, 0) + 1);
		}
		return count;
	}

}
