/**
 * 
 */
package greedy;

import java.util.Arrays;

/**
 * @author PRATAP
 *
 */
public class MaximumSumOfAbsoluteDifferenceOfAnyPermutation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer a[] = { 35, 98, 29, 43, 68, 49, 76, 56, 89, 99, 50, 85, 66, 59, 18, 80, 19, 21, 62, 88, 42, 24 },
				n = a.length;
		int ans = MaxSumDifference(a, n);
		System.out.println(ans);
	}

	public static int MaxSumDifference(Integer[] a, int n) {
		Arrays.sort(a);
		int[] newArr = new int[n];
		int counter = 0;
		int k = 0;
		for (int i = 0, j = n - 1; i <= j;) {
			if (counter % 2 == 0) {
				newArr[k++] = a[i];
				i++;
				counter++;
			} else {
				newArr[k++] = a[j];
				j--;
				counter--;
			}
		}
		int maxSum = 0;
		for (int i = 0; i < n - 1; i++) {
			maxSum += Math.abs(newArr[i] - newArr[i + 1]);
		}
		maxSum += Math.abs(newArr[0] - newArr[n - 1]);
		return maxSum;
	}

}
