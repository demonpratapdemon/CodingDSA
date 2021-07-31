/**
 * 
 */
package miscellaneous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

/**
 * @author PRATAP LeetCode 1942
 *
 */
public class TheNumberOfTheSmallestUnoccupiedChair {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int times[][] = { { 3, 10 }, { 1, 5 }, { 2, 6 } }, targetFriend = 0;
//		int times[][] = { { 1, 4 }, { 2, 3 }, { 4, 6 } }, targetFriend = 1;
		int times[][] = { { 33889, 98676 }, { 80071, 89737 }, { 44118, 52565 }, { 52992, 84310 }, { 78492, 88209 },
				{ 21695, 67063 }, { 84622, 95452 }, { 98048, 98856 }, { 98411, 99433 }, { 55333, 56548 },
				{ 65375, 88566 }, { 55011, 62821 }, { 48548, 48656 }, { 87396, 94825 }, { 55273, 81868 },
				{ 75629, 91467 } }, targetFriend = 6;
		TheNumberOfTheSmallestUnoccupiedChair obj = new TheNumberOfTheSmallestUnoccupiedChair();
		int ans = obj.smallestChair(times, targetFriend);
		System.out.println(ans);
	}

	public int smallestChair(int[][] times, int targetFriend) {
		int n = times.length;
		int key = times[targetFriend][0];
		TreeSet<Integer> chairSet = new TreeSet<Integer>();
		for (int i = 0; i < n; i++) {
			chairSet.add(i);
		}
		Arrays.sort(times, (a, b) -> Integer.compare(a[0], b[0]));
		HashMap<Integer, List<Integer>> endChairMap = new HashMap<Integer, List<Integer>>();
		TreeSet<Integer> ends = new TreeSet<Integer>();
		ends.add(times[0][1]);
		List<Integer> l = new ArrayList<Integer>();
		l.add(chairSet.pollFirst());
		endChairMap.put(times[0][1], l);
		if (times[0][0] == key)
			return 0;
		int reqd = -1;
		for (int i = 1; i < n; i++) {
			while (!ends.isEmpty() && ends.first() <= times[i][0]) {
				int e = ends.pollFirst();
				List<Integer> chairNos = endChairMap.get(e);
				endChairMap.remove(e);
				for (int x : chairNos)
					chairSet.add(x);
			}
			if (times[i][0] == key) {
				reqd = chairSet.pollFirst();
				break;
			} else {
				int chairNo = chairSet.pollFirst();
				ends.add(times[i][1]);
				int e = times[i][1];
				List<Integer> li = endChairMap.getOrDefault(e, null);
				if (li == null)
					li = new ArrayList<Integer>();
				li.add(chairNo);
				endChairMap.put(e, li);
			}
		}
		return reqd;
	}
}
