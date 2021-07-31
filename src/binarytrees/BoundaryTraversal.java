/**
 * 
 */
package binarytrees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import entities.TreeNode;
import util.Utility;

/**
 * @author PRATAP
 *
 */
public class BoundaryTraversal {

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
			ArrayList<Integer> list = printBoundary(root);
			System.out.println(list);
		}
	}

	public static ArrayList<Integer> printBoundary(TreeNode root) {
		ArrayList<Integer> ans = new ArrayList<Integer>();
		if (root == null)
			return ans;
		ans.add(root.data);
		leftBoundary(root.left, ans);
		leaf(root.left, ans);
		leaf(root.right, ans);
		rightBoundary(root.right, ans);
		return ans;
	}

	private static void rightBoundary(TreeNode root, ArrayList<Integer> ans) {
		// TODO Auto-generated method stub
		if (root == null) {
			return;
		}
		if (root.right != null) {
			rightBoundary(root.right, ans);
			ans.add(root.data);
		} else if (root.left != null) {
			rightBoundary(root.left, ans);
			ans.add(root.data);
		}
	}

	private static void leaf(TreeNode root, ArrayList<Integer> ans) {
		// TODO Auto-generated method stub
		if(root == null)
			return;
		
		if (root.left == null && root.right == null) {
			ans.add(root.data);
			return;
		}
		leaf(root.left, ans);
		leaf(root.right, ans);
	}

	private static void leftBoundary(TreeNode node, ArrayList<Integer> ans) {
		// TODO Auto-generated method stub
		if (node == null)
			return;
		if (node.left != null) {
			ans.add(node.data);
			leftBoundary(node.left, ans);
		} else if (node.right != null) {
			ans.add(node.data);
			leftBoundary(node.right, ans);
		}
	}

}
