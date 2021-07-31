/**
 * 
 */
package bst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import entities.TreeNode;
import util.Utility;

/**
 * @author PRATAP
 *
 */
public class PopulateInorderSuccessorOfAllNodes {

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
		populateNext(root);
	}

	public static TreeNode original = null;

	public static void populateNext(TreeNode root) {
		// code here
		if (root == null)
			return;
		if (original == null) {
			original = root;
		}
		TreeNode succ = findInorderSucc(original, root.data, null);
//		if(succ == null)
//		    root.next = null;
//		else
//		    root.next = succ;
		System.out.println(succ == null ? -1 : succ.data);
		populateNext(root.left);
		populateNext(root.right);
	}

	private static TreeNode findInorderSucc(TreeNode root, int key, TreeNode succ) {
		// TODO Auto-generated method stub
		if (root != null && root.data > key) {
			succ = root;
			return findInorderSucc(root.left, key, succ);
		} else if (root != null && root.data <= key) {
			return findInorderSucc(root.right, key, succ);
		}
		return succ;
	}

}
