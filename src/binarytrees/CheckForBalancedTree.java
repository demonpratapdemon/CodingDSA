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
 * @author PRATAP
 *
 */
public class CheckForBalancedTree {

	static boolean balanced = true;

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
			boolean ans = isBalanced(root);
			if (ans)
				System.out.println(1);
			else
				System.out.println(0);
		}
	}

	public static boolean isBalanced(TreeNode root) {
		// Your code here
		balanced = true;
		checkHeight(root);
		return balanced;
	}

	private static int checkHeight(TreeNode root) {
		// TODO Auto-generated method stub
		if (root == null)
			return 0;
		int leftHeight = checkHeight(root.left);
		int rightHeight = checkHeight(root.right);
		if (Math.abs(leftHeight - rightHeight) > 1) {
			balanced = false;
			return 0;
		}
		return Math.max(leftHeight, rightHeight) + 1;
	}
}
