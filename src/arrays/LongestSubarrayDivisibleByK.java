/**
 * 
 */
package arrays;

import java.util.HashMap;

/**
 * @author PRATAP
 *
 */
public class LongestSubarrayDivisibleByK {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = { 2, 7, 6, 1, 4, 5 };
		int k = 3;
		int n = A.length;
		LongestSubarrayDivisibleByK obj = new LongestSubarrayDivisibleByK();
		int ans = obj.longSubarrWthSumDivByK(A, n, k);
		System.out.println(ans);
	}

	int longSubarrWthSumDivByK(int a[], int n, int k) {
		// Complete the function
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		// Key = rem
		// Value = pos
		int prefix = 0;
		map.put(0, -1);
		int ans = 0;
		for (int i = 0; i < n; i++) {
			prefix += a[i];
			int rem = prefix % k;
			if (rem < 0) {
				rem += k;
			}
			if (map.containsKey(rem)) {
				ans = Math.max(ans, i - map.get(rem));
			} else {
				map.put(rem, i);
			}
		}
		return ans;
	}
}
