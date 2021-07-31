/**
 * 
 */
package binarytrees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import entities.TreeNode;
import util.Utility;

/**
 * @author PRATAP LeetCode 145
 *
 */
public class MorrisPostorderTraversal {

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
			List<Integer> list = postorderTraversal(root);
			System.out.println(list);
		}
	}

	public static List<Integer> postorderTraversal(TreeNode root) {
		Deque<Integer> res = new LinkedList<Integer>();
		morrisPostTraversal(root, res);
		return new ArrayList<Integer>(res);
	}

	private static void morrisPostTraversal(TreeNode root, Deque<Integer> res) {
		// TODO Auto-generated method stub
		TreeNode curr = root;
		TreeNode p = null;
		while (curr != null) {
			if (curr.right != null) {
				p = curr.right;
				while (p.left != null && p.left != curr) {
					p = p.left;
				}
				if (p.left == null) {
					p.left = curr;
					res.addFirst(curr.data);
					curr = curr.right;
				} else {
					p.left = null;
					curr = curr.left;
				}
			} else {
				res.addFirst(curr.data);
				curr = curr.left;
			}
		}
	}
}
