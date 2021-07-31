/**
 * 
 */
package arrays;

import java.util.Arrays;

/**
 * @author PRATAP GAP Algorithm Intuition - Shell sort where a few successive
 *         elements are sorted
 *
 */
public class MergeWithoutExtraSpace {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = { 7, 9, 9, 10, 11, 11, 13, 14, 17, 19 };
		int[] arr2 = { 1, 1, 4, 5, 8, 11, 13, 16, 19, 19 };
		merge2(arr1, arr2, arr1.length, arr2.length);
	}

	public static void merge(int arr1[], int arr2[], int n, int m) {
		// code here
		if (n > m) {
			merge(arr2, arr1, m, n);
		}
		int i = 0, j = 0;
		while ((i < n) && (j < m)) {
			if (arr1[i] >= arr2[j]) {
				int temp = arr1[i];
				arr1[i] = arr2[j];
				arr2[j] = temp;
				i++;
				Arrays.sort(arr2);
			} else {
				i++;
			}
		}
		for (int k : arr1)
			System.out.print(k + " ");
		for (int k : arr2)
			System.out.print(k + " ");
	}

	public static void merge2(int arr1[], int arr2[], int n, int m) {
		// code here
		Double gap = Math.ceil((n + m) / 2);
		Double prevGap = 0.0;
		while (gap > 0 && Double.compare(prevGap, gap) != 0) {
			int i = 0;
			int j = i + gap.intValue();
			while (j < n) {
				if (arr1[i] > arr1[j]) {
					swap(arr1, i, j);
				}
				i++;
				j++;
			}
			j = 0;
			while ((i < n) && (j < m)) {
				if (arr1[i] > arr2[j]) {
					int temp = arr1[i];
					arr1[i] = arr2[j];
					arr2[j] = temp;
				}
				i++;
				j++;
			}
			if (i >= n && j < m) {
				i = 0;
			}
			while (i < j && j < m) {
				if (arr2[i] > arr2[j]) {
					swap(arr2, i, j);
				}
				i++;
				j++;
			}
			prevGap = gap;
			gap = Math.ceil(gap / 2);
			System.out.println("previous gap =" + prevGap + " gap =" + gap);
		}
		for (int k : arr1)
			System.out.print(k + " ");
		for (int k : arr2)
			System.out.print(k + " ");

	}

	private static void swap(int[] arr, int i, int j) {
		// TODO Auto-generated method stub
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
