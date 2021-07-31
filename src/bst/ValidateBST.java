/**
 * 
 */
package bst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import entities.TreeNode;
import util.Utility;

/**
 * @author PRATAP
 *
 */
public class ValidateBST {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split("\\s+");
		TreeNode root = Utility.createBinaryTree(input);
		boolean valid = isValidBST(root);
		System.out.println(valid);
	}

	public static boolean isValidBST(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		inorder(root, list);
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i) <= list.get(i - 1))
				return false;
		}
		return true;
	}

	public static void inorder(TreeNode root, ArrayList<Integer> list) {
		if (root == null)
			return;
		inorder(root.left, list);
		list.add(root.data);
		inorder(root.right, list);
	}
}
