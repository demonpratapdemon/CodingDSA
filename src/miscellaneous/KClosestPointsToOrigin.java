/**
 * 
 */
package miscellaneous;

import java.util.PriorityQueue;

/**
 * @author PRATAP LeetCode 973
 *
 */
public class KClosestPointsToOrigin {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int points[][] = { { 1, 3 }, { -2, 2 } }, k = 1;
		KClosestPointsToOrigin obj = new KClosestPointsToOrigin();
		int[][] ans = obj.kClosest(points, k);
		for (int i = 0; i < ans.length; i++) {
			System.out.println(ans[i][0] + " " + ans[i][1]);
		}
	}

	public int[][] kClosest(int[][] points, int k) {
		int[][] res = new int[k][2];
		PriorityQueue<Point> pq = new PriorityQueue<Point>();
		for (int i = 0; i < points.length; i++) {
			Double dist = Math.sqrt(Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2));
			pq.add(new Point(points[i][0], points[i][1], dist));
		}
		int i = 0;
		while (k-- > 0) {
			Point curr = pq.poll();
			res[i][0] = curr.x;
			res[i][1] = curr.y;
			i++;
		}
		return res;
	}
}

class Point implements Comparable<Point> {
	public int x;
	public int y;
	public Double dist;

	public Point(int x, int y, Double dist) {
		super();
		this.x = x;
		this.y = y;
		this.dist = dist;
	}

	@Override
	public int compareTo(Point o) {
		// TODO Auto-generated method stub
		return Double.compare(this.dist, o.dist);
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + ", dist=" + dist + "]";
	}

}