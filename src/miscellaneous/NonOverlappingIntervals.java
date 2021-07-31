/**
 * 
 */
package miscellaneous;

import java.util.Arrays;

/**
 * @author PRATAP LeetCode 435
 *
 */
public class NonOverlappingIntervals {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] intervals = { { 1, 100 }, { 11, 22 }, { 1, 11 }, { 2, 12 } };
		NonOverlappingIntervals obj = new NonOverlappingIntervals();
		int ans = obj.eraseOverlapIntervals(intervals);
		System.out.println(ans);
	}

	public int eraseOverlapIntervals(int[][] intervals) {
		int n = intervals.length;
		Interval[] intrvls = new Interval[n];
		for (int i = 0; i < n; i++) {
			intrvls[i] = new Interval(intervals[i][0], intervals[i][1]);
		}
		Arrays.sort(intrvls);
		int ovmax = 0;
		int[] dp = new int[n];
		for (int i = 0; i < n; i++) {
			int max = 0;
			for (int j = 0; j < i; j++) {
				if (intrvls[i].s != intrvls[j].s && intrvls[i].s >= intrvls[j].e) {
					if (dp[j] > max)
						max = dp[j];
				}
			}
			dp[i] = max + 1;
			ovmax = Math.max(ovmax, dp[i]);
		}
		return n - ovmax;
	}
}

class Interval implements Comparable<Interval> {
	public int s;
	public int e;

	public Interval(int s, int e) {
		super();
		this.s = s;
		this.e = e;
	}

	@Override
	public int compareTo(Interval o) {
		// TODO Auto-generated method stub
		if (this.s != o.s)
			return this.s - o.s;
		return this.e - o.e;
	}

}