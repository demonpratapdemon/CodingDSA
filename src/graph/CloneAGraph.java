/**
 * 
 */
package graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author PRATAP LeetCode 133
 *
 */
public class CloneAGraph {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public Node cloneGraph(Node node) {
		if (node == null)
			return null;
		Node[] visited = new Node[1000];
		Node newNode = new Node(node.val);
		visited[node.val] = newNode;
		for (Node ele : node.neighbors) {
			if (visited[ele.val] == null) {
				Node curr = new Node(ele.val);
				newNode.neighbors.add(curr);
				dfs(ele, curr, visited);
			} else {
				newNode.neighbors.add(visited[ele.val]);
			}
		}
		return newNode;
	}

	// Node ele -> old Node which contains the neighbors
	// Node curr ->  newly created node where we have to add the neighbors
	public void dfs(Node ele, Node curr, Node[] visited) {
		visited[curr.val] = curr;
		for (Node eles : ele.neighbors) {
			if (visited[eles.val] == null) {
				Node newNode = new Node(eles.val);
				curr.neighbors.add(newNode);
				dfs(eles, newNode, visited);
			} else {
				curr.neighbors.add(visited[eles.val]);
			}
		}
	}
}

class Node {
	public int val;
	public List<Node> neighbors;

	public Node() {
		val = 0;
		neighbors = new ArrayList<Node>();
	}

	public Node(int _val) {
		val = _val;
		neighbors = new ArrayList<Node>();
	}

	public Node(int _val, ArrayList<Node> _neighbors) {
		val = _val;
		neighbors = _neighbors;
	}
}
