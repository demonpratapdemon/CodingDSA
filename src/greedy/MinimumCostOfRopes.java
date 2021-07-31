/**
 * 
 */
package greedy;

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
		int n = 4;
		long arr[] = { 4, 3, 2, 6 };
		long ans = minCost(arr, n);
		System.out.println(ans);
	}

	public static long minCost(long arr[], int n) {
		// your code here
		if (n <= 1)
			return 0;
		PriorityQueue<Long> pq = new PriorityQueue<Long>();
		for (long i : arr)
			pq.add(i);
		long cost = 0;
		while (!pq.isEmpty()) {
			long x = pq.poll();
			if (pq.size() <= 0)
				break;
			long y = pq.poll();
			cost += x + y;
			if (pq.size() > 0) {
				pq.add(x + y);
			}
		}
		return cost;
	}

}
