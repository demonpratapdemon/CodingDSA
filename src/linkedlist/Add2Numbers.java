/**
 * 
 */
package linkedlist;

import entities.ListNode;

/**
 * @author PRATAP
 *
 */
public class Add2Numbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(9);
		ListNode temp = l1;
		temp.next = new ListNode(9);
		temp = temp.next;
		temp.next = new ListNode(9);
		ListNode l2 = new ListNode(9);
		temp = l2;
		temp.next = new ListNode(9);
//		temp = temp.next;
//		temp.next = new Node(4);
		ListNode ans = addTwoNumbers(l1, l2);
		while (ans != null) {
			System.out.print(ans.val);
			ans = ans.next;
		}
		System.out.println();
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		l1 = reverse(l1);
		l2 = reverse(l2);
		ListNode ans = null;
		ListNode tail = ans;
		int carry = 0;
		while (l1 != null && l2 != null) {
			int sum = l1.val + l2.val + carry;
			if (sum < 10) {
				if (tail == null) {
					tail = new ListNode(sum);
					ans = tail;
				} else {
					tail.next = new ListNode(sum);
					tail = tail.next;
				}
				carry = 0;
			} else {
				if (tail == null) {
					tail = new ListNode(sum % 10);
					ans = tail;
				} else {
					tail.next = new ListNode(sum % 10);
					tail = tail.next;
				}
				carry = sum / 10;
			}
			l1 = l1.next;
			l2 = l2.next;
		}
		while (l1 != null) {
			int sum = carry + l1.val;
			if (sum < 10) {
				if (tail == null) {
					tail = new ListNode(sum);
				} else {
					tail.next = new ListNode(sum);
					tail = tail.next;
				}
				carry = 0;
			} else {
				if (tail == null) {
					tail = new ListNode(sum % 10);
				} else {
					tail.next = new ListNode(sum % 10);
					tail = tail.next;
				}
				carry = sum / 10;
			}
			l1 = l1.next;
		}

		while (l2 != null) {
			int sum = carry + l2.val;
			if (sum < 10) {
				if (tail == null) {
					tail = new ListNode(sum);
				} else {
					tail.next = new ListNode(sum);
					tail = tail.next;
				}
				carry = 0;
			} else {
				if (tail == null) {
					tail = new ListNode(sum % 10);
				} else {
					tail.next = new ListNode(sum % 10);
					tail = tail.next;
				}
				carry = sum / 10;
			}
			l2 = l2.next;
		}
		if (carry > 0)
			tail.next = new ListNode(carry);
		ans = reverse(ans);
		return ans;
	}

	static ListNode reverse(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode prev = null, curr = head, next = head.next;
		while (next != null) {
			curr.next = prev;
			prev = curr;
			curr = next;
			next = curr.next;
		}
		curr.next = prev;
		return curr;
	}

}
