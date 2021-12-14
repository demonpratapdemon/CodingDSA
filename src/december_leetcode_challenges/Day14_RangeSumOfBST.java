/**
 * 
 */
package december_leetcode_challenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import entities.TreeNode;
import util.Utility;

/**
 * @author PRATAP LeetCode 938
 *
 */
public class Day14_RangeSumOfBST {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		Day14_RangeSumOfBST obj = new Day14_RangeSumOfBST();
		while (t-- > 0) {
			String[] input = br.readLine().split("\\s+");
			TreeNode root = Utility.createBinaryTree(input);
			int low = Integer.parseInt(br.readLine().trim());
			int high = Integer.parseInt(br.readLine().trim());
			int ans = obj.rangeSumBST(root, low, high);
			System.out.println(ans);
		}
	}

	int sum = 0;

	public int rangeSumBST(TreeNode root, int low, int high) {
		sum = 0;
		findSum(root, low, high);
		return sum;
	}

	public void findSum(TreeNode root, int low, int high) {
		if (root == null)
			return;
		if (root.data >= low && root.data <= high)
			sum += root.data;
		if (root.data > low) {
			findSum(root.left, low, high);
		}
		if (root.data < high) {
			findSum(root.right, low, high);
		}
	}
}
