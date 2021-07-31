/**
 * 
 */
package binarytrees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import entities.TreeNode;
import util.Utility;

/**
 * @author PRATAP LeetCode 987
 *
 */
public class VerticalOrderTraversal {

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
			List<List<Integer>> list = verticalOrder(root);
			StringBuilder sb = new StringBuilder();
			for (List<Integer> i : list)
				sb.append(i + " ");
			System.out.println(sb.toString());
		}
	}

	public static List<List<Integer>> verticalOrder(TreeNode root) {
		// add your code here
		HashMap<Integer, ArrayList<VOPair>> hm = new HashMap<Integer, ArrayList<VOPair>>();
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		if (root == null) {
			return ans;
		}
		levelOrderTraversal(root, 0, 0, hm);
		Object[] keys = hm.keySet().toArray();
		Arrays.sort(keys);
		for (Object key : keys) {
			ArrayList<VOPair> pairs = hm.get(key);
			ArrayList<Integer> arr = new ArrayList<Integer>();
			for (VOPair pair : pairs) {
				arr.add(pair.node.data);
			}
			ans.add(arr);
		}
		return ans;
	}

	private static void levelOrderTraversal(TreeNode root, int row, int hd, HashMap<Integer, ArrayList<VOPair>> hm) {
		if (root == null)
			return;
		Queue<VOPair> q = new LinkedList<VOPair>();
		q.add(new VOPair(root, row, hd));
		while (!q.isEmpty()) {
			VOPair curr = q.remove();
			int currRow = curr.row;
			int currCol = curr.hd;
			if (!hm.containsKey(currCol)) {
				ArrayList<VOPair> arr = new ArrayList<VOPair>();
				arr.add(curr);
				hm.put(currCol, arr);
			} else {
				ArrayList<VOPair> arr = hm.get(currCol);
				VOPair prev = arr.get(arr.size() - 1);
				if (prev.row == curr.row && prev.node.data > curr.node.data) {
					arr.set(arr.size() - 1, curr);
					arr.add(prev);
					int currIdx = arr.size() - 2;
					while (currIdx >= 1) {
						if (arr.get(currIdx - 1).row == curr.row && arr.get(currIdx - 1).node.data > curr.node.data) {
							prev = arr.get(currIdx - 1);
							arr.set(currIdx - 1, curr);
							arr.set(currIdx, prev);
						} else 
							break;
						currIdx--;
					}
				} else
					arr.add(curr);
				hm.put(currCol, arr);
			}
			if (curr.node.left != null) {
				q.add(new VOPair(curr.node.left, currRow + 1, currCol - 1));
			}
			if (curr.node.right != null) {
				q.add(new VOPair(curr.node.right, currRow + 1, currCol + 1));
			}
		}

	}
}

class VOPair {
	public TreeNode node;
	public Integer row;
	public Integer hd;

	public VOPair(TreeNode node, int row, int hd) {
		super();
		this.node = node;
		this.row = row;
		this.hd = hd;
	}
}
