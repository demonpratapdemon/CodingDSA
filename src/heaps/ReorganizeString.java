/**
 * 
 */
package heaps;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @author PRATAP LeetCode 767
 *
 */
public class ReorganizeString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "kkk";
		String ans = reorganizeString(s);
		System.out.println(ans);
	}

	public static String reorganizeString(String s) {
		if (s.length() <= 0)
			return "";
		int n = s.length();
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < n; i++) {
			if (map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
			} else
				map.put(s.charAt(i), 1);
		}
		if (map.size() == 1 && map.get(s.charAt(0)) > 1) {
			return "";
		}
		PriorityQueue<StringPair> maxHeap = new PriorityQueue<StringPair>(new Comparator<StringPair>() {
			@Override
			public int compare(StringPair o1, StringPair o2) {
				return -Integer.compare(o1.freq, o2.freq);
			}
		});
		for (Character ch : map.keySet()) {
			maxHeap.add(new StringPair(ch, map.get(ch)));
		}
		String result = "";
		StringPair prev = null;
		while (!maxHeap.isEmpty()) {
			StringPair curr = maxHeap.poll();
			if (result.length() != 0) {
				if (result.charAt(result.length() - 1) == curr.ch && maxHeap.size() == 0) {
					return "";
				} else if (result.charAt(result.length() - 1) == curr.ch) {
					prev = curr;
					curr = maxHeap.poll();
					maxHeap.add(prev);
					prev = null;
				}
			}
			if (curr != null) {
				result += curr.ch;
				curr.freq -= 1;
				if (curr.freq > 0)
					maxHeap.add(curr);
			}
			
		}
		return result;
	}

}

class StringPair {
	public char ch;
	public int freq;

	public StringPair(char ch, int freq) {
		super();
		this.ch = ch;
		this.freq = freq;
	}

}
