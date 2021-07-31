/**
 * 
 */
package dynamic_programming;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author PRATAP LeetCode 1235
 *
 */
public class WeightedJobScheduling {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] startTime = { 1, 2, 3, 3 }, endTime = { 3, 4, 5, 6 }, profit = { 50, 10, 40, 70 };
		WeightedJobScheduling obj = new WeightedJobScheduling();
		int ans = obj.jobScheduling(startTime, endTime, profit);
		System.out.println(ans);
	}

	public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
		int n = startTime.length;
		Jobs[] jobs = new Jobs[n];
		for (int i = 0; i < n; i++) {
			Jobs newJob = new Jobs(startTime[i], endTime[i], profit[i]);
			jobs[i] = newJob;
		}
		Arrays.sort(jobs, new JobComp());
		int[] dp = new int[n];
		int[] ends = new int[n];
		for (int i = 0; i < n; i++) {
			ends[i] = jobs[i].end;
		}
		dp[0] = jobs[0].profit;
		int max = dp[0];
		for (int i = 1; i < n; i++) {
			dp[i] = dp[i - 1];
			int idx = binarySearch(jobs[i], ends, i);
			dp[i] = Math.max(dp[i], (idx >= 0 ? dp[idx] : 0) + jobs[i].profit);
			max = Math.max(max, dp[i]);
		}
		return dp[n - 1];
	}

	private int binarySearch(Jobs req, int[] ends, int i) {
		// TODO Auto-generated method stub
		int low = 0;
		int high = ends.length - 1;
		int ans = -1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (ends[mid] <= req.start && mid < i) {
				ans = mid;
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return ans;
	}
}

class JobComp implements Comparator<Jobs> {

	@Override
	public int compare(Jobs o1, Jobs o2) {
		return Integer.compare(o1.end, o2.end);
	}
}

class Jobs {
	public int start;
	public int end;
	public int profit;

	public Jobs(int start, int end, int profit) {
		super();
		this.start = start;
		this.end = end;
		this.profit = profit;
	}

}
