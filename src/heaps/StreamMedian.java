/**
 * 
 */
package heaps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author PRATAP
 *
 */
public class StreamMedian {

	static PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			return -o1.compareTo(o2);
		}
	});
	static PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
	static double currentMedian = -1;

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		while (n-- > 0) {
			int x = Integer.parseInt(br.readLine());
			insertHeap(x);
			System.out.println(getMedian());
		}
	}

	public static void insertHeap(int x) {
		// add your code here
		if (x < currentMedian) {
			maxHeap.add(x);
		} else {
			minHeap.add(x);
		}
		balanceHeaps();
	}

	// Function to balance heaps.
	public static void balanceHeaps() {
		// add your code here
		int maxHeapSize = maxHeap.size();
		int minHeapSize = minHeap.size();
		if (maxHeapSize == minHeapSize)
			return;
		if (maxHeapSize > minHeapSize + 1) {
			int popped = maxHeap.poll();
			minHeap.add(popped);
		} else if (minHeapSize > maxHeapSize + 1) {
			int popped = minHeap.poll();
			maxHeap.add(popped);
		}
	}

	// Function to return Median.
	public static double getMedian() {
		// add your code here
		int maxHeapSize = maxHeap.size();
		int minHeapSize = minHeap.size();
		if (maxHeapSize > minHeapSize) {
			currentMedian = maxHeap.peek();
			return maxHeap.peek();
		} else if (minHeapSize > maxHeapSize) {
			currentMedian = minHeap.peek();
			return minHeap.peek();
		} else {
			currentMedian = (maxHeap.peek() + minHeap.peek()) / 2.0;
			return (maxHeap.peek() + minHeap.peek()) / 2.0;
		}
	}

}
