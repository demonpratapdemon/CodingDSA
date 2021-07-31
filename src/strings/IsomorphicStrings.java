/**
 * 
 */
package strings;

import java.util.HashMap;

/**
 * @author PRATAP
 *
 */
public class IsomorphicStrings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "paper";
		String str2 = "title";
		System.out.println(areIsomorphic(str1, str2));
	}

	public static boolean areIsomorphic(String str1, String str2) {
		// Your code here
		if (str1.length() != str2.length())
			return false;
		int n = str1.length();
		int i = 1;
		HashMap<Character, Character> map1 = new HashMap<Character, Character>();
		HashMap<Character, Character> map2 = new HashMap<Character, Character>();
		map1.put(str1.charAt(i - 1), str2.charAt(i - 1));
		map2.put(str2.charAt(i - 1), str1.charAt(i - 1));
		while (i < n) {
			char c1 = str1.charAt(i);
			char c2 = str2.charAt(i);
			if (map1.containsKey(c1) && map1.get(c1) != c2) {
				return false;
			} else if (map2.containsKey(c2) && map2.get(c2) != c1) {
				return false;
			} else {
				map1.put(c1, c2);
				map2.put(c2, c1);
			}
			i++;
		}
		return true;
	}
}
