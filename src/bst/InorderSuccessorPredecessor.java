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
public class InorderSuccessorPredecessor {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the values : ");
		String[] input = br.readLine().split("\\s+");
		TreeNode root = null;
		for (String s : input) {
			root = Utility.createBST(root, Integer.parseInt(s));
		}
		int k = Integer.parseInt(br.readLine());
		int inorderSucc = inorderSuccessorPredecessor(root, k);
		System.out.println(inorderSucc);
	}

	private static int inorderSuccessorPredecessor(TreeNode root, int k) {
		// TODO Auto-generated method stub
		if (root == null)
			return -1;
		int pred = findPredecessor(root, k, -1);
		int succ = findInorderSucc(root, k, -1);
		System.out.println(pred + " " + succ);
		return succ;
	}

	private static int findPredecessor(TreeNode root, int key, int pred) {
		// TODO Auto-generated method stub
		if (root != null && root.data < key) {
			pred = root.data;
			pred = findPredecessor(root.right, key, pred);
		} else if (root != null && root.data >= key) {
			pred = findPredecessor(root.left, key, pred);
		}
		return pred;
	}

	private static int findInorderSucc(TreeNode root, int key, int succ) {
		// TODO Auto-generated method stub
		if (root != null && root.data > key) {
			succ = root.data;
			succ = findInorderSucc(root.left, key, succ);
		} else if (root != null && root.data <= key) {
			succ = findInorderSucc(root.right, key, succ);
		}
		return succ;
	}

}
