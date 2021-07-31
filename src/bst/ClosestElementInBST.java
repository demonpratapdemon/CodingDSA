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
public class ClosestElementInBST {

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
		System.out.println("Closest Element : " + findClosestElement(root, K));
		System.out.println("Minimum Difference : " + minDiff(root, K));
	}

	static int minDiff(TreeNode root, int K) {
		// Write your code here
		int min = Integer.MAX_VALUE;
		min = findMinDiff(root, K, min);
		return min;
	}

	private static int findMinDiff(TreeNode root, int k, int min) {
		// TODO Auto-generated method stub
		if (root == null)
			return min;
		if (root.left == null && root.right == null)
			return Math.min(min, Math.abs(k - root.data));
		min = Math.min(min, Math.abs(root.data - k));
		if (k < root.data)
			min = findMinDiff(root.left, k, min);
		else
			min = findMinDiff(root.right, k, min);
		return min;
	}

	static int findClosestElement(TreeNode root, int K) {
		// TODO Auto-generated method stub
		int min = Integer.MAX_VALUE;
		min = findClosest(root, K, min);
		return min;
	}

	private static int findClosest(TreeNode root, int K, int min) {
		// TODO Auto-generated method stub
		if (root == null)
			return min;
		if (root.left == null && root.right == null) {
			if (Math.abs(K - min) > Math.abs(root.data - K))
				return root.data;
			return min;
		}
		if (Math.abs(K - min) > Math.abs(root.data - K))
			min = root.data;
		if (K < root.data)
			min = findClosest(root.left, K, min);
		else
			min = findClosest(root.right, K, min);
		return min;
	}

}
