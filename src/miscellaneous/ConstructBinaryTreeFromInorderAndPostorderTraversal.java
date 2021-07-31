/**
 * 
 */
package miscellaneous;

import java.util.HashMap;

import entities.TreeNode;

/**
 * @author PRATAP LeetCode 106
 *
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int inorder[] = { 1, 2, 3, 4 }, postorder[] = { 1, 2, 4, 3 };
		TreeNode root = buildTree(inorder, postorder);
		System.out.println(root.data);
	}

	public static TreeNode buildTree(int[] inorder, int[] postorder) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
		TreeNode root = solve(inorder, postorder, map, postorder.length - 1, 0, inorder.length - 1);
		return root;
	}

	private static TreeNode solve(int[] inorder, int[] postorder, HashMap<Integer, Integer> map, int i, int inS,
			int inE) {
		// TODO Auto-generated method stub
		if (inS > inE)
			return null;
		TreeNode root = new TreeNode(postorder[i]);
		int pos = map.get(postorder[i]);
		root.right = solve(inorder, postorder, map, i - 1, pos + 1, inE);
		root.left = solve(inorder, postorder, map, i + pos - inE - 1, inS, pos - 1);
		return root;
	}
}
