/**
 * 
 */
package greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author PRATAP
 *
 */
public class HuffmanEncoding {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S = "abcdef";
		int f[] = { 8, 9, 14, 19, 20, 21, 21, 25, 33, 45, 50, 50, 66, 68, 70, 73, 74, 75, 76, 82, 85, 90, 94, 97, 100 };
		ArrayList<String> huffmanCodes = huffmanCodes(S, f, f.length);
		System.out.println(huffmanCodes);
	}

	public static ArrayList<String> huffmanCodes(String S, int f[], int N) {
		// Code here
		PriorityQueue<HuffPair> minHeap = new PriorityQueue<HuffPair>(new Comparator<HuffPair>() {

			@Override
			public int compare(HuffPair o1, HuffPair o2) {
				// TODO Auto-generated method stub
				if (o1.freq == o2.freq)
					return 1;
				return Integer.compare(o1.freq, o2.freq);
			}
		});
		for (int i = 0; i < N; i++) {
			minHeap.add(new HuffPair(f[i]));
		}
		while (!minHeap.isEmpty()) {
			HuffPair left = minHeap.poll();
			HuffPair right = minHeap.poll();
			HuffPair interval = new HuffPair(left.freq + right.freq);
			interval.left = left;
			interval.right = right;
			minHeap.add(interval);
			if (minHeap.size() == 1)
				break;
		}
		HuffPair root = minHeap.poll();
		ArrayList<String> list = new ArrayList<String>();
		preorder(root, "", list);
		return list;
	}

	private static void preorder(HuffPair root, String curr, ArrayList<String> list) {
		// TODO Auto-generated method stub
		if (root.left == null && root.right == null) {
			list.add(curr);
			return;
		}
		preorder(root.left, curr + "0", list);
		preorder(root.right, curr + "1", list);
	}

}

class HuffPair {
	public int freq;
	public HuffPair left;
	public HuffPair right;

	public HuffPair(int freq) {
		super();
		this.freq = freq;
		this.left = null;
		this.right = null;
	}

}
