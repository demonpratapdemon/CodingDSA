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
public class CountBSTNodeInAGivenRange {

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
		int l = 2, h = 8;
		System.out.println(getCount(root, l, h));
	}

	static int count = 0;

	static int getCount(TreeNode root, int l, int h) {
		// Your code here
		if (root == null)
			return 0;
		count = 0;
		solve(root, l, h);
		return count;
	}

	private static void solve(TreeNode root, int l, int h) {
		// TODO Auto-generated method stub
		if (root == null)
			return;
		if (root.data <= h && root.data >= l) {
			count++;
		}
		if (root.data >= l) {
			solve(root.left, l, h);
		}
		if (root.data <= h) {
			solve(root.right, l, h);
		}
	}

}
