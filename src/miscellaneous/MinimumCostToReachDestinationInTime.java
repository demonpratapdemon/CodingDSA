/**
 * 
 */
package miscellaneous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author PRATAP
 *
 */
public class MinimumCostToReachDestinationInTime {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int maxTime = 30,
				edges[][] = { { 0, 1, 10 }, { 1, 2, 10 }, { 2, 5, 10 }, { 0, 3, 1 }, { 3, 4, 10 }, { 4, 5, 15 } },
				passingFees[] = { 5, 1, 2, 20, 20, 3 };
//		int maxTime = 100, edges[][] = { { 0, 1, 100 } }, passingFees[] = { 2, 5 };
		MinimumCostToReachDestinationInTime obj = new MinimumCostToReachDestinationInTime();
		int ans = obj.minCost(maxTime, edges, passingFees);
		System.out.println(ans);
	}

	public int minCost(int maxTime, int[][] edges, int[] passingFees) {
		ArrayList<ArrayList<Node>> adj = new ArrayList<ArrayList<Node>>();
		int n = passingFees.length;
		for (int i = 0; i < n; i++)
			adj.add(new ArrayList<Node>());
		for (int i = 0; i < edges.length; i++) {
			int u = edges[i][0];
			int v = edges[i][1];
			int time = edges[i][2];
			adj.get(u).add(new Node(v, time));
			adj.get(v).add(new Node(u, time));
		}
		int[] times = new int[n];
		int[] fees = new int[n];
		Arrays.fill(times, Integer.MAX_VALUE);
		Arrays.fill(fees, Integer.MAX_VALUE);

		PriorityQueue<GraphNode> pq = new PriorityQueue<GraphNode>(
				(o1, o2) -> o1.fees == o2.fees ? o1.time - o2.time : o1.fees - o2.fees);
		pq.add(new GraphNode(0, 0, passingFees[0]));
		fees[0] = passingFees[0];
		times[0] = 0;
		while (!pq.isEmpty()) {
			GraphNode curr = pq.poll();
			for (int i = 0; i < adj.get(curr.node).size(); i++) {
				Node adjacent = adj.get(curr.node).get(i);
				if (times[curr.node] + adjacent.time <= maxTime
						&& (curr.fees + passingFees[adjacent.node] < fees[adjacent.node]
								|| curr.time + adjacent.time < times[adjacent.node])) {
					pq.add(new GraphNode(adjacent.node, curr.time + adjacent.time,
							curr.fees + passingFees[adjacent.node]));
					if (curr.fees + passingFees[adjacent.node] < fees[adjacent.node]) {
						fees[adjacent.node] = curr.fees + passingFees[adjacent.node];
					}
					if (curr.time + adjacent.time < times[adjacent.node]) {
						times[adjacent.node] = curr.time + adjacent.time;
					}
				}
			}
		}
		return fees[n - 1] == Integer.MAX_VALUE ? -1 : fees[n - 1];
	}
}

class GraphComp implements Comparator<GraphNode> {

	@Override
	public int compare(GraphNode o1, GraphNode o2) {
		// TODO Auto-generated method stub
		int c = Integer.compare(o1.fees, o2.fees);
		if (c == 0)
			c = Integer.compare(o1.time, o2.time);
		return c;
	}

}

class GraphNode {
	public int node;
	public int time;
	public int fees;

	public GraphNode(int node, int time, int fees) {
		super();
		this.node = node;
		this.time = time;
		this.fees = fees;
	}
}

class Node {
	public int node;
	public int time;

	public Node(int node, int time) {
		super();
		this.node = node;
		this.time = time;
	}

}
