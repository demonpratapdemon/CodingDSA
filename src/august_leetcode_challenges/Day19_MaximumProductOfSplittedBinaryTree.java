/**
 * 
 */
package august_leetcode_challenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import entities.TreeNode;
import util.Utility;

/**
 * @author PRATAP LeetCode 1339
 *
 */
public class Day19_MaximumProductOfSplittedBinaryTree {

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
			Day19_MaximumProductOfSplittedBinaryTree obj = new Day19_MaximumProductOfSplittedBinaryTree();
			int ans = obj.maxProduct(root);
			System.out.println(ans);
		}
	}

	public long max = 0;
	public long mod = (long) (1e9 + 7);

	public int maxProduct(TreeNode root) {
		int totalSum = findTotalSum(root);
		max = 0;
		findMaxProd(root, totalSum);
		return (int) (max % mod);
	}

	private long findMaxProd(TreeNode root, int totalSum) {
		// TODO Auto-generated method stub
		if (root == null)
			return 0;
		long left = findMaxProd(root.left, totalSum);
		long right = findMaxProd(root.right, totalSum);
		long subtreeSum = left + root.data + right;
		max = Math.max(max, ((totalSum - subtreeSum) * subtreeSum));
		return subtreeSum;
	}

	private int findTotalSum(TreeNode root) {
		// TODO Auto-generated method stub
		if (root == null)
			return 0;
		return root.data + findTotalSum(root.left) + findTotalSum(root.right);
	}
}
