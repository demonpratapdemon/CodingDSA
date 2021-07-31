/**
 * 
 */
package binarytrees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import entities.TreeNode;
import util.Utility;

/**
 * @author PRATAP LeetCode 112
 *
 */
public class PathSum {

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
			PathSum obj = new PathSum();
			int targetSum = Integer.parseInt(br.readLine());
			boolean ans = obj.hasPathSum(root, targetSum);
			System.out.println(ans);
		}
	}

	public boolean hasPathSum(TreeNode root, int targetSum) {
		if (root == null) {
			return false;
		}
		if (root.data == targetSum && root.left == null && root.right == null)
			return true;
		boolean left = root.left != null ? find(root.left, root.data, targetSum) : false;
		boolean right = root.right != null ? find(root.right, root.data, targetSum) : false;
		return left | right;
	}

	private boolean find(TreeNode node, int sum, int targetSum) {
		// TODO Auto-generated method stub
		if (sum + node.data == targetSum && node.left == null && node.right == null)
			return true;
		boolean left = false;
		boolean right = false;
		if (node.left != null) {
			left = find(node.left, sum + node.data, targetSum);
		}
		if (node.right != null && !left) {
			right = find(node.right, sum + node.data, targetSum);
		}
		return left | right;
	}
}
