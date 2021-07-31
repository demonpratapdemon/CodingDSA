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
 * @author PRATAP
 *
 */
public class CheckIsomorphism {

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String[] input = br.readLine().split("\\s+");
			TreeNode root1 = Utility.createBinaryTree(input);
			input = br.readLine().split("\\s+");
			TreeNode root2 = Utility.createBinaryTree(input);
			System.out.println(isIsomorphic(root1, root2) ? "Yes" : "No");
		}
	}

	public static boolean isIsomorphic(TreeNode root1, TreeNode root2) {
		// code here.
		if(root1 == null && root2 == null)
            return true;
        else if((root1 == null && root2 != null) || (root1 != null && root2 == null))
            return false;
        if (root1.data != root2.data)
			return false;
		boolean res1 = true, res2 = true;
		
		res1 = res1 & isIsomorphic(root1.left, root2.left);
		res1 = res1 & isIsomorphic(root1.right, root2.right);
		
		res2 = res2 & isIsomorphic(root1.left, root2.right);
		res2 = res2 & isIsomorphic(root1.right, root2.left);
		return res1 | res2;
	}

}
