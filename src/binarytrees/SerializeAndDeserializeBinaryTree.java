/**
 * 
 */
package binarytrees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Stack;

import entities.TreeNode;
import util.Utility;

/**
 * @author PRATAP LeetCode 297
 *
 */
public class SerializeAndDeserializeBinaryTree {

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
			Codec obj = new Codec();
			String serialized = obj.serialize(root);
			TreeNode deserialized = obj.deserialize(serialized);
			List<Integer> ans = Utility.levelOrderTraversal(deserialized);
			System.out.println(ans);
		}
	}

}

class Codec {

	public void serialize(TreeNode root, StringBuilder sb) {
		if (root == null) {
			sb.append("null,");
			return;
		}
		sb.append(root.data + ",");
		serialize(root.left, sb);
		serialize(root.right, sb);
	}

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		StringBuilder sb = new StringBuilder();
		if (root == null)
			return "null";
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode curr = stack.pop();
			if (curr != null && sb.length() == 0)
				sb.append(curr.data);
			else if (curr != null)
				sb.append(",").append(curr.data);
			else
				sb.append(",null");
			if (curr != null) {
				stack.push(curr.right);
				stack.push(curr.left);
			}
		}
		return sb.toString();
	}

	static int idx = 0;

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		String[] nodes = data.trim().split(",");
		idx = 0;
		return deserialize(nodes);
	}

	public TreeNode deserialize(String[] nodes) {
		if (idx >= nodes.length || nodes[idx].trim().equalsIgnoreCase("null")) {
			idx++;
			return null;
		}
		TreeNode root = new TreeNode(Integer.parseInt(nodes[idx++]));
		root.left = deserialize(nodes);
		root.right = deserialize(nodes);
		return root;
	}
}
