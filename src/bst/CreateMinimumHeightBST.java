/**
 * 
 */
package bst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

import entities.TreeNode;
import util.Utility;

/**
 * @author PRATAP
 *
 */
public class CreateMinimumHeightBST {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split("\\s+");
		int[] arr = new int[input.length];
		int p = 0;
		TreeNode root = null;
		for (String s : input) {
			arr[p++] = Integer.parseInt(s);
		}
		Arrays.sort(arr);
		root = Utility.createMinHeightBST(arr, 0, arr.length - 1);
		List<Integer> output = Utility.printInorderBST(root);
		System.out.println(output);
	}

}
