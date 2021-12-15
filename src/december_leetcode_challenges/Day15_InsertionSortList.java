/**
 * 
 */
package december_leetcode_challenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import entities.ListNode;

/**
 * @author PRATAP LeetCode 147
 *
 */
public class Day15_InsertionSortList {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ListNode head = null, temp = null;
		String[] input = br.readLine().split("\\s+");
		for (int i = 0; i < input.length; i++) {
			int x = Integer.parseInt(input[i]);
			if (head == null) {
				head = new ListNode(x);
				temp = head;
			} else {
				temp.next = new ListNode(x);
				temp = temp.next;
			}
		}
		Day15_InsertionSortList obj = new Day15_InsertionSortList();
		head = obj.insertionSortList(head);
		temp = head;
		while (temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
	}

	public ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode temp = head.next, prev = head, temp1 = null;
		while (temp != null) {
			temp1 = temp.next;
			if (temp.val < prev.val) {
				ListNode node = temp;
				prev.next = node.next;
				node.next = null;
				if (node.val < head.val) {
					node.next = head;
					head = node;
				} else {
					ListNode x = head;
					while (x != null && x.next != null && x.next.val < node.val) {
						x = x.next;
					}
					node.next = x.next;
					x.next = node;
				}
				temp = temp1;
			} else {
				temp = temp1;
				prev = prev.next;
			}
		}
		return head;
	}

}
