/**
 * 
 */
package bst;

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
public class KthSmallestElement {

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
		int K = Integer.parseInt(br.readLine());
		System.out.println(KthSmallestEle(root, K));
	}

	public static int KthSmallestEle(TreeNode root, int K) {
		// Write your code here
		ArrayList<Integer> list = new ArrayList<>();
		inorder(root, list);
		int n = list.size();
		if (K > n)
			return -1;
		return list.get(K - 1);
	}

	private static void inorder(TreeNode root, ArrayList<Integer> list) {
		// TODO Auto-generated method stub
		if (root == null)
			return;
		inorder(root.left, list);
		list.add(root.data);
		inorder(root.right, list);
	}
}
