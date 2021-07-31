/**
 * 
 */
package binarytrees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import entities.TreeNode;
import util.Utility;

/**
 * @author PRATAP
 *
 */
public class DiagonalTraversal {

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
			ArrayList<Integer> list = diagonal(root);
			System.out.println(list);
		}
	}

	public static ArrayList<Integer> diagonal(TreeNode root) {
		// add your code here.
		ArrayList<Integer> ans = new ArrayList<Integer>();
		if (root == null)
			return ans;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		while (!q.isEmpty()) {
			TreeNode curr = q.poll();
			while (curr != null) {
				if(curr.left!=null)
					q.add(curr.left);
				ans.add(curr.data);
				curr= curr.right;
			}
		}
		return ans;
	}

}
