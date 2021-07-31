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
public class LevelOrderTraversal {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String[] input = br.readLine().split("\\s+");
			TreeNode root = Utility.createBinaryTree(input);
			ArrayList<Integer> list = levelOrder(root);
			StringBuilder sb = new StringBuilder();
			for (int i : list)
				sb.append(i + " ");
			System.out.println(sb.toString());
		}
	}

	// Function to return the level order traversal of a tree.
	public static ArrayList<Integer> levelOrder(TreeNode node) {
		// Your code here
		ArrayList<Integer> ans = new ArrayList<Integer>();
		if (node == null)
			return ans;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(node);
		while (!q.isEmpty()) {
			TreeNode curr = q.remove();
			ans.add(curr.data);
			if (curr.left != null)
				q.add(curr.left);
			if (curr.right != null)
				q.add(curr.right);
		}
		return ans;
	}

}
