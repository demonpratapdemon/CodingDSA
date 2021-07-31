/**
 * 
 */
package linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import entities.Node;

/**
 * @author PRATAP LeetCode 25
 *
 */
public class ReverseLLInGroup {

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
		int k = Integer.parseInt(br.readLine());
		head = reverse(head, k);
		temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

	public static Node reverse(Node node, int k) {
		// Your code here
		int count = 0;
		Node temp = node;
		while (temp != null) {
			count++;
			temp = temp.next;
		}
		int groups = Math.floorDiv(count, k);
		Node prev = null, curr = node, next = curr.next;
		node = null;
		temp = null;
		while (groups > 0) {
			for (int i = 0; i < k - 1; i++) {
				curr.next = prev;
				prev = curr;
				curr = next;
				next = curr.next;
			}
			curr.next = prev;
			if (node == null) {
				node = curr;
				temp = node;
			} else {
				temp.next = curr;
			}
			while (temp.next != null)
				temp = temp.next;
			groups--;
			if (groups > 0) {
				curr = next;
				prev = null;
				if (next != null)
					next = next.next;
			}

		}
//		temp.next = next;  ===> For Leetcode, only allow this part
//		For GFG, allow the below part
		if (next != null) {
			prev = null;
			curr = next;
			if (next != null)
				next = next.next;
//		prev = temp;
			while (next != null) {
				curr.next = prev;
				prev = curr;
				curr = next;
				next = next.next;
			}
			curr.next = prev;
			temp.next = curr;
		} else
			temp.next = next;
		return node;
	}

}
