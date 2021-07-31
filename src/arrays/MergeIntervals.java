/**
 * 
 */
package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author PRATAP LeetCode 56
 *
 */
public class MergeIntervals {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] intervals = { { 1, 4 }, { 0, 2 }, { 3, 5 } };
		int[][] ans = merge(intervals);
		System.out.println(ans);
	}

	public static int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return Integer.compare(a[0], b[0]);
			}
		});
		int n = intervals.length;
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> first = new ArrayList<Integer>();
		first.add(intervals[0][0]);
		first.add(intervals[0][1]);
		res.add(first);
		for (int i = 1; i < n; i++) {
			if (res.get(res.size() - 1).get(1) >= intervals[i][0]) {
				ArrayList<Integer> newList = new ArrayList<Integer>();
				newList.add(res.get(res.size() - 1).get(0));
				newList.add(Math.max(intervals[i][1], res.get(res.size() - 1).get(1)));
				res.remove(res.size() - 1);
				res.add(newList);
			} else {
				ArrayList<Integer> newList = new ArrayList<Integer>();
				newList.add(intervals[i][0]);
				newList.add(intervals[i][1]);
				res.add(newList);
			}
		}
		int[][] newInterval = new int[res.size()][2];
		for (int i = 0; i < res.size(); i++) {
			newInterval[i][0] = res.get(i).get(0);
			newInterval[i][1] = res.get(i).get(1);
		}
		return newInterval;
	}
}
