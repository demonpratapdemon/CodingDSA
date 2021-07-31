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
public class MergeSortForLL {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split("\\s+");
		Node head = new Node();
		Node temp = head;
		Node prev = null;
		for (String in : input) {
			temp.data = Integer.parseInt(in);
			prev = temp;
			temp.next = new Node();
			temp = temp.next;
		}
		prev.next = null;
		head = mergeSort(head);
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}

	public static Node mergeSort(Node head) {
		// add your code here
		if (head == null || head.next == null)
			return head;
		if (head != null && head.next != null) {
			Node slow = head, fast = head;
			while (fast.next != null && fast.next.next != null) {
				slow = slow.next;
				fast = fast.next.next;
			}
			Node next = slow.next;
			slow.next = null;
			head = mergeSort(head);
			next = mergeSort(next);
			head = merge(head, next);
		}
		return head;
	}

	private static Node merge(Node head, Node next) {
		// TODO Auto-generated method stub
		Node temp1 = head, temp2 = next;
		Node newhead = null;
		Node temp = newhead;
		while (temp1 != null && temp2 != null) {
			if (temp1.data <= temp2.data) {
				if (newhead == null) {
					newhead = new Node(temp1.data);
					temp = newhead;
				} else {
					temp.next = new Node(temp1.data);
					temp = temp.next;
				}
				temp1 = temp1.next;
			} else {
				if (newhead == null) {
					newhead = new Node(temp2.data);
					temp = newhead;
				} else {
					temp.next = new Node(temp2.data);
					temp = temp.next;
				}
				temp2 = temp2.next;
			}
		}
		while (temp1 != null) {
			temp.next = new Node(temp1.data);
			temp = temp.next;
			temp1 = temp1.next;
		}
		while (temp2 != null) {
			temp.next = new Node(temp2.data);
			temp = temp.next;
			temp2 = temp2.next;
		}
		temp.next = null;
		return newhead;
	}
}
