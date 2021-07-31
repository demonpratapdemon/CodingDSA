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
public class MinDistBetween2NodesOfBinaryTree {

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
			input = br.readLine().split("\\s+");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			int dist = findDist(root, a, b);
			System.out.println(dist);
		}
	}

	public static int findDist(TreeNode root, int a, int b) {
		// Your code here
		TreeNode lca = lca(root, a, b);
		int dist = 0;
		if (lca.data != a && lca.data != b) {
			dist = find(lca.left, a, b);
			dist += find(lca.right, a, b);
		} else if (lca.data == a) {
			dist = find(lca.left, b, Integer.MIN_VALUE);
			dist = dist <= 0 ? find(lca.right, b, Integer.MIN_VALUE) : dist;
		} else {
			dist = find(lca.left, a, Integer.MIN_VALUE);
			dist = dist <= 0 ? find(lca.right, a, Integer.MIN_VALUE) : dist;
		}
		return dist;
	}

	private static int find(TreeNode lca, int a, int b) {
		// TODO Auto-generated method stub
		if (lca == null)
			return 0;
		if (lca.data == a || lca.data == b)
			return 1;
		int left = find(lca.left, a, b);
		int right = find(lca.right, a, b);
		if (left > 0)
			return 1 + left;
		else if (right > 0)
			return 1 + right;
		else
			return 0;
	}

	private static TreeNode lca(TreeNode root, int a, int b) {
		// TODO Auto-generated method stub
		if (root == null)
			return null;
		if (root.data == a || root.data == b)
			return root;
		TreeNode left = null, right = null;
		left = lca(root.left, a, b);
		right = lca(root.right, a, b);
		if (left != null && right != null)
			return root;

		return (left != null) ? left : right;
	}

}
