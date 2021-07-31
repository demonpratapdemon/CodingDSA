/**
 * 
 */
package miscellaneous;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author PRATAP LeetCode Virtual 248 (1921)
 *
 */
public class EliminateMaximumNoOfMonsters {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int dist[] = { 3, 3, 5, 7, 7 }, speed[] = { 1, 1, 4, 2, 2 };
		int ans = eliminateMaximum(dist, speed);
		System.out.println(ans);
	}

	public static int eliminateMaximum(int[] dist, int[] speed) {
		int n = dist.length;
		List<Monster> list = new ArrayList<Monster>();
		for (int i = 0; i < n; i++) {
			list.add(new Monster(dist[i], speed[i], (double) dist[i] / (double) speed[i]));
		}
		Collections.sort(list, new MonsComp());
		int killed = 0;
		for (int i = 0; i < n; i++) {
			if (list.get(i).time < i) {
				break;
			}
			killed++;
		}
		return killed;
	}

}

class MonsComp implements Comparator<Monster> {

	@Override
	public int compare(Monster o1, Monster o2) {
		// TODO Auto-generated method stub
		return Double.compare(o1.time, o2.time);
	}

}

class Monster {
	public int dist;
	public int speed;
	public double time;

	public Monster(int dist, int speed, double time) {
		super();
		this.dist = dist;
		this.speed = speed;
		this.time = time;
	}
}
