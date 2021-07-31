/**
 * 
 */
package miscellaneous;

import java.util.HashMap;

import entities.TreeNode;

/**
 * @author PRATAP LeetCode 105
 *
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int preorder[] = { 3, 9, 20, 15, 7 }, inorder[] = { 9, 3, 15, 20, 7 };
		TreeNode root = buildTree(preorder, inorder);
		System.out.println(root.data);
	}

	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		HashMap<Integer, Integer> inorderMap = new HashMap<Integer, Integer>();

		for (int i = 0; i < inorder.length; i++)
			inorderMap.put(inorder[i], i);
		TreeNode root = solve(preorder, inorder, 0, 0, inorder.length - 1, inorderMap);
		return root;
	}

	private static TreeNode solve(int[] preorder, int[] inorder, int i, int inS, int inE,
			HashMap<Integer, Integer> inorderMap) {
		// TODO Auto-generated method stub
		if (inS > inE)
			return null;
		TreeNode root = new TreeNode(preorder[i]);
		int pos = inorderMap.get(preorder[i]);
		root.left = solve(preorder, inorder, i + 1, inS, pos - 1, inorderMap);
		root.right = solve(preorder, inorder, i + pos - inS + 1, pos + 1, inE, inorderMap);
		return root;
	}

}