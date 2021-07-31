/**
 * 
 */
package miscellaneous;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import entities.TreeNode;
import util.Utility;

/**
 * @author PRATAP LeetCode 814
 *
 */
public class BinaryTreePruning {

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
			TreeNode node = pruneTree(root);
			System.out.println(node == null ? "" : node.data);
		}
	}

	public static TreeNode pruneTree(TreeNode root) {
		boolean left = binaryTreePruning(root.left);
		boolean right = binaryTreePruning(root.right);
		if (left)
			root.left = null;
		if (right)
			root.right = null;
		if (root.data == 0 && root.left == null && root.right == null)
			return null;
		return root;
	}

	private static boolean binaryTreePruning(TreeNode root) {
		// TODO Auto-generated method stub
		if (root == null)
			return false;
		if (root.data == 0 && root.left == null && root.right == null) {
			return true;
		}
		boolean left = binaryTreePruning(root.left);
		boolean right = binaryTreePruning(root.right);
		if (left) {
			root.left = null;
		}
		if (right) {
			root.right = null;
		}
		if (root.left == null && root.right == null && root.data == 0)
			return true;
		return false;
	}
}
