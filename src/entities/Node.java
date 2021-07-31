/**
 * 
 */
package entities;

/**
 * @author PRATAP
 *
 */
public class Node {

	public int data;
	public Node next;

	public Node() {
		super();
	}

	public Node(int data) {
		super();
		this.data = data;
	}

	public Node(int data, Node next) {
		super();
		this.data = data;
		this.next = next;
	}

}
