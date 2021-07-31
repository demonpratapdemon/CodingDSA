/**
 * 
 */
package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author PRATAP
 *
 */
public class ShortestPathUsingAtmostOneCurvedEdge {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static int shortestPath(int n, int m, int a, int b, ArrayList<ArrayList<Integer>> edges) {
		// code here
		ArrayList<ArrayList<GraphNode>> adj = new ArrayList<ArrayList<GraphNode>>();
		ArrayList<CurvedEdges> curves = new ArrayList<CurvedEdges>();
		for (int i = 0; i < n; i++)
			adj.add(new ArrayList<GraphNode>());

		for (int i = 0; i < m; i++) {
			int u = edges.get(i).get(0);
			int v = edges.get(i).get(1);
			int w = edges.get(i).get(2);
			int cw = edges.get(i).get(3);
			adj.get(u).add(new GraphNode(u, v, w));
			adj.get(v).add(new GraphNode(v, u, w));
			curves.add(new CurvedEdges(u, v, cw));
		}

		int[] da = dijkstra(adj, n, a);
		int[] db = dijkstra(adj, n, b);

		int min = da[b];
		for (int i = 0; i < m; i++) {
			int u = curves.get(i).u;
			int v = curves.get(i).v;
			int cw = curves.get(i).cw;
			min = Math.min(min, da[u] + cw + db[v]);
			min = Math.min(min, da[v] + cw + db[u]);
		}
		return min;
	}

	private static int[] dijkstra(ArrayList<ArrayList<GraphNode>> adj, int n, int source) {
		// TODO Auto-generated method stub
		int[] D = new int[n];
		int[] phi = new int[n];
		Arrays.fill(D, Integer.MAX_VALUE);
		D[source] = 0;
		phi[source] = -1;
		PriorityQueue<DKGraphNode> pq = new PriorityQueue<DKGraphNode>(new DKGraphComp());
		DKGraphNode curr = new DKGraphNode(source, 0);
		pq.add(curr);
		DKGraphNode[] added = new DKGraphNode[n];
		added[source] = curr;
		boolean[] visited = new boolean[n];
		while (!pq.isEmpty()) {
			curr = pq.poll();
			visited[curr.source] = true;
			int u = curr.source;
			for (int i = 0; i < adj.get(u).size(); i++) {
				int v = adj.get(u).get(i).v;
				int w = adj.get(u).get(i).w;
				if (!visited[v] && D[v] > D[u] + w) {
					D[v] = D[u] + w;
					phi[v] = u;
					DKGraphNode temp = added[v];
					if (temp != null) {
						pq.remove(temp);
					}
					temp = new DKGraphNode(v, D[u] + w);
					added[v] = temp;
					pq.add(temp);
				}
			}
		}
		return D;
	}
}

class DKGraphComp implements Comparator<DKGraphNode> {

	@Override
	public int compare(DKGraphNode o1, DKGraphNode o2) {
		// TODO Auto-generated method stub
		return Integer.compare(o1.pW, o2.pW);
	}

}

class DKGraphNode {
	public int source;
	public int pW;

	public DKGraphNode(int source, int pW) {
		super();
		this.source = source;
		this.pW = pW;
	}
}

class GraphNode {
	public int u;
	public int v;
	public int w;

	public GraphNode(int u, int v, int w) {
		super();
		this.u = u;
		this.v = v;
		this.w = w;
	}

}

class CurvedEdges {
	public int u;
	public int v;
	public int cw;

	public CurvedEdges(int u, int v, int cw) {
		super();
		this.u = u;
		this.v = v;
		this.cw = cw;
	}

}