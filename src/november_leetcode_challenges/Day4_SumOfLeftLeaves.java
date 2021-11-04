/**
 * 
 */
package november_leetcode_challenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import entities.TreeNode;
import util.Utility;

/**
 * @author PRATAP LeetCode 404
 *
 */
public class Day4_SumOfLeftLeaves {

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
			Day4_SumOfLeftLeaves obj = new Day4_SumOfLeftLeaves();
			int ans = obj.sumOfLeftLeaves(root);
			System.out.println(ans);
		}
	}

	int sum = 0;

	public int sumOfLeftLeaves(TreeNode root) {
		if (root == null)
			return sum;
		find(root, false);
		return sum;
	}

	public void find(TreeNode root, boolean val) {
		if (root == null)
			return;
		if (root.left == null && root.right == null && val) {
			sum += root.data;
			return;
		}
		find(root.left, true);
		find(root.right, false);
	}
}
