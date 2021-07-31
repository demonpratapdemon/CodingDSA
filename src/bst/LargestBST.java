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
public class LargestBST {

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
		int largestBSTSize = largestBst(root);
		System.out.println(largestBSTSize);
	}

	static int largestBst(TreeNode root) {
		// Write your code here
		PostOrderDetails largestBST = findLargestBST(root);
		return largestBST.size;
	}

	private static PostOrderDetails findLargestBST(TreeNode root) {
		// TODO Auto-generated method stub
		if (root.left == null && root.right == null) {
			PostOrderDetails poDet = new PostOrderDetails(true, 1, root.data, root.data);
			return poDet;
		}
		PostOrderDetails left = new PostOrderDetails(true, 0, 0, 0), right = new PostOrderDetails(true, 0, 0, 0),
				finalOb = new PostOrderDetails(false, 0, 0, 0);
		if (root.left != null) {
			left = findLargestBST(root.left);
		}
		if (root.right != null) {
			right = findLargestBST(root.right);
		}

		if (left.isBST && right.isBST) {
			if (root.data >= left.max && root.data < right.min && left.size != 0 && right.size != 0) {
				finalOb = new PostOrderDetails(true, left.size + right.size + 1, left.min, right.max);
			} else if (root.data >= left.max && right.size == 0) {
				finalOb = new PostOrderDetails(true, left.size + 1, left.min, root.data);
			} else if (root.data < right.min && left.size == 0) {
				finalOb = new PostOrderDetails(true, right.size + 1, root.data, right.max);
			} else {
				finalOb = new PostOrderDetails(false, Math.max(left.size, right.size), 0, 0);
			}
		} else if (left.isBST && !right.isBST) {
			if (right.size == 0 && root.data >= left.max) {
				finalOb = new PostOrderDetails(true, left.size + 1, left.min, root.data);
			} else {
				finalOb = new PostOrderDetails(false, Math.max(left.size, right.size), 0, 0);
			}
		} else if (right.isBST && !left.isBST) {
			if (left.size == 0 && root.data < right.min) {
				finalOb = new PostOrderDetails(true, right.size + 1, root.data, right.max);
			} else {
				finalOb = new PostOrderDetails(false, Math.max(left.size, right.size), 0, 0);
			}
		} else {
			finalOb = new PostOrderDetails(false, Math.max(left.size, right.size), 0, 0);
		}
		return finalOb;
	}

}

class PostOrderDetails {
	public boolean isBST;
	public int size;
	public int min;
	public int max;

	public PostOrderDetails(boolean isBST, int size, int min, int max) {
		super();
		this.isBST = isBST;
		this.size = size;
		this.min = min;
		this.max = max;
	}

}
