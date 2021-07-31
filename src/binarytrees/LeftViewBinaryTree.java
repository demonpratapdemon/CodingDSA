/**
 * 
 */
package binarytrees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import entities.TreeNode;
import util.Utility;

/**
 * @author PRATAP
 *
 */
public class LeftViewBinaryTree {

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
			ArrayList<Integer> list = leftView(root);
			StringBuilder sb = new StringBuilder();
			for (int i : list)
				sb.append(i + " ");
			System.out.println(sb.toString());
		}
	}

	public static ArrayList<Integer> leftView(TreeNode root) {
		// Your code here
		ArrayList<LNPair> ans = new ArrayList<LNPair>();
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (root == null)
			return res;
		Queue<LNPair> q = new LinkedList<LNPair>();
		int level = 0;
		q.add(new LNPair(root, level));
		while (!q.isEmpty()) {
			LNPair curr = q.remove();
			if (ans.size() > 0 && ans.get(ans.size() - 1).level != curr.level) {
				ans.add(curr);
			} else if (ans.size() == 0) {
				ans.add(curr);
			}
			int currLevel = curr.level;
			if (curr.node.left != null) {
				q.add(new LNPair(curr.node.left, currLevel + 1));
			}
			if (curr.node.right != null) {
				q.add(new LNPair(curr.node.right, currLevel + 1));
			}
		}
		for (LNPair node : ans) {
			res.add(node.node.data);
//			System.out.print(node.node.data + " ");
		}
		return res;
	}
}

class LNPair {
	public TreeNode node;
	public int level;

	public LNPair(TreeNode node, int level) {
		super();
		this.node = node;
		this.level = level;
	}
}
