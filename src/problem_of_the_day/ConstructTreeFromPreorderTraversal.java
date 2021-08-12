/**
 * 
 */
package problem_of_the_day;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import entities.TreeNode;
import util.Utility;

/**
 * @author PRATAP
 *
 */
public class ConstructTreeFromPreorderTraversal {

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
			String[] chars = br.readLine().split("\\s+");
			int n = input.length;
			int[] pre = new int[n];
			char[] preLN = new char[n];
			for (int i = 0; i < n; i++) {
				preLN[i] = chars[i].charAt(0);
				pre[i] = Integer.parseInt(input[i]);
			}
			ConstructTreeFromPreorderTraversal obj = new ConstructTreeFromPreorderTraversal();
			TreeNode node = obj.constructTree(n, pre, preLN);
			List<Integer> list = Utility.printInorderBST(node);
			System.out.println(list);
		}
	}

	public int k = -1;

	TreeNode constructTree(int n, int pre[], char preLN[]) {
		// code here
		if (n == 1) {
			return new TreeNode(pre[0]);
		}
		TreeNode node = new TreeNode(pre[0]);
		k = 1;
		createTree(node, pre, preLN, 1);
		return node;
	}

	private void createTree(TreeNode node, int[] pre, char[] preLN, int i) {
		// TODO Auto-generated method stub
		if (k >= pre.length)
			return;
		node.left = new TreeNode(pre[k]);
		if (preLN[k] == 'N') {
			k++;
			createTree(node.left, pre, preLN, i);
		} else {
			k++;
		}
		node.right = new TreeNode(pre[k]);
		if (preLN[k] == 'N') {
			k++;
			createTree(node.right, pre, preLN, i);
		} else {
			k++;
		}
	}
}

class Tree {
	public TreeNode node;
	public int i;

	public Tree(TreeNode node, int i) {
		super();
		this.node = node;
		this.i = i;
	}

}
