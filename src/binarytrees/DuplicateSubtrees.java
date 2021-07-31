/**
 * 
 */
package binarytrees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import entities.TreeNode;
import util.Utility;

/**
 * @author PRATAP LeetCode 652
 *
 */
public class DuplicateSubtrees {

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String[] input = br.readLine().split("\\s+");
			TreeNode root = Utility.createBinaryTree(input);
			List<TreeNode> list = findDuplicateSubtrees(root);
			for (TreeNode l : list) {
				System.out.println("Root = " + l.data);
			}
		}
	}

	public static boolean flag = false;

	public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		List<TreeNode> list = new ArrayList<TreeNode>();
		inorder(root, list, map);
		return list;
	}

	private static String inorder(TreeNode root, List<TreeNode> list, HashMap<String, Integer> map) {
		// TODO Auto-generated method stub
		if (root == null)
			return "";
		StringBuilder sb = new StringBuilder();
		sb.append("#");
		sb.append(inorder(root.left, list, map));
		sb.append(root.data);
		sb.append(inorder(root.right, list, map));
		sb.append("#");
		if (map.containsKey(sb.toString()) && map.get(sb.toString()) == 1) {
			list.add(root);
			String[] buff = sb.toString().split("#");
			if (buff.length >= 2) {
				System.out.println(root.data);
				flag = true;
			}
		}
		map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
		return sb.toString();
	}
}
