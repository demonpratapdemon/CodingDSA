/**
 * 
 */
package miscellaneous;

import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * @author PRATAP LeetCode 451
 *
 */
public class SortCharactersByFrequency {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "Aabb";
		SortCharactersByFrequency obj = new SortCharactersByFrequency();
		String ans = obj.frequencySort(s);
		System.out.println(ans);
	}

	public String frequencySort(String s) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (char ch : s.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
		Iterator<Character> itr = map.keySet().iterator();
		PriorityQueue<Characters> pq = new PriorityQueue<Characters>();
		while (itr.hasNext()) {
			char ch = itr.next();
			int count = map.get(ch);
			pq.add(new Characters(ch, count));
		}
		StringBuilder sb = new StringBuilder();
		while (!pq.isEmpty()) {
			Characters curr = pq.poll();
			int k = curr.count;
			while (k-- > 0)
				sb.append(curr.ch);
		}
		return sb.toString();
	}
}

class Characters implements Comparable<Characters> {
	public char ch;
	public int count;

	public Characters(char ch, int count) {
		this.ch = ch;
		this.count = count;
	}

	public int compareTo(Characters o) {
		return Integer.compare(o.count, this.count);
	}
}
