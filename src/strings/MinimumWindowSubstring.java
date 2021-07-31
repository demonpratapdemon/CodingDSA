/**
 * 
 */
package strings;

import java.util.HashMap;

/**
 * @author PRATAP LeetCode 76
 *
 */
public class MinimumWindowSubstring {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aa", t = "aa";
		String ans = smallestWindow(s, t);
		System.out.println(ans);
	}

	public static String minWindow(String s, String t) {
		if (t.length() > s.length())
			return "";
		HashMap<Character, Integer> map1 = new HashMap<Character, Integer>();
		HashMap<Character, Integer> map2 = new HashMap<Character, Integer>();
		String ans = "";
		for (Character ch : t.toCharArray()) {
			map2.put(ch, map2.getOrDefault(ch, 0) + 1);
		}

		int i = -1, j = -1;
		int mct = 0, dmct = t.length();
		while (true) {
			boolean f1 = false;
			boolean f2 = false;
			// Acquire
			while (i < s.length() - 1 && mct < dmct) {
				i++;
				Character ch = s.charAt(i);
				map1.put(ch, map1.getOrDefault(ch, 0) + 1);
				if (map2.containsKey(ch) && map1.get(ch) <= map2.get(ch)) {
					mct++;
				}
				f1 = true;
			}

			// Release
			while (j < i && mct == dmct) {
				String pans = s.substring(j + 1, i + 1);
				if (ans.length() == 0 || pans.length() < ans.length())
					ans = pans;
				j++;
				Character ch = s.charAt(j);
				if (map1.get(ch) == 1)
					map1.remove(ch);
				else
					map1.put(ch, map1.get(ch) - 1);
				if (map2.getOrDefault(ch, 0) > map1.getOrDefault(ch, 0))
					mct--;
				f2 = true;
			}
			if (!f1 && !f2)
				break;
		}
		return ans;
	}

	public static String smallestWindow(String s, String t) {
		// Your code here
		int[] map1 = new int[256];
		int[] map2 = new int[256];
		String ans = "";
		for (Character ch : t.toCharArray()) {			
			map2[ch]++;
		}
		int i = -1, j = -1;
		int mct = 0, dmct = t.length();
		while (true) {
			boolean f1 = false;
			boolean f2 = false;
			// Acquire
			while (i < s.length() - 1 && mct < dmct) {
				i++;
				Character ch = s.charAt(i);
				map1[ch]++;
				if (map2[ch] > 0 && map1[ch] <= map2[ch]) {
					mct++;
				}
				f1 = true;
			}

			// Release
			while (j < i && mct == dmct) {
				String pans = s.substring(j + 1, i + 1);
				if (ans.length() == 0 || pans.length() < ans.length())
					ans = pans;
				j++;
				Character ch = s.charAt(j);
				if (map1[ch] == 1)
					map1[ch] = 0;
				else
					map1[ch]--;
				if (map2[ch] > 0 && map1[ch] < map2[ch])
					mct--;
				f2 = true;
			}
			if (!f1 && !f2)
				break;
		}
		if (ans.length() == 0)
			return String.valueOf(-1);
		return ans;
	}

}
