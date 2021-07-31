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
 * @author PRATAP Single Source Shortest Path
 *
 */
public class DijkstraSSSP {

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
		}
		int source = Integer.parseInt(br.readLine());
		String shortestPath = dijkstra(adj, source);
		System.out.println(shortestPath);
	}

	private static String dijkstra(ArrayList<ArrayList<GraphNode>> adj, int source) {
		// TODO Auto-generated method stub
		int n = adj.size();
		boolean[] visited = new boolean[n];
		int[] phi = new int[n];
		int[] D = new int[n];
		PriorityQueue<DGraphNode> pq = new PriorityQueue<DGraphNode>(new DGraphComp());
		DGraphNode[] added = new DGraphNode[n];
		for (int i = 0; i < n; i++) {
			phi[i] = -2;
			D[i] = Integer.MAX_VALUE;
		}
		phi[source] = -1;
		D[0] = 0;
		DGraphNode curr = new DGraphNode(source, 0);
		added[source] = curr;
		pq.add(curr);
		StringBuilder sb = new StringBuilder();
		while (!pq.isEmpty()) {
			curr = pq.poll();
			visited[curr.source] = true;
			int u = curr.source;
			sb.append(u).append(" ");
			for (int i = 0; i < adj.get(u).size(); i++) {
				int v = adj.get(u).get(i).v;
				int w = adj.get(u).get(i).w;
				if (!visited[v] && D[v] > D[u] + w) {
					D[v] = D[u] + w;
					phi[v] = u;
					DGraphNode temp = null;
					if (added[v] != null) {
						temp = added[v];
					}
					if (temp != null) {
						pq.remove(temp);
					}
					temp = new DGraphNode(v, D[u] + w);
					added[v] = temp;
					pq.add(temp);
				}
			}
		}
		return sb.toString();
	}

}

class DGraphComp implements Comparator<DGraphNode> {

	@Override
	public int compare(DGraphNode o1, DGraphNode o2) {
		// TODO Auto-generated method stub
		return Integer.compare(o1.pW, o2.pW);
	}

}

class DGraphNode {
	public int source;
	public int pW;

	public DGraphNode(int source, int pW) {
		super();
		this.source = source;
		this.pW = pW;
	}
}
