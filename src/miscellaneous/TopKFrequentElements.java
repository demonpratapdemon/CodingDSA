/**
 * 
 */
package miscellaneous;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @author PRATAP LeetCode 347
 *
 */
public class TopKFrequentElements {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = { 1, 1, 1, 2, 2, 3 }, k = 2;
		TopKFrequentElements obj = new TopKFrequentElements();
		int[] ans = obj.topKFrequent(nums, k);
		for (int i : ans)
			System.out.println(i);
	}

	public int[] topKFrequent(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i : nums) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		PriorityQueue<Pairs> pq = new PriorityQueue<Pairs>();
		for (int i : nums) {
			if (map.containsKey(i)) {
				pq.add(new Pairs(i, map.get(i)));
				map.remove(i);
			}
		}
		int[] res = new int[k];
		int i = 0;
		while (k-- > 0 && !pq.isEmpty()) {
			Pairs curr = pq.poll();
			res[i++] = curr.val;
		}
		return res;
	}
}

class Pairs implements Comparable<Pairs> {
	public int val;
	public int count;

	public Pairs(int val, int count) {
		this.val = val;
		this.count = count;
	}

	public int compareTo(Pairs o) {
		return Integer.compare(o.count, this.count);
	}

	public String toString() {
		return "Val = " + this.val + ", Count = " + this.count;
	}
}
