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
 * @author PRATAP LeetCode 1382
 *
 */
public class BalanceABinarySearchTree {

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
		TreeNode balanced = balanceBST(root);
		preorder(balanced);
	}

	private static void preorder(TreeNode balanced) {
		// TODO Auto-generated method stub
		if (balanced == null)
			return;
		System.out.print(balanced.data + " ");
		preorder(balanced.left);
		preorder(balanced.right);
	}

	public static TreeNode balanceBST(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		inorder(root, list);
		TreeNode balanced = createMinHghtBST(list, 0, list.size() - 1);
		return balanced;
	}

	private static TreeNode createMinHghtBST(ArrayList<Integer> list, int i, int j) {
		// TODO Auto-generated method stub
		if (j < i || i > j)
			return null;
		int mid = (i + j) / 2;
		TreeNode root = new TreeNode(list.get(mid));
		root.left = createMinHghtBST(list, i, mid - 1);
		root.right = createMinHghtBST(list, mid + 1, j);
		return root;
	}

	private static void inorder(TreeNode root, ArrayList<Integer> list) {
		// TODO Auto-generated method stub
		if (root == null)
			return;
		inorder(root.left, list);
		list.add(root.data);
		inorder(root.right, list);
	}

}
