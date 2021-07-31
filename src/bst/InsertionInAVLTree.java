/**
 * 
 */
package bst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import entities.TreeNode;
import util.Utility;

/**
 * @author PRATAP
 *
 */
public class InsertionInAVLTree {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the nodes for insertion :");
		String[] input = br.readLine().split("\\s+");
		TreeNode root = null;
		for (String str : input) {
			int data = Integer.parseInt(str);
			root = insertAVL(root, data);
		}
		List<Integer> list = Utility.printInorderBST(root);
		System.out.println("Inorder Traversal = " + list);
	}

	private static TreeNode insertAVL(TreeNode root, int data) {
		// TODO Auto-generated method stub
		if (root == null) {
			return new TreeNode(data);
		} else if (root.data >= data) {
			root.left = insertAVL(root.left, data);
		} else {
			root.right = insertAVL(root.right, data);
		}
		int balance = balanced(root.left, root.right);
		if (balance > 1) { // LL or LR
			if (height(root.left.left) >= height(root.left.right)) {
				// LL -> Right Rotation
				root = rightRotate(root);
			} else {
				// LR -> Left Rotation + Right Rotation
				root.left = (root.left);
				root = rightRotate(root);
			}
		} else if (balance < -1) {
			if (height(root.right.right) >= height(root.right.left)) {
				// RR -> Left Rotation
				root = leftRotate(root);
			} else {
				// RL -> Right Rotation + Left Rotation
				root.right = rightRotate(root.right);
				root = leftRotate(root);
			}
		} else {
			root.height = setHeight(root);
		}
		return root;
	}

	private static int setHeight(TreeNode root) {
		// TODO Auto-generated method stub
		if (root == null)
			return 0;
		return 1 + Math.max((root.left != null) ? root.left.height : 0, (root.right != null) ? root.right.height : 0);
	}

	private static TreeNode rightRotate(TreeNode root) {
		// TODO Auto-generated method stub
		TreeNode newRoot = root.left;
		root.left = newRoot.right;
		newRoot.right = root;
		root.height = setHeight(root);
		newRoot.height = setHeight(newRoot);
		return newRoot;
	}

	private static TreeNode leftRotate(TreeNode root) {
		// TODO Auto-generated method stub
		TreeNode newRoot = root.right;
		root.right = newRoot.left;
		newRoot.left = root;
		root.height = setHeight(root);
		newRoot.height = setHeight(newRoot);
		return newRoot;
	}

	private static int balanced(TreeNode left, TreeNode right) {
		// TODO Auto-generated method stub
		return height(left) - height(right);
	}

	private static int height(TreeNode root) {
		// TODO Auto-generated method stub
		if (root == null)
			return 0;
		return root.height;
	}

}
