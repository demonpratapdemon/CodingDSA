/**
 * 
 */
package heaps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

import entities.ListNode;

/**
 * @author PRATAP LeetCode 23
 *
 */
public class MergeKSortedArrays {

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ListNode[] lists = new ListNode[n];
		for (int i = 0; i < n; i++) {
			String[] arr = br.readLine().split("\\s+");
			ListNode head = new ListNode(Integer.parseInt(arr[0]));
			ListNode tail = head;
			for (int j = 1; j < arr.length; j++) {
				tail.next = new ListNode(Integer.parseInt(arr[j]));
				tail = tail.next;
			}
			lists[i] = head;
		}
		ListNode merged = mergeKLists(lists);
		while (merged != null) {
			System.out.print(merged.val + " ");
			merged = merged.next;
		}
	}

	public static ListNode mergeKLists(ListNode[] lists) {
		int n = lists.length;
		ListNode ans = new ListNode();
		if (n <= 0)
			return null;
		MergeKNode[] arr = new MergeKNode[n];
		int p = 0;
		PriorityQueue<MergeKNode> minHeap = new PriorityQueue<MergeKNode>(new KMergeCompartor());
		for (int i = 0; i < n; i++) {
			if (lists[i] != null) {
				arr[p] = new MergeKNode(lists[i], p);
				minHeap.add(new MergeKNode(lists[i], p));
				p++;
			}
		}
		if (minHeap.size() <= 0) {
			return null;
		}
		ListNode tail = ans;
		ListNode prev = null;
		while (minHeap.size() > 0) {
			MergeKNode curr = minHeap.poll();
			int i = curr.row;
			tail.val = curr.node.val;
			if (arr[i].node.next != null) {
				arr[i] = new MergeKNode(arr[i].node.next, i);
				minHeap.add(new MergeKNode(arr[i].node, i));
			}
			tail.next = new ListNode();
			prev = tail;
			tail = tail.next;
		}
		if (prev != null)
			prev.next = null;
		return ans;
	}

}

class KMergeCompartor implements Comparator<MergeKNode> {

	@Override
	public int compare(MergeKNode o1, MergeKNode o2) {
		// TODO Auto-generated method stub
		return (o1.node.val > o2.node.val) ? 1 : -1;
	}

}

class MergeKNode {
	public ListNode node;
	public int row;

	public MergeKNode() {
		super();
	}

	public MergeKNode(ListNode node, int row) {
		super();
		this.node = node;
		this.row = row;
	}
}
