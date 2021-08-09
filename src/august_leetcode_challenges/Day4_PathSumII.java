/**
 * 
 */
package august_leetcode_challenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import entities.TreeNode;
import util.Utility;

/**
 * @author PRATAP
 *
 */
public class Day4_PathSumII {

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
			int targetSum = Integer.parseInt(br.readLine());
			List<List<Integer>> ans = pathSum(root, targetSum);
			System.out.println(ans);
		}
	}

	public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		solve(root, targetSum, ans, 0, "");
		return ans;
	}

	private static void solve(TreeNode root, int targetSum, List<List<Integer>> ans, int ssf, String path) {
		// TODO Auto-generated method stub
		if (root == null)
			return;
		if (root.left == null && root.right == null) {
			if (ssf + root.data == targetSum) {
				path +=  root.data;
				String[] buff = path.trim().split("\\s+");
				List<Integer> list = new ArrayList<Integer>();
				for (String s : buff)
					list.add(Integer.parseInt(s));
				list.add(root.data);
			}
			return;
		}
		solve(root.left, targetSum, ans, ssf + root.data, path + root.data + " ");
		solve(root.right, targetSum, ans, ssf + root.data, path + root.data + " ");
	}
}
