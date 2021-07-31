/**
 * 
 */
package miscellaneous;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author PRATAP Greedy Approach (Adobe) LeetCode 1353
 *
 */
public class MaximumNoOfEventsThatCanBeAttended {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int start[] = { 1, 2, 3 };
		int end[] = { 2, 3, 4 };
		int N = start.length;
		int maxEvents = maxEvents(start, end, N);
		System.out.println(maxEvents);
	}

	static int maxEvents(int[] start, int[] end, int N) {
		if (N == 0)
			return 0;
		EventPair[] arr = new EventPair[N];
		int max = -1;
		for (int i = 0; i < N; i++) {
			arr[i] = new EventPair(start[i], end[i]);
			max = Math.max(max, arr[i].end);
		}
		Arrays.sort(arr, new EventComp());
		int count = 0;
		PriorityQueue<EventPair> pq = new PriorityQueue<EventPair>(new EventComp1());
		int ptr = 0;
		for (int day = 1; day <= 100000; day++) {
			while (ptr < N && arr[ptr].start == day) {
				pq.add(arr[ptr]);
				ptr++;
			}
			while (!pq.isEmpty() && pq.peek().end < day) {
				pq.poll();
			}
			if (!pq.isEmpty()) {
				count++;
				pq.poll();
			}
		}
		return count;
	}

	public static int search(int start, int end, boolean[] days) {
		int ans = -1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (!days[mid]) {
				ans = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		for (int i = start; i <= ans; i++) {
			if (!days[i]) {
				ans = i;
				break;
			}
		}
		return ans;
	}

}

class EventComp implements Comparator<EventPair> {
	public int compare(EventPair o1, EventPair o2) {
		return Integer.compare(o1.start, o2.start);
	}
}

class EventComp1 implements Comparator<EventPair> {
	public int compare(EventPair o1, EventPair o2) {
		return Integer.compare(o1.end, o2.end);
	}
}

class EventPair {
	public int start;
	public int end;

	public EventPair(int start, int end) {
		this.start = start;
		this.end = end;
	}
}
