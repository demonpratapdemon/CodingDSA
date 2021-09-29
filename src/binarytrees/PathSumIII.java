/**
 * 
 */
package binarytrees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import entities.TreeNode;
import util.Utility;

/**
 * @author PRATAP LeetCode 437
 *
 */
public class PathSumIII {

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
			PathSumIII obj = new PathSumIII();
			int ans = obj.pathSum(root, targetSum);
			System.out.println(ans);
		}
	}

	public int pathSum(TreeNode root, int targetSum) {
		if (root == null)
			return 0;
		return pathSum(root.left, targetSum) + pathSum(root.right, targetSum) + findPath(root, targetSum);
	}

	private int findPath(TreeNode root, int targetSum) {
		// TODO Auto-generated method stub
		if (root == null)
			return 0;
		int res = 0;
		if (root.data == targetSum)
			res++;
		res += findPath(root.left, targetSum - root.data) + findPath(root.right, targetSum - root.data);
		return res;
	}
}
