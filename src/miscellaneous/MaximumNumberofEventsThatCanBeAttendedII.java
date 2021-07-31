/**
 * 
 */
package miscellaneous;

/**
 * @author PRATAP LeetCode 1751
 *
 */
public class MaximumNumberofEventsThatCanBeAttendedII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int events[][] = { { 31, 57, 53 }, { 5, 63, 29 }, { 54, 57, 32 }, { 55, 83, 28 }, { 25, 64, 5 }, { 5, 33, 33 },
				{ 32, 68, 27 }, { 30, 99, 54 } }, k = 4;
		int maxVal = maxValue(events, k);
		System.out.println(maxVal);
	}

	public static int maxValue(int[][] events, int k) {
		int maxDay = 0;
		for (int i = 0; i < events.length; i++) {
			maxDay = Math.max(maxDay, events[i][1]);
		}
		boolean[] days = new boolean[maxDay + 1];
		int max = solve(events, k, 0, 0, days);
		return max;
	}

	private static int solve(int[][] events, int k, int val, int idx, boolean[] days) {
		// TODO Auto-generated method stub
		if (k <= 0) {
			return val;
		}
		if (idx == events.length) {
			return val;
		}
		int taken = 0, notTaken = 0;
		if (!checkPossible(events, idx, days)) {
			return val;
		}
		taken = solve(events, k - 1, val + events[idx][2], idx + 1,
				getDays(days, events[idx][0], events[idx][1], true));
		notTaken = solve(events, k, val, idx + 1, getDays(days, events[idx][0], events[idx][1], false));
		System.out.println(taken + " " + notTaken);
		return Math.max(taken, notTaken);
	}

	private static boolean checkPossible(int[][] events, int idx, boolean[] days) {
		// TODO Auto-generated method stub
		int start = events[idx][0];
		int end = events[idx][1];
		for (int i = start; i <= end; i++) {
			if (days[i]) {
				return false;
			}
		}
		return true;
	}

	private static boolean[] getDays(boolean[] days, int i, int j, boolean flag) {
		// TODO Auto-generated method stub
		if (flag) {
			while (i <= j) {
				days[i] = true;
				i++;
			}
		} else {
			while (i <= j) {
				days[i] = false;
				i++;
			}
		}

		return days;
	}
}
