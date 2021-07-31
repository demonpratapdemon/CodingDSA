/**
 * 
 */
package entities;

/**
 * @author PRATAP
 *
 */
public class TreeNode {

	public int data;
	public TreeNode left;
	public TreeNode right;
	public int height;

	public TreeNode() {
		super();
	}

	public TreeNode(int data) {
		super();
		this.data = data;
		this.left = null;
		this.right = null;
		this.height = 1;
	}

	public TreeNode(int data, TreeNode left, TreeNode right) {
		super();
		this.data = data;
		this.left = left;
		this.right = right;
	}

}
