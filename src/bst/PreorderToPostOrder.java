/**
 * 
 */
package bst;

import java.util.Stack;

import entities.TreeNode;

/**
 * @author PRATAP
 *
 */
public class PreorderToPostOrder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 40, 30, 35, 80, 100 };
		TreeNode root = constructTree(arr, arr.length);
		inorder(root);
	}

	private static void inorder(TreeNode root) {
		// TODO Auto-generated method stub
		if (root == null)
			return;
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}

	public static TreeNode constructTree(int pre[], int size) {
		// Your code here
		if (size == 0)
			return null;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode root = new TreeNode(pre[0]);
		stack.push(root);
		for (int i = 1; i < size; i++) {
			if (pre[i] < stack.peek().data) {
				TreeNode curr = stack.peek();
				curr.left = new TreeNode(pre[i]);
				stack.push(curr.left);
			} else {
				TreeNode popped = null;
				while (!stack.isEmpty() && stack.peek().data < pre[i]) {
					popped = stack.pop();
				}
				if (popped != null) {
					popped.right = new TreeNode(pre[i]);
					stack.push(popped.right);
				}
			}
		}
		return root;
	}

}
