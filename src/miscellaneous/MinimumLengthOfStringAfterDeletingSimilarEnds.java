/**
 * 
 */
package miscellaneous;

/**
 * @author PRATAP LeetCode 1750
 *
 */
public class MinimumLengthOfStringAfterDeletingSimilarEnds {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "bbbbbbbbbbbbbbbbbbbbbbbbbbbabbbbbbbbbbbbbbbccbcbcbccbbabbb";
		int ans = minimumLength(s);
		System.out.println(ans);
	}

	public static int minimumLength(String s) {
		StringBuilder sb = new StringBuilder();
		int n = s.length();
		int i = 0, j = n - 1;
		sb.append(s);
		boolean flag = false;
		while (i < j) {
			if (i == 0 && j == sb.length() - 1 && sb.charAt(i) == sb.charAt(j)) {
				flag = true;
			}
			if (sb.charAt(i) == sb.charAt(j) && flag) {
				while (i <= j && sb.charAt(i) == sb.charAt(j)) {
					j--;
				}
				while (i <= j && j < n - 1 && sb.charAt(i) == sb.charAt(j + 1)) {
					i++;
				}
				if (j == -1) {
					return 0;
				}
				sb.replace(0, i, "");
				sb.replace(j - i + 1, sb.length(), "");
				i = 0;
				j = sb.length() - 1;
				flag = false;
			} else {
				i++;
				j--;
			}
		}
		return sb.length();
	}
}
