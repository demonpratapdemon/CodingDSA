/**
 * 
 */
package binarytrees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import entities.TreeNode;
import util.Utility;

/**
 * @author PRATAP
 *
 */
public class ZigZagTreeTraversal {

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
			List<Integer> list = zigZagTraversal(root);
			StringBuilder sb = new StringBuilder();
			for (Integer i : list)
				sb.append(i + " ");
			System.out.println(sb.toString());
		}
	}

	public static ArrayList<Integer> zigZagTraversal(TreeNode root) {
		// Add your code here.
		ArrayList<Integer> ans = new ArrayList<Integer>();
		if (root == null)
			return ans;
		Stack<TreeNode> s1 = new Stack<TreeNode>(); // LR
		Stack<TreeNode> s2 = new Stack<TreeNode>(); // RL
		s1.add(root);
		int swap = 0;
		while (!s1.isEmpty() || !s2.isEmpty()) {
			TreeNode curr;
			if (swap == 0) {
				while (!s1.isEmpty()) {
					curr = s1.pop();
					ans.add(curr.data);
					if (curr.left != null)
						s2.add(curr.left);
					if (curr.right != null)
						s2.add(curr.right);
				}
				swap = 1;
			} else {
				while (!s2.isEmpty()) {
					curr = s2.pop();
					ans.add(curr.data);
					if (curr.right != null)
						s1.add(curr.right);
					if (curr.left != null)
						s1.add(curr.left);
				}
				swap = 0;
			}
		}
		return ans;
	}

}
