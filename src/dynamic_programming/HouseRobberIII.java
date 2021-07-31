/**
 * 
 */
package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import entities.TreeNode;
import util.Utility;

/**
 * @author PRATAP LeetCode 337
 *
 */
public class HouseRobberIII {

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
			HouseRobberIII obj = new HouseRobberIII();
			int ans = obj.rob(root);
			System.out.println(ans);
		}
	}

	public int rob(TreeNode root) {
		Robbery left = solve(root.left);
		Robbery right = solve(root.right);
		int with = root.data + left.without + right.without;
		int without = Math.max(left.with, left.without) + Math.max(right.with, right.without);
		return Math.max(with, without);
	}

	private Robbery solve(TreeNode node) {
		// TODO Auto-generated method stub
		if (node == null) {
			return new Robbery(0, 0);
		}
		Robbery left = solve(node.left);
		Robbery right = solve(node.right);
		int with = node.data + left.without + right.without;
		int without = Math.max(left.with, left.without) + Math.max(right.with, right.without);
		return new Robbery(with, without);
	}
}

class Robbery {
	public int with;
	public int without;

	public Robbery(int with, int without) {
		super();
		this.with = with;
		this.without = without;
	}

}
