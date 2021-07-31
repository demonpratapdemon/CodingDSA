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
public class LowestCommonAncestor {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the values : ");
		String[] input = br.readLine().split("\\s+");
		TreeNode root = Utility.createBinaryTree(input);
		input = br.readLine().split("\\s+");
		int n1 = Integer.parseInt(input[0]);
		int n2 = Integer.parseInt(input[1]);
		TreeNode lca = LCA(root, n1, n2);
		System.out.println(lca.data);
	}

	public static TreeNode LCA(TreeNode root, int n1, int n2) {
		// code here.
		if (root == null)
			return root;
		if (n1 > n2) {
			return LCA(root, n2, n1);
		}
		TreeNode lca = findLCA(root, n1, n2);
		return lca;
	}

	private static TreeNode findLCA(TreeNode root, int n1, int n2) {
		// TODO Auto-generated method stub
		if (n1 <= root.data && n2 >= root.data) {
			return root;
		}
		if (n1 >= root.data && n2 >= root.data) {
			return findLCA(root.right, n1, n2);
		} else if (n1 <= root.data && n2 <= root.data) {
			return findLCA(root.left, n1, n2);
		}
		return root;
	}
}
