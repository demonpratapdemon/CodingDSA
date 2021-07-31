/**
 * 
 */
package strings;

import java.util.ArrayList;
import java.util.List;

/**
 * @author PRATAP LeetCode 93
 *
 */
public class RestorIPAdresses {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "25011255255";
		List<String> ans = restoreIpAddresses(s);
		System.out.println(ans);
	}

	public static List<String> restoreIpAddresses(String s) {
		List<String> ans = new ArrayList<String>();
		int[] path = new int[4];
		snapshot(ans, s, path, 0, 0);
		return ans;
	}

	private static void snapshot(List<String> ans, String s, int[] path, int builderIndex, int segment) {
		// TODO Auto-generated method stub
		if (segment == 4 && builderIndex == s.length()) {
			ans.add(path[0] + "." + path[1] + "." + path[2] + "." + path[3]);
			return;
		} else if (segment == 4 && builderIndex < s.length()) {
			return;
		}
		for (int len = 1; len <= 3 && builderIndex + len <= s.length(); len++) {
			String snap = s.substring(builderIndex, builderIndex + len);
			int value = Integer.parseInt(snap);
			if (value > 255 || (len >= 2 && snap.charAt(0) == '0')) {
				break;
			}
			path[segment] = value;
			snapshot(ans, s, path, builderIndex + len, segment + 1);
			path[segment] = -1;
		}
	}

}
