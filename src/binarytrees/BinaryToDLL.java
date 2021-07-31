/**
 * 
 */
package binarytrees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import entities.DLLNode;
import entities.TreeNode;
import util.Utility;

/**
 * @author PRATAP
 *
 */
public class BinaryToDLL {

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
			DLLNode node = bToDLL(root);
			while (node != null) {
				System.out.print(node.data + " ");
				node = node.right;
			}
		}
	}

	public static DLLNode bToDLL(TreeNode root) {
		// Your code here
		DLL node = flattenRecur(root);
		return node.head;
	}

	private static DLL flattenRecur(TreeNode root) {
		// TODO Auto-generated method stub
		DLL node = new DLL();
		if (root == null) {
			node.head = node.tail = null;
		}
		if (root.left == null && root.right == null) {
			node.head = node.tail = new DLLNode(root.data);
		} else if (root.left != null && root.right == null) {
			DLL left = flattenRecur(root.left);
			left.tail.right = new DLLNode(root.data);
			left.tail.right.left = left.tail;
			left.tail = left.tail.right;
			node.head = left.head;
			node.tail = left.tail;
		} else if (root.left == null && root.right != null) {
			DLL right = flattenRecur(root.right);
			right.head.left = new DLLNode(root.data);
			right.head.left.right = right.head;
			right.head = right.head.left;
			node.head = right.head;
			node.tail = right.tail;
		} else {
			DLL left = flattenRecur(root.left);
			DLL right = flattenRecur(root.right);
			left.tail.right = new DLLNode(root.data);
			left.tail.right.left = left.tail;
			left.tail = left.tail.right;
			node.head = left.head;
			node.tail = left.tail;
			node.tail.right = right.head;
			node.tail.right.left = node.tail;
			node.tail = right.tail;
		}
		return node;
	}

}

class DLL {
	public DLLNode head;
	public DLLNode tail;
}
