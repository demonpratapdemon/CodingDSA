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
public class LinkedListPalindrome {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split("\\s+");
		Node head = new Node(Integer.parseInt(input[0]));
		Node temp = head;
		for (int i = 1; i < input.length; i++) {
			temp.next = new Node(Integer.parseInt(input[i]));
			temp = temp.next;
		}
		boolean ans = isPalindrome(head);
		System.out.println(ans);
	}

	public static boolean isPalindrome(Node head) {
		if (head == null || head.next == null)
			return true;
		if (head.next.next == null) {
			if (head.data == head.next.data)
				return true;
			else
				return false;
		}
		Node mid = revFromMid(head);
		Node temp = head;
		Node temp1 = mid.next;
		while (temp != mid.next && temp1 != null) {
			if (temp.data != temp1.data)
				return false;
			temp = temp.next;
			temp1 = temp1.next;
		}
		if (temp1 == null && temp != mid && temp.data != temp.next.data) {
			System.out.println("here");
			return false;
		}
		return true;
	}

	private static Node revFromMid(Node head) {
		// TODO Auto-generated method stub
		Node slow = head, fast = head;
		do {
			slow = slow.next;
			fast = fast.next.next;
		} while (fast != null && fast.next != null);
		Node mid = slow;
		Node prev = null, curr = slow.next;
		mid.next = null;
		Node next = curr.next != null ? curr.next : null;
		while (next != null) {
			curr.next = prev;
			prev = curr;
			curr = next;
			next = next.next;
		}
		curr.next = prev;
		mid.next = curr;
		return mid;
	}
}
