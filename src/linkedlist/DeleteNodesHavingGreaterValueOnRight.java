/**
 * 
 */
package linkedlist;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import entities.Node;

/**
 * @author PRATAP
 *
 */
public class DeleteNodesHavingGreaterValueOnRight {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split("\\s+");
		Node head = null;
		Node temp = null;
		for (String str : input) {
			if (head == null) {
				head = new Node(Integer.parseInt(str));
				temp = head;
			} else {
				temp.next = new Node(Integer.parseInt(str));
				temp = temp.next;
			}
		}
		Node ans = compute(head);
		while (ans != null) {
			System.out.print(ans.data + " ");
			ans = ans.next;
		}
	}

	public static Node compute(Node head) {
		// your code here
		if (head == null)
			return head;
		head = reverse(head);

		Node temp = head;
		int max = head.data;
		while (temp != null) {
			if (temp.next != null && temp.next.data < max) {
				temp.next = temp.next.next;
			} else {
				temp = temp.next;
				if (temp != null)
					max = Math.max(max, temp.data);
			}
		}

		return reverse(head);
	}

	private static Node reverse(Node head) {
		// TODO Auto-generated method stub
		Node prev = null, curr = head, next = head;
		while (next != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

}
