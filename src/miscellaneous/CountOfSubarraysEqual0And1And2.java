/**
 * 
 */
package miscellaneous;

import java.util.HashMap;

/**
 * @author PRATAP
 *
 */
public class CountOfSubarraysEqual0And1And2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "0102010";
		CountOfSubarraysEqual0And1And2 obj = new CountOfSubarraysEqual0And1And2();
		long ans = obj.getSubstringWithEqual012(str);
		System.out.println(ans);
	}

	long getSubstringWithEqual012(String str) {
		// code here
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		// Key = (c1-c0#c2-c1)
		int c0 = 0, c1 = 0, c2 = 0;
		long count = 0;
		map.put(String.valueOf(c1 - c0) + "#" + String.valueOf(c2 - c1), 1);
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '0') {
				c0++;
			} else if (str.charAt(i) == '1') {
				c1++;
			} else if (str.charAt(i) == '2') {
				c2++;
			}
			String key = String.valueOf(c1 - c0) + "#" + String.valueOf(c2 - c1);
			if (map.containsKey(key))
				count += map.get(key);

			map.put(key, map.getOrDefault(key, 0) + 1);
		}
		return count;
	}
}
