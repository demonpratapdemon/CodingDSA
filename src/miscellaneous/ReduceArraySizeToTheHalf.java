/**
 * 
 */
package miscellaneous;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @author PRATAP LeetCode 1338
 *
 */
public class ReduceArraySizeToTheHalf {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1000, 1000, 3, 7 };
		int ans = minSetSize(arr);
		System.out.println(ans);
	}

	public static int minSetSize(int[] arr) {
		PriorityQueue<Remove> pq = new PriorityQueue<Remove>(new RemoveComp());
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i : arr)
			map.put(i, map.getOrDefault(i, 0) + 1);
		for (Integer key : map.keySet()) {
			pq.add(new Remove(key, map.get(key)));
		}
		int org = arr.length;
		int n = arr.length;
		int count = 0;
		while (!pq.isEmpty()) {
			Remove curr = pq.poll();
			count++;
			n -= curr.freq;
			if (n <= org / 2) {
				break;
			}
		}
		return count;
	}

}

class RemoveComp implements Comparator<Remove> {

	@Override
	public int compare(Remove o1, Remove o2) {
		// TODO Auto-generated method stub
		return Integer.compare(o2.freq, o1.freq);
	}

}

class Remove {
	public int val;
	public int freq;

	public Remove(int val, int freq) {
		super();
		this.val = val;
		this.freq = freq;
	}

}
