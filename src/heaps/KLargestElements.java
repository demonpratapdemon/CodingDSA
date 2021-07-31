/**
 * 
 */
package heaps;

import java.util.PriorityQueue;

/**
 * @author PRATAP
 *
 */
public class KLargestElements {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 2, 3, 4, 5, 6 };
		int[] ans = kLargest(arr, arr.length, 3);
		for (int i : ans)
			System.out.print(i + " ");
	}

	public static int[] kLargest(int[] arr, int n, int k) {
		// code here
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(3);
		for (int i = 0; i < k; i++) {
			minHeap.add(arr[i]);
		}
		for (int i = k; i < n; i++) {
			if (minHeap.peek() < arr[i]) {
				minHeap.remove();
				minHeap.add(arr[i]);
			}
		}
		int[] ans = new int[k];
		for (int i = k - 1; i >= 0; i--) {
			ans[i] = minHeap.poll();
		}
		return ans;
	}

}
