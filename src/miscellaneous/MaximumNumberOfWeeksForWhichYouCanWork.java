/**
 * 
 */
package miscellaneous;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author PRATAP LeetCode 1953
 *
 */
public class MaximumNumberOfWeeksForWhichYouCanWork {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] milestones = { 5, 9, 4, 4, 8, 9, 9, 8, 7, 3 };
		MaximumNumberOfWeeksForWhichYouCanWork obj = new MaximumNumberOfWeeksForWhichYouCanWork();
//		Solution obj1 = new Solution();
		long ans = obj.numberOfWeeks(milestones);
		System.out.println(ans);
	}

	public long numberOfWeeks(int[] milestones) {
		Arrays.sort(milestones);
		int n = milestones.length;
		int max = milestones[n - 1];
		long sum = milestones[n - 1];
		long x = 0;
		for (int i = n - 2; i >= 0; i--) {
			x += milestones[i];
			sum += milestones[i];
		}
		if (max > x + 1) {
			return 2 * x + 1;
		} else {
			return sum;
		}
	}
}

class Solution {
	public long numberOfWeeks(int[] milestones) {
		long weeks = 0;
		PriorityQueue<Mile> pq = new PriorityQueue<Mile>();
		int n = milestones.length;
		for (int i = 0; i < n; i++) {
			pq.add(new Mile(i, milestones[i]));
		}
		int prev = -1;
		while (!pq.isEmpty()) {
			// System.out.println(pq);
			Mile curr = pq.poll();
			if (curr.id == prev && pq.size() == 0)
				break;
			else if (curr.id != prev) {
				weeks++;
				curr.mile--;
				if (curr.mile > 0)
					pq.add(curr);
				prev = curr.id;
			} else if (pq.size() > 0) {
				Mile curr1 = pq.poll();
				prev = curr1.id;
				curr1.mile--;
				pq.add(curr);
				if (curr1.mile > 0)
					pq.add(curr1);
				weeks++;
			} else {
				break;
			}
		}
		return weeks;
	}
}

class Mile implements Comparable<Mile> {
	public int mile;
	public int id;

	public Mile(int id, int mile) {
		this.id = id;
		this.mile = mile;
	}

	@Override
	public String toString() {
		return "Id = " + this.id + ", Mile = " + this.mile;
	}

	@Override
	public int compareTo(Mile o) {
		return Integer.compare(o.mile, this.mile);
	}
}