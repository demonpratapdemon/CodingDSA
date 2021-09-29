/**
 * 
 */
package util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import entities.Node;
import entities.TreeNode;

/**
 * @author PRATAP
 *
 */
public class Utility {

	static List<Integer> bstInOrder = new ArrayList<Integer>();
	static List<Integer> preOrder = new ArrayList<Integer>();
	static List<Integer> levelOrder = new ArrayList<Integer>();

	public static boolean binarySearch(int[] newArr, int item) {

		int start = 0;
		int end = newArr.length - 1;
		int mid;
		if (item > newArr[end] || item < newArr[start])
			return false;
		while (start <= end) {
			mid = (start + end) / 2;
			if (newArr[mid] == item)
				return true;
			if (newArr[mid] < item)
				start = mid + 1;
			else
				end = mid - 1;
		}
		return false;
	}

	public static void printList(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
		System.out.println();
	}

	public static void makeloop(Node head, Node tail, int x) {
		// TODO Auto-generated method stub
		if (x == 0)
			return;
		Node curr = head;
		for (int i = 1; i < x; i++) {
			curr = curr.next;
		}
		tail.next = curr;
	}

	public static TreeNode createBinaryTree(String[] input) {
		// TODO Auto-generated method stub
		if (input.length == 0 || input[0].equalsIgnoreCase("N"))
			return null;
		TreeNode root = new TreeNode(Integer.parseInt(input[0]));
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		int i = 1;
		String currval;
		while (q.size() > 0 && i < input.length) {
			TreeNode curr = q.remove();
			currval = input[i];
			if (!currval.equalsIgnoreCase("N")) {
				curr.left = new TreeNode(Integer.parseInt(currval));
				q.add(curr.left);
			}
			i++;
			if (i >= input.length)
				break;
			currval = input[i];
			if (!currval.equalsIgnoreCase("N")) {
				curr.right = new TreeNode(Integer.parseInt(currval));
				q.add(curr.right);
			}
			i++;
		}
		return root;
	}

	public static TreeNode createBST(TreeNode root, int i) {
		// TODO Auto-generated method stub
		if (root == null) {
			return new TreeNode(i);
		}
		if (i > root.data) {
			root.right = createBST(root.right, i);
		} else {
			root.left = createBST(root.left, i);
		}
		return root;
	}

	public static List<Integer> printInorderBST(TreeNode root) {
		// TODO Auto-generated method stub
		if (root == null)
			return bstInOrder;
		bstInOrder = printInorderBST(root.left);
		bstInOrder.add(root.data);
		bstInOrder = printInorderBST(root.right);
		return bstInOrder;
	}

	public static boolean isPresent(TreeNode root, int target) {
		if (root == null)
			return false;
		if (root.data == target)
			return true;
		else if (root.data > target)
			return isPresent(root.left, target);
		else
			return isPresent(root.right, target);
	}

	public static TreeNode createMinHeightBST(int[] arr, int i, int j) {
		// TODO Auto-generated method stub
		if (i > j)
			return null;
		int mid = (i + j) / 2;
		TreeNode root = new TreeNode(arr[mid]);
		root.left = createMinHeightBST(arr, i, mid - 1);
		root.right = createMinHeightBST(arr, mid + 1, j);
		return root;
	}

	public static List<Integer> preorderTraversal(TreeNode root) {
		// TODO Auto-generated method stub
		if (root == null) {
			preOrder.add(null);
			return preOrder;
		}
		preOrder.add(root.data);
		preorderTraversal(root.left);
		preorderTraversal(root.right);
		return preOrder;
	}

	public static List<Integer> levelOrderTraversal(TreeNode root) {
		// TODO Auto-generated method stub
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				TreeNode curr = q.poll();
				if (curr == null)
					levelOrder.add(null);
				else
					levelOrder.add(curr.data);
				if (curr != null) {
					q.add(curr.left);
					q.add(curr.right);
				}
			}
		}
		return levelOrder;
	}
}
