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
public class QuickSortOnLL {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split("\\s+");
		Node head = null, temp = null;
		for (String str : input) {
			if (head == null) {
				head = new Node(Integer.parseInt(str));
				temp = head;
			} else {
				temp.next = new Node(Integer.parseInt(str));
				temp = temp.next;
			}
		}
		temp.next = null;
		head = quickSort(head);
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}

	public static Node quickSort(Node node) {
		// Your code here
		Node end = node;
		while (end.next != null)
			end = end.next;
		quickSorted(node, end);
		return node;
	}

	private static void quickSorted(Node start, Node end) {
		// TODO Auto-generated method stub
		if (start == null || start.next == null || start == end)
			return;
		Node pivotPrev = partition(start, end);
		quickSorted(start, pivotPrev);
		if (pivotPrev != null && pivotPrev == start)
			quickSorted(pivotPrev.next, end);
		else if (pivotPrev != null && pivotPrev.next != null && pivotPrev.next != end) {
			quickSorted(pivotPrev.next.next, end);
		}
	}

	private static Node partition(Node start, Node end) {
		if (start == end || start == null || end == null)
			return start;
		Node prev = start, curr = start;
		int pivot = end.data;
		while (start != end) {
			if (start.data <= pivot) {
				prev = curr;
				int temp = curr.data;
				curr.data = start.data;
				start.data = temp;
				curr = curr.next;
			}
			start = start.next;
		}
		int temp = curr.data;
		curr.data = pivot;
		end.data = temp;

		return prev;
	}

}