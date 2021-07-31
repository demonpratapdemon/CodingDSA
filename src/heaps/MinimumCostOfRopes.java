/**
 * 
 */
package heaps;

import java.util.PriorityQueue;

/**
 * @author PRATAP
 *
 */
public class MinimumCostOfRopes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long arr[] = { 4, 3, 2, 6 };
		long minCost = minCost(arr, arr.length);
		System.out.println(minCost);
	}

	public static long minCost(long arr[], int n) {
		// your code here
		PriorityQueue<Long> pq = new PriorityQueue<Long>(); // Min Heap 
		for (long item : arr)
			pq.add(item);
		long cost = 0;
		while (pq.size() > 1) {
			long a = pq.poll();
			long b = pq.poll();
			long newRope = a + b;
			cost += newRope;
			pq.add(newRope);
		}
		return cost;
	}
}
