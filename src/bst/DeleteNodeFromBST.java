/**
 * 
 */
package bst;

import entities.TreeNode;

/**
 * @author PRATAP LeetCode 450
 *
 */
public class DeleteNodeFromBST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null)
			return root;
		if (key < root.data) {
			root.left = deleteNode(root.left, key);
		} else if (key > root.data)
			root.right = deleteNode(root.right, key);
		else {
			if (root.left != null && root.right != null) {
				int lmax = max(root.left);
				root.data = lmax;
				root.left = deleteNode(root.left, lmax);
				return root;
			} else if (root.left != null) {
				return root.left;
			} else if (root.right != null) {
				return root.right;
			} else
				return null;
		}
		return root;
	}

	private int max(TreeNode left) {
		// TODO Auto-generated method stub
		if (left.right != null)
			return max(left.right);
		return left.data;
	}

}
