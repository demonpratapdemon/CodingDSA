/**
 * 
 */
package linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;

import entities.ListNode;
import entities.Node;

/**
 * @author PRATAP
 *
 */
public class ReverseLL {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		LinkedList<Integer> ll = new LinkedList<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String[] inputs = br.readLine().split("\\s+");
//		for (String input : inputs) {
//			ll.add(Integer.parseInt(input));
//		}
//		ll = reverseRecursively(ll);
//		ll = reverseIeratively(ll);
//		Iterator<Integer> itr = ll.iterator();
//		while (itr.hasNext())
//			System.out.print(itr.next() + " ");
		ListNode head = new ListNode();
		head.val = 1;
		ListNode temp = head;
		temp.next = new ListNode(2);
		temp = temp.next;
		temp.next = new ListNode(3);
		temp = temp.next;
		temp.next = new ListNode(4);
		temp = temp.next;
		temp.next = new ListNode(5);
		temp.next.next = null;
		ListNode node = reverseKGroup(head, 1);
//		Node reverse = solveRecur(head);
//		while (reverse != null) {
//			System.out.print(reverse.data + "->");
//			reverse = reverse.next;
//		}
	}

	private static LinkedList<Integer> reverseIeratively(LinkedList<Integer> ll) {
		// TODO Auto-generated method stub
		Iterator<Integer> itr = ll.iterator();
		Node head = new Node(itr.next(), null);
		Node temp = head;
		while (itr.hasNext()) {
			temp.next = new Node(itr.next(), null);
			temp = temp.next;
		}
		Node prev = null, curr = head, next = head.next;
		while (next != null) {
			curr.next = prev;
			prev = curr;
			curr = next;
			next = next.next;
		}
		curr.next = prev;
		head = curr;
		temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		return null;
	}

	private static LinkedList<Integer> reverseRecursively(LinkedList<Integer> ll) {
		// TODO Auto-generated method stub
		if (ll.isEmpty())
			return null;
		Integer temp = ll.poll();
		reverseRecursively(ll);
		ll.add(temp);
		return ll;
	}

	static Node finalHead;

	private static Node solveRecur(Node head) {
		reverseRecursive(head);
		return finalHead;
	}

	private static Node reverseRecursive(Node head) {
		if (head == null) {
			return null;
		}
		Node temp = head;
		Node next = reverseRecursive(head.next);
		temp.next = null;
		if (next != null) {
			next.next = temp;
			next = next.next;
		} else {
			next = temp;
			finalHead = next;
		}
		return next;
	}

	public static ListNode reverseKGroup(ListNode head, int k) {
		ListNode temp = head;
		boolean flag = false;
		int f = -1;
		ListNode prevTail = null;
		ListNode curr = null;
		while (temp != null) {
			curr = temp;
			for (int i = 1; i < k; i++) {
				if (temp == null) {
					flag = true;
					break;
				}
				temp = temp.next;
			}
			if (flag)
				break;
			if (temp == null)
				break;
			ListNode hold = temp.next;
			temp.next = null;
			ListNode newHead = reverse(curr);
			if (f == -1) {
				f++;
				head = newHead;
			} else {
				prevTail.next = newHead;
			}
			prevTail = curr;
			temp = hold;
		}
		prevTail.next = curr;
		return head;
	}

	public static ListNode reverse(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode prev = null, curr = head, next = head.next;
		while (next != null) {
			curr.next = prev;
			prev = curr;
			curr = next;
			next = next.next;
		}
		curr.next = prev;
		head = curr;
		return head;
	}
}
