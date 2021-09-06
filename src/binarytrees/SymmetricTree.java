/**
 * 
 */
package binarytrees;

import java.util.ArrayList;

import entities.TreeNode;

/**
 * @author PRATAP LeetCode 101
 *
 */
public class SymmetricTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isSymmetric(TreeNode root) {
		ArrayList<Integer> left = new ArrayList<Integer>();
		ArrayList<Integer> right = new ArrayList<Integer>();
		finddataues(root.left, true, left);
		finddataues(root.right, false, right);
		if (left.size() != right.size())
			return false;
		for (int i = 0; i < left.size(); i++) {
			Integer num1 = left.get(i);
			Integer num2 = right.get(i);
			if (num1 != num2)
				return false;
		}
		return true;
	}

	public void finddataues(TreeNode root, boolean flag, ArrayList<Integer> list) {
		if (root == null) {
			list.add(null);
			return;
		}
		if (flag) {
			list.add(root.data);
			finddataues(root.left, flag, list);
			finddataues(root.right, flag, list);
		} else {
			list.add(root.data);
			finddataues(root.right, flag, list);
			finddataues(root.left, flag, list);
		}
	}
}
