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
 * @author PRATAP LeetCode 124
 *
 */
public class BinaryTreeMaximumPathSum {

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
			BinaryTreeMaximumPathSum obj = new BinaryTreeMaximumPathSum();
			int maxSum = obj.maxPathSum(root);
			System.out.println(maxSum);
		}
	}

	public int result = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		solve(root);
		return result;
	}

	private int solve(TreeNode root) {
		// TODO Auto-generated method stub
		if (root == null)
			return 0;
		int left = solve(root.left);
		int right = solve(root.right);
		int ms = Math.max(Math.max(left, right) + root.data, root.data);
		int m21 = Math.max(ms, left + right + root.data);
		result = Math.max(result, m21);
		return ms;
	}
}
