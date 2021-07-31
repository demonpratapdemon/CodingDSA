/**
 * 
 */
package miscellaneous;

import java.util.Arrays;

/**
 * @author PRATAP LeetCode 452
 *
 */
public class MinimumNumberOfArrowsToBurstBalloons {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[][] points = { { 10, 16 }, { 2, 8 }, { 1, 6 }, { 7, 12 } };
//		int[][] points = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 } };
		int[][] points = { { -2147483646, -2147483645 }, { 2147483646, 2147483647 } };
		MinimumNumberOfArrowsToBurstBalloons obj = new MinimumNumberOfArrowsToBurstBalloons();
		int ans = obj.findMinArrowShots(points);
		System.out.println(ans);
	}

	public int findMinArrowShots(int[][] points) {
		int n = points.length;
		Balloon[] blns = new Balloon[n];
		for (int i = 0; i < n; i++) {
			blns[i] = new Balloon(points[i][0], points[i][1]);
		}
		Arrays.sort(blns);
		int count = 0;
		int arrow = 0;
		int killed[] = new int[n];
		for (int i = 0; i < n; i += count == 0 ? 1 : count) {
			count = 0;
			if (killed[i] != -1) {
				killed[i] = -1;
				arrow++;
				for (int j = i + 1; j < n; j++) {
					if (blns[i].e >= blns[j].s && killed[j] != -1) {
						count++;
						killed[j] = -1;
					} else {
						break;
					}
				}
			}
		}
		return arrow;
	}
}

class Balloon implements Comparable<Balloon> {
	public int s;
	public int e;

	public Balloon(int s, int e) {
		super();
		this.s = s;
		this.e = e;
	}

	@Override
	public int compareTo(Balloon o) {
		return Integer.compare(this.e, o.e);
	}
}
