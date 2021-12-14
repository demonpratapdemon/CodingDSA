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
 * @author PRATAP LeetCode 563
 *
 */
public class Day08_BinaryTreeTilt {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		Day08_BinaryTreeTilt obj = new Day08_BinaryTreeTilt();
		while (t-- > 0) {
			String[] input = br.readLine().split("\\s+");
			TreeNode root = Utility.createBinaryTree(input);
			int ans = obj.findTilt(root);
			System.out.println(ans);
		}
	}

	int tilt = 0;

	public int findTilt(TreeNode root) {
		findTilt1(root);
		return tilt;
	}
	
	public int findTilt1(TreeNode root) {
		if (root == null)
			return 0;
		int left = findTilt1(root.left);
		int right = findTilt1(root.right);
		tilt += Math.abs(left-right);
		return left + right + root.data;
	}
}
