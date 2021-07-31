/**
 * 
 */
package heaps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author PRATAP
 *
 */
public class HeapSort {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split("\\s+");
		int[] arr = new int[input.length];
		int p = 0;
		for (String in : input)
			arr[p++] = Integer.parseInt(in);
		heapSort(arr, arr.length);
		for (int a : arr)
			System.out.print(a + " ");
	}

	private static void heapSort(int[] arr, int n) {
		// TODO Auto-generated method stub
		buildMaxHeap(arr, n);
		int k = n - 1;
		for (int i = 0; i < n; i++) {
			swap(arr, 0, k);
			k--;
			maxHeapify(arr, 0, k);
		}
	}

	private static void maxHeapify(int[] arr, int i, int k) {
		// TODO Auto-generated method stub
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		int max = i;
		if (r <= k) {
			if (arr[l] > arr[i]) {
				max = l;
			}
			if (arr[r] > arr[max]) {
				max = r;
			}
			swap(arr, i, max);
			maxHeapify(arr, max, k);
		} else if (l <= k) {
			if (arr[l] > arr[i]) {
				swap(arr, l, i);
			}
		}
	}

	private static void buildMaxHeap(int[] arr, int n) {
		// TODO Auto-generated method stub
		for (int i = 1; i < n; i++) {
			bottomUpHeapify(arr, i);
		}
	}

	private static void bottomUpHeapify(int[] arr, int i) {
		// TODO Auto-generated method stub
		int p = (i - 1) / 2;
		while (p >= 0) {
			if (arr[i] > arr[p]) {
				swap(arr, i, p);
				i = p;
				p = (p - 1) / 2;
			} else {
				break;
			}
		}
	}

	private static void swap(int[] arr, int i, int p) {
		// TODO Auto-generated method stub
		int temp = arr[i];
		arr[i] = arr[p];
		arr[p] = temp;
	}

}
