/**
 * 
 */
package binarytrees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

import entities.TreeNode;
import util.Utility;

/**
 * @author PRATAP
 *
 */
public class InorderTraversalIterative {

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
			ArrayList<Integer> list = inOrder(root);
			System.out.println(list);
		}
	}

	static ArrayList<Integer> inOrder(TreeNode root) {
		// Code
		ArrayList<Integer> ans = new ArrayList<Integer>();
		Stack<Hits> stack = new Stack<Hits>();
		stack.push(new Hits(root, 1));
		while (!stack.isEmpty()) {
			Hits curr = stack.peek();
			if (curr.node.left != null && curr.hit == 1) {
				curr.hit++;
				stack.push(new Hits(curr.node.left, 1));
			} else {
				curr = stack.pop();
				ans.add(curr.node.data);
				if (curr.node.right != null) {
					stack.push(new Hits(curr.node.right, 1));
				}
			}
		}
		return ans;
	}
}

class Hits {
	public TreeNode node;
	public int hit;

	public Hits(TreeNode node, int hit) {
		super();
		this.node = node;
		this.hit = hit;
	}

}
