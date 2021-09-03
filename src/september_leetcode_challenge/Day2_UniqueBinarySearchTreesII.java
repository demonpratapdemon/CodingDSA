/**
 * 
 */
package september_leetcode_challenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import entities.TreeNode;
import util.Utility;

/**
 * @author PRATAP LeetCode 95
 *
 */
public class Day2_UniqueBinarySearchTreesII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		Day2_UniqueBinarySearchTreesII obj = new Day2_UniqueBinarySearchTreesII();
		List<TreeNode> list = obj.generateTrees(n);
		System.out.println(list);
		for (TreeNode root : list) {
			List<Integer> l = Utility.printInorderBST(root);
			System.out.println(l);
		}
	}

	public List<TreeNode> generateTrees(int n) {
		HashMap<String, List<TreeNode>> map = new HashMap<String, List<TreeNode>>();
		return generate(1, n, map);
	}

	private List<TreeNode> generate(int start, int end, HashMap<String, List<TreeNode>> map) {
		// TODO Auto-generated method stub
		List<TreeNode> list = new ArrayList<TreeNode>();
		if (start > end) {
			list.add(null);
			return list;
		}
		if (start == end) {
			list.add(new TreeNode(start));
			return list;
		}
		if (map.containsKey(String.valueOf(start) + "#" + String.valueOf(end))) {
			return map.get(String.valueOf(start) + "#" + String.valueOf(end));
		}
		for (int i = start; i <= end; i++) {
			List<TreeNode> left = generate(start, i - 1, map);
			List<TreeNode> right = generate(i + 1, end, map);
			for (TreeNode lRoot : left) {
				for (TreeNode rRoot : right) {
					TreeNode root = new TreeNode(i);
					root.left = lRoot;
					root.right = rRoot;
					list.add(root);
				}
			}
		}
		map.put(String.valueOf(start) + "#" + String.valueOf(end), list);
		return list;
	}
}
