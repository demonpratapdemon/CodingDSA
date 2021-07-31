/**
 * 
 */
package binarytrees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import entities.TreeNode;
import util.Utility;

/**
 * @author PRATAP LeetCode 199
 *
 */
public class RightViewBinaryTree {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String[] input = br.readLine().split("\\s+");
			TreeNode root = Utility.createBinaryTree(input);
			List<Integer> list = rightSideView(root);
			StringBuilder sb = new StringBuilder();
			for (int i : list)
				sb.append(i + " ");
			System.out.println(sb.toString());
		}
	}

	public static List<Integer> rightSideView(TreeNode root) {
		List<RNode> list = new ArrayList<RNode>();
		List<Integer> res = new ArrayList<Integer>();
		if (root == null)
			return res;
		Queue<RNode> q = new LinkedList<RNode>();
		q.add(new RNode(root, 0));
		while (!q.isEmpty()) {
			RNode curr = q.remove();
			if (list.size() == 0) {
				list.add(curr);
			} else if (list.size() > 0 && list.get(list.size() - 1).level != curr.level) {
				list.add(curr);
			}
			if (curr.node.right != null) {
				q.add(new RNode(curr.node.right, curr.level + 1));
			}
			if (curr.node.left != null) {
				q.add(new RNode(curr.node.left, curr.level + 1));
			}
		}

		for (RNode node : list)
			res.add(node.node.data);
		return res;
	}
}

class RNode {
	public TreeNode node;
	public int level;

	public RNode(TreeNode node, int level) {
		super();
		this.node = node;
		this.level = level;
	}

}
