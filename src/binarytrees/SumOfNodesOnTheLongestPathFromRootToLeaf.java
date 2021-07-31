/**
 * 
 */
package binarytrees;

import entities.TreeNode;

/**
 * @author PRATAP
 *
 */
public class SumOfNodesOnTheLongestPathFromRootToLeaf {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int max = Integer.MIN_VALUE;
	public int prevHt = Integer.MIN_VALUE;

	public int sumOfLongRootToLeafPath(TreeNode root) {
		// code here
		preorder(root, 0, 0);
		return max;
	}

	public void preorder(TreeNode root, int curr, int ht) {
		if (root == null)
			return;
		if (root.left == null && root.right == null) {
			if (ht > prevHt) {
				max = curr + root.data;
				prevHt = ht;
			} else if (ht == prevHt)
				max = Math.max(max, curr + root.data);
			return;
		}
		int temp = root.data;
		preorder(root.left, curr + temp, ht + 1);
		preorder(root.right, curr + temp, ht + 1);
	}
}
