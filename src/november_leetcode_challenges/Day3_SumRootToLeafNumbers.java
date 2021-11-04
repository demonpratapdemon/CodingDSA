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
 * @author PRATAP LeetCode 129
 *
 */
public class Day3_SumRootToLeafNumbers {

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
			Day3_SumRootToLeafNumbers obj = new Day3_SumRootToLeafNumbers();
			int ans = obj.sumNumbers(root);
			System.out.println(ans);
		}
	}

	int sum = 0;

	public int sumNumbers(TreeNode root) {
		if (root == null)
			return sum;
		find(root, "");
		return sum;
	}

	public void find(TreeNode root, String s) {
		if (root == null)
			return;
		if (root.left == null && root.right == null) {
			s = s + String.valueOf(root.data);
			sum += Integer.parseInt(s);
			return;
		}
		find(root.left, s + String.valueOf(root.data));
		find(root.right, s + String.valueOf(root.data));
	}
}
