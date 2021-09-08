/**
 * 
 */
package miscellaneous;

/**
 * @author PRATAP LeetCode 394
 *
 */
public class DecodeString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "2[abc]3[cd]ef";
		DecodeString obj = new DecodeString();
		String ans = obj.decodeString(s);
		System.out.println(ans);
	}

	int j = 0;

	public String decodeString(String s) {
		j = 0;
		return decode(s);
	}

	private String decode(String s) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		while (j < s.length() && s.charAt(j) != ']') {
			if (isDigit(s.charAt(j))) {
				int k = 0;
				while (j < s.length() && isDigit(s.charAt(j))) {
					k = k * 10 + Integer.parseInt(String.valueOf(s.charAt(j++)));
				}
				j++;
				String r = decode(s);
				while (k-- > 0) {
					sb.append(r);
				}
				j++;
			} else {
				sb.append(s.charAt(j++));
			}
		}
		return sb.toString();
	}

	private boolean isDigit(char ch) {
		// TODO Auto-generated method stub
		int val = (int) ch;
		return val >= 48 && val <= 57;
	}
}
