/**
 * 
 */
package miscellaneous;

/**
 * @author PRATAP LeetCOde 28
 *
 */
public class ImplementStrStr {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String haystack = "hello", needle = "ll";
//		String haystack = "a", needle = "a";
		ImplementStrStr obj = new ImplementStrStr();
		int ans = obj.strStr1(haystack, needle);
		System.out.println(ans);
	}

	public int strStr(String haystack, String needle) {
		if (needle.length() == 0)
			return 0;
		if ((needle.length() > 0 && haystack.length() == 0) || needle.length() > haystack.length())
			return -1;
		StringBuilder sb = new StringBuilder();
		sb.append(haystack.substring(0, needle.length()));
		if (sb.toString().equals(needle))
			return 0;
		for (int i = needle.length(); i < haystack.length(); i++) {
			String x = sb.substring(1);
			sb.setLength(0);
			sb.append(x);
			sb.append(haystack.charAt(i));
			if (sb.toString().equals(needle))
				return i - needle.length() + 1;
		}
		return -1;
	}

//	Using KMP Pattern Matching Algorithm
	public int strStr1(String haystack, String needle) {
		if (needle.length() == 0)
			return 0;
		if ((needle.length() > 0 && haystack.length() == 0) || needle.length() > haystack.length())
			return -1;
		int[] arr = computeTempArray(needle);
		int i = 0, j = 0;
		while (i < haystack.length() && j < needle.length()) {
			if (haystack.charAt(i) == needle.charAt(j)) {
				i++;
				j++;
			} else {
				if (j != 0)
					j = arr[j - 1];
				else
					i++;
			}
		}
		if (j == needle.length())
			return i - needle.length();
		return -1;
	}

	private int[] computeTempArray(String s) {
		// TODO Auto-generated method stub
		int n = s.length();
		int[] arr = new int[n];
		int j = 0;
		for (int i = 1; i < n;) {
			if (s.charAt(i) == s.charAt(j)) {
				arr[i] = j + 1;
				j++;
				i++;
			} else {
				if (j != 0) {
					j = arr[j - 1];
				} else {
					arr[i] = 0;
					i++;
				}
			}
		}
		return arr;
	}
}
