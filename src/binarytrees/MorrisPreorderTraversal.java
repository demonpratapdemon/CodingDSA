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
 * @author PRATAP LeetCode 144
 *
 */
public class MorrisPreorderTraversal {

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String[] input = br.readLine().split("\\s+");
			TreeNode root = Utility.createBinaryTree(input);
			List<Integer> list = preorderTraversal(root);
			System.out.println(list);
		}
	}

	public static List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		morrisPreorderTraversal(root, list);
		return list;
	}

	private static void morrisPreorderTraversal(TreeNode root, List<Integer> list) {
		// TODO Auto-generated method stub
		TreeNode curr = root;
		while (curr != null) {
			if (curr.left == null) {
				list.add(curr.data);
				curr = curr.right;
			} else {
				TreeNode pred = findPred(curr, null);
				if (pred != null && pred.right != curr) {
					pred.right = curr;
					list.add(curr.data);
					curr = curr.left;
				} else if (pred != null) {
					curr = pred.right;
					pred.right = null;
					curr = curr.right;
				}
			}
		}
	}

	private static TreeNode findPred(TreeNode curr, TreeNode pred) {
		// TODO Auto-generated method stub
		pred = curr.left;
		while (pred.right != null && pred.right != curr) {
			pred = pred.right;
		}
		return pred;
	}
}
