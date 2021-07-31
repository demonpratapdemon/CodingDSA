/**
 * 
 */
package miscellaneous;

import java.util.HashMap;

/**
 * @author PRATAP
 *
 */
public class CustomSortString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String order = "cba", str = "abccd";
		String ans = customSortString(order, str);
		System.out.println(ans);
	}

	public static String customSortString(String order, String str) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (char ch : str.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < order.length(); i++) {
			char key = order.charAt(i);
			while (map.get(key) != null && map.get(key) > 0) {
				sb.append(key);
				map.put(key, map.get(key) - 1);
			}
		}
		for (char ch : map.keySet()) {
			while (map.get(ch) != null && map.get(ch) > 0) {
				sb.append(ch);
				map.put(ch, map.get(ch) - 1);
			}
		}
		return sb.toString();
	}
}
