/**
 * 
 */
package binarytrees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import entities.TreeNode;
import util.Utility;

/**
 * @author PRATAP
 *
 */
public class MorrisInorderTraversal {

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
			List<Integer> list = inorderTraversal(root);
			System.out.println(list);
		}
	}

	public static List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		morrisTraversalInorder(root, list);
		return list;
	}

	private static void morrisTraversalInorder(TreeNode root, List<Integer> list) {
		// TODO Auto-generated method stub
		TreeNode curr = root;
		while (curr != null) {
			if (curr.left == null) {
				list.add(curr.data);
				curr = curr.right;
			} else {
				TreeNode pred = findInorderPredecessor(curr, null);
				if (pred != null && pred.right != curr) {
					pred.right = curr;
					curr = curr.left;
				} else if (pred != null) {
					pred.right = null;
					list.add(curr.data);
					curr = curr.right;
				}
			}
		}
	}

	private static TreeNode findInorderPredecessor(TreeNode key, TreeNode pred) {
		// TODO Auto-generated method stub
		pred = key.left;
		while (pred.right != null && pred.right != key) {
			pred = pred.right;
		}
		return pred;
	}
}
