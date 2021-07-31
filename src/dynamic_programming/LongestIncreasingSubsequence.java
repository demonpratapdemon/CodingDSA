/**
 * 
 */
package dynamic_programming;

import java.util.Arrays;

/**
 * @author PRATAP LeetCode 300
 *
 */
public class LongestIncreasingSubsequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 5, 8, 3, 7, 9, 1 };
//		int longSeq = longestSubsequence(arr.length, arr);
		int longSeq = longestSubSeq(arr.length, arr);
		System.out.println(longSeq);
	}

//	O(n^2)
	static int longestSubsequence(int size, int arr[]) {
		// code here
		if (size == 0)
			return 0;
		if (size == 1)
			return 1;
		int[] dp = new int[size];
		dp[0] = 1;
		int max = 1;
		for (int i = 1; i < size; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i] && dp[j] + 1 > dp[i]) {
					dp[i] = dp[j] + 1;
				}
			}
			if (dp[i] == 0)
				dp[i] = 1;
			max = Math.max(max, dp[i]);
		}
		return max;
	}

	public static int longestSubSeq(int size, int[] arr) {
		if (size == 0)
			return 0;
		if (size == 1)
			return 1;
		int[] dp = new int[size + 1];
		dp[0] = Integer.MIN_VALUE;
		for (int i = 1; i <= size; i++)
			dp[i] = Integer.MAX_VALUE;
		for (int i = 0; i < size; i++) {
			int pos = Arrays.binarySearch(dp, arr[i]);
			if (pos < 0) {
				pos = Math.abs(pos) - 1;
				dp[pos] = arr[i];
			} else {
				dp[pos] = arr[i];
			}
		}
		int max = 0;
		for (int i = size; i >= 0; i--) {
			if (dp[i] != Integer.MAX_VALUE) {
				max = i;
				break;
			}
		}
		return max;
	}

}
