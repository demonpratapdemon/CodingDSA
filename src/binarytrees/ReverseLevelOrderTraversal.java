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
import java.util.Stack;

import entities.TreeNode;
import util.Utility;

/**
 * @author PRATAP
 *
 */
public class ReverseLevelOrderTraversal {

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
			ArrayList<Integer> list = reverseLevelOrder(root);
			StringBuilder sb = new StringBuilder();
			for (int i : list)
				sb.append(i + " ");
			System.out.println(sb.toString());
		}
	}

	public static ArrayList<Integer> reverseLevelOrder(TreeNode node) {
		// code here
		ArrayList<Integer> ans = new ArrayList<Integer>();
		if (node == null)
			return ans;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(node);
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (!q.isEmpty()) {
			TreeNode curr = q.remove();
			stack.add(curr);
			if (curr.right != null)
				q.add(curr.right);
			if (curr.left != null)
				q.add(curr.left);
		}
		while(!stack.isEmpty())
			ans.add(stack.pop().data);
		return ans;
	}

}
