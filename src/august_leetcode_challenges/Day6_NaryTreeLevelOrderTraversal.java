/**
 * 
 */
package august_leetcode_challenges;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author PRATAP LeetCode 429
 *
 */
public class Day6_NaryTreeLevelOrderTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> levelOrder(Node root) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		if (root == null)
			return ans;
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while (!q.isEmpty()) {
			int size = q.size();
			List<Integer> list = new ArrayList<Integer>();
			while (size-- > 0) {
				Node curr = q.poll();
				list.add(curr.val);
				for (Node node : curr.children) {
					q.add(node);
				}
			}
			ans.add(list);
		}
		return ans;
	}
}

class Node {
	public int val;
	public List<Node> children;

	public Node() {
	}

	public Node(int _val) {
		val = _val;
	}

	public Node(int _val, List<Node> _children) {
		val = _val;
		children = _children;
	}
}
