/**
 * 
 */
package arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * @author PRATAP LeetCode 128
 *
 */
public class LongestConsecutiveSubsequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 9, 3, 10, 4, 20, 2 };
		int ans = findLongestConseqSubseq(arr, arr.length);
		System.out.println(ans);
	}

	static int findLongestConseqSubseq(int arr[], int N) {

		Set<Integer> hs = new HashSet<Integer>();
		for (int i = 0; i < N; i++)
			hs.add(arr[i]);
		int maxLength = 0;
		for (int i = 0; i < N; i++) {
			if (!hs.contains(arr[i] - 1)) {
				int count = 1;
				int x = arr[i];
				x++;
				while (hs.contains(x)) {
					count++;
					x++;
				}
				maxLength = Math.max(maxLength, count);
			}
		}
		return maxLength;
	}

}
