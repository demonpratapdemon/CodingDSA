/**
 * 
 */
package arrays;

import java.util.PriorityQueue;

/**
 * @author PRATAP
 *
 */
public class MinimumOpsForContinuousArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 12, 8, 1, 4, 14, 15, 7 };
		int ans = findMinOps(arr);
		System.out.println(ans);
	}

	private static int findMinOps(int[] arr) {
		// TODO Auto-generated method stub
		int n = arr.length;
		if (n <= 0)
			return 0;
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		for (int i = 0; i < n; i++)
			minHeap.add(arr[i]);
		int minOps = 0, lastMin = minHeap.poll();
		while (!minHeap.isEmpty()) {
			int curr = minHeap.poll();
			while (curr - lastMin == 0 && minHeap.size() > 0) {
				minHeap.add(minHeap.peek() + 1);
				curr = minHeap.poll();
				minOps++;
			}
			if (curr - lastMin > 1) {
				int newEle = curr + 1;
				minOps++;
				lastMin = curr;
				minHeap.add(newEle);
			} else {
				lastMin = curr;
			}
		}
		return minOps;
	}

}
