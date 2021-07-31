/**
 * 
 */
package strings;

/**
 * @author PRATAP
 *
 */
public class CountTheReversals {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "}{{}}{{{";
		int ans = countRev(s);
		System.out.println(ans);
	}

	public static int countRev(String s) {
		// your code here
		int n = s.length();
		if (n % 2 != 0)
			return -1;
		int open = 0, close = 0;
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == '{') {
				open++;
			} else {
				if (open > 0) {
					open--;
				} else {
					close++;
				}
			}
		}
		if (open == 0 && close == 0)
			return 0;
		int count = 0;
		count += (open / 2) + (close / 2);
		open -= (open / 2) * 2;
		close -= (close / 2) * 2;
		count += open + close;
		if (count == 0)
			return -1;
		return count;
	}

}
