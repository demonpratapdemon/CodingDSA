/**
 * 
 */
package arrays;

import java.util.HashMap;
import java.util.Iterator;

/**
 * @author PRATAP LeetCode 781
 *
 */
public class RabbitsInForest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] answers = { 1, 1, 2 };
		RabbitsInForest obj = new RabbitsInForest();
		int ans = obj.numRabbits(answers);
		System.out.println(ans);
	}

	public int numRabbits(int[] answers) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		// Color -> Rabbit (Key -> Value)
		for (int i : answers) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		Iterator<Integer> itr = map.keySet().iterator();
		int count = 0;
		while (itr.hasNext()) {
			int color = itr.next();
			int rabb = map.get(color);
			while (rabb > 0) {
				count += (color + 1);
				rabb -= (color + 1);
			}
		}
		return count;
	}
}
