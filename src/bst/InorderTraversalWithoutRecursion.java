/**
 * 
 */
package bst;

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
public class InorderTraversalWithoutRecursion {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split("\\s+");
		int[] arr = new int[input.length];
		int p = 0;
		TreeNode root = null;
		for (String s : input) {
			arr[p++] = Integer.parseInt(s);
			root = Utility.createBST(root, arr[p - 1]);
		}
		ArrayList<Integer> list = inorderWithoutRecursion(root);
		System.out.println(list);
	}

	public static ArrayList<Integer> inorderWithoutRecursion(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (root == null)
			return list;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode curr = root;
		while (curr != null || !stack.isEmpty()) {
			while (curr != null) {
				stack.add(curr);
				curr = curr.left;
			}
			curr = stack.pop();
			list.add(curr.data);
			curr = curr.right;
		}
		return list;
	}
}
