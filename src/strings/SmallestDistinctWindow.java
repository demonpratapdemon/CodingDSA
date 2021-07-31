/**
 * 
 */
package strings;

import java.util.HashMap;
import java.util.TreeSet;

/**
 * @author PRATAP
 *
 */
public class SmallestDistinctWindow {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "CCCbAbbBbbC";
		String ans = findSubString(str);
		System.out.println(ans);
	}

	public static String findSubString(String str) {
		// Your code goes here
		TreeSet<Character> set = new TreeSet<Character>();
		for (Character ch : str.toCharArray())
			set.add(ch);
		int i = -1, j = -1;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		String res = "";
		while (true) {
			boolean f1 = false;
			boolean f2 = false;
			// Acquire
			while (i < str.length() - 1 && map.size() < set.size()) {
				i++;
				map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
				f1 = true;
			}
			// Release
			while (j < i && map.size() == set.size()) {
				j++;
				if (res.length() != 0 && str.substring(j, i + 1).length() < res.length())
					res = str.substring(j, i + 1);
				else if (res.length() == 0)
					res = str.substring(j, i + 1);
				if (map.get(str.charAt(j)) == 1)
					map.remove(str.charAt(j));
				else
					map.put(str.charAt(j), map.get(str.charAt(j)) - 1);
				f2 = true;
			}
			if (!f1 && !f2)
				break;
		}
		System.out.println(res.length());
		return res;
	}

}
