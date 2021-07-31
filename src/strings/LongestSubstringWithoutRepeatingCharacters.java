/**
 * 
 */
package strings;

import java.util.HashMap;

/**
 * @author PRATAP LeetCode 3
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "jlygy";
		int ans = lengthOfLongestSubstring(s);
		System.out.println(ans);
	}

	public static int lengthOfLongestSubstring(String s) {
		int n = s.length();
		if (n == 0 || n == 1)
			return n;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int i = 0, j = 1;
		int max = 1;
		while (i < j && j < n) {
			if (s.charAt(i) != s.charAt(j)) {
				map.put(s.charAt(i), 1);
				map.put(s.charAt(j), 1);
				j++;
				while (j < n) {
					if (map.containsKey(s.charAt(j))) {
						max = Math.max(max, j - i);
						break;
					}
					map.put(s.charAt(j), 1);
					j++;
				}
				if (j == n && i == 0) {
					max = s.length();
					break;
				} else {
					max = Math.max(max, j - i);
				}
				map.clear();
			}
			i++;
			j = i + 1;
		}
		return max;
	}

}
