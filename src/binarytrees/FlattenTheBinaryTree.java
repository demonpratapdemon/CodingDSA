/**
 * 
 */
package binarytrees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import entities.TreeNode;
import util.Utility;

/**
 * @author PRATAP LeetCode 114
 *
 */
public class FlattenTheBinaryTree {

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
			LLNode ll = flattenRecur(root);
			TreeNode temp = ll.head;
			while (temp != null) {
				if (temp.right == null) {
					System.out.println(temp.data);
					break;
				}
				System.out.print(temp.data + "-->");
				temp = temp.right;
			}
		}
	}

	List<Integer> list = new ArrayList<Integer>();

	public void flatten(TreeNode root) {
		if (root == null)
			return;
		preorder(root);
		root.left = null;
		root.right = null;
		root.data = list.get(0);
		TreeNode tail = root;
		for (int i = 1; i < list.size(); i++) {
			tail.right = new TreeNode(list.get(i), null, null);
			tail = tail.right;
		}
	}

	void preorder(TreeNode root) {
		if (root == null) {
			return;
		}
		list.add(root.data);
		preorder(root.left);
		preorder(root.right);
	}

	public static LLNode flattenRecur(TreeNode root) {
		LLNode l = new LLNode();
		if (root == null) {
			l.head = l.tail = null;
		}
		if (root.left == null && root.right == null) {
			l.head = l.tail = root;
		} else if (root.left != null && root.right == null) {
			LLNode left = flattenRecur(root.left);
			left.tail.right = root;
			l.head = left.head;
			l.head.left = null;
			l.tail = root;
			l.tail.left = null;
		} else if (root.left == null && root.right != null) {
			LLNode right = flattenRecur(root.right);
			l.head = root;
			l.head.right = right.head;
			l.head.left = null;
			l.tail = right.tail;
			l.tail.left = null;
		} else {
			LLNode left = flattenRecur(root.left);
			LLNode right = flattenRecur(root.right);
			root.right = right.head;
			left.tail.right = root;
			root.left = null;
			l.head = left.head;
			l.tail = right.tail;
			l.tail.left = null;
		}
		return l;
	}

}

class LLNode {
	public TreeNode head;
	public TreeNode tail;
}
