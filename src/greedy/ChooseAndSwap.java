/**
 * 
 */
package greedy;

import java.util.TreeSet;

/**
 * @author PRATAP
 *
 */
public class ChooseAndSwap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String A = "ccad";
		String lexicoGraphicallySmallest = chooseandswap(A);
		System.out.println(lexicoGraphicallySmallest);
	}

	public static String chooseandswap(String A) {
		// Code Here
		if (A.length() <= 0)
			return "";
		TreeSet<Character> set = new TreeSet<Character>();
		for (int i = 0; i < A.length(); i++)
			set.add(A.charAt(i));
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < A.length(); i++) {
			set.remove(A.charAt(i));
			if (set.isEmpty())
				break;
			char ch = set.first();
			if (ch < A.charAt(i)) {
				char ch2 = A.charAt(i);

				for (int j = 0; j < A.length(); j++) {
					if (A.charAt(j) != ch && A.charAt(j) != ch2)
						sb.append(A.charAt(j));
					else {
						if (A.charAt(j) == ch)
							sb.append(ch2);
						else
							sb.append(ch);
					}
				}
				break;
			}
		}
		if (sb.length() <= 0)
			return A;
		return sb.toString();
	}
}
