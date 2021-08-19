/**
 * 
 */
package strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author PRATAP LeetCode 438
 *
 */
public class FindAllAnagramsInAString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abab", p = "ab";
		FindAllAnagramsInAString obj = new FindAllAnagramsInAString();
		List<Integer> ans = obj.findAnagrams(s, p);
		System.out.println(ans);
	}

	public List<Integer> findAnagrams(String s, String p) {
		int n = p.length();
		HashMap<Character, Integer> map1 = new HashMap<Character, Integer>();
		for (char ch : p.toCharArray()) {
			map1.put(ch, map1.getOrDefault(ch, 0) + 1);
		}
		List<Integer> ans = new ArrayList<Integer>();
		HashMap<Character, Integer> map2 = new HashMap<Character, Integer>();
		for (int i = 0; i < n; i++) {
			map2.put(s.charAt(i), map2.getOrDefault(s.charAt(i), 0) + 1);
		}
		if (map1.equals(map2))
			ans.add(0);
		for (int i = n; i < s.length(); i++) {
			char ch = s.charAt(i - n);
			map2.put(ch, map2.get(ch) - 1);
			if (map2.get(ch) <= 0)
				map2.remove(ch);
			map2.put(s.charAt(i), map2.getOrDefault(s.charAt(i), 0) + 1);
			if (map1.equals(map2))
				ans.add(i - n + 1);
		}
		return ans;
	}
}
