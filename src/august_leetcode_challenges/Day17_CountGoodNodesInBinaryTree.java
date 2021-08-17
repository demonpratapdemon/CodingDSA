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
 * @author PRATAP
 *
 */
public class Day17_CountGoodNodesInBinaryTree {

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
			Day17_CountGoodNodesInBinaryTree obj = new Day17_CountGoodNodesInBinaryTree();
			int ans = obj.goodNodes(root);
			System.out.println(ans);
		}
	}

	int ans = 0;

	public int goodNodes(TreeNode root) {
		ans = 0;
		find(root, root.data);
		return ans;
	}

	public void find(TreeNode root, int max) {
		if (root == null)
			return;
		if (root.data >= max)
			ans++;
		find(root.left, Math.max(max, root.data));
		find(root.right, Math.max(max, root.data));
	}
}
