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
public class DetectLoopInLinkedList {

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
		boolean ans = detectLoop(head);
		System.out.println(ans);
	}

	public static boolean detectLoop(Node head) {
		// Add code here
		if (head == null)
			return false;
		Node slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return true;
			}
		}
		return false;
	}

}
