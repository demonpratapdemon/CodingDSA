/**
 * 
 */
package linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import entities.ListNode;

/**
 * @author PRATAP LeetCode 725
 *
 */
public class SplitLinkedListInParts {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split("\\s+");
		ListNode head = null, temp = head;
		for (String s : input) {
			if (head == null) {
				head = new ListNode(Integer.parseInt(s));
				temp = head;
			} else {
				temp.next = new ListNode(Integer.parseInt(s));
				temp = temp.next;
			}
		}
		int k = Integer.parseInt(br.readLine());
		ListNode[] ans = splitListToParts(head, k);
		for (ListNode l : ans) {
			while (l != null) {
				if (l.next != null)
					System.out.print(l.val + "->");
				else
					System.out.print(l.val);
				l = l.next;
			}
			System.out.println();
		}
	}

	public static ListNode[] splitListToParts(ListNode head, int k) {
		int n = 0;
		ListNode temp = head;
		while (temp != null) {
			n++;
			temp = temp.next;
		}
		ListNode[] result = new ListNode[k];
		int q = n / k;
		int r = n % k;
		temp = head;
		int p = 0;
		while (temp != null) {
			int i = q;
			ListNode curr = null;
			ListNode temp1 = curr;
			while (i-- > 0) {
				if (curr == null) {
					curr = new ListNode(temp.val);
					temp1 = curr;
				} else {
					temp1.next = new ListNode(temp.val);
					temp1 = temp1.next;
				}
				temp = temp.next;
			}
			if (temp != null && r > 0) {
				if (curr == null) {
					curr = new ListNode(temp.val);
					temp1 = curr;
				} else {
					temp1.next = new ListNode(temp.val);
					temp1 = temp1.next;
				}
				r--;
				temp = temp.next;
			}
			temp1.next = null;
			result[p++] = curr;
		}
		return result;
	}
}
