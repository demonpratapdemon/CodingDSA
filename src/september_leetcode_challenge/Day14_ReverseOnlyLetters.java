/**
 * 
 */
package september_leetcode_challenge;

/**
 * @author PRATAP LeetCode 917
 *
 */
public class Day14_ReverseOnlyLetters {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "a-bC-dEf-ghIj";
		Day14_ReverseOnlyLetters obj = new Day14_ReverseOnlyLetters();
		String ans = obj.reverseOnlyLetters(s);
		System.out.println(ans);
	}

	public String reverseOnlyLetters(String s) {
		StringBuilder sb = new StringBuilder();
		sb.append(s);
		int i = 0, j = s.length() - 1;
		while (i < j) {
			boolean t1 = ((int) s.charAt(i) >= 65 && (int) s.charAt(i) <= 90) ? true
					: (((int) s.charAt(i) >= 97 && (int) s.charAt(i) <= 122) ? true : false);
			boolean t2 = ((int) s.charAt(j) >= 65 && (int) s.charAt(j) <= 90) ? true
					: (((int) s.charAt(j) >= 97 && (int) s.charAt(j) <= 122) ? true : false);
			if (t1 && t2) {
				sb.replace(i, i + 1, String.valueOf(s.charAt(j)));
				sb.replace(j, j + 1, String.valueOf(s.charAt(i)));
				i++;
				j--;
			} else {
				if (!t1 && t2) {
					i++;
				} else {
					j--;
				}
			}
		}
		return sb.toString();
	}
}
