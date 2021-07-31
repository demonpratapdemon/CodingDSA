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
 * @author PRATAP LeetCode 543
 *
 */
public class TreeDiameter {

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
			int diameter = diameter(root);
			System.out.println(diameter);
		}
	}

	public static int diameter(TreeNode root) {
		// Your code here
		if (root == null)
			return 0;
		Pair pair = diameterUtil(root);
		return Math.max(pair.first, pair.second) - 1; // for LeetCode(edges)
//		return Math.max(pair.first, pair.second); // for GFG(nodes)
	}

	private static Pair diameterUtil(TreeNode root) {
		// TODO Auto-generated method stub
		if (root == null)
			return new Pair(0, 0);
		Pair left = diameterUtil(root.left);
		Pair right = diameterUtil(root.right);
		int internalPath = Math.max(left.first + right.first + 1, Math.max(left.second, right.second));
		return new Pair(Math.max(left.first, right.first) + 1, internalPath);
	}
}

class Pair {
	public int first;
	public int second;

	public Pair(int first, int second) {
		super();
		this.first = first;
		this.second = second;
	}

}
