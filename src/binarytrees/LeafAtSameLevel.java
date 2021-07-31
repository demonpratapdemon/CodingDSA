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
public class LeafAtSameLevel {

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
			boolean ans = check(root);
			System.out.println(ans);
		}
	}

	static int presentLevel = 0;

	public static boolean check(TreeNode root) {
		// Your code here
		presentLevel = 0;
		if (root == null || (root.left == null && root.right == null))
			return true;
		boolean ans = findLeafLevels(root, 0);
		return ans;
	}

	private static boolean findLeafLevels(TreeNode root, int currLevel) {
		// TODO Auto-generated method stub
		if (root == null)
			return true;
		if (root.left == null && root.right == null) {
			if (presentLevel == 0) {
				presentLevel = currLevel;
			} else {
				if (currLevel != presentLevel)
					return false;
			}
		}
		boolean left = findLeafLevels(root.left, currLevel + 1);
		boolean right = findLeafLevels(root.right, currLevel + 1);
		return left && right;
	}
}
