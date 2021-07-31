/**
 * 
 */
package linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import entities.Node;

/**
 * @author PRATAP
 *
 */
public class Add1ToLL {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split("\\s+");
		Node head = new Node(Integer.parseInt(inputs[0]), null);
		Node temp = head;
		for (int i = 1; i < inputs.length; i++) {
			temp.next = new Node(Integer.parseInt(inputs[i]), null);
			temp = temp.next;
		}
		head = addOne(head);
		temp = head;
		while (temp != null) {
			System.out.print(temp.data + "");
			temp = temp.next;
		}
		System.out.println();
	}

	public static Node addOne(Node head) {
		// code here.
		head = reverse(head);
		int carry = 0;
		if (head.data + 1 < 10) {
			head.data += 1;
		} else {
			Node temp = head;
			int x = (temp.data + 1);
			temp.data = (x) % 10;
			carry = (x) / 10;
			Node prev = temp;
			temp = temp.next;
			while (carry > 0 && (temp != null)) {
				if (temp.data + carry < 10) {
					temp.data += carry;
					carry = 0;
					prev = temp;
					break;
				} else {
					x = (temp.data + carry);
					temp.data = (x) % 10;
					carry = x / 10;
					prev = temp;
					temp = temp.next;
				}
			}
			if (carry > 0) {
				prev.next = new Node(carry, null);
			}
		}
		head = reverse(head);
		return head;
	}

	public static Node reverse(Node head) {
		if (head == null)
			return null;
		Node temp = head;
		Node next = reverse(head.next);
		if (next != null) {
			temp.next = null;
			Node x = next;
			while (x.next != null)
				x = x.next;
			x.next = temp;
			return next;
		}
		return temp;
	}

}
