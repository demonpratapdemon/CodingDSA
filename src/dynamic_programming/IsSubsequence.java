/**
 * 
 */
package dynamic_programming;

/**
 * @author PRATAP LeetCode 392
 *
 */
public class IsSubsequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String s = "abc", t = "ahbgdc";
		String s = "axc", t = "ahbgdc";
		IsSubsequence obj = new IsSubsequence();
		boolean ans = obj.isSubsequence(s, t);
		System.out.println(ans);
	}

	public boolean isSubsequence(String s, String t) {
		int i = 0, j = 0;
		while (i < t.length() && j < s.length()) {
			if (t.charAt(i) == s.charAt(j)) {
				i++;
				j++;
			} else {
				i++;
			}
		}
		if (j >= s.length())
			return true;
		return false;
	}
}
