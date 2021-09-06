/**
 * 
 */
package binarytrees;

import entities.TreeNode;

/**
 * @author PRATAP LeetCode 617
 *
 */
public class MergeTwoBinaryTrees {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
		return merge(root1, root2);
	}

	public TreeNode merge(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null)
			return null;
		if (root1 == null && root2 != null) {
			TreeNode root = new TreeNode(root2.data);
			root.left = merge(null, root2.left);
			root.right = merge(null, root2.right);
			return root;
		}
		if (root1 != null && root2 == null) {
			TreeNode root = new TreeNode(root1.data);
			root.left = merge(root1.left, null);
			root.right = merge(root1.right, null);
			return root;
		}
		if (root1 != null && root2 != null) {
			TreeNode root = new TreeNode(root1.data + root2.data);
			root.left = merge(root1.left, root2.left);
			root.right = merge(root1.right, root2.right);
			return root;
		}
		return null;
	}
}
