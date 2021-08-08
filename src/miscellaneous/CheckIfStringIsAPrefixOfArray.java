/**
 * 
 */
package miscellaneous;

/**
 * @author PRATAP
 *
 */
public class CheckIfStringIsAPrefixOfArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "ileetcode", words[] = { "i", "love", "leetcode", "apples" };
		CheckIfStringIsAPrefixOfArray obj = new CheckIfStringIsAPrefixOfArray();
		boolean ans = obj.isPrefixString(s, words);
		System.out.println(ans);
	}

	public boolean isPrefixString(String s, String[] words) {
		int n = words.length;
		for (int i = n - 1; i >= 0; i--) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j <= i; j++) {
				sb.append(words[j]);
			}
			if (s.equalsIgnoreCase(sb.toString()))
				return true;
		}
		return false;
	}
}
