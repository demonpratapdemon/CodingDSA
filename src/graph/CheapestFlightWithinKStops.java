/**
 * 
 */
package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author PRATAP LeetCode 787
 *
 */
public class CheapestFlightWithinKStops {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int n = 3, flights[][] = { { 0, 1, 100 }, { 1, 2, 100 }, { 0, 2, 500 } }, src = 0, dst = 2, k = 1;
//		int n = 3, flights[][] = { { 0, 1, 100 }, { 1, 2, 100 }, { 0, 2, 500 } }, src = 0, dst = 2, k = 0;
		int n = 4, flights[][] = { { 0, 1, 1 }, { 0, 2, 5 }, { 1, 2, 1 }, { 2, 3, 1 } }, src = 0, dst = 3, k = 1;
		CheapestFlightWithinKStops obj = new CheapestFlightWithinKStops();
		int ans = obj.findCheapestPrice(n, flights, src, dst, k);
		System.out.println(ans);
	}

	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
		Map<Integer, List<DKNode>> adj = new HashMap<Integer, List<DKNode>>();
		for (int i = 0; i < n; i++) {
			adj.put(i, new ArrayList<DKNode>());
		}
		for (int i = 0; i < flights.length; i++) {
			int from = flights[i][0];
			int to = flights[i][1];
			int cost = flights[i][2];
			List<DKNode> list = adj.get(from);
			list.add(new DKNode(to, cost, 0));
			adj.put(from, list);
		}

		Queue<DKNode> pq = new PriorityQueue<DKNode>(new DKNodeComp());
		pq.add(new DKNode(src, 0, 0));
		int[] costArr = new int[n];
		int[] stops = new int[n];
		Arrays.fill(costArr, Integer.MAX_VALUE);
		Arrays.fill(stops, Integer.MAX_VALUE);
		costArr[src] = 0;
		stops[src] = 0;
		while (!pq.isEmpty()) {
			DKNode curr = pq.poll();
			int currCity = curr.source;
			int currCost = curr.cost;
			int stop = curr.stops;
			if (stop > k + 1)
				continue;
			if (currCity == dst)
				return currCost;
			for (DKNode node : adj.get(currCity)) {
				if (costArr[node.source] > currCost + node.cost || stops[node.source] > stop + 1) {
					stops[node.source] = stop + 1;
					costArr[node.source] = currCost + node.cost;
					pq.add(new DKNode(node.source, currCost + node.cost, stop + 1));
				}
			}
		}
		return -1;
	}

}

class DKNode {
	public int source;
	public int cost;
	public int stops;

	public DKNode(int source, int cost, int stops) {
		super();
		this.source = source;
		this.cost = cost;
		this.stops = stops;
	}

}

class DKNodeComp implements Comparator<DKNode> {
	@Override
	public int compare(DKNode o1, DKNode o2) {
		return Integer.compare(o1.cost, o2.cost);
	}
}