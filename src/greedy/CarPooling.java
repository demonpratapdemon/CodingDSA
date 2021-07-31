/**
 * 
 */
package greedy;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author PRATAP LeetCode 1094
 *
 */
public class CarPooling {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] trips = { { 2, 1, 5 }, { 3, 3, 7 } };
		int capacity = 5;
		boolean flag = carPooling(trips, capacity);
		System.out.println(flag);
	}

	public static boolean carPooling(int[][] trips, int capacity) {
		ArrayList<CarPool> list = new ArrayList<CarPool>();
		for (int i = 0; i < trips.length; i++) {
			list.add(new CarPool(trips[i][0], trips[i][1], trips[i][2]));
		}
		list.sort(new CarPoolComparator());
		boolean flag = true;
		int p = 0;
		int[] finish = new int[10001];
		for (int i = 0; i <= 1000; i++) {
			if (finish[i] > 0) {
				capacity += finish[i];
			}
			if (i == list.get(p).start && capacity >= list.get(p).pass) {
				int start = list.get(p).start;
				while (p < list.size() && list.get(p).start == start) {
					CarPool curr = list.get(p++);
					finish[curr.end] += curr.pass;
					capacity -= curr.pass;
					if (capacity < 0) {
						flag = false;
						break;
					}
				}
			} else if (i == list.get(p).start && capacity < list.get(p).pass) {
				flag = false;
				break;
			}

			if (p >= list.size())
				break;
		}
		return flag;
	}

}

class CarPoolComparator implements Comparator<CarPool> {

	@Override
	public int compare(CarPool o1, CarPool o2) {
		// TODO Auto-generated method stub
		return Integer.compare(o1.start, o2.start);
	}

}

class CarPool {
	public int pass;
	public int start;
	public int end;

	public CarPool(int cap, int start, int end) {
		super();
		this.pass = cap;
		this.start = start;
		this.end = end;
	}

}
