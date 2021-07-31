/**
 * 
 */
package strings;

/**
 * @author PRATAP LeetCode 38
 *
 */
public class CountAndSay {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 10;
		String ans = countAndSay(n);
		System.out.println(ans);
	}

	public static String countAndSay(int n) {
		if (n == 1)
			return "1";
		StringBuffer sb = new StringBuffer("1");
		for (int i = 2; i <= n; i++) {
			int len = sb.length();
			StringBuffer curr = new StringBuffer("");
			int count = 1;
			int j = 1;
			for (; j < len; j++) {
				if (sb.charAt(j) != sb.charAt(j - 1)) {
					curr.append(count).append(sb.charAt(j - 1));
					count = 0;
				}
				count++;
			}
			curr.append(count).append(sb.charAt(j - 1));
			sb = curr;
		}
		return sb.toString();
	}
}
