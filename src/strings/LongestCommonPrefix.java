/**
 * 
 */
package strings;

/**
 * @author PRATAP LeetCode 14
 *
 */
public class LongestCommonPrefix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = { "dog", "racecar", "car" };
		String ans = longestCommonPrefix(strs);
		System.out.println(ans);
	}

	public static String longestCommonPrefix(String[] strs) {
		if (strs.length <= 0)
			return "";
		int min = Integer.MAX_VALUE;
		for (String s : strs)
			min = Math.min(min, s.length());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < min; i++) {
			int j = 1;
			Character ch = strs[0].charAt(i);
			boolean flag = true;
			for (; j < strs.length; j++) {
				if (strs[j].charAt(i) != ch) {
					flag = false;
					break;
				}
			}
			if (flag)
				sb.append(ch);
			else
				break;
		}
		return sb.toString();
	}
}
