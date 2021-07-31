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
public class DeadEnd {

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
		System.out.println(isDeadEnd(root) ? "Yes" : "No");
	}

	public static boolean isDeadEnd(TreeNode root) {
		// Add your code here.
		boolean ans = find(root, 1, Integer.MAX_VALUE, false);
		return ans;
	}

	public static boolean find(TreeNode root, int l, int r, boolean flag) {
		if (root == null)
			return flag;
		if (flag)
			return flag;
		if (root.left == null && root.right == null) {
			if (l == r) {
				flag = true;
			}
			return flag;
		}
		boolean left = false, right = false;
		if (root.left != null)
			left = find(root.left, l, root.data - 1, flag);
		if (root.right != null)
			right = find(root.right, root.data + 1, r, flag);
		return left || right;
	}

}
