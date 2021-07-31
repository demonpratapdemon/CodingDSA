/**
 * 
 */
package heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author PRATAP
 *
 */
public class MinimumSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 5, 9 };
		String ans = solve(arr, arr.length);
		System.out.println(ans);
	}

	public static String solve(int[] arr, int n) {
		// code here
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return -Integer.compare(o1, o2);
			}
		});

		for (int i : arr)
			maxHeap.add(i);
		String res = "";
		int carry = 0;
		while (!maxHeap.isEmpty()) {
			int i = maxHeap.poll();
			int j = 0;
			if (maxHeap.size() > 0)
				j = maxHeap.poll();
			int sum = i + j + carry;
			if (sum < 10) {
				res = sum + res;
				carry = 0;
			} else {
				carry = sum / 10;
				sum = sum % 10;
				res = sum + res;
			}
		}
		if (carry > 0)
			res = carry + res;
		while (res.charAt(0) == '0' && res.length() > 1) {
			res = res.substring(1);
		}
		return res;
	}

}
