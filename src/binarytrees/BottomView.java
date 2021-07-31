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
import java.util.Queue;

import entities.TreeNode;
import util.Utility;

/**
 * @author PRATAP
 *
 */
public class BottomView {

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
			ArrayList<Integer> list = bottomView(root);
			System.out.println(list);
		}
	}

	public static ArrayList<Integer> bottomView(TreeNode root) {
		// Code here
		ArrayList<Integer> ans = new ArrayList<Integer>();
		if (root == null)
			return ans;
		HashMap<Integer, ArrayList<BottomPair>> map = new HashMap<Integer, ArrayList<BottomPair>>();
		verticalOrderTraversal(root, map);
		Object[] keys = map.keySet().toArray();
		Arrays.sort(keys);
		for (Object key : keys) {
			ArrayList<BottomPair> list = map.get(key);
			ans.add(list.get(list.size() - 1).node.data);
		}
		return ans;
	}

	private static void verticalOrderTraversal(TreeNode root, HashMap<Integer, ArrayList<BottomPair>> map) {
		// TODO Auto-generated method stub
		Queue<BottomPair> q = new LinkedList<BottomPair>();
		q.add(new BottomPair(0, 0, root));
		while (!q.isEmpty()) {
			BottomPair curr = q.poll();
			int currRow = curr.row, currCol = curr.hd;
			if (map.containsKey(currCol)) {
				ArrayList<BottomPair> arr = new ArrayList<BottomPair>();
				arr.add(curr);
				map.put(currCol, arr);
			} else {
				ArrayList<BottomPair> arr = new ArrayList<BottomPair>();
				arr.add(curr);
				map.put(currCol, arr);
			}

			if (curr.node.left != null) {
				q.add(new BottomPair(currRow + 1, currCol - 1, curr.node.left));
			}
			if (curr.node.right != null) {
				q.add(new BottomPair(currRow + 1, currCol + 1, curr.node.right));
			}
		}
	}
}

class BottomPair {
	public int row;
	public int hd;
	public TreeNode node;

	public BottomPair(int row, int hd, TreeNode node) {
		super();
		this.row = row;
		this.hd = hd;
		this.node = node;
	}

}
