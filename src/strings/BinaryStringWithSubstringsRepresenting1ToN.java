/**
 * 
 */
package strings;

/**
 * @author PRATAP
 *
 */
public class BinaryStringWithSubstringsRepresenting1ToN {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "0110";
		int n = 4;
		boolean ans = queryString(s, n);
		System.out.println(ans);
	}

	public static boolean queryString(String s, int n) {
		if (s.length() <= 0)
			return false;
		int max = binaryRepres(n).length();
		if (s.length() < max) {
			String str = "";
			for (int i = 0; i < max - s.length(); i++) {
				str += "0";
			}
			s = str + s;
		}
		for (int i = 1; i <= n; i++) {
			String repr = binaryRepres(i);
			if (!s.contains(repr)) {
				return false;
			}
		}
		return true;
	}

	public static String binaryRepres(int x) {
		StringBuilder sb = new StringBuilder();
		while (x > 0) {
			int rem = x % 2;
			x /= 2;
			sb.insert(0, rem);
		}
		return sb.toString();
	}
}
