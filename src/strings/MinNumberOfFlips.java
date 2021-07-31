/**
 * 
 */
package strings;

/**
 * @author PRATAP
 *
 */
public class MinNumberOfFlips {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S = "0001010111";
		int ans = minFlips(S);
		System.out.println(ans);
	}

	public static int minFlips(String S) {
		// Code here
		int n = S.length();
		StringBuilder s1 = new StringBuilder(), s2 = new StringBuilder();
		for (int i = 0; i < n; i++) {
			if (i % 2 == 0) {
				s1.append('0');
				s2.append('1');
			} else {
				s1.append('1');
				s2.append('0');
			}
		}
		int count1 = 0, count2 = 0;
		for (int i = 0; i < n; i++) {
			if (s1.charAt(i) != S.charAt(i))
				count1++;
			if (s2.charAt(i) != S.charAt(i))
				count2++;
		}
		return Math.min(count1, count2);
	}
}
