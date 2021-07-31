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
 * @author PRATAP LeetCode 236
 *
 */
public class LowestCommonAncestorOfBinaryTree {

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
			TreeNode p = new TreeNode(5);
			TreeNode q = new TreeNode(4);
			TreeNode ans = lowestCommonAncestor(root, p, q);
			System.out.println(ans.data);
		}
	}

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null)
			return null;
		if (root.data == p.data || root.data == q.data) {
			return root;
		}
		TreeNode left = null;
		TreeNode right = null;

		left = lowestCommonAncestor(root.left, p, q);
		right = lowestCommonAncestor(root.right, p, q);

		if (left == null && right == null) {
			return null;
		} else if (left == null && right != null) {
			return right;
		} else if (left != null && right == null) {
			return left;
		} else {
			return root;
		}
	}

}
