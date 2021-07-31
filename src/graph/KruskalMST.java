/**
 * 
 */
package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import entities.GraphNode;

/**
 * @author PRATAP Kruskal Algorithm using Disjoint Set
 *
 */
public class KruskalMST {

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int e = Integer.parseInt(br.readLine());
		ArrayList<ArrayList<GraphNode>> adj = new ArrayList<ArrayList<GraphNode>>();
		for (int i = 0; i < n; i++)
			adj.add(new ArrayList<GraphNode>());
		for (int i = 0; i < e; i++) {
			String[] buff = br.readLine().split("\\s+");
			int u = Integer.parseInt(buff[0]);
			int v = Integer.parseInt(buff[1]);
			int w = Integer.parseInt(buff[2]);
			adj.get(u).add(new GraphNode(u, v, w));
			adj.get(v).add(new GraphNode(v, u, w));
		}
		int mst = findKruskalMST(adj);
		System.out.println("Minimum Cost of Spanning Tree = " + mst);
	}

	private static int findKruskalMST(ArrayList<ArrayList<GraphNode>> adj) {
		// TODO Auto-generated method stub
		int n = adj.size();
		int[] parent = new int[n];
		for (int i = 0; i < n; i++)
			parent[i] = i;
		boolean[][] visited = new boolean[n][n];
		PriorityQueue<GraphNode> maxHeap = new PriorityQueue<GraphNode>(new GraphComp());
		for (int i = 0; i < n; i++) {
			ArrayList<GraphNode> list = adj.get(i);
			for (GraphNode node : list) {
				if (!visited[node.u][node.v]) {
					maxHeap.add(node);
					visited[node.u][node.v] = true;
					visited[node.v][node.u] = true;
				}
			}
		}
		int minCost = 0;
		int k = n - 1;
		while (!maxHeap.isEmpty() && k > 0) {
			GraphNode curr = maxHeap.poll();
			int pu = find(curr.u, parent);
			int pv = find(curr.v, parent);
			if (pu != pv) {
				k--;
				minCost += curr.w;
				union(pu, pv, parent);
			}
		}
		if (k > 0) {
			System.out.println("MST Not Possible");
			return -1;
		}
		return minCost;
	}

	private static void union(int pu, int pv, int[] parent) {
		// TODO Auto-generated method stub
		parent[pv] = pu;
	}

	private static int find(int u, int[] parent) {
		// TODO Auto-generated method stub
		if (parent[u] == u)
			return u;
		return find(parent[u], parent);
	}

}

class GraphComp implements Comparator<GraphNode> {

	@Override
	public int compare(GraphNode o1, GraphNode o2) {
		// TODO Auto-generated method stub
		return Integer.compare(o1.w, o2.w);
	}
}