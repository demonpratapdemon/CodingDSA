/**
 * 
 */
package miscellaneous;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author PRATAP
 *
 */
public class MissingPointOfParallelogram {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = { 3, 2 }, B[] = { 3, 4 }, C[] = { 2, 2 };
		MissingPointOfParallelogram obj = new MissingPointOfParallelogram();
		double[] ans = obj.findPoint(A, B, C);
		System.out.println(ans[0] + " " + ans[1]);
	}

	public double[] findPoint(int A[], int B[], int C[]) {
		// your code here
		ArrayList<PointPair> list = new ArrayList<PointPair>();
		list.add(findMissingPoint(A, B, C));
		list.add(findMissingPoint(B, C, A));
		list.add(findMissingPoint(B, A, C));
		Collections.sort(list);
		double[] ans = new double[2];
		ans[0] = list.get(0).first;
		ans[1] = list.get(0).second;
		return ans;
	}

	private PointPair findMissingPoint(int[] a, int[] b, int[] c) {
		// TODO Auto-generated method stub
		ArrayList<PointPair> d = findPoints(a, findSlope(b, c), findLength(b, c));
		int[] dist = new int[2];
		dist[0] = d.get(0).first.intValue();
		dist[1] = d.get(0).second.intValue();
		PointPair ans = new PointPair();
		if (findLength(dist, c) == findLength(a, b)) {
			ans.first = d.get(0).first;
			ans.second = d.get(0).second;
		} else {
			ans.first = d.get(1).first;
			ans.second = d.get(1).second;
		}
		return ans;
	}

	private ArrayList<PointPair> findPoints(int[] a, double m, double l) {
		// TODO Auto-generated method stub
		ArrayList<PointPair> list = new ArrayList<PointPair>();
		if (m == 0) {
			double x = (double) (a[0] + l);
			double y = (double) a[1];
			PointPair one = new PointPair(x, y);
			double x1 = (double) (a[0] - l);
			double y1 = (double) a[1];
			PointPair two = new PointPair(x1, y1);
			list.add(one);
			list.add(two);
		} else if (m == Double.MAX_VALUE) {
			double x = (double) a[0];
			double y = (double) (a[1] + l);
			PointPair one = new PointPair(x, y);
			double x1 = (double) a[0];
			double y1 = (double) (a[1] - l);
			PointPair two = new PointPair(x1, y1);
			list.add(one);
			list.add(two);
		} else {
			double dx = (l / Math.sqrt(1 + m * m));
			double dy = m * dx;
			double x = (double) (a[0] + dx);
			double y = (double) (a[1] + dy);
			PointPair one = new PointPair(x, y);
			double x1 = (double) (a[0] - dx);
			double y1 = (double) (a[1] - dy);
			PointPair two = new PointPair(x1, y1);
			list.add(one);
			list.add(two);
		}
		return list;
	}

	private double findLength(int[] b, int[] c) {
		// TODO Auto-generated method stub
		double length = Math.sqrt(Math.pow(b[0] - c[0], 2) + Math.pow(b[1] - c[1], 2));
		return length;
	}

	private double findSlope(int[] b, int[] c) {
		// TODO Auto-generated method stub
		if (b[1] == c[1])
			return 0;
		if (b[0] == c[0])
			return Double.MAX_VALUE;
		double slope = ((double) (b[1] - c[1])) / (b[0] - c[0]);
		return slope;
	}
}

class PointPair implements Comparable<PointPair> {
	public Double first;
	public Double second;

	public PointPair(Double first, Double second) {
		super();
		this.first = first;
		this.second = second;
	}

	public PointPair() {
		super();
	}

	@Override
	public int compareTo(PointPair o) {
		// TODO Auto-generated method stub
		if (this.first == o.first)
			return Double.compare(this.second, o.second);
		return Double.compare(this.first, o.first);
	}

}
