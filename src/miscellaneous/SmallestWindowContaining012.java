/**
 * 
 */
package miscellaneous;

import java.util.HashMap;

/**
 * @author PRATAP
 *
 */
public class SmallestWindowContaining012 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S = "1210";
		int ans = smallestSubstring(S);
		System.out.println(ans);
	}

	public static int smallestSubstring(String S) {
		// Code here
		S = S.trim();
		if (S.length() == 0)
			return -1;
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		int i = -1, j = -1;
		int ans = Integer.MAX_VALUE;
		int n = S.length();
		while (true) {
			boolean flag1 = false, flag2 = false;
			while (++i < n && map.size() < 3) {
				String key = String.valueOf(S.charAt(i));
				map.put(key, map.getOrDefault(key, 0) + 1);
				flag1 = true;
			}
			while (j < i && map.size() == 3) {
				ans = Math.min(ans, i - j - 1);
				j++;
				String key = String.valueOf(S.charAt(j));
				map.put(key, map.get(key) - 1);
				if (map.get(key) <= 0)
					map.remove(key);
				flag2 = true;
			}
			if (!flag1 && !flag2)
				break;
		}
		if (ans == Integer.MAX_VALUE)
			return -1;
		return ans;
	}
}
